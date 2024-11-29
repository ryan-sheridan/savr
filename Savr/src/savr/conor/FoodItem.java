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

    //add constructor
    public FoodItem() {
    }

    public FoodItem(int id, int quantity, String name, String type, Date expiryDate) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.type = type;
        this.expiryDate = expiryDate;
    }
       
    //abstract method
    public abstract boolean needsRefrigeration();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    
    
}

    