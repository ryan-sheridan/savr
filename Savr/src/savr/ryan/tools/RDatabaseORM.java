package savr.ryan.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import savr.conor.FoodItem;
import savr.conor.FoodStockApp;
import savr.conor.NonPerishableFood;
import savr.conor.PerishableFood;
import savr.ryan.ContactInfo;
import savr.ryan.FoodSaver;
import savr.ryan.FoodSaver.SaverType;
import static savr.ryan.FoodSaver.SaverType.INDIVIDUAL;
import static savr.ryan.FoodSaver.SaverType.ORGANISATION;
import savr.ryan.IndividualFoodSaver;
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

// this class was completely redone, the main idea is to create instances of
// WasteSource, FoodSaver, and RedistributionRecord based on the database

// trying my best to use DRY

public class RDatabaseORM {
    
    // SECTION: RedistributionRecord
    
    private static RedistributionRecord getRedistributionRecordByResultSet(ResultSet rs) throws SQLException {
        try {
            int id = rs.getInt("id");
            
            FoodSaver foodSaver = getFoodSaverById(rs.getInt("foodsaverId"));
            DeliveryStatus deliveryStatus = DeliveryStatus.valueOf(rs.getString("status"));
            WasteSource wasteSource = getWasteSourceById(rs.getInt("wastesourceid"));
            
            return new RedistributionRecord(Integer.valueOf(1), wasteSource, foodSaver, deliveryStatus);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static RedistributionRecord getRedistributionRecordById(int redistributionId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();
        FoodSaver fs;

        String query = "select * from redistributionrecord where id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, redistributionId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { 
                return getRedistributionRecordByResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    
    public static ArrayList<RedistributionRecord> getRedistributionRecords() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();
        ArrayList<RedistributionRecord> redistributionRecords = new ArrayList<>();

        String query = "select * from redistributionrecord";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs != null) {
                    RedistributionRecord rr = getRedistributionRecordByResultSet(rs);
                    redistributionRecords.add(rr);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return redistributionRecords;
    }
    
    // SECTION_END

    public static ContactInfo getContactById(int contactId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "SELECT * FROM contact_info WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, contactId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                return new ContactInfo(Integer.valueOf(id), email, phone);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        
        return null;
    }

    public static Location getLocationById(int locationId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "SELECT * FROM location WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, locationId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String country = rs.getString("country");
                double lon = rs.getDouble("longitude");
                double lat = rs.getDouble("latitude");
                
                return new Location(Integer.valueOf(id), lon, lat, country);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return null;
    }

    // SECTION: WasteSource
    
    public static WasteSource getWasteSourceFromResultSet(ResultSet rs) throws SQLException {
        try {
            int id = rs.getInt("id");
            String name = rs.getString("sourceName");
            SourceType sourceType = SourceType.valueOf(rs.getString("sourceType"));
            
            Location location = getLocationById(rs.getInt("locationId"));
            double wasteAmount = rs.getInt("wasteAmount");
            
            // singular food item, should be more than 1
            FoodItem foodItem = getFoodItemById(id);
            ArrayList<FoodItem> foodItems = new ArrayList<>();
            foodItems.add(foodItem);
            FoodStockApp fsa = new FoodStockApp(foodItems);
            
            WasteSource wasteSource = new WasteSource(id, name, sourceType, location, wasteAmount, fsa);
            return wasteSource;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static WasteSource getWasteSourceById(int wasteId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        String query = "select * from wastesource where id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, wasteId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                WasteSource wasteSource = getWasteSourceFromResultSet(rs);
                return wasteSource;
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return null;
    }
    
    public static ArrayList<WasteSource> getWasteSources() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        ArrayList<WasteSource> wasteSources = new ArrayList<>();

        String query = "select * from wastesource";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                WasteSource wasteSource = getWasteSourceFromResultSet(rs);
                if(wasteSource != null) {
                    wasteSources.add(wasteSource);
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return wasteSources;
    }
    
    // SECTION_END
    
    // SECTION: FoodSaver
    
    private static FoodSaver getFoodSaverFromResultSet(ResultSet rs) throws SQLException {
        try {
            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            SaverType saverType = SaverType.valueOf(rs.getString("saverType"));
            
            ContactInfo contactInfo = getContactById(rs.getInt("contactInfoId"));
            Location location = getLocationById(rs.getInt("locationId"));
            
            // public IndividualFoodSaver(Integer id, String firstName, String lastName, SaverType saverType, ContactInfo contactInfo, Location location)
            
            if(saverType == INDIVIDUAL) {
                return new IndividualFoodSaver(Integer.valueOf(id), firstName, lastName, saverType, contactInfo, location);
            } else if (saverType == ORGANISATION) {
                return new OrganisationFoodSaver(Integer.valueOf(id), firstName+lastName, saverType, contactInfo, location);
            }
            
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public static FoodSaver getFoodSaverById(int recipientId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();
        FoodSaver fs;

        String query = "select * from foodsaver where id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, recipientId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                fs = getFoodSaverFromResultSet(rs);
                return fs;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    
    public static ArrayList<FoodSaver> getFoodSavers() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();

        ArrayList<FoodSaver> foodSavers = new ArrayList<>();

        String query = "select * from foodsaver";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FoodSaver fs = getFoodSaverFromResultSet(rs);
                if(fs != null) {
                    foodSavers.add(fs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return foodSavers;
    }

    // SECTION_END
    
    // SECTION: FoodItem
    
    private static FoodItem getFoodItemFromResultSet(ResultSet rs) throws SQLException {
        try {
            int id = rs.getInt("id");
            int quantity = rs.getInt("quantity");
            String foodName = rs.getString("name");
            String foodType = rs.getString("type");
            String dateStr = rs.getString("expiryDate");

            // parse expiry date
            Date expiryDate = null;
            if (dateStr != null && !dateStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    expiryDate = sdf.parse(dateStr);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            }

            // random value for storage temp and monthly shelf life, im lazy
            int random = Math.round((int) ThreadLocalRandom.current().nextDouble(0, 200));
            
            if ("PERISHABLE".equals(foodType)) {
                return new PerishableFood(id, quantity, foodName, foodType, expiryDate.toString(), random);
            } else if ("NON_PERISHABLE".equals(foodType)) {
                return new NonPerishableFood(id, quantity, foodName, foodType, expiryDate.toString(), random);
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public static FoodItem getFoodItemById(int foodId) {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();
        FoodItem foodItem = null;

        String query = "select * from fooditem where id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, foodId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                foodItem = getFoodItemFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return foodItem;
    }

    public static ArrayList<FoodItem> getFoodItems() {
        RDataPersistence rdp = RDataPersistence.getInstance();
        Connection conn = rdp.getConnection();
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        String query = "select * from foodtem";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FoodItem foodItem = getFoodItemFromResultSet(rs);
                if (foodItem != null) {
                    foodItems.add(foodItem);
                }
            }
        } catch (SQLException e) {
            System.out.println("err fetching food items: " + e.getMessage());
        }

        return foodItems;
    }
    
    // SECTION_END 
}
