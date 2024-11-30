/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.sean;

import static com.savrui.components.AgricultureUIManager.corpEmailTF;
import static com.savrui.components.AgricultureUIManager.corpFoundingYearTF;
import static com.savrui.components.AgricultureUIManager.corpHQAddressTF;
import static com.savrui.components.AgricultureUIManager.corpNameTF;
import static com.savrui.components.AgricultureUIManager.corpPhoneNumberTF;
import static com.savrui.components.AgricultureUIManager.indiAddressTF;
import static com.savrui.components.AgricultureUIManager.indiDoBTF;
import static com.savrui.components.AgricultureUIManager.indiEmailTF;
import static com.savrui.components.AgricultureUIManager.indiFirstNameTF;
import static com.savrui.components.AgricultureUIManager.indiPhoneNumberTF;
import static com.savrui.components.AgricultureUIManager.indiSurnameTF;
import static com.savrui.components.AgricultureUIManager.itemConditionCB;
import static com.savrui.components.AgricultureUIManager.itemDateReceivedTF;
import static com.savrui.components.AgricultureUIManager.itemElectricalChB;
import static com.savrui.components.AgricultureUIManager.itemNameTF;
import static com.savrui.components.AgricultureUIManager.itemQuantityTF;
import static com.savrui.components.AgricultureUIManager.itemTypeTF;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Sean
 */
public class AgricultureUI {
    private static ArrayList<AgriculturalAid> agriAid = new ArrayList<>();

  
    
    public static void addIndi(){
        //TODO add individual donor logic
        //AgriculturalAid variables
        String donorID = createIndiDonorID();
        String itemID = createItemID();
        String item = itemNameTF.getText();
        String dateReceived = itemDateReceivedTF.getText();
        String itemType = itemTypeTF.getText();
        int itemQuantity = Integer.parseInt(itemQuantityTF.getText());
        String condition = (String)itemConditionCB.getSelectedItem();
        boolean isElectrical = itemElectricalChB.isSelected();
        //individual variables
        String indiFirstName = indiFirstNameTF.getText();
        String indiSurname = indiSurnameTF.getText();
        String indiDoB = indiDoBTF.getText();
        String indiAddress = indiAddressTF.getText();
        String indiEmail = indiEmailTF.getText();
        int indiPhoneNumber = Integer.parseInt(indiPhoneNumberTF.getText());
        
        AgriculturalAid tempI = new IndividualDonor(indiFirstName, indiSurname, indiDoB, indiAddress, indiEmail, indiPhoneNumber, donorID, itemID, item, dateReceived, itemType, itemQuantity, condition, isElectrical);
        agriAid.add(tempI);
        int i = agriAid.size() - 1;
        
        JOptionPane.showMessageDialog(null, "New Item Added!" + "\n" + agriAid.get(i).toString());
    }
    
    public void addCorp(){
        //TODO add corporation donor logci
         //AgriculturalAid variables
        String donorID = createCorpDonorID();
        String itemID = createItemID();
        String item = itemNameTF.getText();
        String dateReceived = itemDateReceivedTF.getText();
        String itemType = itemTypeTF.getText();
        int itemQuantity = Integer.parseInt(itemQuantityTF.getText());
        String condition = (String)itemConditionCB.getSelectedItem();
        boolean isElectrical = itemElectricalChB.isSelected();
        //corporation variables
        String corpName = corpNameTF.getText();
        int corpFoundingYear = Integer.parseInt(corpFoundingYearTF.getText());
        String corpHeadquareterAddress = corpHQAddressTF.getText();
        String corpEmail = corpEmailTF.getText();
        int corpPhoneNumber = Integer.parseInt(corpPhoneNumberTF.getText());
    }
    
    public void viewDonor(){
        //TODO view donor logic
    }
    
    public void searchDonor(){
        //TODO search donor logic
    }
    
    public void deleteDonor(){
        //TODO delete donor logic
    }
    
    public static String createIndiDonorID(){
        return "Indi1";
    }
    
    public static String createCorpDonorID(){
        return "";
    }
    
    public static String createItemID(){
        return "ItemI-1";
    }
}
