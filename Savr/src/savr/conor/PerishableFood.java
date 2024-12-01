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
public class PerishableFood extends FoodItem{
    
    private int storageTemp;

    public PerishableFood() {
    }

    public PerishableFood(int id, int quantity, String name, String type, String expiryDate, int storageTemp) {
        super(id, quantity, name, type, expiryDate);
        this.storageTemp = storageTemp;
    }
    
    
    @Override
    public boolean needsRefrigeration(){
        return true;
    }

    public int getStorageTemp() {
        return storageTemp;
    }

    public void setStorageTemp(int storageTemp) {
        this.storageTemp = storageTemp;
    }
    
    
}
