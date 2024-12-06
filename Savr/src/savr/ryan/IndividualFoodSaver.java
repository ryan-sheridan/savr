/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

import java.util.List;

/**
 *
 * @author ryan
 */
public class IndividualFoodSaver extends FoodSaver {
    public enum DietaryRestrictions {
        GLUTEN_FREE,
        NUT_FREE,
        DAIRY_FREE,
        VEGETARIAN,
        VEGAN,
        KETO,
        PALEO,
        HALAL,
        KOSHER
    }
    
    protected List<DietaryRestrictions> dietaryRestrictions;

    public void addRestriction(DietaryRestrictions restriction) {
        // logic
        return;
    }
    
    public void removeRestriction(DietaryRestrictions restriction) {
        // logic
        return;
    }
    
    public void setDietaryRestrictions(List<DietaryRestrictions> restrictions) {
        // logic
        return;
    }
    
    public IndividualFoodSaver(Integer id, String firstName, String lastName, SaverType saverType, ContactInfo contactInfo, Location location) {
        super(id, firstName, lastName, saverType, contactInfo, location);
    }
}
