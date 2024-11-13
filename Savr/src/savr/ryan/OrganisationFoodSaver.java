/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

/**
 *
 * @author ryan
 */
public class OrganisationFoodSaver extends FoodSaver {
    public double capacity;

    public OrganisationFoodSaver(String firstName, String lastName, SaverType saverType, ContactInfo contactInfo, Location location) {
        super(firstName, lastName, saverType, contactInfo, location);
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    
    
}
