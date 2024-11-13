/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

/**
 *
 * @author ryan
 */
public class RedistributionRecord {
    public enum DeliveryStatus {
        INFO_RECIEVED,
        DELIVERED,
        IN_TRANSIT,
        OUT_FOR_DELIVERY,
        CANCELLED
    }
    
    private WasteSource source;
    private FoodSaver recipient;
    private DeliveryStatus status;

    public void setSource(WasteSource source) {
        this.source = source;
    }

    public void setRecipient(FoodSaver recipient) {
        this.recipient = recipient;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
    
    public boolean isPackageDelivered() {
        // logic
        return false;
    }
    
    public void sendNotification() {
        // logic
        return;
    }
}
