package com.mingrisoft.jlabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;

public class JHyperlinkLabel extends JLabel {
    
    /**
     * 
     */
    private static final long serialVersionUID = -863116705726089148L;
    
    private String label;
    
    public JHyperlinkLabel(String label) {
        super(label);
        this.label = label;
        setForeground(Color.BLUE.darker());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new HyperlinkLabelMouseAdapter());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        Insets insets = getInsets();
        
        int left = insets.left;
        if (getIcon() != null) {
            left += getIcon().getIconWidth() + getIconTextGap();
        }
        
        g.drawLine(left, getHeight() - 1 - insets.bottom, (int) getWidth() - insets.right, getHeight() - 1 - insets.bottom);
    }
    
    private class HyperlinkLabelMouseAdapter extends MouseAdapter {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                URI uri = new URI(label);
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }
                
                if (desktop != null) {
                    desktop.browse(uri);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (URISyntaxException use) {
                use.printStackTrace();
            }
        }
    }
}
