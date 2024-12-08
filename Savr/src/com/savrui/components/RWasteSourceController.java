/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.savrui.components;

import com.ryansheridan.rfields.RTextField;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import savr.MainApplication;
import savr.conor.FoodStockApp;
import savr.ryan.FoodSaver;
import savr.ryan.Location;
import savr.ryan.RedistributionRecord;
import savr.ryan.WasteManager;
import savr.ryan.WasteSource;
import savr.ryan.WasteSource.SourceType;
import savr.ryan.tools.RDataPersistence;
import savr.ryan.tools.interfaces.RInformationPanelEditor;

/**
 *
 * @author ryan
 */
public class RWasteSourceController extends javax.swing.JPanel implements RInformationPanelEditor {

    /**
     * Creates new form RWasteSourceController
     */
    public RWasteSourceController() {
        initComponents();
        
        sourceEdit.fadeIn();
        rScrollView1.setRInformationPanelEditor(this);
    }


    public void setSourceAddressField(String text) {
        sourceAddressField.setText(text);
    }
    
    private WasteSource selectedSource;
    private FoodSaver selectedFoodSaver;
    private RedistributionRecord selectedRecord;

    public WasteSource getSelectedSource() {
        return selectedSource;
    }

    public void setSelectedSource(WasteSource selectedSource) {
        this.selectedSource = selectedSource;
        
    }

    public FoodSaver getSelectedFoodSaver() {
        return selectedFoodSaver;
    }

    public void setSelectedFoodSaver(FoodSaver selectedFoodSaver) {
        this.selectedFoodSaver = selectedFoodSaver;
    }

    public RedistributionRecord getSelectedRecord() {
        return selectedRecord;
    }

