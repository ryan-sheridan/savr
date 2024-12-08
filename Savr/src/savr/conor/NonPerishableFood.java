/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.conor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author conor
 */
public class NonPerishableFood extends FoodItem implements Serializable {
    
    private int monthlyShelfLife;

    public NonPerishableFood() {
    }

    public NonPerishableFood(int id, int quantity, String name, String type, String expiryDate, int monthlyShelfLife) {
        super(id, quantity, name, type, expiryDate);
        this.monthlyShelfLife = monthlyShelfLife;
    }
    
    @Override
    public boolean needsRefrigeration(){
        return false;
    }

    public int getMonthlyShelfLife() {
        return monthlyShelfLife;
    }

    public void setMonthlyShelfLife(int monthlyShelfLife) {
        this.monthlyShelfLife = monthlyShelfLife;
    }
    
    
}
