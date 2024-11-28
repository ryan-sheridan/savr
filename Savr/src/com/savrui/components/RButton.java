/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savrui.components;

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGElement;
import com.kitfox.svg.SVGElementException;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;
import com.kitfox.svg.animation.AnimationElement;
import static com.savrui.components.RButton.ButtonType.HOME;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import savr.ryan.tools.RDynamicUI;
import static savr.ryan.tools.RDynamicUI.Theme.DARK;
import static savr.ryan.tools.RDynamicUI.Theme.LIGHT;

/**
 *
 * @author ryan
 */

// this was originally a good idea but became a pain of a class when SVG was implemented
public class RButton extends JButton {
    Color backgroundColor;
    
    private boolean roundTopLeft;
    private boolean roundTopRight;
    private boolean roundBottomLeft;
    private boolean roundBottomRight;
    
    private boolean roundedCorners;
    
    private BufferedImage iconImage;
    private SVGDiagram svgIcon;
    
    private int padding = 0;

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
    
    private ButtonType buttonType;
    
    // this svg stuff is way to static, figure out how to resize svg dynamically
    // depending on button w and h, or dont, or does it really matter?
    
    // could of just used an icon ...
    
    // load the svg icon and set it as the button icon
    public void setIconWithSVG(String svgPath) {
        SVGUniverse svgUniverse = new SVGUniverse();
        // load svg into a SVGDiagram object
        svgIcon = svgUniverse.getDiagram(svgUniverse.loadSVG(getClass().getResource(svgPath)));
        svgIcon.setIgnoringClipHeuristic(true);
        
        SVGElement rootElement = svgIcon.getRoot();
        
        try {
            if(buttonType == HOME) {
                rootElement.setAttribute("fill", AnimationElement.AT_XML, "#FFFFFF");
                rootElement.addAttribute("fill-opacity", AnimationElement.AT_CSS, "0.5");
            }
        } catch (SVGElementException ex) {
            Logger.getLogger(RButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int width = Math.max(getWidth() - padding * 2, 1);
        int height = Math.max(getHeight() - padding * 2, 1);
        
        // System.out.println(String.format("%d %d", getWidth(), getHeight()));
        
        // render the SVGDiagram as a BufferedImage
        iconImage = renderSVG(svgIcon, width, height);
    }

    private BufferedImage renderSVG(SVGDiagram svgIcon, int width, int height) {
        // create a new BufferedImage
        BufferedImage image = new BufferedImage(27, 27, BufferedImage.TYPE_INT_ARGB);
        // get a new graphics context
        Graphics2D g = image.createGraphics();
        
        // for those smooth edges
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        
        // set width and height of the SVG
        //Rectangle viewport = new Rectangle(0, 0, width, height);
        //svgIcon.setDeviceViewport(viewport);
        
        try {
            // render svg to a graphics context
            svgIcon.render(g);
        } catch (SVGException ex) {
            Logger.getLogger(RButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // RESEARCH: why i always have to do dispose
        g.dispose();
        
        // DEBUG
        // displayBufferedImage(image);
        
        return image;
    }
    
    
    public enum ButtonType {
        SETTINGS,
        HOME,
        TEXT
    }

    public ButtonType getButtonType() {
        return buttonType;
    }

    public void setButtonType(ButtonType buttonType) {
        this.buttonType = buttonType;
    }
    
    
    public RButton() {
        super();
        roundedCorners = true;
        setRoundedCorners(roundedCorners);
    }
    
    // SOURCE: gpt
    // question: "how would i increase the brightness of a Color instance by a certain percent"
    public static Color updateBrightness(Color color, double percent) {
        // Ensure the percent is within reasonable bounds
        percent = Math.max(-100, Math.min(100, percent));
        
        double factor = 1 + (percent / 100.0);

        // Extract the RGB components
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        // Increase the brightness of each component
        r = (int) Math.min(255, r * factor); // Clamp to max 255
        g = (int) Math.min(255, g * factor); // Clamp to max 255
        b = (int) Math.min(255, b * factor); // Clamp to max 255

        // Return the new color with increased brightness
        return new Color(r, g, b);
    }
    
    // RESEARCH: https://stackoverflow.com/questions/596216/formula-to-determine-perceived-brightness-of-rgb-color
    // calculates the luminocity of a colour, we can use this to determine what foreground we should use to render text
    public double calculateLuminocity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        
        // from aleclarson's reply in StackOverflow thread
        return (r * 0.2126) + (g * 0.7152) + (b * 0.0722);
    }
    
    // we want our rendered text colour to be dynamically chosen based on the background
    public Color calculateForeground(Color color) {
        double luminance = calculateLuminocity(color);
        
        // RESEARCH: https://www.w3schools.com/java/java_conditions_shorthand.asp
        double luminancePercent = Math.max(0, Math.min(100, luminance));
        System.out.println(luminancePercent);
        return luminancePercent > 80.0 ? Color.BLACK : Color.WHITE;
    }
    
    // this is a method called when a component is added to a container
    // or when a component is made visible by setVisible
    // here we can attach a MouseListener to the button to allow us to change the colour
    // when the button is on hover using mouseEntered and mouseExited
    //
    // we can increase the brightness by 30 percent then go back to the original
    // background (backgroundColor) which is set when the class is instanciated
    @Override
    public void addNotify() {
        super.addNotify();
        setBorderPainted(false);
        backgroundColor = getBackground();

        // attach MouseListener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // set the background on hover to the original backgroundColor with the brightness increased by 30%
                
                float percent = 30.0f;
                
                if (RDynamicUI.getTheme() == LIGHT) {
                    percent = -percent;
                }
                
                setBackground(updateBrightness(backgroundColor, percent));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backgroundColor); // revert to original background colour when hover is finished
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                
                float percent = 50.0f;
                
                if (RDynamicUI.getTheme() == LIGHT) {
                    percent = -percent;
                }
                
                // when button is clicked it should increase the brightness even more than if it was a hover
                setBackground(updateBrightness(backgroundColor, percent));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // we are still hovering when the mouse press is released
                // so pass mouseEntered our mouse event instead
                mouseEntered(e);
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // the perfect border radius
        int radius = Math.min(getWidth(), getHeight()) / 3;

        System.out.println(isRoundBottomLeft());
        // create path for rounded rect
        Path2D.Float path = createRoundedRectangle(getWidth(), getHeight(),
                            isRoundTopLeft()     ? radius : 0,
                            isRoundTopRight()    ? radius : 0,
                            isRoundBottomLeft()  ? radius : 0,
                            isRoundBottomRight() ? radius : 0);

        // fill in path
        g2.setColor(getBackground());
        g2.fill(path);
        
        if(getButtonType() == ButtonType.HOME) {
            
            // TODO: stop hardcoding things
            setIconWithSVG("/resources/home.svg");
            
            if(iconImage != null) {
                g2.drawImage(iconImage, 2,2, this);
            }
        } else if (getButtonType() == ButtonType.SETTINGS) {
            // TODO: stop hardcoding things
            setIconWithSVG("/resources/settings.svg");
            
            if(iconImage != null) {
                g2.drawImage(iconImage, 2,2, this);
            }
        } else {
            // here we render the text manually so we can draw over our rounded rect
            g2.setColor(calculateForeground(backgroundColor));  
            String text = getText();  // grab the text of the button
            FontMetrics fm = g2.getFontMetrics();

            // Calculate the position of the text to center it
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

            // Draw the text
            g2.drawString(text, x, y);
        }
        
        g2.dispose();
        
        // do what we wore ment to do originally
        //super.paintComponent(g);
    }
    
    // magic black box
    // SOURCE: old RTextField code
    private Path2D.Float createRoundedRectangle(int width, int height, int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius) {
        Path2D.Float path = new Path2D.Float();
        path.moveTo(0, topLeftRadius);
        path.quadTo(0, 0, topLeftRadius, 0);
        path.lineTo(width - topRightRadius, 0);
        path.quadTo(width, 0, width, topRightRadius);
        path.lineTo(width, height - bottomRightRadius);
        path.quadTo(width, height, width - bottomRightRadius, height);
        path.lineTo(bottomLeftRadius, height);
        path.quadTo(0, height, 0, height - bottomLeftRadius);
        path.closePath();
        return path;
    }
    
    public void setRoundedCorners(boolean isRounded) {
        this.roundedCorners = isRounded;
        
        setRoundTopLeft(isRounded);
        setRoundTopRight(isRounded);
        setRoundBottomLeft(isRounded);
        setRoundBottomRight(isRounded);
    }
    
    public boolean isRoundTopLeft() {
        return roundTopLeft;
    }
    
    public void setRoundTopLeft(boolean roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    public boolean isRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(boolean roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    public boolean isRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(boolean roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
    }

    public boolean isRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(boolean roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
    }
}
