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
    private double capacity;
    private Integer id;

    public OrganisationFoodSaver(Integer id, String organisationName, SaverType saverType, ContactInfo contactInfo, Location location) {
        super(id, organisationName, saverType, contactInfo, location);
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
