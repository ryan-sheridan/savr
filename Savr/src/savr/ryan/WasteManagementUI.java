/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ryan
 */
public class WasteManagementUI extends JPanel {
    private ArrayList<WasteSource> wasteSources;
    private ArrayList<RedistributionRecord> redistributionRecords;
    private ArrayList<FoodSaver> foodSavers;
    
    public void addWasteSource(WasteSource source) {
        // logic
        return;
    }
    
    public void addRedistributionRecord(RedistributionRecord record) {
        // logic
        return;
    }
    
    public void addFoodSaver(FoodSaver saver) {
        // logic
        return;
    }

    public ArrayList<WasteSource> getWasteSources() {
        return wasteSources;
    }

    public void setWasteSources(ArrayList<WasteSource> wasteSources) {
        this.wasteSources = wasteSources;
    }

    public ArrayList<RedistributionRecord> getRedistributionRecords() {
        return redistributionRecords;
    }

    public void setRedistributionRecords(ArrayList<RedistributionRecord> redistributionRecords) {
        this.redistributionRecords = redistributionRecords;
    }

    public ArrayList<FoodSaver> getFoodSavers() {
        return foodSavers;
    }

    public void setFoodSavers(ArrayList<FoodSaver> foodSavers) {
        this.foodSavers = foodSavers;
    }
    
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // logic
    }
}
