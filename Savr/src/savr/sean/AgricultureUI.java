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
import static com.savrui.components.AgricultureUIManager.displayTA;
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
import static com.savrui.components.AgricultureUIManager.searchTF;
import static com.savrui.components.AgricultureUIManager.viewCorpDonorPanel;
import static com.savrui.components.AgricultureUIManager.viewCorpEmailTF;
import static com.savrui.components.AgricultureUIManager.viewCorpFoundingYearTF;
import static com.savrui.components.AgricultureUIManager.viewCorpHQAddressTF;
import static com.savrui.components.AgricultureUIManager.viewCorpNameTF;
import static com.savrui.components.AgricultureUIManager.viewCorpPhoneNumberTF;
import static com.savrui.components.AgricultureUIManager.viewCorpSelectorBTN;
import static com.savrui.components.AgricultureUIManager.viewDonorIDTF;
import static com.savrui.components.AgricultureUIManager.viewIndiAddressTF;
import static com.savrui.components.AgricultureUIManager.viewIndiDOBTF;
import static com.savrui.components.AgricultureUIManager.viewIndiDonorPanel;
import static com.savrui.components.AgricultureUIManager.viewIndiFirstNameTF;
import static com.savrui.components.AgricultureUIManager.viewIndiPhoneNumberTF;
import static com.savrui.components.AgricultureUIManager.viewIndiSelectorBTN;
import static com.savrui.components.AgricultureUIManager.viewIndiSurnameTF;
import static com.savrui.components.AgricultureUIManager.viewItemConditionCB;
import static com.savrui.components.AgricultureUIManager.viewItemDateReceivedTF;
import static com.savrui.components.AgricultureUIManager.viewItemElectricalChB;
import static com.savrui.components.AgricultureUIManager.viewItemIDTF;
import static com.savrui.components.AgricultureUIManager.viewItemNameTF;
import static com.savrui.components.AgricultureUIManager.viewItemQuantityTF;
import static com.savrui.components.AgricultureUIManager.viewItemTypeTF;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import savr.sean.AgriculturalAid;
import savr.sean.CorporationDonor;
import savr.sean.IndividualDonor;
import static com.savrui.components.AgricultureUIManager.viewIndiDonorIDTF;
import static com.savrui.components.AgricultureUIManager.viewIndiEmailTF;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Sean
 */
public class AgricultureUI {
    private static ArrayList<AgriculturalAid> agriAid = new ArrayList<>();
    private static File f = new File("AgriAid.dat");;
    
    
    //demo records 
    public static void addTempRecords(){
        //temporery records to populate the ArrayLists
        AgriculturalAid tempI1 = new IndividualDonor("John", "Doe", "12/05/1990", "123 Maple Street, NY", "john.doe@example.com", 555123456, "Indi-001", "Item-001", "Shovel", "20/11/2024", "Hand Tool", 50, "Gently Used", false);
        AgriculturalAid tempI2 = new IndividualDonor("Jane", "Smith", "19/07/1985", "456 Oak Avenue, CA", "jane.smith@example.com", 555987654, "Indi-002", "Item-002", "Hoe", "15/11/2024", "Hand Tool", 25, "Factory New", false);

        AgriculturalAid tempC1 = new CorporationDonor("Helping Hands Corp.", 1994, "789 Elm Street, Chicago, IL", "contact@helpinghands.org", 555333444, "Corp-001", "Item-003", "Solar Panels", "28/11/2024", "Hardware", 10, "Like New", true);
        AgriculturalAid tempC2 = new CorporationDonor("Green Future LLC", 2010, "321 Pine Boulevard, TX", "info@greenfuture.com", 555765432, "Corp-002", "Item-004", "Tracker", "20/11/2024", "Heavy Machinery", 100, "Moderately Used", true);
    
        agriAid.add(tempI1);
        agriAid.add(tempI2);
        agriAid.add(tempC1);
        agriAid.add(tempC2);

    }
  
    
    public static void addIndi(){
        //set variables to get the text of each text field
        //create an instance of Individual as tempI
        //add tempI to AgricultureAid obj
        //display newly add donor
        //set all text fields back to empty once donor has been added
        
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
        
        saveAgri();//saves added Individual donor to a .dat file
        
        JOptionPane.showMessageDialog(null, "New Item Added!" + "\n" + agriAid.get(i).toString());
        //sets all fields to null after donor is added
        itemNameTF.setText("");
        itemDateReceivedTF.setText("");
        itemTypeTF.setText("");
        itemQuantityTF.setText("");
        itemConditionCB.setSelectedItem(null);
        itemElectricalChB.setSelected(false);
                
        corpNameTF.setText("");
        corpFoundingYearTF.setText("");
        corpHQAddressTF.setText("");
        corpEmailTF.setText("");
        corpPhoneNumberTF.setText("");
        
        indiFirstNameTF.setText("");
        indiSurnameTF.setText("");
        indiDoBTF.setText("");
        indiAddressTF.setText("");
        indiEmailTF.setText("");
        indiPhoneNumberTF.setText("");
    }
    
