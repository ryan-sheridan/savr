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
        IN_TRANSIT,
        OUT_FOR_DELIVERY,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }
    
    private WasteSource source;
    private FoodSaver saver;
    private DeliveryStatus status;
    private Integer id;
    
    public RedistributionRecord(Integer id, WasteSource source, FoodSaver recipient, DeliveryStatus status) {
        this.id = id;
        this.source = source;
        this.saver = recipient;
        this.status = status;
    }

    public WasteSource getSource() {
        return source;
    }

    public FoodSaver getSaver() {
        return saver;
    }

    public DeliveryStatus getStatus() {
        return status;
    }
    
    public void setSource(WasteSource source) {
        this.source = source;
    }

    public void setSaver(FoodSaver recipient) {
        this.saver = recipient;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
