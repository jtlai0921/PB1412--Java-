package com.mingrisoft.jlist;

import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class FontListCellRenderer implements ListCellRenderer {
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Font font = (Font) value;
        renderer.setFont(font);
        renderer.setText(font.getFontName());
        return renderer;
    }
    
}