    public static void addCorp(){
        //set variables to get the text of each text field
        //create an instance of Corporation as tempC
        //add tempC to AgricultureAid obj
        //display newly added donor
        //set all text fields back to empty once donor has been added
        
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
        
        AgriculturalAid tempC = new CorporationDonor(corpName, corpFoundingYear, corpHeadquareterAddress, corpEmail, corpPhoneNumber, donorID, itemID, item, dateReceived, itemType, itemQuantity, condition, isElectrical);
        agriAid.add(tempC);
        int i = agriAid.size() - 1;
        
        saveAgri();//saves Corporation donor to a .dat file
        
        JOptionPane.showMessageDialog(null, "New Item Added!" + "\n" + agriAid.get(i).toString());
        
        //sets all fields to null after donor is added
        itemNameTF.setText("");
        itemDateReceivedTF.setText("");
        itemTypeTF.setText("");
        itemQuantityTF.setText("");
        itemConditionCB.setSelectedItem("Factory New");
        itemElectricalChB.setSelected(false);
                
        corpNameTF.setText("");
        corpFoundingYearTF.setText("");
        corpHQAddressTF.setText("");
        corpEmailTF.setText("");
        corpPhoneNumberTF.setText("");
        
        indiFirstNameTF.setText("");
        indiSurnameTF.setText("");
        indiDoBTF.setText("");
        indiAddressTF.setText("");
        indiEmailTF.setText("");
        indiPhoneNumberTF.setText("");
    }
    
    
    public static void searchDonor(){
        //get the searchTerm from search text field
        //check if empty, if empty display that its empty
        //if populated, get Item ID from searchTerm
        //display details in each text field based on Item ID by iterating through both Corporation and Individual donors
        //if searchTerm doesnt equal and Item ID, display an error explaining so
        
        String searchTerm = searchTF.getText().trim(); //get searchTerm from search text field
        if(agriAid.isEmpty()){//if arraylist is empty, display it to the user
            JOptionPane.showMessageDialog(null, "No-One in System!");
            return;
        } 
        boolean found = false;
        
        for(AgriculturalAid temp: agriAid){ //loop through AgriculturalAid arraylist
        if(temp.getItemID().equals(searchTerm)){//if for finding if there is an item ID in the arraylist with a given searchTerm
            found = true; // if Item ID equals searchTerm, found is true
            if(temp instanceof CorporationDonor){ //checks if searchTerm is within CorporationDonor 
                
                //if searchTerm is equal to a CorporationDonor item ID, displays all information related to that item ID
                viewCorpSelectorBTN.setSelected(true);
                viewCorpDonorPanel.setVisible(true);
                viewIndiDonorPanel.setVisible(false);
                
                viewItemIDTF.setText(temp.getItemID());
                viewDonorIDTF.setText(temp.getDonorID());
                viewItemNameTF.setText(temp.getItem());
                viewItemDateReceivedTF.setText(temp.getDateReceived());
                viewItemTypeTF.setText(temp.getItemType());
                viewItemQuantityTF.setText(String.valueOf(temp.getItemQuantity()));
                viewItemConditionCB.setSelectedItem(temp.getCondition());
                viewItemElectricalChB.setSelected(temp.isIsElectrical());
                
                viewCorpNameTF.setText(((CorporationDonor) temp).getCorpName());
                viewCorpFoundingYearTF.setText(String.valueOf(((CorporationDonor) temp).getCorpFoundingYear()));
                viewCorpHQAddressTF.setText(((CorporationDonor) temp).getCorpHeadquareterAddress());
                viewCorpEmailTF.setText(((CorporationDonor) temp).getCorpEmail());
                viewCorpPhoneNumberTF.setText(String.valueOf(((CorporationDonor) temp).getCorpPhoneNumber()));
                
                JOptionPane.showMessageDialog(null, "Corporation Donation Found!");
                searchTF.setText("Item-00");
                break;
            } else if(temp instanceof IndividualDonor) { //checks if searchTerm is within IndividualDonor
                //if searchTerm is equal to a IndividualDonor item ID, displays all information related to that item ID
                viewIndiSelectorBTN.setSelected(true);
                viewCorpDonorPanel.setVisible(false);
                viewIndiDonorPanel.setVisible(true);
                
                viewItemIDTF.setText(temp.getItemID());
                viewIndiDonorIDTF.setText(temp.getDonorID());
                viewItemNameTF.setText(temp.getItem());
                viewItemDateReceivedTF.setText(temp.getDateReceived());
                viewItemTypeTF.setText(temp.getItemType());
                viewItemQuantityTF.setText(String.valueOf(temp.getItemQuantity()));
                viewItemConditionCB.setSelectedItem(temp.getCondition());
                viewItemElectricalChB.setSelected(temp.isIsElectrical());
                
                viewIndiFirstNameTF.setText(((IndividualDonor) temp).getIndiFirstName());
                viewIndiSurnameTF.setText(((IndividualDonor) temp).getIndiSurname());
                viewIndiDOBTF.setText(((IndividualDonor) temp).getIndiDoB());
                viewIndiAddressTF.setText(((IndividualDonor) temp).getIndiAddress());
                viewIndiDonorIDTF.setText(((IndividualDonor) temp).getDonorID());
                viewIndiEmailTF.setText(((IndividualDonor) temp).getIndiEmail());
                viewIndiPhoneNumberTF.setText(String.valueOf(((IndividualDonor) temp).getIndiPhoneNumber()));
                
                JOptionPane.showMessageDialog(null, "Individual Donation Found!");
                searchTF.setText("Item-00");
                break;
            }
            break;
        }      
        }
        if(!found){ //if the searchTerm doesnt match any item ID in the system, display it to the user that no item ID was found
            JOptionPane.showMessageDialog(null, "No record found for Item ID: " + searchTerm);
            searchTF.setText("Item-00");
        }
    }
    
    
    public static void deleteDonor(){
        //Function for deleting donations
        //checks if any donations are in the system
        //if donation are in the system, loops through each donation and match donation ItemID with searchTerm
        //if match is found, removes donation from the ArrayList
        //sets all text fields to null once completed
        
        String searchTerm = viewItemIDTF.getText().trim(); //sets searchTerm to viewItemID text field
        boolean found = false; //if viewItemIDTF equals searchTerm, itemID is found
        if(agriAid.isEmpty()){ //if array list is empty, display a message to the user the the system is empty
            JOptionPane.showMessageDialog(null, "No-One is System!");
        } else {
            for(int i = 0; i < agriAid.size(); i++){ //for loop that loop through the arraylist (initially used AgriculturalAid temp: agriAid but this cause an iteration error
               AgriculturalAid temp = agriAid.get(i); //set temp to get the position of the obj to be deleted
                if(temp.getItemID().equalsIgnoreCase(searchTerm)){//if item ID equals searchTerm, display which record is getting deleted and remove it from the arraylist
                    found = true;
                    JOptionPane.showMessageDialog(null, "Donation Deleted: " + temp.toString());
                    agriAid.remove(i);
                    
                    saveAgri();//after deletion, write to a dat file to remove the record from the system
                    
                    //sets all fields to null after donor is added
                    viewItemNameTF.setText("");
                    viewItemDateReceivedTF.setText("");
                    viewItemTypeTF.setText("");
                    viewItemQuantityTF.setText("");
                    viewItemConditionCB.setSelectedItem("Factory New");
                    viewItemElectricalChB.setSelected(false);
                
                    viewCorpNameTF.setText("");
                    viewCorpFoundingYearTF.setText("");
                    viewCorpHQAddressTF.setText("");
                    viewCorpEmailTF.setText("");
                    viewCorpPhoneNumberTF.setText("");
        
                    viewIndiFirstNameTF.setText("");
                    viewIndiSurnameTF.setText("");
                    viewIndiDOBTF.setText("");
                    viewIndiAddressTF.setText("");
                    viewIndiEmailTF.setText("");
                    viewIndiPhoneNumberTF.setText("");
                }
            }
            if(!found){//if itemID isnt found, display that no record is found for the used searchTerm
            JOptionPane.showMessageDialog(null, "No record found for Item ID: " + searchTerm);
            }
        }
    }
    
