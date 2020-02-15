package com.mingrisoft.jlist;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ImageListCellRenderer implements ListCellRenderer {
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Object[]) {
            Object values[] = (Object[]) value;
            renderer.setIcon((Icon) values[0]);
            renderer.setText((String) values[1]);
        }
        return renderer;
    }
}
