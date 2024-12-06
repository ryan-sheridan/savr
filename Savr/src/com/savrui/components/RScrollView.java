package com.savrui.components;

import static com.savrui.components.RScrollView.ScrollDataType.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import savr.ryan.FoodSaver;
import savr.ryan.RedistributionRecord;
import savr.ryan.WasteManager;
import savr.ryan.WasteSource;
import savr.ryan.tools.RDatabaseORM;
import savr.ryan.tools.RDynamicUI;
import savr.ryan.tools.interfaces.RInformationPanelEditor;

public class RScrollView extends JPanel {

    private JPanel contentPanel;
    private JScrollPane scrollPane;
    
    private ArrayList<RFadePanel> fadePanels;
    private RFadePanel focusedPanel = null;
    
    private WasteManager wasteManager;
    
    private RInformationPanelEditor editor;
    
    public void setRInformationPanelEditor(RInformationPanelEditor editor) {
        this.editor = editor;
    }
    
    // Object because were not sure of the datatype yet, could be source, saver or record
    private HashMap<Integer, ?> dataMap;
    
    public enum ScrollDataType {
        RECORD,
        SOURCE,
        SAVER
    }
    
    private ScrollDataType scrollDataType;

    public ScrollDataType getScrollDataType() {
        return scrollDataType;
    }

    public void setScrollDataType(ScrollDataType scrollDataType) {
        this.scrollDataType = scrollDataType;
    }
    

    public RScrollView() {
        super(new BorderLayout());
        scrollDataType = SOURCE;
        
        fadePanels = new ArrayList<>();

        if (!java.beans.Beans.isDesignTime()) {
            WasteManager wasteManager = new WasteManager();
            initializeData(wasteManager);
        }

        // content panel with vertical layout
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        
        boolean secondaryColour = true;
        
        if(dataMap == null) {
            return;
        }
        
        for (Map.Entry<Integer, ?> entry : dataMap.entrySet()) {
            Integer key = entry.getKey();
            Object value = entry.getValue();
            RFadePanel panel = new RFadePanel();
            
            if(value instanceof WasteSource) {
                WasteSource source = (WasteSource)value;
                panel = createWasteSourcePanel(source);
                contentPanel.add(panel);
            } else if (value instanceof FoodSaver) {
                FoodSaver saver = (FoodSaver)value;
                panel = createFoodSaverPanel(saver);
                contentPanel.add(panel);
            } else if (value instanceof RedistributionRecord) {
                RedistributionRecord record = (RedistributionRecord)value;
                panel = createRedistributionPanel(record);
                contentPanel.add(panel);
            }
            
            if(secondaryColour) {
                panel.setBackground(new Color(60, 60, 60));
            }

            secondaryColour = !secondaryColour;
            
        }
        
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void initializeData(WasteManager wasteManager) {
        // grab map from db
        if(scrollDataType == SOURCE) {
            dataMap = wasteManager.getWasteSources();
        } else if (scrollDataType == SAVER) {
            dataMap = wasteManager.getFoodSavers();
        } else if (scrollDataType == RECORD) {
            dataMap = wasteManager.getRedistributionRecords();
        }
    }
    
    private void focusPanel(RFadePanel focusPanel, float opacity) {
        for (RFadePanel panel : fadePanels) {
            if (panel == focusPanel) {
                panel.setOpacity(1f);
            } else {
                panel.setOpacity(opacity); 
            }
        }
        focusedPanel = focusPanel;
    }
    
    private void unfocusAll() {
        for(RFadePanel panel : fadePanels) {
            panel.setOpacity(1f);
        }
        focusedPanel = null;
    }
    
    private RFadePanel createDataPanel() {
        RFadePanel panel = new RFadePanel();
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                focusPanel(panel, 0.1f);
                
                Integer dataId = Integer.valueOf((String)panel.getClientProperty("dataId"));
                Object value = dataMap.get(dataId);
                if (value instanceof WasteSource) {
                    WasteSource wasteSource = (WasteSource)value;
                    editor.updateSourceNameField(wasteSource.getSourceName());
                    editor.updateWasteAmountField(String.valueOf(wasteSource.getWasteAmount()));
                    editor.updateSourceAddressField(wasteSource.getLocation().getCountry());
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                focusPanel(panel, 0.3f);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                unfocusAll();
            }
        });
        
        fadePanels.add(panel);
        
        panel.setLayout(new BorderLayout());
        panel.setBackground(RDynamicUI.getCurrentPalleteColour("Button.background"));
        
        return panel;
    }
    
    private RFadePanel createDataPanel(String id, String name) {
        RFadePanel panel = createDataPanel();
        
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        
        JLabel idLabel = new JLabel(id);
        idLabel.setForeground(Color.GRAY);
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setPreferredSize(new Dimension(40, 0)); 
        idLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        
        JLabel nameLabel = new JLabel(name);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setHorizontalAlignment(SwingConstants.LEADING);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        contentPanel.add(idLabel, BorderLayout.WEST); 
        contentPanel.add(nameLabel, BorderLayout.CENTER);
        
        panel.add(contentPanel, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        panel.putClientProperty("dataId", id);
        
        return panel;
    }


    private RFadePanel createDataPanel(String id, String name, String secondary) {
        RFadePanel panel = createDataPanel(id, name);
        
        JLabel secondaryLabel = new JLabel(secondary);
        secondaryLabel.setForeground(new Color(0x22, 0xc5, 0x5e));
        secondaryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        secondaryLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(secondaryLabel, BorderLayout.EAST);

        return panel;
    }
    
    private RFadePanel createWasteSourcePanel(WasteSource source) {
        return createDataPanel(source.getId().toString(), source.getSourceName(), String.format("%s", source.getSourceType()));
    }
    
    private RFadePanel createFoodSaverPanel(FoodSaver saver) {
        return createDataPanel("1", saver.getFirstName() +" "+ saver.getLastName());
    }
    
    private RFadePanel createRedistributionPanel(RedistributionRecord record) {
        return createDataPanel("1", "record");
    }
}