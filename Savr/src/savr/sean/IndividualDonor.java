/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.sean;

/**
 *
 * @author Sean
 */
public class IndividualDonor extends AgriculturalAid{
    //declare variables
    private String indiFirstName;
    private String indiSurname;
    private String indiDoB;
    private String indiAddress;
    private String indiEmail;
    private int indiPhoneNumber;

    public IndividualDonor() {//Empty Constructor
    }
    
    //Constructor
    public IndividualDonor(String indiFirstName, String indiSurname, String indiDoB, String indiAddress, String indiEmail, int indiPhoneNumber, String donorID, String itemID, String item, String dateReceived, String itemType, int itemQuantity, String condition, boolean isElectrical) {
        super(donorID, itemID, item, dateReceived, itemType, itemQuantity, condition, isElectrical);
        this.indiFirstName = indiFirstName;
        this.indiSurname = indiSurname;
        this.indiDoB = indiDoB;
        this.indiAddress = indiAddress;
        this.indiEmail = indiEmail;
        this.indiPhoneNumber = indiPhoneNumber;
    }

    //Setters and Getters for IndividualDonor Class
    public void setIndiFirstName(String indiFirstName) {
        this.indiFirstName = indiFirstName;
    }

    public void setIndiSurname(String indiSurname) {
        this.indiSurname = indiSurname;
    }

    public void setIndiDoB(String indiDoB) {
        this.indiDoB = indiDoB;
    }

    public void setIndiAddress(String indiAddress) {
        this.indiAddress = indiAddress;
    }

    public void setIndiEmail(String indiEmail) {
        this.indiEmail = indiEmail;
    }

    public void setIndiPhoneNumber(int indiPhoneNumber) {
        this.indiPhoneNumber = indiPhoneNumber;
    }

    public String getIndiFirstName() {
        return indiFirstName;
    }

    public String getIndiSurname() {
        return indiSurname;
    }

    public String getIndiDoB() {
        return indiDoB;
    }

    public String getIndiAddress() {
        return indiAddress;
    }

    public String getIndiEmail() {
        return indiEmail;
    }

    public int getIndiPhoneNumber() {
        return indiPhoneNumber;
    }
    
    //toString for displaying IndividualDonor information
     @Override
    public String toString() {
        return "----- Individual Donor -----\n" +
                "First Name: " + indiFirstName + "\n" +
                "Surname: " + indiSurname + "\n" +
                "Date of Birth: " + indiDoB + "\n" +
                "Address: " + indiAddress + "\n" +
                "Email: " + indiEmail + "\n" +
                "Phone Number: " + indiPhoneNumber + "\n"
                 + super.toString();
    } 
}
