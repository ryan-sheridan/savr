/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr;

import com.kitfox.svg.app.beans.SVGPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;
import javax.swing.JPanel;

public class ConorLogoPanel extends JPanel {
    
    // svg panel for conors logo compatible with gui builder
    public ConorLogoPanel() {
        super();
        
        setLayout(new BorderLayout());
        setOpaque(false);

        SVGPanel svgPanel = new SVGPanel();

        try (InputStream svgStream = getClass().getResourceAsStream("/resources/savr.svg")) {
            if (svgStream == null) {
                throw new IllegalArgumentException("SVG resource not found at /resources/savr.svg");
            }
            svgPanel.setSvgURI(getClass().getResource("/resources/savr.svg").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

        svgPanel.setAntiAlias(true);
        svgPanel.setScaleToFit(true);
        svgPanel.setOpaque(false);
        
        add(svgPanel, BorderLayout.CENTER);
    }
}