    public void setSelectedRecord(RedistributionRecord selectedRecord) {
        this.selectedRecord = selectedRecord;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rTextField1 = new com.ryansheridan.rfields.RTextField();
        rButton5 = new com.savrui.components.RButton();
        rButton3 = new com.savrui.components.RButton();
        rButton6 = new com.savrui.components.RButton();
        rScrollView1 = new com.savrui.components.RScrollView();
        jPanel1 = new javax.swing.JPanel();
        sourceEdit = new com.savrui.components.RFadePanel();
        sourceAddressField = new com.ryansheridan.rfields.RTextField();
        sourceNameField = new com.ryansheridan.rfields.RTextField();
        sourceWasteAmountField = new com.ryansheridan.rfields.RTextField();
        selectedIdLabel = new javax.swing.JLabel();
        sourceFieldTypeCombo = new javax.swing.JComboBox<>();
        rButton2 = new com.savrui.components.RButton();
        submitEdit = new com.savrui.components.RButton();
        jLabel2 = new javax.swing.JLabel();
        rButton1 = new com.savrui.components.RButton();
        rButton4 = new com.savrui.components.RButton();

        rTextField1.setBackground(new java.awt.Color(50, 50, 50));
        rTextField1.setBorderBottom(false);
        rTextField1.setBottomLeftRadius(10);
        rTextField1.setBottomRightRadius(10);
        rTextField1.setPlaceholder("Search Source");
        rTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTextField1ActionPerformed(evt);
            }
        });

        rButton5.setText("Import Data");
        rButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton5ActionPerformed(evt);
            }
        });

        rButton3.setBackground(new java.awt.Color(16, 121, 234));
        rButton3.setText("Export Data");
        rButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton3ActionPerformed(evt);
            }
        });

        rButton6.setButtonType(com.savrui.components.RButton.ButtonType.HOME);
        rButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton6ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.CardLayout());

        sourceEdit.setOpacity(0f);
        sourceEdit.setVisible(false);

        sourceAddressField.setFieldType(com.ryansheridan.rfields.RTextField.FieldType.ANY);
        sourceAddressField.setPlaceholder("Country / Location");
        sourceAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceAddressFieldActionPerformed(evt);
            }
        });

        sourceNameField.setPlaceholder("Name");

        sourceWasteAmountField.setFieldType(com.ryansheridan.rfields.RTextField.FieldType.ANY);
        sourceWasteAmountField.setPlaceholder("Waste Amount");

        selectedIdLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        selectedIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedIdLabel.setText("Selected: None");
        selectedIdLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sourceFieldTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Source Type", "RETAILER", "RESTAURANT", "INDIVIDUAL", "FARMER", " " }));
        sourceFieldTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceFieldTypeComboActionPerformed(evt);
            }
        });

        rButton2.setBackground(new java.awt.Color(34, 197, 94));
        rButton2.setText("Create New");
        rButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton2ActionPerformed(evt);
            }
        });

        submitEdit.setBackground(new java.awt.Color(34, 197, 94));
        submitEdit.setText("Submit Edit");
        submitEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Make an edit");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout sourceEditLayout = new javax.swing.GroupLayout(sourceEdit);
        sourceEdit.setLayout(sourceEditLayout);
        sourceEditLayout.setHorizontalGroup(
            sourceEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sourceNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sourceWasteAmountField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sourceAddressField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectedIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
            .addComponent(sourceFieldTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(submitEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sourceEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        sourceEditLayout.setVerticalGroup(
            sourceEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sourceEditLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(rButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceWasteAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceFieldTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(sourceEdit, "card3");

        rButton1.setText("Delete Selected");
        rButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton1ActionPerformed(evt);
            }
        });

        rButton4.setText("Clear All Entries");
        rButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rScrollView1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addComponent(rTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rScrollView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(rButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private HashMap<Integer, WasteSource> origWasteSources;
    
    // man its 1 in the morning
    private void rTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTextField1ActionPerformed
        
        // once the user presses enter, grab the text
        String inputText = rTextField1.getText().trim();

        // create our dialog box incase theres an error
        RGlassDialog glassPanel = new RGlassDialog("Ok", "") {
            @Override
            public void dismissPress() {
                super.dismissPress();
                rScrollView1.setDataMap(origWasteSources);
                rScrollView1.updateAll();
            }
        };

        // to interact with the RScrollView we need some data, keep a copy of the original data to go back to
        // after we are finished displaying 1 record on the RScrollView
        WasteManager wasteManager = WasteManager.getInstance();
        HashMap<Integer, WasteSource> origWasteSources = wasteManager.getWasteSources();

        // if the input text is empty
        if (inputText.isEmpty()) {
            glassPanel.setTitle("Input must be a valid WasteSource id!");
            glassPanel.fadeInOver((Component) evt.getSource());
            rScrollView1.setDataMap(origWasteSources); 
            rScrollView1.updateAll();
            return;
        }

        // if we cannot parse the waste source id
        // e.g. someone enters SABDIJBASIDBIASBIJn
        int wasteSourceId;
        try {
            wasteSourceId = Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            glassPanel.setTitle("Format error, input must be a valid WasteSource id!");
            glassPanel.fadeInOver((Component) evt.getSource());
            rScrollView1.setDataMap(origWasteSources);
            rScrollView1.updateAll();
            return;
        }

        // grab a waste source by the id that we just grabbed
        WasteSource wasteSource = wasteManager.getWasteSourceById(wasteSourceId);

        if (wasteSource != null) {
            // if the waste source exists wack it into a hashmap and pass it to RScrollView
            // because RScrollView likes HashMaps
            HashMap<Integer, WasteSource> singularWasteSource = new HashMap<>();
            singularWasteSource.put(wasteSource.getId(), wasteSource);

            // updateAll to update the actual scrollView
            rScrollView1.setDataMap(singularWasteSource);
            rScrollView1.updateAll();
        } else {
            // if wasteSource does not exist, this means the number cannot be found
            // the database stores 1000 WasteSources so input 1111 for this error
            glassPanel.setTitle(String.format("Cannot find WasteSource with id of %d", wasteSourceId));
            glassPanel.fadeInOver((Component) evt.getSource());

            // in the event of an error display original waste sources
            rScrollView1.setDataMap(origWasteSources);
            rScrollView1.updateAll();
        }
    }//GEN-LAST:event_rTextField1ActionPerformed

    private void rButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton3ActionPerformed
        // grab a WasteManager instance to get our data
        WasteManager wasteManager = WasteManager.getInstance();
        // get it in the form of a HashMap
        HashMap<Integer, WasteSource> wasteSources = wasteManager.getWasteSources();
        
        // create a filename, we dont want to rewrite over past files so use
        // day hour minute second, which will be random enough
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddHHmmss"));
        
        // create our dialog message box
        RGlassDialog glassPanel = new RGlassDialog("Default (AppData)", "Choose Location") {
            @Override
            public void submitPress() {
                // since submit is pressed, the user doesnt mind saving to default app data, so do that
                super.submitPress();
                RDataPersistence.exportObject(wasteSources, "sources-" + filename + ".dat");
            }
            
            @Override
            public void dismissPress() {
                // jfilechooser logic for directory choosing
                // general jfilechooser stuff
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Directory to Save File");
                // we are here to select a directory to place our file in not a file to place our file in
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);

                int userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    // grab the directory path the user chose and save the serialised hashmap there
                    String directoryPath = selectedDirectory.getAbsolutePath();
                    RDataPersistence.exportObject(wasteSources, "sources-" + filename + ".dat", directoryPath);
                } else {
                    System.out.println("no directory selected");
                }
                super.dismissPress();
            }
        };
        
        glassPanel.setTitle("Would you like to choose a file location?");
        glassPanel.fadeInOver((Component) evt.getSource());
    }//GEN-LAST:event_rButton3ActionPerformed

    private void rButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton6ActionPerformed
        // thanks sean
        MainApplication zerohunger = new MainApplication();
        zerohunger.setVisible(true);
        zerohunger.setLocationRelativeTo(null);
        
        Window pFrame = SwingUtilities.getWindowAncestor(this);
        if(pFrame !=null){
            pFrame.dispose();
        }
    }//GEN-LAST:event_rButton6ActionPerformed

    private void rButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton5ActionPerformed
        String filename = "sources-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddHHmmss")) + ".dat";
        
        RGlassDialog glassPanel = new RGlassDialog("Default (AppData)", "Choose Location") {
            @Override
            public void submitPress() {
                super.submitPress();
                String defaultDirectory = RDataPersistence.getDataDirectory();

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select File from Default App Data Directory");
                fileChooser.setCurrentDirectory(new File(defaultDirectory));
                
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null) {
                        String chosenDirectory = selectedFile.getParent();
                        String chosenFilename = selectedFile.getName();
                        
                        HashMap<Integer, WasteSource> wasteSources = RDataPersistence.importObject(chosenFilename, chosenDirectory);

                        if (wasteSources != null) {
                            WasteManager wasteManager = WasteManager.getInstance();
                            wasteManager.setWasteSources(wasteSources);
                            rScrollView1.initialiseData(WasteManager.getInstance());
                            rScrollView1.updateAll();
                        }
                    }
                }
            }


            @Override
            public void dismissPress() {
                // dismiss pressed, allow user to choose directory
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Directory Containing File");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);

                int userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    String directoryPath = selectedDirectory.getAbsolutePath();

                    // attempt import
                    HashMap<Integer, WasteSource> wasteSources = RDataPersistence.importObject(filename, directoryPath);

                    if (wasteSources != null) {
                        // import sucessfull
                        WasteManager wasteManager = WasteManager.getInstance();
                        wasteManager.setWasteSources(wasteSources);
                        rScrollView1.updateAll();
                    }
                }
                
                super.dismissPress();
            }
        };
        
        glassPanel.setTitle("Would you like to choose a file location to import from?");
        glassPanel.fadeInOver((Component) evt.getSource());
        
    }//GEN-LAST:event_rButton5ActionPerformed

    private void submitEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditActionPerformed
        WasteManager wasteManager = WasteManager.getInstance();
        String sourceName = sourceNameField.getText();
        String sourceAddress = sourceAddressField.getText();
        double sourceWasteAmount = Double.parseDouble(sourceWasteAmountField.getText());
        
        String selectedItem = sourceFieldTypeCombo.getSelectedItem().toString();
        Integer id = Integer.valueOf(selectedIdLabel.getText());
        Location location = new Location(id, sourceAddress);
        
        
        // public WasteSource(Integer id, String sourceName, SourceType sourceType, Location location, double wasteAmount, FoodStockApp foodDistribution) {
        if(!selectedItem.equals("Saver Type") || selectedItem == null) {
            SourceType sourceType = SourceType.valueOf(selectedItem);
            WasteSource currentWasteSource = wasteManager.getWasteSourceById(id);
            FoodStockApp currentFoodStockApp = currentWasteSource.getFoodDistribution();
            
            WasteSource ws = new WasteSource(id, sourceName, sourceType, location, sourceWasteAmount, currentFoodStockApp);
            wasteManager.addWasteSource(id, ws);
            
            rScrollView1.updateAll();
            
            WasteSource debug = wasteManager.getWasteSourceById(id);
            String debugOut = debug.getSourceDetails();
            System.out.println(debugOut);
        }

    }//GEN-LAST:event_submitEditActionPerformed

    private void sourceAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceAddressFieldActionPerformed

    private void rButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton1ActionPerformed
        WasteManager wasteManager = WasteManager.getInstance();
        Integer id = Integer.valueOf(selectedIdLabel.getText());
        wasteManager.deleteWasteSourceById(id);
        
        rScrollView1.updateAll();
    }//GEN-LAST:event_rButton1ActionPerformed

    private void rButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton4ActionPerformed
        WasteManager wasteManager = WasteManager.getInstance();
        wasteManager.clearAllSources();
        rScrollView1.updateAll();
    }//GEN-LAST:event_rButton4ActionPerformed

    private void rButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton2ActionPerformed
        RCreateWasteSource wasteSourceCreationPanel = new RCreateWasteSource();
        JFrame frame = new JFrame();
        
        Dimension wasteSourcePreferredSize = wasteSourceCreationPanel.getPreferredSize();
        Dimension frameSize = new Dimension(wasteSourcePreferredSize.width, wasteSourcePreferredSize.height + 30);
        wasteSourceCreationPanel.setEditor(this);
        
        frame.setSize(frameSize);
        frame.add(wasteSourceCreationPanel);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }//GEN-LAST:event_rButton2ActionPerformed

    private void sourceFieldTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceFieldTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceFieldTypeComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.savrui.components.RButton rButton1;
    private com.savrui.components.RButton rButton2;
    private com.savrui.components.RButton rButton3;
    private com.savrui.components.RButton rButton4;
    private com.savrui.components.RButton rButton5;
    private com.savrui.components.RButton rButton6;
    private com.savrui.components.RScrollView rScrollView1;
    private com.ryansheridan.rfields.RTextField rTextField1;
    private javax.swing.JLabel selectedIdLabel;
    private com.ryansheridan.rfields.RTextField sourceAddressField;
    private com.savrui.components.RFadePanel sourceEdit;
    private javax.swing.JComboBox<String> sourceFieldTypeCombo;
    private com.ryansheridan.rfields.RTextField sourceNameField;
    private com.ryansheridan.rfields.RTextField sourceWasteAmountField;
    private com.savrui.components.RButton submitEdit;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void updateSourceNameField(String text) {
        sourceNameField.setText(text);
    }

    @Override
    public void updateSourceAddressField(String text) {
       sourceAddressField.setText(text);
    }

    @Override
    public void updateWasteAmountField(String text) {
        sourceWasteAmountField.setText(text);
    }

    @Override
    public void clearInformationPanel() {
        updateSourceNameField("");
        updateSourceAddressField("");
        updateWasteAmountField("");
        updateSourceTypeCombo("Saver Type");
    }

    @Override
    public void updateSourceTypeCombo(String text) {
        sourceFieldTypeCombo.setSelectedItem(text);
    }

    @Override
    public void updateSelectedId(int id) {
        selectedIdLabel.setText(String.format("%d", id));
    }

    @Override
    public void refreshScrollView() {
        rScrollView1.updateAll();
    }
}
