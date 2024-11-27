/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan.tools;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.UIManager;

/**
 *
 * @author ryan
 */
public class RDynamicFont {
    public static void updateFont(Container container) {
        Font ubuntuFont = null;
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font f = Font.createFont(Font.TRUETYPE_FONT,
                    RDynamicFont.class.getResourceAsStream("/resources/Ubuntu-Regular.ttf"));
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
