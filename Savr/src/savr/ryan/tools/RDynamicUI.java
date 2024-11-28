/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan.tools;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ryan
 */

// this was implemented to allow a consistent font throughout the whole system
// the original font system was set by UIManager in the main method, for all 
// awt components, this did not take into account for when someone changes the font
// size of a JLabel anywhere in the application, in the case of one of us wanting
// to change a font size, we wouldnt have the option to select Ubunut-Regular
// and its size in the properties manager. meaning the font would have to be changed
// to a font already provided by the system for its size to be changed.

// to solve this problem, this class has 2 methods regarding fonts, 
// the useful one being updateFont this takes a container, loops 
// through all of its components and sets the font
// to Ubuntu-Regular from the resources, but also retains the font size.

// in every view/controller, (i hope my terminology is correct here regarding MVC)
// updateFont is called in the constructor after components are initialised, giving 
// them time to load correctly then forcing the font update, this ofcourse is optional
// and the line can be removed from any of the views/controllers

// UPDATE: this has now been updated to manage application wide UI look and feel
public class RDynamicUI {
    
    private static RDynamicUI instance;
    
    private static HashMap<String, Color> darkPallete = new HashMap<>();
    private static HashMap<String, Color> lightPallete = new HashMap<>();

    private static void initialisePallete() {
        darkPallete.put("Panel.background", new Color(40, 40, 40));
        darkPallete.put("Table.background", new Color(40, 40, 40));
        darkPallete.put("TextField.background", new Color(40, 40, 40));
        darkPallete.put("Label.foreground", Color.WHITE);
        darkPallete.put("TextArea.background", new Color(40, 40, 40));
        darkPallete.put("TextArea.foreground", Color.WHITE);
        darkPallete.put("ComboBox.background", new Color(40, 40, 40));
        darkPallete.put("ComboBox.foreground", Color.WHITE);
        darkPallete.put("ComboBox.selectionBackground", new Color(60, 60, 60));
        darkPallete.put("ComboBox.selectionForeground", Color.WHITE);
        
        lightPallete.put("Panel.background", new Color(245, 245, 245)); 
        lightPallete.put("Table.background", Color.WHITE);
        lightPallete.put("Button.background", Color.LIGHT_GRAY);
        lightPallete.put("TextField.background", Color.WHITE);
        lightPallete.put("Label.foreground", Color.BLACK); 
        lightPallete.put("TextArea.background", Color.WHITE);
        lightPallete.put("TextArea.foreground", Color.BLACK);
        lightPallete.put("ComboBox.background", Color.WHITE);
        lightPallete.put("ComboBox.foreground", Color.BLACK);
        lightPallete.put("ComboBox.selectionBackground", new Color(220, 220, 220));
        lightPallete.put("ComboBox.selectionForeground", Color.BLACK);
    }

    public static Theme getTheme() {
        return currentTheme;
    }
    
    
    public enum Theme {
        DARK,
        LIGHT
    }
    
    private static Theme currentTheme;
    
    private RDynamicUI() {
        initialisePallete();
        // setup default theme
        currentTheme = Theme.DARK;
        applyTheme(currentTheme);
    }
    
    public static synchronized RDynamicUI getInstance() {
        if (instance == null) {
            instance = new RDynamicUI();
        }
        return instance;
    }
    
    public static void applyTheme(Theme theme) {
        currentTheme = theme;
        
        switch(theme) {
            case DARK:
                setDarkTheme();
                break;
            case LIGHT:
                setLightTheme();
        }
    }
    
    private static void setDarkTheme() {
        try {
            // RESEARCH: https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
            for(Map.Entry<String, Color> entry : darkPallete.entrySet()) {
                javax.swing.UIManager.put(entry.getKey(), entry.getValue());
            }
            
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RDynamicUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void setLightTheme() {
        try {
            // RESEARCH: https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
            for(Map.Entry<String, Color> entry : lightPallete.entrySet()) {
                javax.swing.UIManager.put(entry.getKey(), entry.getValue());
            }
            
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RDynamicUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateFont(Container container) {
        Font ubuntuFont = null;
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font f = Font.createFont(Font.TRUETYPE_FONT,
                    RDynamicUI.class.getResourceAsStream("/resources/Ubuntu-Regular.ttf"));
            if (!ge.registerFont(f)) {
                System.out.println("Unable to register font");
            }
            ubuntuFont = f; // preserve existing font size
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        if (ubuntuFont != null) {
            updateFontRecursively(container, ubuntuFont);
        }
    }

    private static void updateFontRecursively(Container container, Font ubuntuFont) {
        // grab all components in the container
        for (Component comp : container.getComponents()) {
            // make sure each component is an instance of container
            if (comp instanceof Container) {
                updateFontRecursively((Container) comp, ubuntuFont);
            }

            // for the current component, get the font
            Font currentFont = comp.getFont();
            if (currentFont != null) {
                // preserve the size, but change the font
                comp.setFont(ubuntuFont.deriveFont(currentFont.getStyle(), currentFont.getSize()));
            }
        }
    }
}
