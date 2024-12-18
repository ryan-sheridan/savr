/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.savrui.components;

import savr.ryan.Location;
import savr.ryan.WasteManager;
import savr.ryan.WasteSource;
import savr.ryan.WasteSource.SourceType;
import savr.ryan.tools.interfaces.RInformationPanelEditor;

/**
 *
 * @author ryan
 */
public class RCreateWasteSource extends javax.swing.JPanel {

    /**
     * Creates new form RCreateWasteSource
     */
    public RCreateWasteSource() {
        initComponents();
    }
    
    private RInformationPanelEditor editor;

    public RInformationPanelEditor getEditor() {
        return editor;
    }

    public void setEditor(RInformationPanelEditor editor) {
        this.editor = editor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressField = new com.ryansheridan.rfields.RTextField();
        nameField = new com.ryansheridan.rfields.RTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        submitEdit = new com.savrui.components.RButton();

        addressField.setFieldType(com.ryansheridan.rfields.RTextField.FieldType.ADDRESS);
        addressField.setPlaceholder("Source Address");
        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });

        nameField.setPlaceholder("Source Name");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Source Type", "RETAILER", "RESTAURANT", "INDIVIDUAL", "FARMER" }));

        submitEdit.setBackground(new java.awt.Color(34, 197, 94));
        submitEdit.setText("Submit Edit");
        submitEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

    private void submitEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditActionPerformed
        WasteManager wasteManager = WasteManager.getInstance();
        Integer id = wasteManager.getNewId();
        
        SourceType sourceType = SourceType.valueOf(jComboBox1.getSelectedItem().toString());
        String sourceName = nameField.getText();
        Location location = new Location(id, addressField.getText());
        
        WasteSource wasteSource = new WasteSource(id, sourceName, sourceType, location, 0, null);
        System.out.println("created new waste source, adding to WasteManager");
        wasteManager.addWasteSource(id, wasteSource);
        
        // interfaces are cool
        editor.refreshScrollView();
    }//GEN-LAST:event_submitEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ryansheridan.rfields.RTextField addressField;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.ryansheridan.rfields.RTextField nameField;
    private com.savrui.components.RButton submitEdit;
    // End of variables declaration//GEN-END:variables

}