    public static void updateDonor(){ 
        //Function for updating the Donation in tha ArrayList
        //searchTerm set to Item ID in Item id text field
        //check if ArryList is empty, if empty display message
        //iterate through ArrayList for matching Item ID with searchTerm
        //updates the text fields that were change based on if it was a Corporation donor or Individual Donor
        //if no Item ID is found, display error
        
         String searchTerm = viewItemIDTF.getText().trim(); //sets searchTerm to viewItemID text field
        if(agriAid.isEmpty()){//if system is empty display message to user telling that no-one is in the system
            JOptionPane.showMessageDialog(null, "No-One in System!");
            return;
        } 
        boolean found = false;
        
        for(AgriculturalAid temp: agriAid){ 
            if(temp.getItemID().equals(searchTerm)){//checks if item ID is equal to searchTerm
                found = true;
            
        if (temp instanceof CorporationDonor) { //checks if searchTerm is equal to a CorporationDonor item ID
            
            //if item iD is found, update any changed fields that are equal to the searchTerm
            temp.setItem(viewItemNameTF.getText().trim());
            temp.setDateReceived(viewItemDateReceivedTF.getText().trim());
            temp.setItemType(viewItemTypeTF.getText().trim());
            temp.setItemQuantity(Integer.parseInt(viewItemQuantityTF.getText().trim()));
            temp.setCondition((String) viewItemConditionCB.getSelectedItem());
            temp.setIsElectrical(viewItemElectricalChB.isSelected());

            ((CorporationDonor) temp).setCorpName(viewCorpNameTF.getText().trim());
            ((CorporationDonor) temp).setCorpFoundingYear(Integer.parseInt(viewCorpFoundingYearTF.getText().trim()));
            ((CorporationDonor) temp).setCorpHeadquareterAddress(viewCorpHQAddressTF.getText().trim());
            ((CorporationDonor) temp).setCorpEmail(viewCorpEmailTF.getText().trim());
            ((CorporationDonor) temp).setCorpPhoneNumber(Integer.parseInt(viewCorpPhoneNumberTF.getText().trim()));
                
            saveAgri(); //saves any changes to a dat file
            
             JOptionPane.showMessageDialog(null, "\nCorp Donor information updated successfully!\n" + temp.toString() + "\n");//displays the updated record
            return;
        } 
        
        if (temp instanceof IndividualDonor) { //checks if searchTerm is equal to a IndividualDonor item ID
            
            //if item id is found, update any changed fields that are equal to the that item ID
            temp.setItem(viewItemNameTF.getText().trim());
            temp.setDateReceived(viewItemDateReceivedTF.getText().trim());
            temp.setItemType(viewItemTypeTF.getText().trim());
            temp.setItemQuantity(Integer.parseInt(viewItemQuantityTF.getText().trim()));
            temp.setCondition((String) viewItemConditionCB.getSelectedItem());
            temp.setIsElectrical(viewItemElectricalChB.isSelected());

            ((IndividualDonor) temp).setIndiFirstName(viewIndiFirstNameTF.getText().trim());
            ((IndividualDonor) temp).setIndiSurname(viewIndiSurnameTF.getText().trim());
            ((IndividualDonor) temp).setIndiDoB(viewIndiDOBTF.getText().trim());
            ((IndividualDonor) temp).setIndiAddress(viewIndiAddressTF.getText().trim());
            ((IndividualDonor) temp).setIndiEmail(viewIndiEmailTF.getText().trim());
            ((IndividualDonor) temp).setIndiPhoneNumber(Integer.parseInt(viewIndiPhoneNumberTF.getText().trim()));
            
            saveAgri(); //saves any changes to a dat file
            
             JOptionPane.showMessageDialog(null, "\nIndi Donor information updated successfully!\n" + temp.toString() + "\n");//displays the updated record
            return;
            }
            }
        }
    
        if(!found){//if item ID doesnt equal any searchTerm, display to the user that no item ID was found
            JOptionPane.showMessageDialog(null, "No record found for Item ID: " + searchTerm);
        }
    }
    
