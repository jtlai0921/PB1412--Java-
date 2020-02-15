package com.mingrisoft.jlist;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EtchedBorder;

public class BorderListCellRenderer implements ListCellRenderer {
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (index % 2 == 0) {
            renderer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        }
        return renderer;
    }
}
