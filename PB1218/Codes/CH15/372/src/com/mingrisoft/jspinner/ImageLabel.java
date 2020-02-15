package com.mingrisoft.jspinner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageLabel extends JLabel implements ChangeListener {
    
    private static final long serialVersionUID = -5189246904858249548L;
    private JSpinner spinner;
    private ImageIcon image;
    
    public ImageLabel(JSpinner spinner) {
        this.spinner = spinner;
        this.image = (ImageIcon) spinner.getValue();
        spinner.addChangeListener(this);
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        image = (ImageIcon) spinner.getValue();
        setIcon(image);
    }
    
    @Override
    public Icon getIcon() {
        return image;
    }
    
}
