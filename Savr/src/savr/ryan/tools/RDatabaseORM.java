package savr.ryan.tools;

import com.formdev.flatlaf.json.ParseException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import savr.conor.FoodItem;
import savr.conor.FoodStockApp;
import savr.conor.NonPerishableFood;
import savr.conor.PerishableFood;
import savr.ryan.ContactInfo;
import savr.ryan.FoodSaver;
import savr.ryan.FoodSaver.SaverType;
import savr.ryan.IndividualFoodSaver;
import savr.ryan.IndividualFoodSaver.DietaryRestrictions;
import savr.ryan.Location;
import savr.ryan.OrganisationFoodSaver;
import savr.ryan.RedistributionRecord;
import savr.ryan.RedistributionRecord.DeliveryStatus;
import savr.ryan.WasteSource;
import savr.ryan.WasteSource.SourceType;

/**
 *
 * @author ryan
 */

// object relational mapper for the zero hunger database
// management section

// TODO: comment everything
// use dry, i feel like theres alot of code repeat here
// refactor db so it actually makes sense

// TODOOOOOOOOOOOOOOOO: fix confliction errors, (conor updated constructors that are not compatible when im instanciating his food classes)
// will fix in the new week

public class RDatabaseORM {

    public static ArrayList<RedistributionRecord> getRedistributionRecords() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();
        ArrayList<RedistributionRecord> redistributionRecords = new ArrayList<>();

        String query = "SELECT * FROM RedistributionRecord";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int wasteId = rs.getInt("waste_id");
                int recipientId = rs.getInt("recipient_id");
                String deliveryStatusStr = rs.getString("delivery_status").replace(" ", "_").toUpperCase();
                DeliveryStatus deliveryStatus = DeliveryStatus.valueOf(deliveryStatusStr.replace(" ", "").toUpperCase());

                WasteSource wasteSource = getWasteSourceById(wasteId);
                FoodSaver foodSaver = getFoodSaverById(recipientId);

