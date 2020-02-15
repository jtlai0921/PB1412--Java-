package com.mingrisoft.glasspane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class GlassPane extends JComponent {
    
    private static final long serialVersionUID = 9060636159598343142L;
    
    public GlassPane() {
        addMouseListener(new MouseAdapter() {
        });
        addMouseMotionListener(new MouseMotionAdapter() {
        });
        addKeyListener(new KeyAdapter() {
        });
        
        setFont(new Font("Default", Font.BOLD, 16));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("¥¿¦b¤U¸ü", 190, 130);
    }
    
}
