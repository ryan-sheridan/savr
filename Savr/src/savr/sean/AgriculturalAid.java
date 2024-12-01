/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.sean;

/**
 *
 * @author Sean
 */
public class AgriculturalAid {
    //declare variables
    protected String donorID;
    protected String itemID;
    protected String item;
    protected String dateReceived;
    protected String itemType;
    protected int itemQuantity;
    protected String condition;
    protected boolean isElectrical;

    public AgriculturalAid() {
    }

    public AgriculturalAid(String donorID, String itemID, String item, String dateReceived, String itemType, int itemQuantity, String condition, boolean isElectrical) {
        this.donorID = donorID;
        this.itemID = itemID;
        this.item = item;
        this.dateReceived = dateReceived;
        this.itemType = itemType;
        this.itemQuantity = itemQuantity;
        this.condition = condition;
        this.isElectrical = isElectrical;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setIsElectrical(boolean isElectrical) {
        this.isElectrical = isElectrical;
    }

    public String getDonorID() {
        return donorID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItem() {
        return item;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public String getItemType() {
        return itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getCondition() {
        return condition;
    }

    public boolean isIsElectrical() {
        return isElectrical;
    }
    
    
    public String toString() {
     return "Donor ID: " + donorID + "\n" +
            "Item ID: " + itemID + "\n" +
            "Item: " + item + "\n" +
            "Date Received Item: " + dateReceived + "\n" +
            "Item Type: " + itemType + "\n" +
            "Quantity of Item: " + itemQuantity + "\n" +
            "Item Condition: " + condition + "\n" +
            "Electrical Item: " + isElectrical;
}

    
}
