/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.conor;

import com.savrui.components.FoodStockAppManager;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author conor
 * 
 * 
 * 
 */
public class FoodStockApp implements Serializable {
    
    protected ArrayList<FoodItem> foodItem;

    public FoodStockApp(ArrayList<FoodItem> foodItem) {
        this.foodItem = foodItem;
    }

    public FoodStockApp() {
    }
    
    //addRecords method will add records so the GUI has information on startup
    public void addRecords(){
        if(foodItem == null) {//if foodItem is null initialize new ArrayList
           foodItem = new ArrayList<>(); //initialize the foodItem arrayList
        }
        
        //add some nonperishable items
        foodItem.add(new NonPerishableFood(1,100,"Pasta", "Grain", "12-12-2025",12));
        foodItem.add(new NonPerishableFood(2, 50, "Canned Peas", "Canned Goods", "27-12-2025", 24));
        
        //add some perishable items
        foodItem.add(new PerishableFood(4,10,"Milk", "Dairy", "8-12-2024", 4));
        foodItem.add(new PerishableFood(5, 20, "Chicken", "Meat", "19-12-2024", 2));
        
    }
    
    //method for viewing stock panel, shows perishable and non perishable food in stock
    public String viewRecords(String selectedOption){              
        //switch statement to choose what to display
        
        switch(selectedOption){
            case "Perishable Food":
                return showPerishableFood();
                              
            case "Non-Perishable Food":
               return showNonPerishableFood();
                             
            case "None Selected":
            default:
                return "Please select an option from Dropdown Menu";
        }
        
    }
    
    //method to add new food record to the stock
    public void addFoodItem(int id, int quantity, String name, String type, String expiryDate, String storageTemp, String monthlyShelfLife){
    boolean idExists = false;
    for (FoodItem item : foodItem) {
        if (item.getId() == id) {
            idExists = true;  // id exists set to true
            break;  //exit the loop if id is being used
        }
    }

    if (!idExists) {//if id doesnt exist
        // create food item based on type
        FoodItem newItem = null;
        
        if (type.equals("Yes")) {
            //makes the perishable food item
            try {
                int storageTempValue = Integer.parseInt(storageTemp);  //parse storage temp
                newItem = new PerishableFood(id, quantity, name, type, expiryDate, storageTempValue);
            } catch (NumberFormatException e) {
                //if user enters in wrong format display message
                JOptionPane.showMessageDialog(null, "Invalid storage temperature. Please enter a valid number.");
                return;
            }
        } else if (type.equals("No")) {
            // makes a nonperish food item
            try {
                int shelfLifeValue = Integer.parseInt(monthlyShelfLife);  //parse shelf life
                newItem = new NonPerishableFood(id, quantity, name, type, expiryDate, shelfLifeValue);
            } catch (NumberFormatException e) {               
                JOptionPane.showMessageDialog(null, "Invalid monthly shelf life. Please enter a valid number.");
                return;
            }
        } 

        //adds new item to the foodlist
        foodItem.add(newItem);
        JOptionPane.showMessageDialog(null, "Food Item Added Successfully!");
    } else {
        //if id already exists show message
        JOptionPane.showMessageDialog(null, "ID is already in use!");
    }
    }
    
    //method to search for the food item using its ID
    public void searchFoodItem(int id){
       boolean foundItem = false;
       
       //loop through the food items to find id match
       for(FoodItem item : foodItem){
           if(item.getId() == id){//check if current food item matches id inputted
               foundItem = true;//id found so set to true
               
               //fill GUI fields with the information from that ID
               FoodStockAppManager.idTF.setText(Integer.toString(item.getId()));
               FoodStockAppManager.nameTF.setText(item.getName());
               FoodStockAppManager.foodTypeTF.setText(item.getType());
               FoodStockAppManager.expiryDateTF.setText(item.getExpiryDate());
               FoodStockAppManager.quantityTF.setText(Integer.toString(item.getQuantity()));
              
               
               //for the perishable and non perish foods details
               
               if(item instanceof PerishableFood){//check if item is an instance of perishablefood
                   PerishableFood p = (PerishableFood) item;
                   //update combo box and storage temp fields
                   FoodStockAppManager.perishableCB.setSelectedItem("Yes");
                   FoodStockAppManager.storageTempTF.setText(Integer.toString(p.getStorageTemp()));
                   //else if its nonperish
               }else if(item instanceof NonPerishableFood){
                   NonPerishableFood np = (NonPerishableFood) item;
                   //update combo box and monthly shelf life fields
                   FoodStockAppManager.perishableCB.setSelectedItem("No");
                   FoodStockAppManager.monthlyShelfTF.setText(Integer.toString(np.getMonthlyShelfLife()));
               }
               //display message
               JOptionPane.showMessageDialog(null, "Food Item Found!");
               break; //exit loop when items found
           }
       }
       
        //if its not found show an error message
        if(!foundItem){
            JOptionPane.showMessageDialog(null, "No Food Item with that ID");
            
            //clear the fields if incorrect search
            FoodStockAppManager.idTF.setText("");
            FoodStockAppManager.nameTF.setText("");
            FoodStockAppManager.foodTypeTF.setText("");
            FoodStockAppManager.quantityTF.setText("");
            FoodStockAppManager.expiryDateTF.setText("");
            FoodStockAppManager.storageTempTF.setText("");
            FoodStockAppManager.monthlyShelfTF.setText("");
            FoodStockAppManager.perishableCB.setSelectedItem("None Selected");
            
        }
       
    }
    
