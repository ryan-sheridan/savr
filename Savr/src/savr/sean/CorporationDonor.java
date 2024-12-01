/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.sean;

/**
 *
 * @author Sean
 */
public class CorporationDonor extends AgriculturalAid{
    //declare variables
    private String corpName;
    private int corpFoundingYear;
    private String corpHeadquareterAddress;
    private String corpEmail;
    private int corpPhoneNumber;

    public CorporationDonor() {
    }

    public CorporationDonor(String corpName, int corpFoundingYear, String corpHeadquareterAddress, String corpEmail, int corpPhoneNumber, String donorID, String itemID, String item, String dateReceived, String itemType, int itemQuantity, String condition, boolean isElectrical) {
        super(donorID, itemID, item, dateReceived, itemType, itemQuantity, condition, isElectrical);
        this.corpName = corpName;
        this.corpFoundingYear = corpFoundingYear;
        this.corpHeadquareterAddress = corpHeadquareterAddress;
        this.corpEmail = corpEmail;
        this.corpPhoneNumber = corpPhoneNumber;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setCorpFoundingYear(int corpFoundingYear) {
        this.corpFoundingYear = corpFoundingYear;
    }

    public void setCorpHeadquareterAddress(String corpHeadquareterAddress) {
        this.corpHeadquareterAddress = corpHeadquareterAddress;
    }

    public void setCorpEmail(String corpEmail) {
        this.corpEmail = corpEmail;
    }

    public void setCorpPhoneNumber(int corpPhoneNumber) {
        this.corpPhoneNumber = corpPhoneNumber;
    }

    public String getCorpName() {
        return corpName;
    }

    public int getCorpFoundingYear() {
        return corpFoundingYear;
    }

    public String getCorpHeadquareterAddress() {
        return corpHeadquareterAddress;
    }

    public String getCorpEmail() {
        return corpEmail;
    }

    public int getCorpPhoneNumber() {
        return corpPhoneNumber;
    }
  
    @Override
    public String toString(){
        return "----- Corporation Donor -----\n" +
               "Corporation Name: " + corpName + "\n" +
               "Corporation Founding Year: " + corpFoundingYear + "\n" +
               "Corporation HQ Address: " + corpHeadquareterAddress + "\n" +
               "Corporation Email: " + corpEmail + "\n" +
               "Corporation Phone Number: " + corpPhoneNumber + "\n"
                + super.toString();
    }
}
    
