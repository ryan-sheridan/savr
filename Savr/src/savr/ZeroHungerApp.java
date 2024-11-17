/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package savr;
import com.ryansheridan.rfields.RTextField;
import com.formdev.flatlaf.FlatDarkLaf;
import com.savrui.components.FoodStockAppManager;
import com.savrui.components.RWasteManagementController;
import java.awt.Color;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ryan
 */
public class ZeroHungerApp extends javax.swing.JFrame {

    /**
     * Creates new form ZeroHungerApp
     */
    public ZeroHungerApp() {
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setSize(new java.awt.Dimension(1024, 768));

        jPanel2.setLayout(new java.awt.CardLayout());

        jButton1.setText("Waste Management UI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Food Stock UI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agriculture Aid UI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RWasteManagementController controllerPanel = new RWasteManagementController();
        
        JFrame newFrame = new JFrame("Waste Management Controller");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(800, 600);
        newFrame.add(controllerPanel); 
        newFrame.setVisible(true); 

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //button will open the foodstockapp jframe
        FoodStockAppManager FoodStockMenu = new FoodStockAppManager();
        
        JFrame newFrame = new JFrame("Food Stock App");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(800,600);
        newFrame.add(FoodStockMenu);
        newFrame.setVisible(true);
        //make the logopanel be the tab to show up when coming on the food stock app
        FoodStockMenu.logoPanel.setVisible(true);
        FoodStockMenu.foodStockPanel.setVisible(false);
        FoodStockMenu.viewingStockPanel.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*
            whats up sean, the following code is an example of how this button
            can open a new jframe, append a new jpanel (your agriculture ui controller)
            
            it will then open the new jframe, and close the current window
        */
        /*
            // example
            RWasteManagementController controllerPanel = new RWasteManagementController();

            JFrame newFrame = new JFrame("Waste Management Controller");
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFrame.setSize(800, 600);
            newFrame.add(controllerPanel); 
            newFrame.setVisible(true); 

            this.dispose();
        */
        JOptionPane.showMessageDialog(this, "AgricultureUI not yet implemented, please check the button event listener! - ryan", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FontFormatException, IOException {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.put("Panel.background", new Color(30, 30, 30));
            javax.swing.UIManager.put("Button.background", new Color(60, 60, 60));
            javax.swing.UIManager.put("Button.foreground", Color.WHITE);
            javax.swing.UIManager.put("TextField.background", new Color(40, 40, 40));
            javax.swing.UIManager.put("TextField.foreground", Color.WHITE);
            javax.swing.UIManager.put("TextField.caretForeground", Color.WHITE);
            javax.swing.UIManager.put("Label.foreground", Color.WHITE);
            javax.swing.UIManager.put("TextArea.background", new Color(40, 40, 40));
            javax.swing.UIManager.put("TextArea.foreground", Color.WHITE);
            javax.swing.UIManager.put("ComboBox.background", new Color(40, 40, 40));
            javax.swing.UIManager.put("ComboBox.foreground", Color.WHITE);
            javax.swing.UIManager.put("ComboBox.selectionBackground", new Color(60, 60, 60));
            javax.swing.UIManager.put("ComboBox.selectionForeground", Color.WHITE);
            
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Font ubuntuFont = null;
                try {
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    Font f = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/Ubuntu-Regular.ttf"));
                    if (!ge.registerFont(f)) {
                        System.out.println("Unable to register font");
                    }
                    ubuntuFont = f.deriveFont(Font.PLAIN, 17);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (FontFormatException e) {
                    e.printStackTrace();
                }

                // Set the font for all components
                UIManager.put("Label.font", ubuntuFont);
                UIManager.put("Button.font", ubuntuFont);
                UIManager.put("TextField.font", ubuntuFont);
                UIManager.put("PasswordField.font", ubuntuFont);
                UIManager.put("TextArea.font", ubuntuFont);
                UIManager.put("ComboBox.font", ubuntuFont);
                UIManager.put("CheckBox.font", ubuntuFont);
                UIManager.put("RadioButton.font", ubuntuFont);
                UIManager.put("TabbedPane.font", ubuntuFont);
                UIManager.put("Table.font", ubuntuFont);
                UIManager.put("ToolTip.font", ubuntuFont);
                new ZeroHungerApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
