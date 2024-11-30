/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.conor;

import java.util.ArrayList;

/**
 *
 * @author conor
 * 
 * 
 * 
 */
public class FoodStockApp {
    
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
        foodItem.add(new PerishableFood(5, 20, "Chicken", "Meat", "19-12-2024", -5));
        
    }
    
    public void viewRecords(){
        return;
    }
    
    public void addFoodItem(){
        return;
    }
    
    public void editFoodItem(){
        return;
    }
    
    public void deleteFoodItem(){
        return;
    }

    public ArrayList<FoodItem> getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(ArrayList<FoodItem> foodItem) {
        this.foodItem = foodItem;
    }
    
    
    
}

