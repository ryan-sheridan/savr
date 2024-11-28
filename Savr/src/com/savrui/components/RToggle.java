package com.savrui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author ryan
 */

// RESEARCH: lerp: https://www.youtube.com/watch?v=YJB1QnEmlTs
public class RToggle extends JRadioButton {
    private Dimension fixedSize;
    
    private int innerOffset;
    private int circleRadius;
    private int circleY;
    private int circleX;
    private int circleXToggled;
    
    // animation variables
    private float animationProgress = 0.0f; // 0.0 untoggled, 1.0 toggled
    private Timer animationTimer;
    private final int animationDuration = 200; // animation duration in ms 
    private long animationStartTime;
    
    // two colours to lerp
    private final Color colorUntoggled = new Color(70, 70, 70); // suitable dark background
    private final Color colorToggled = new Color(0x22c55e); // from github colour pallete

    public RToggle() {
        super();
        fixedSize = new Dimension(65, 30);
        setPreferredSize(fixedSize);
        setBackground(colorUntoggled); // initial background colour
        
        // init animation timer
        animationTimer = new Timer(15, e -> {
            updateAnimation();
        });
        
        // when toggled, start animation
        addActionListener(e -> {
            startAnimation();
        });
    }
    
    // make it impossible to resize for gui builder
    @Override
    public Dimension getPreferredSize() {
        return fixedSize;
    }
    
    @Override
    public Dimension getMinimumSize() {
        return fixedSize;
    }

    @Override
    public Dimension getMaximumSize() {
        return fixedSize;
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, fixedSize.width, fixedSize.height);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // the perfect border radius
        int radius = Math.min(getWidth(), getHeight()) / 3;
        
        // create path for rounded rect
        Path2D.Float path = createRoundedRectangle((fixedSize.height / 2) + 2);

        // lerp colour, t being animationProgress
        Color currentBackground = interpolateColor(colorUntoggled, colorToggled, animationProgress);
        
        // fill in path with interpolated color
        g2.setColor(currentBackground);
        g2.fill(path);
        
        // played around with this until it looked grand
        int innerOffset = 3;
        int circleRadius = fixedSize.height / 2 - innerOffset;
        int circleY = fixedSize.height / 2;
        int circleXStart = circleRadius + innerOffset;
        int circleXEnd = fixedSize.width - circleRadius - innerOffset;
        
        // lerp x position
        float circleX = circleXStart + (circleXEnd - circleXStart) * animationProgress;
        
        Path2D.Float circle = createCircle(circleX, circleY, circleRadius);
        
        g2.setColor(Color.WHITE);
        g2.fill(circle);
        
        // super.paintComponent(g);
    }
    
    private void startAnimation() {
        animationStartTime = System.currentTimeMillis();
        if (!animationTimer.isRunning()) {
            animationTimer.start();
        }
    }

    private void updateAnimation() {
        long currentTime = System.currentTimeMillis();
        float elapsedTime = currentTime - animationStartTime;
        float progress = Math.min(elapsedTime / (float) animationDuration, 1.0f);
        
        if (isSelected()) {
            // if toggled, animate to toggled state
            animationProgress = progress;
        } else {
            // animate to untoggled state
            animationProgress = 1.0f - progress;
        }
        
        // update
        repaint();
        
        if (progress >= 1.0f) {
            animationTimer.stop();
        }
    }
    
    // RESEARCH: https://stackoverflow.com/questions/17544157/generate-n-colors-between-two-colors
    // THANKS: Martin Larsson
    private Color interpolateColor(Color startColor, Color endColor, float percent) {
        int red = (int)(startColor.getRed() + (endColor.getRed() - startColor.getRed()) * percent);
        int green = (int)(startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * percent);
        int blue = (int)(startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * percent);
        return new Color(red, green, blue);
    }
    
    // SOURCE: GPT
    // question: can you give me a method that returns Path2D.Float for creating a circle
    public static Path2D.Float createCircle(float centerX, float centerY, float radius) {
        Path2D.Float path = new Path2D.Float();
        path.moveTo(centerX + radius, centerY); // Start at the right edge of the circle
        path.append(new java.awt.geom.Arc2D.Float(
                centerX - radius, // Top-left x
                centerY - radius, // Top-left y
                radius * 2,       // Width
                radius * 2,       // Height
                0,                // Start angle
                360,              // Sweep angle
                java.awt.geom.Arc2D.OPEN // Arc type
        ), true);
        path.closePath(); // Ensure the circle is closed
        return path;
    }

    // SOURCE: RButton >> old project
    private Path2D.Float createRoundedRectangle(int radius) {
        Path2D.Float path = new Path2D.Float();
        path.moveTo(0, radius);
        path.quadTo(0, 0, radius, 0);
        path.lineTo(fixedSize.width - radius, 0);
        path.quadTo(fixedSize.width, 0, fixedSize.width, radius);
        path.lineTo(fixedSize.width, fixedSize.height - radius);
        path.quadTo(fixedSize.width, fixedSize.height, fixedSize.width - radius, fixedSize.height);
        path.lineTo(radius, fixedSize.height);
        path.quadTo(0, fixedSize.height, 0, fixedSize.height - radius);
        path.closePath();

        return path;
    }
}