                RedistributionRecord rr = new RedistributionRecord(wasteSource, foodSaver, deliveryStatus);
                redistributionRecords.add(rr);
                System.out.println(String.format("wasteid: %d, recipientid: %d, deliverystatus: %s", wasteId, recipientId, deliveryStatus));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return redistributionRecords;
    }

    public static ArrayList<FoodSaver> getFoodSavers() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        ArrayList<FoodSaver> foodSavers = new ArrayList<>();

        String query = "SELECT * FROM FoodSaver";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int recipientId = rs.getInt("recipient_id");
                SaverType saverType = SaverType.valueOf(rs.getString("recipient_type"));
                ContactInfo contactInfo = getContact(rs.getInt("contact_id"));
                Location location = getLocation(rs.getInt("location_id"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                
                if (saverType == SaverType.INDIVIDUAL) {
                    IndividualFoodSaver ifs = new IndividualFoodSaver(firstName, lastName, saverType, contactInfo, location);
                    foodSavers.add(ifs);
                } else if (saverType == SaverType.ORGANISATION) {
                    String name = rs.getString("name");
                    OrganisationFoodSaver ofs = new OrganisationFoodSaver(firstName, lastName, saverType, contactInfo, location);
                    foodSavers.add(ofs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return foodSavers;
    }

    private static ContactInfo getContact(int contactId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "SELECT * FROM ContactInfo WHERE contact_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, contactId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                return new ContactInfo(email, phone);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return new ContactInfo("null", "null");
    }

    private static Location getLocation(int locationId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "SELECT * FROM Location WHERE location_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, locationId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String locationAddress = rs.getString("address");
                Location newLocation = new Location(locationAddress);
                return newLocation;
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return new Location("null");
    }

    public static ArrayList<WasteSource> getWasteSources() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        ArrayList<WasteSource> wasteSources = new ArrayList<>();

        String query = "SELECT * FROM WasteSource";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int wasteId = rs.getInt("waste_id");
                String sourceName = rs.getString("source_name");
                SourceType sourceType = SourceType.valueOf(rs.getString("source_type"));
                Location sourceLocation = getLocation(rs.getInt("source_location_id"));
                double wasteAmount = rs.getDouble("waste_amount");
                
                // TODOOOOOOOOOOOOOOOO
                // FoodItem foodItem = getFoodItemById(rs.getInt("food_id"));
                FoodItem foodItem = new PerishableFood();
                
                ArrayList<FoodItem> foodItems = new ArrayList<>();
                foodItems.add(foodItem);
                FoodStockApp sourceFsa = new FoodStockApp(foodItems);

                WasteSource ws = new WasteSource(sourceName, sourceType, sourceLocation, wasteAmount, sourceFsa);
                wasteSources.add(ws);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return wasteSources;
    }

    private static WasteSource getWasteSourceById(int wasteId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "SELECT * FROM WasteSource WHERE waste_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, wasteId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String sourceName = rs.getString("source_name");
                SourceType sourceType = SourceType.valueOf(rs.getString("source_type"));
                Location sourceLocation = getLocation(rs.getInt("source_location_id"));
                double wasteAmount = rs.getDouble("waste_amount");
                
                // TODOOOOOOOOOOOOOOOO
                // FoodItem foodItem = getFoodItemById(rs.getInt("food_id"));
                FoodItem foodItem = new PerishableFood();
                
                ArrayList<FoodItem> foodItems = new ArrayList<>();
                foodItems.add(foodItem);
                FoodStockApp sourceFsa = new FoodStockApp(foodItems);

                return new WasteSource(sourceName, sourceType, sourceLocation, wasteAmount, sourceFsa);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return null;
    }

    private static FoodSaver getFoodSaverById(int recipientId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "SELECT * FROM FoodSaver WHERE recipient_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, recipientId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SaverType saverType = SaverType.valueOf(rs.getString("recipient_type"));
                ContactInfo contactInfo = getContact(rs.getInt("contact_id"));
                Location location = getLocation(rs.getInt("location_id"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                
                if (saverType == SaverType.INDIVIDUAL) {
                    
                    IndividualFoodSaver ifs = new IndividualFoodSaver(firstName, lastName, saverType, contactInfo, location);
                    return ifs;
                } else if (saverType == SaverType.ORGANISATION) {
                    String name = rs.getString("name");
                    OrganisationFoodSaver ofs = new OrganisationFoodSaver(firstName, lastName, saverType, contactInfo, location);
                    return ofs;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    
    // BROKEN: need to update this to use conors new constructors, will do this in the new week :)

    // private static FoodItem getFoodItemById(int foodId) {
    //     RDataPersistence rdp = RDataPersistence.getInstance();
    //     Connection conn = rdp.getConnection();
    //     FoodItem foodItem = null;// 

    //     String query = "SELECT * FROM FoodStock WHERE food_id = ?";// 

    //     try (PreparedStatement pstmt = conn.prepareStatement(query)) {
    //         pstmt.setInt(1, foodId);
    //         ResultSet rs = pstmt.executeQuery();
    //         if (rs.next()) {
    //             String foodName = rs.getString("food_name");
    //             String foodType = rs.getString("food_type");
    //             int quantity = rs.getInt("quantity");
    //             String dateStr = rs.getString("expiration_date");
    //             // parse the date, this is ugly
    //             Date expiration = null;
    //             if (dateStr != null && !dateStr.isEmpty()) {
    //                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //                 try {
    //                     // parse date string into date object
    //                     expiration = sdf.parse(dateStr);
    //                 } catch (java.text.ParseException e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //             if (foodType.equals("Perishable")) {
    //                 int storageTemp = rs.getInt("storage_temp");
    //                 PerishableFood pf = new PerishableFood(storageTemp, foodId, quantity, foodName, foodType, expiration);
    //                 foodItem = pf;
    //             } else if (foodType.equals("NonPerishable")) {
    //                 NonPerishableFood npf = new NonPerishableFood(foodId, quantity, foodName, foodType, expiration);
    //                 foodItem = npf;
    //             }
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e);
    //     }// 

    //     return foodItem;
    // }

    // BROKEN: need to update this to use conors new constructors, will do this in the new week :)

    // public static ArrayList<FoodItem> getFoodItems() {
    //     RDataPersistence rdp = RDataPersistence.getInstance();
    //     Connection conn = rdp.getConnection();
    //     
    //     ArrayList foodItems = new ArrayList<FoodItem>();
    //     
    //     String query = "select * from FoodStock";
    //     
    //     try(Statement stmt  = conn.createStatement()) {
    //         ResultSet rs = stmt.executeQuery(query);
    //         while(rs.next()) {
    //             int foodId = rs.getInt("food_id");
    //             String foodName = rs.getString("food_name");
    //             String foodType = rs.getString("food_type");
    //             int quantity = rs.getInt("quantity");
    //             
    //             // parse expiration date, this is ugly
    //             String dateStr = rs.getString("expiration_date");
    //             Date expiration = null;
    //             if (dateStr != null && !dateStr.isEmpty()) {
    //                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //                 try {
    //                     try {
    //                         expiration = sdf.parse(dateStr);
    //                     } catch (java.text.ParseException ex) {
    //                         System.out.println("err parsing date");
    //                     }
    //                 } catch (ParseException e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //             
    //             // public PerishableFood(int storageTemp, int id, int quantity, String name, String type, Date expiryDate) {
    //             
    //             // public PerishableFood(int id, int quantity, String name, String type, String expiryDate, int storageTemp) {
    //             
    //             if(foodType.equals("Perishable")) {
    //                 // TODO: add storage temp to db
    //                 int storageTemp = ThreadLocalRandom.current().nextInt(0, 78 + 1);
    //                 
    //                 
    //                 PerishableFood pf = new PerishableFood(storageTemp, foodId, quantity, foodName, foodType, expiration);
    //                 
    //                 // cast to an abstract food item
    //                 foodItems.add((FoodItem)pf);
    //             } else if (foodType.equals("NonPerishable")) {
    //                 // public NonPerishableFood(int id, int quantity, String name, String type, Date expiryDate) {
    //                 NonPerishableFood npf = new NonPerishableFood(foodId, quantity, foodName, foodType, expiration);
    //                 
    //                 foodItems.add((FoodItem)npf);
    //             }
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e);
    //     }
    //     
    //     return foodItems;
    // }
}
