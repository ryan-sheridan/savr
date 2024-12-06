/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savrui.components;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Timer;

/**
 *
 * @author ryan
 */

// SOURCE: old project
// DATE: some point in the last year, march ? 

public class RFadePanel extends JPanel implements ActionListener {
    
    // an interface allowing us to listen for fade completions
    public interface FadeCompleteListener {
        void onFadeComplete(boolean fadedOut);
    }

    private FadeCompleteListener fadeCompleteListener;
    private final Timer timer;
    private float opacity = 1.0f;
    private boolean fadingOut = false;
    
    private float startY = 0; 
    private float targetY = 0;
    private float currentY = 0;
    private boolean allowedLerpY;

    // not every fade panel should lerp on the y axis
    public boolean isAllowedLerpY() {
        return allowedLerpY;
    }
    
    public void setIsAllowedLerpY(boolean isAllowedLerpY) {
        this.allowedLerpY = isAllowedLerpY;
    }

    // method for linear interpolation
    // with a start and end point we can get a point on that line
    // by providing a % (a value between 0.0 and 1.0)
    private float lerp(float start, float end, float t) {
        return start + t * (end - start);
    }
    
    // sets the target y position for movement
    // the target y position is the final y position of the element
    public void setTargetY(float targetY) {
        this.targetY = targetY;
        
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    // gets the current y position
    public float getCurrentY() {
        return currentY;
    }
    
    // set the opacity and repaint the component 
    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }

    // returns the radius of top left
    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    // sets radius of top left
    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    // same thing
    public int getRoundTopRight() {
        return roundTopRight;
    }

    // same thing
    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    // layout null to allow us to do everything, no border and allow transparency
    public RFadePanel() {
        setLayout(null);
        setBorder(null);
        setOpaque(false);
        
        // 6 is the speed of the animation
        timer = new Timer(6, this);
    }

    @Override
    public void paint(Graphics g) {
        // we override to draw with opacity
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        super.paint(g2d);
        g2d.dispose();
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        // for smooth edges, anti alias
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // allow transparency
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        // set the colour based on background
        g2.setColor(getBackground());
        
        // honestly not sure what this does i wrote this months ago and adding comments now
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        
        g2.fill(area);
        g2.dispose();
        
        // do what a JPanel is ment to do
        super.paintComponent(grphcs);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // this is called by timer repeatedly
        if (fadingOut) {
            // if we are fading out decrease the opacity by a certain amount
            opacity -= 0.05f;
            if (opacity <= 0) {
                // if the opacity is <= 0 stop the timer
                opacity = 0;
                timer.stop();
                // remove the component
                setVisible(false);
                // if our listener exists
                if (fadeCompleteListener != null) {
                    // let it know the fade is completed
                    fadeCompleteListener.onFadeComplete(true);
                }
            }
        } else {
            // we are fading in, so increase opacity
            opacity += 0.05f;
            if (opacity >= 1.0f) {
                // opacity is 1 if we are done, so stop timer
                opacity = 1.0f;
                timer.stop();
                if (fadeCompleteListener != null) {
                    // let the listener know that the fade is completed
                    fadeCompleteListener.onFadeComplete(false);
                }
            }
        }
        
        // if the component is allowed to lerp on the y axis
        if(allowedLerpY) {
            // increase the current y axis by 10 percent closer to the final y 
            currentY = lerp(currentY, targetY, 0.1f);
            // set bounds because setLocation was bugging out
            // make sure currentY is an int
            setBounds(getX(), Math.round(currentY), getWidth(), getHeight());
        }
        
        // repaint to display changes
        repaint();
    }
    
    public void fadeIn() {
        // make sure we are visible and start the timer, timer will call actionListener then actionListener calls repaint()
        fadingOut = false;
        setVisible(true);
        if (opacity < 1.0f) {
            timer.start();
        }
    }

    public void fadeOut() {
        // same thing
        fadingOut = true;
        if (opacity > 0) {
            timer.start();
        }
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (!visible) {
            // make sure if the component is not visible, there is no timer running
            timer.stop();
        }
    }
    
    public void setFadeCompleteListener(FadeCompleteListener listener) {
        this.fadeCompleteListener = listener;
    }

    // corner radius implementation 
    // stolen from R*Field source code, and that was definetly stolen from either GPT or the internet
    // i dont know exactly what this does but it works
    
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}
