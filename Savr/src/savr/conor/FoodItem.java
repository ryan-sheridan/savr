/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.conor;

import java.util.Date;

/**
 *
 * @author conor
 */
public abstract class FoodItem {
    //declare variables
    protected int id, quantity;
    protected String name, type;
    protected Date expiryDate;

    public FoodItem() {
    }

    public FoodItem(int id, int quantity, String name, String type, Date expiryDate) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.type = type;
        this.expiryDate = expiryDate;
    }
    
    // Method to check if the food item is expired
    public boolean isExpired() {
        Date currentDate = new Date();
        return expiryDate != null && expiryDate.before(currentDate);
    }
    
    
}

