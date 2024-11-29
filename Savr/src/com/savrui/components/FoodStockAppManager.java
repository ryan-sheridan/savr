/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.savrui.components;

import java.awt.Color;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import savr.ZeroHungerApp;

/**
 *
 * @author conor
 */
public class FoodStockAppManager extends javax.swing.JPanel {

    /**
     * Creates new form FoodStockAppManager
     */
    public FoodStockAppManager() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        MenuPanel = new javax.swing.JPanel();
        checkStockPanel = new javax.swing.JPanel();
        fsmenuLBL = new javax.swing.JLabel();
        viewTypesPanel = new javax.swing.JPanel();
        vtmenuLBL = new javax.swing.JLabel();
        returnBTN = new javax.swing.JButton();
        exitBTN = new javax.swing.JButton();
        RightPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        logoTitleLBL = new javax.swing.JLabel();
        logopictureLBL = new javax.swing.JLabel();
        foodStockPanel = new javax.swing.JPanel();
        titleLBL = new javax.swing.JLabel();
        addBTN = new javax.swing.JButton();
        editBTN = new javax.swing.JButton();
        searchBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        nameLBL = new javax.swing.JLabel();
        idLBL = new javax.swing.JLabel();
        foodTypeLBL = new javax.swing.JLabel();
        expirydateLBL = new javax.swing.JLabel();
        quantityLBL = new javax.swing.JLabel();
        perishableLBL = new javax.swing.JLabel();
        nameTF = new com.ryansheridan.rfields.RTextField();
        idTF = new com.ryansheridan.rfields.RTextField();
        foodtypeTF = new com.ryansheridan.rfields.RTextField();
        expiryDateTF = new com.ryansheridan.rfields.RTextField();
        quantityTF = new com.ryansheridan.rfields.RTextField();
        perishableCB = new javax.swing.JComboBox<>();
        prevBTN = new javax.swing.JButton();
        viewmoveLBL = new javax.swing.JLabel();
        nextBTN = new javax.swing.JButton();
        viewingStockPanel = new javax.swing.JPanel();
        viewLBL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTA = new javax.swing.JTextArea();
        optionLBL = new javax.swing.JLabel();
        optionCB = new javax.swing.JComboBox<>();
        submitBTN = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 30, 30));
        setToolTipText("");

        MenuPanel.setBackground(new java.awt.Color(55, 55, 55));

        checkStockPanel.setBackground(new java.awt.Color(102, 102, 102));
        checkStockPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkStockPanelMouseClicked(evt);
            }
        });

        fsmenuLBL.setBackground(new java.awt.Color(102, 102, 102));
        fsmenuLBL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fsmenuLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fsmenuLBL.setText("Food Stock");
        fsmenuLBL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fsmenuLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fsmenuLBLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout checkStockPanelLayout = new javax.swing.GroupLayout(checkStockPanel);
        checkStockPanel.setLayout(checkStockPanelLayout);
        checkStockPanelLayout.setHorizontalGroup(
            checkStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fsmenuLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        checkStockPanelLayout.setVerticalGroup(
            checkStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fsmenuLBL, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        viewTypesPanel.setBackground(new java.awt.Color(102, 102, 102));
        viewTypesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTypesPanelMouseClicked(evt);
            }
        });

        vtmenuLBL.setBackground(new java.awt.Color(102, 102, 102));
        vtmenuLBL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vtmenuLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vtmenuLBL.setText("Food Types");
        vtmenuLBL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vtmenuLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vtmenuLBLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout viewTypesPanelLayout = new javax.swing.GroupLayout(viewTypesPanel);
        viewTypesPanel.setLayout(viewTypesPanelLayout);
        viewTypesPanelLayout.setHorizontalGroup(
            viewTypesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vtmenuLBL, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        viewTypesPanelLayout.setVerticalGroup(
            viewTypesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vtmenuLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        returnBTN.setText("Return To Menu");
        buttonGroup2.add(returnBTN);
        returnBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBTNActionPerformed(evt);
            }
        });

        exitBTN.setText("Exit");
        buttonGroup2.add(exitBTN);
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewTypesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkStockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addComponent(returnBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(checkStockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewTypesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBTN)
                    .addComponent(exitBTN))
                .addContainerGap())
        );

        RightPanel.setBackground(new java.awt.Color(40, 40, 40));
        RightPanel.setLayout(new javax.swing.OverlayLayout(RightPanel));

        logoPanel.setBackground(new java.awt.Color(40, 40, 40));

        logoTitleLBL.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoTitleLBL.setForeground(new java.awt.Color(240, 240, 240));
        logoTitleLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoTitleLBL.setText("Welcome to Savr ");
        logoTitleLBL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        logopictureLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SavrLogo300.jpg"))); // NOI18N

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logoPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(logopictureLBL))
                    .addGroup(logoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoTitleLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logoTitleLBL)
                .addGap(18, 18, 18)
                .addComponent(logopictureLBL)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        RightPanel.add(logoPanel);

        foodStockPanel.setBackground(new java.awt.Color(40, 40, 40));

        titleLBL.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLBL.setForeground(new java.awt.Color(187, 187, 187));
        titleLBL.setText("Savr Food Stock");

        addBTN.setText("Add");
        buttonGroup1.add(addBTN);

        editBTN.setText("Edit");
        buttonGroup1.add(editBTN);

        searchBTN.setText("Search");
        buttonGroup1.add(searchBTN);

        deleteBTN.setText("Delete");
        buttonGroup1.add(deleteBTN);

        nameLBL.setForeground(new java.awt.Color(240, 240, 240));
        nameLBL.setText("Name:");

        idLBL.setForeground(new java.awt.Color(240, 240, 240));
        idLBL.setText("ID:");

        foodTypeLBL.setForeground(new java.awt.Color(240, 240, 240));
        foodTypeLBL.setText("Food Type:");

        expirydateLBL.setForeground(new java.awt.Color(240, 240, 240));
        expirydateLBL.setText("Expiry Date:");

        quantityLBL.setForeground(new java.awt.Color(240, 240, 240));
        quantityLBL.setText("Quantity:");

        perishableLBL.setForeground(new java.awt.Color(240, 240, 240));
        perishableLBL.setText("Is It Perishable:");

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        idTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTFActionPerformed(evt);
            }
        });

        foodtypeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodtypeTFActionPerformed(evt);
            }
        });

        expiryDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expiryDateTFActionPerformed(evt);
            }
        });

        quantityTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTFActionPerformed(evt);
            }
        });

        perishableCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None Selected", "Yes", "No" }));
        perishableCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perishableCBActionPerformed(evt);
            }
        });

        prevBTN.setText("<");
        prevBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBTNActionPerformed(evt);
            }
        });

        viewmoveLBL.setForeground(new java.awt.Color(255, 255, 255));
        viewmoveLBL.setText("View");

        nextBTN.setText(">");
        nextBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout foodStockPanelLayout = new javax.swing.GroupLayout(foodStockPanel);
        foodStockPanel.setLayout(foodStockPanelLayout);
        foodStockPanelLayout.setHorizontalGroup(
            foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodStockPanelLayout.createSequentialGroup()
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodStockPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(foodStockPanelLayout.createSequentialGroup()
                                .addComponent(perishableLBL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(perishableCB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodStockPanelLayout.createSequentialGroup()
                                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addBTN)
                                    .addComponent(nameLBL)
                                    .addComponent(idLBL)
                                    .addComponent(foodTypeLBL)
                                    .addComponent(expirydateLBL)
                                    .addComponent(quantityLBL))
                                .addGap(18, 18, 18)
                                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expiryDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodtypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(foodStockPanelLayout.createSequentialGroup()
                                        .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(foodStockPanelLayout.createSequentialGroup()
                                                .addComponent(editBTN)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchBTN))
                                            .addComponent(titleLBL))
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteBTN))
                                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(foodStockPanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(prevBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewmoveLBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBTN)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        foodStockPanelLayout.setVerticalGroup(
            foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodStockPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLBL)
                .addGap(26, 26, 26)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLBL)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLBL)
                    .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foodTypeLBL)
                    .addComponent(foodtypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expirydateLBL)
                    .addComponent(expiryDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityLBL)
                    .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(perishableLBL)
                    .addComponent(perishableCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevBTN)
                    .addComponent(viewmoveLBL)
                    .addComponent(nextBTN))
                .addGap(18, 18, 18)
                .addGroup(foodStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTN)
                    .addComponent(editBTN)
                    .addComponent(searchBTN)
                    .addComponent(deleteBTN))
                .addGap(35, 35, 35))
        );

        RightPanel.add(foodStockPanel);

        viewingStockPanel.setBackground(new java.awt.Color(40, 40, 40));

        viewLBL.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        viewLBL.setForeground(new java.awt.Color(187, 187, 187));
        viewLBL.setText("Savr View Perishable Food Types");

        stockTA.setColumns(20);
        stockTA.setRows(5);
        jScrollPane1.setViewportView(stockTA);

        optionLBL.setForeground(new java.awt.Color(240, 240, 240));
        optionLBL.setText("Select an option: ");

        optionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None Selected", "Perishable Food", "Non-Perishable Food" }));
        optionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionCBActionPerformed(evt);
            }
        });

        submitBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitBTN.setText("Submit");

        javax.swing.GroupLayout viewingStockPanelLayout = new javax.swing.GroupLayout(viewingStockPanel);
        viewingStockPanel.setLayout(viewingStockPanelLayout);
        viewingStockPanelLayout.setHorizontalGroup(
            viewingStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewingStockPanelLayout.createSequentialGroup()
                .addGroup(viewingStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewingStockPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(viewingStockPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(viewLBL)
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addGroup(viewingStockPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(optionLBL)
                        .addGap(18, 18, 18)
                        .addComponent(optionCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(viewingStockPanelLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(submitBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewingStockPanelLayout.setVerticalGroup(
            viewingStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewingStockPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(viewLBL)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(viewingStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionLBL)
                    .addComponent(optionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitBTN)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        RightPanel.add(viewingStockPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fsmenuLBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fsmenuLBLMouseClicked
        // when button is clicked hide other two panels and make foodStockPanel visible
        foodStockPanel.setVisible(true);
        logoPanel.setVisible(false);
        viewingStockPanel.setVisible(false);
        
        //add a different background color to in use tab
        checkStockPanel.setBackground(new Color(40,40,40));
        viewTypesPanel.setBackground(new Color (102,102,102));
    }//GEN-LAST:event_fsmenuLBLMouseClicked

    private void vtmenuLBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vtmenuLBLMouseClicked
        // when button is clicked hide other two panels and make viewingStockPanel visible
        foodStockPanel.setVisible(false);
        logoPanel.setVisible(false);
        viewingStockPanel.setVisible(true);
        
        //add a different background color to in use tab
        viewTypesPanel.setBackground(new Color(40,40,40));
        checkStockPanel.setBackground(new Color (102,102,102));
    }//GEN-LAST:event_vtmenuLBLMouseClicked

    private void checkStockPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkStockPanelMouseClicked

    }//GEN-LAST:event_checkStockPanelMouseClicked

    private void viewTypesPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTypesPanelMouseClicked

    }//GEN-LAST:event_viewTypesPanelMouseClicked

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        // exit the program
        System.exit(0);
    }//GEN-LAST:event_exitBTNActionPerformed

    private void returnBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBTNActionPerformed
        ZeroHungerApp MainMenuFrame = new ZeroHungerApp();
        MainMenuFrame.setVisible(true);

       //close the parent frame containing this panel
       //move up swing component to find next window which is the zerohungerapp jframe
        Window parentFrame = SwingUtilities.getWindowAncestor(this);
            if (parentFrame != null) {//if panel is inside a window will close the current from
            parentFrame.dispose();
        }
        
    }//GEN-LAST:event_returnBTNActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // view the name of the food item being viewed
    }//GEN-LAST:event_nameTFActionPerformed

    private void idTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTFActionPerformed
        // show the id of the food item being viewed
    }//GEN-LAST:event_idTFActionPerformed

    private void foodtypeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodtypeTFActionPerformed
        // show the food type of the food item being viewed
    }//GEN-LAST:event_foodtypeTFActionPerformed

    private void expiryDateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expiryDateTFActionPerformed
        // show expiry date of the food item being viewed
    }//GEN-LAST:event_expiryDateTFActionPerformed

    private void quantityTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTFActionPerformed
        // show the quantity of the food item current being viewed
    }//GEN-LAST:event_quantityTFActionPerformed

    private void perishableCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perishableCBActionPerformed
        // show if food is perishable on combo box with "yes" or "no"
    }//GEN-LAST:event_perishableCBActionPerformed

    private void nextBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTNActionPerformed
        // when clicked changes information in the text fields to next item in array
    }//GEN-LAST:event_nextBTNActionPerformed

    private void prevBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBTNActionPerformed
        // when clicked changes information in the text fields to previous item in array
    }//GEN-LAST:event_prevBTNActionPerformed

    private void optionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JButton addBTN;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel checkStockPanel;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JButton editBTN;
    private javax.swing.JButton exitBTN;
    private com.ryansheridan.rfields.RTextField expiryDateTF;
    private javax.swing.JLabel expirydateLBL;
    public static javax.swing.JPanel foodStockPanel;
    private javax.swing.JLabel foodTypeLBL;
    private com.ryansheridan.rfields.RTextField foodtypeTF;
    private javax.swing.JLabel fsmenuLBL;
    private javax.swing.JLabel idLBL;
    private com.ryansheridan.rfields.RTextField idTF;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel logoPanel;
    private javax.swing.JLabel logoTitleLBL;
    private javax.swing.JLabel logopictureLBL;
    private javax.swing.JLabel nameLBL;
    private com.ryansheridan.rfields.RTextField nameTF;
    private javax.swing.JButton nextBTN;
    private javax.swing.JComboBox<String> optionCB;
    private javax.swing.JLabel optionLBL;
    private javax.swing.JComboBox<String> perishableCB;
    private javax.swing.JLabel perishableLBL;
    private javax.swing.JButton prevBTN;
    private javax.swing.JLabel quantityLBL;
    private com.ryansheridan.rfields.RTextField quantityTF;
    private javax.swing.JButton returnBTN;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextArea stockTA;
    private javax.swing.JButton submitBTN;
    private javax.swing.JLabel titleLBL;
    private javax.swing.JLabel viewLBL;
    private javax.swing.JPanel viewTypesPanel;
    public static javax.swing.JPanel viewingStockPanel;
    private javax.swing.JLabel viewmoveLBL;
    public static javax.swing.JLabel vtmenuLBL;
    // End of variables declaration//GEN-END:variables

    
}
