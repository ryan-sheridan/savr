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
public class NonPerishableFood extends FoodItem{
    
    private int monthlyShelfLife;

    public NonPerishableFood() {
    }

    public NonPerishableFood(int id, int quantity, String name, String type, Date expiryDate) {
        super(id, quantity, name, type, expiryDate);
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
