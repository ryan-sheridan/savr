/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savrui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import savr.MainApplication;
import savr.ryan.tools.RDynamicUI;

/**
 *
 * @author ryan
 */
public class RGlassDialog extends RFadePanel {

    private RFadePanel centerBox; // the little box in the center of the GlassPane
    private RButton primaryButton; // the primary button
    private RButton secondaryButton; // the other button
    private String primaryText = "Ok"; // default text for primary button
    private String secondaryText = "Dismiss"; // default text for secondary
    private String title = "Title Placeholder"; // default text for our title

    public RGlassDialog() {
        super();
        // we need to be slightly transparent but still focus on the center dialog box
        // so alpha to around 50%
        setBackground(new Color(0, 0, 0, 128));
        // when we first load our RGlassDialog, we should be fully transparent
        setOpacity(0f);
        setOpaque(false);
    }

    public RGlassDialog(String primaryText, String secondaryText) {
        this();
        // same thing as above, the user just provided us with some button text
        this.primaryText = primaryText;
        this.secondaryText = secondaryText;
    }

    public RGlassDialog(String primaryText, String secondaryText, String title) {
        this();
        // and again
        this.primaryText = primaryText;
        this.secondaryText = secondaryText;
        this.title = title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void fadeInOver(Component component) {
        // grab the parent JFrame
        JFrame frame = getTopLevelFrame(component);
        // make sure it actually exists
        if (frame != null) {
            // update the GlassPane of the JFrame
            setGlassPaneToFrame(frame);
            // listen out for when our fade is completed
            setFadeCompleteListener(fadedOut -> {
                if (!fadedOut) {
                    // then start the fade in of our little dialog box
                    SwingUtilities.invokeLater(this::fadeInCenterBox);
                }
            });
            
            fadeIn();
        }
    }
    
    // RESEARCH: https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html
    private void setGlassPaneToFrame(JFrame frame) {
        // set the frames glassPane to self
        frame.setGlassPane(this);
        setVisible(true);
    }

    private JFrame getTopLevelFrame(Component component) {
        // find the parent component
        while (component != null) {
            // make sure its a JFrame
            if (component instanceof JFrame) {
                return (JFrame) component;
            }
            // if not get the parent of the component
            // eventually we will reach the parent JFrame
            component = component.getParent();
        }
        throw new IllegalArgumentException("cant find top level jframe :( ");
    }

    private void fadeInCenterBox() {
        if (centerBox == null) {
            // grab JPanel background color based on theme
            Color centerBoxBackgroundColor = RDynamicUI.getCurrentPalleteColour("Panel.background");

            // center box should also be able to fade in
            centerBox = new RFadePanel();
            
            // set the background of our center box depending on the theme
            centerBox.setBackground(centerBoxBackgroundColor);
            centerBox.setOpacity(0f);
            centerBox.setOpaque(false);

            // set the corner radius of each corner
            centerBox.setRoundTopLeft(20);
            centerBox.setRoundTopRight(20);
            centerBox.setRoundBottomLeft(20);
            centerBox.setRoundBottomRight(20);

            // the box size
            Dimension boxSize = new Dimension(300, 200);
            centerBox.setSize(boxSize);

            // grab the parent JFrame
            JFrame topFrame = getTopLevelFrame(this);
            // make sure it exists
            if (topFrame != null) {
                // calculate the x and y coordinate of the centerBox based on 
                // the width and height of our window
                Rectangle frameBounds = topFrame.getBounds();
                // this should center it 
                // this is so much easier programatically, gui builder is weird
                int x = (frameBounds.width - boxSize.width) / 2;
                int y = (frameBounds.height - boxSize.height) / 2;
                centerBox.setLocation(x, y);
            }

            // no constraints, allows us to place things anywhere
            this.setLayout(null);

            // our primary button is an instance of RButton
            // set the size 
            primaryButton = new RButton();
            Dimension buttonSize = new Dimension(60, 30);
            primaryButton.setSize(buttonSize);

            // to position the button and title we need the bounds of our centerBox
            Rectangle centerBoxBounds = centerBox.getBounds();

            // create a JTextArea based on the title 
            // JLabel was being weird
            JTextArea titleLabel = new JTextArea(title);
            // x and y should be 10 so its a little bit away from the top left
            // the width should nearly span the entire with of the centerBox
            titleLabel.setBounds(10, 10, centerBoxBounds.width - 20, 50);
            // set word wrap to true
            titleLabel.setWrapStyleWord(true);
            titleLabel.setLineWrap(true);
            // transparency
            titleLabel.setOpaque(false);
            // dont allow users to edit it
            titleLabel.setEditable(false);
            // dont focus
            titleLabel.setFocusable(false);
            // set the font size, Arial is ignored due to RDynamicUI call
            titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            // add the title to the centerBox
            centerBox.add(titleLabel, 0);

            // define a padding and button spacing
            int padding = 15;
            int buttonSpacing = 5;
            
            // the position of the main button can be calculated
            // x being parent width - button width should leave it on the right hand side
            // dont stick it to the very right, so we use padding 
            int submitX = (centerBoxBounds.width - buttonSize.width - padding);
            // the y value is the same thing, will leave it at the bottom but with some space
            int submitY = (centerBoxBounds.height - buttonSize.height - padding);
            primaryButton.setLocation(submitX, submitY);
            primaryButton.setText(primaryText);

            // create our secondaryButton, background based on theme, size is the same
            secondaryButton = new RButton();
            secondaryButton.setBackground(centerBoxBackgroundColor);
            secondaryButton.setSize(buttonSize);

            // we do the same as before but take away the button size twice so
            // we dont overlap with the submit button, also add padding, like before
            // but also add spacing between buttons
            // y is calculated the same
            int dismissX = (centerBoxBounds.width - buttonSize.width * 2 - padding - buttonSpacing);
            int dismissY = (centerBoxBounds.height - buttonSize.height - padding);
            secondaryButton.setLocation(dismissX, dismissY);
            secondaryButton.setText(secondaryText);
            
            // when our buttons are pressed, do something
            // dismiss will simply do nothing but fade out
            secondaryButton.addActionListener(e -> fadeOutOver());
            primaryButton.addActionListener(e -> submitPress());
            
            // add buttons to the center box
            centerBox.add(secondaryButton);
            centerBox.add(primaryButton);
            
            // update the font of everything, keeping font size
            RDynamicUI.updateFont(centerBox);
            
            // add centerBox to the glassPane
            this.add(centerBox);
        }

        // make our center box visible
        centerBox.setVisible(true);
        // we dont realllly have to listen for a fade in completion here
        centerBox.fadeIn();
    }

    private void fadeOutOver() {
        // make sure our centerBox exists
        if (centerBox != null) {
            // listen out for fade completion
            centerBox.setFadeCompleteListener(fadedOut -> {
                // when we are faded out
                if (fadedOut) {
                    // remove the centerBox
                    centerBox.setVisible(false);
                    // and fadeOut 
                    fadeOut();
                }
            });
            
            centerBox.fadeOut();
        }
    }

    // this can be overriden to add functionality
    public void submitPress() {
        fadeOutOver();
    }
    
}