    //method to edit the information of the food item list
    public void editFoodItem(int id, int quantity, String name, String type, String expiryDate, String storageTemp, String monthlyShelfLife){
        boolean foundItem = false;
        
        for(FoodItem item : foodItem){
            if(item.getId() == id){
             foundItem = true;
             
             //update the items details
             item.setQuantity(quantity);
             item.setName(name);
             item.setExpiryDate(expiryDate);
             item.setType(type);
             
             //update fields of perishable and non perish
             
             if(item instanceof PerishableFood && type.equals("Yes")){
                 ((PerishableFood) item).setStorageTemp(Integer.parseInt(storageTemp));                
             }else if(item instanceof NonPerishableFood && type.equals("No")){
                 ((NonPerishableFood) item).setMonthlyShelfLife(Integer.parseInt(monthlyShelfLife));
             }
             //show message to user to confirm the change
             JOptionPane.showMessageDialog(null, "Food Item edited successfully!");
             return;//exit after finding item
            }
            
        }
        //if there is no ID matching, display message
        if (!foundItem) {
        JOptionPane.showMessageDialog(null, "Food item not found, check ID!");
    }
    }
    
    //method to delete food items from the list 
    public void deleteFoodItem(int id){
        boolean idFound = false; //track whether ID  is found in list
        
        //for loop to find item with matching id
        for(FoodItem item : foodItem){
            if(item.getId() == id){
                foodItem.remove(item);//remove item if it matches existing ID
                idFound = true;//set to true as item found
                JOptionPane.showMessageDialog(null, "Food Item with ID: " + id + " has been deleted");
                break; //exit loop after its done
            }
        }
        if(!idFound){//if id isnt on array list
            JOptionPane.showMessageDialog(null, "ID not found");
        }
    }

    public ArrayList<FoodItem> getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(ArrayList<FoodItem> foodItem) {
        this.foodItem = foodItem;
    }
    
    public String showPerishableFood(){
        //create StringBuilder to display the result as a string and start with title
        StringBuilder result = new StringBuilder("Perishable Food Items: \n");
        //track whether perishable foods  found or not
        boolean found = false;
        //go through food item list
        for(FoodItem item : foodItem){
           if(item.needsRefrigeration()) {//if it needs refrigeration it is perishable
               //append the items name and quantity to result
               result.append(item.getName())
                       .append(" - Quantity: ")
                       .append(item.getQuantity())
                       .append(" - Storage Temp: ")
                       .append(((PerishableFood) item).getStorageTemp())
                       .append("°C\n");
               //set boolean flag to true, showing theres at least 1 persiahble food
               found = true;
           }
        }
        //check if any perishable items are found if they are display the result
        if(found){
            return result.toString();
        }else{ //if it isnt found return this message
            return "No Perishable food items found \n";
        }
    }
    
    public String showNonPerishableFood(){
        StringBuilder result = new StringBuilder("Non Perishable Food Items: \n");
        
        boolean found = false;
        
        for(FoodItem item : foodItem){
           if(!item.needsRefrigeration()) {//if it doesnt need refrigeration it is non-perishable
               //append the items name quanitity, and shelf life to result
               result.append(item.getName())
                       .append(" - Quantity: ")
                       .append(item.getQuantity())
                       .append(" - Monthly Shelf Life: ")
                       .append(((NonPerishableFood) item).getMonthlyShelfLife())
                       .append(" Months\n");
               //set boolean flag to true, showing theres at least 1 persiahble food
               found = true;
           }
        }
        //check if any non perishable items are found if they are display the result
        if(found){
            return result.toString();
        }else{ //if it isnt found return this message
            return "No Non-Perishable food items found \n";
        }
        
    }
        
    }
    