    public static String createIndiDonorID() {
    //Function for incrementing the Individual Donors ID
    //declare starting prefix and starting id number
    //checks for previous donors
    //interages through ArrayList to find the current highest indi donor id
    //seperate prefix from numeric part of id, sets idNumber as the highest number id
    //increment idNumber by 1
    //return next highest Individual Donor ID
    
    String prefix = "Indi-";
    int nextId = 1; 

    if (agriAid != null && !agriAid.isEmpty()) {
        for (AgriculturalAid temp : agriAid) {
            if (temp instanceof IndividualDonor) {
                String currentId = ((IndividualDonor) temp).getDonorID();
                if (currentId.startsWith(prefix)) {
                    int idNumber = Integer.parseInt(currentId.substring(prefix.length()));
                    nextId = Math.max(nextId, idNumber + 1);
                }
            }
        }
    }
 
    return prefix + String.format("%03d", nextId); //returns next highest Individual ID in format Indi-000
    }

    
    public static String createCorpDonorID(){
    //Function for incrementing the Coporation Donors ID
    //declare starting prefix and starting id number
    //checks for previous donors
    //interages through ArrayList to find the current highest corp donor id
    //seperate prefix from numeric part of id, sets idNumber as the highest number id
    //increment idNumber by 1
    //return next highest Corporation Donor ID
        
        String prefix = "Corp-";
        int nextId = 1;
        
        if(agriAid != null && !agriAid.isEmpty()){
            for (AgriculturalAid temp : agriAid){
                if(temp instanceof CorporationDonor){
                    String currentId = ((CorporationDonor) temp).getDonorID();
                    if(currentId.startsWith(prefix)){
                    int idNumber = Integer.parseInt(currentId.substring(prefix.length()));
                    nextId = Math.max(nextId, idNumber + 1);
                }
            }
        }
    }
        return prefix + String.format("%03d", nextId); //returns next highest Corporation ID in the format Corp-000
    }
    
