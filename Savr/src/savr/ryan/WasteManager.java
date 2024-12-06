/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

import java.util.ArrayList;
import java.util.HashMap;
import savr.ryan.tools.RDataPersistence;

/**
 *
 * @author ryan
 */
public class WasteManager {
    private HashMap<Integer, RedistributionRecord> recordMap;
    private HashMap<Integer, WasteSource> sourceMap;
    private HashMap<Integer, FoodSaver> saverMap;

    public WasteManager() {
        recordMap = new HashMap<>();
        sourceMap = new HashMap<>();
        saverMap = new HashMap<>();
        
        ArrayList<RedistributionRecord> records = RDataPersistence.getSavedRedistributionRecords();
        for(RedistributionRecord record : records) {
            recordMap.put(record.getId(), record);
            
            WasteSource recordWasteSource = record.getSource();
            FoodSaver recordFoodSaver = record.getSaver();
            
            if(recordWasteSource != null) {
                sourceMap.put(recordWasteSource.getId(), recordWasteSource);
            }
            
            if(recordFoodSaver != null) {
                saverMap.put(recordFoodSaver.getId(), recordFoodSaver);
            }
        }
    }

    public void addWasteSource(Integer id, WasteSource source) {
        sourceMap.put(id, source);
    }

    public void addRedistributionRecord(Integer id, RedistributionRecord record) {
        recordMap.put(id, record);
    }

    public void addFoodSaver(Integer id, FoodSaver saver) {
        saverMap.put(id, saver);
    }

    public HashMap<Integer, WasteSource> getWasteSources() {
        return sourceMap;
    }

    public void setWasteSources(HashMap<Integer, WasteSource> wasteSources) {
        this.sourceMap = wasteSources;
    }

    public HashMap<Integer, RedistributionRecord> getRedistributionRecords() {
        return recordMap;
    }

    public void setRedistributionRecords(HashMap<Integer, RedistributionRecord> redistributionRecords) {
        this.recordMap = redistributionRecords;
    }

    public HashMap<Integer, FoodSaver> getFoodSavers() {
        return saverMap;
    }

    public void setFoodSavers(HashMap<Integer, FoodSaver> foodSavers) {
        this.saverMap = foodSavers;
    }
}