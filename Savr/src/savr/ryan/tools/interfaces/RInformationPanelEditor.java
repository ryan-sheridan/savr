/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan.tools.interfaces;

import savr.ryan.WasteSource.SourceType;

/**
 *
 * @author ryan
 */
public interface RInformationPanelEditor {
    void updateSourceNameField(String text);
    void updateSourceAddressField(String text);
    void updateWasteAmountField(String text);
    void updateSourceTypeCombo(String type);
    void updateSelectedId(int id);
    
    void refreshScrollView();
    
    void clearInformationPanel();
}
