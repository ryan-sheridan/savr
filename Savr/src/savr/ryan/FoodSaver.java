/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

/**
 *
 * @author ryan
 */
public class FoodSaver {
    
    public enum SaverType {
        INDIVIDUAL,
        ORGANISATION
    }
    
    protected String firstName;
    protected String lastName;
    
    protected String organisationName;
    
    protected SaverType saverType;
    protected ContactInfo contactInfo;
    protected Location location;
    protected double totalRecieved;
    protected Integer id;

    protected FoodSaver(Integer id, String firstName, String lastName, SaverType saverType, ContactInfo contactInfo, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.saverType = saverType;
        this.contactInfo = contactInfo;
        this.location = location;
    }
    
    protected FoodSaver(Integer id, String organisationName, SaverType saverType, ContactInfo contactInfo, Location location) {
        this.id = id;
        this.organisationName = organisationName;
        this.saverType = saverType;
        this.contactInfo = contactInfo;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SaverType getSaverType() {
        return saverType;
    }

    public void setSaverType(SaverType saverType) {
        this.saverType = saverType;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getTotalRecieved() {
        return totalRecieved;
    }

    public void setTotalRecieved(double totalRecieved) {
        this.totalRecieved = totalRecieved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
