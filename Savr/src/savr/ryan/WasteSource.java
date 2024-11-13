/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

import savr.conor.FoodStockApp;

/**
 *
 * @author ryan
 */
public class WasteSource {
    
    public enum SourceType {
        SHOP,
        RESTAURANT,
        INDIVIDUAL,
        FOOD_BANK
    }
    
    private String sourceName;
    private SourceType sourceType;
    private Location location;
    private double wasteAmount;
    private FoodStockApp foodDistribution;

    public WasteSource(String sourceName, SourceType sourceType, Location location, double wasteAmount, FoodStockApp foodDistribution) {
        this.sourceName = sourceName;
        this.sourceType = sourceType;
        this.location = location;
        this.wasteAmount = wasteAmount;
        this.foodDistribution = foodDistribution;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getWasteAmount() {
        return wasteAmount;
    }

    public void setWasteAmount(double wasteAmount) {
        this.wasteAmount = wasteAmount;
    }

    public FoodStockApp getFoodDistribution() {
        return foodDistribution;
    }

    public void setFoodDistribution(FoodStockApp foodDistribution) {
        this.foodDistribution = foodDistribution;
    }
    
    public void updateWasteAmount(double amount) {
        return;
    }
    
    public String getSourceDetails() {
        return "";
    }
    
}