    public static String createItemID(){
    //Function for incrementing both Coporation and Individual Item IDs
    //declare starting prefix and starting id number
    //checks for previous Item IDs
    //interages through ArrayList to find the current highest Item ID
    //seperate prefix from numeric part of id, sets idNumber as the highest number id
    //increment idNumber by 1
    //return next highest Item ID regrardless of donor type
        
        String prefix = "Item-";
        int nextId = 1;
        
        if(agriAid != null && !agriAid.isEmpty()){
            for (AgriculturalAid temp : agriAid){
                String currentId = temp.getItemID();
                if (currentId != null && currentId.startsWith(prefix)) {
                int idNumber = Integer.parseInt(currentId.substring(prefix.length()));
                nextId = Math.max(nextId, idNumber + 1);
            }
        }
    }
    return prefix + String.format("%03d", nextId);
    }
    
    
    public static void saveAgri(){
        FileOutputStream fStream;
        ObjectOutputStream oStream;
        
        try {
            fStream = new FileOutputStream(f);
            oStream = new ObjectOutputStream(fStream);
            oStream.writeObject(agriAid); //writes arraylist to a dat file
            oStream.close();//close the file
            
           // System.out.println("file saved successfully");
        } catch (IOException e){
            System.out.println("I/O e" + e);
        }
    }
    
    public static void loadAgri(){
        FileInputStream fStream;
        ObjectInputStream oStream;
        
        try {
            fStream = new FileInputStream(f);
            oStream = new ObjectInputStream(fStream);
            
            agriAid = (ArrayList <AgriculturalAid>)oStream.readObject();
            //reads all elements from the arraylist object
            oStream.close();
        } catch(IOException | ClassNotFoundException e){
            System.out.println("File input " + e);
        }
    }
    
    public static void viewDonor(){
        if(agriAid.isEmpty()){//if arraylist is emtpy, display to the user that no-one is in the system
            JOptionPane.showMessageDialog(null, "No-One in System!");
            return;
        } else {//else load the arraylist with the most up to date records and display them in a text area
            loadAgri();
        displayTA.setText(" ");
        displayTA.append("\nTotal Donors: " + agriAid.size() + "\n");//displays how many donors are in the system
         for(AgriculturalAid temp : agriAid){
//           JOptionPane.showMessageDialog(null, temp.toString());
        displayTA.append("\n" + temp.toString() + "\n");//appends all the Donors information to a text area
        displayTA.setCaretPosition(0);//sets the text area to the top if scrolling is needed
        }
        }
    }
    
    public static void mkFile(){
        if(!f.exists()){//if no dat file exists, create the dat file and populate it with 4 records
            saveAgri();
        } else { //if dat file exists load all the record in the system
            loadAgri();
        }
    }
}
