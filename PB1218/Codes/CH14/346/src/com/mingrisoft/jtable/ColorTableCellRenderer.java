package com.mingrisoft.jtable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ColorTableCellRenderer extends JPanel implements TableCellRenderer {
    
    private static final long serialVersionUID = 8932176536826008653L;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int times = 50;
        int r = row * times % 255;
        int g = column * times % 255;
        int b = (row + column) * times % 255;
        setBackground(new Color(r, g, b));
        return this;
    }
}
