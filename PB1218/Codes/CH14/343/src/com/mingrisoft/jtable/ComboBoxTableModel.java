package com.mingrisoft.jtable;

import javax.swing.table.AbstractTableModel;

public class ComboBoxTableModel extends AbstractTableModel {
    
    private static final long serialVersionUID = 5523252281451951512L;
    
    private static String[] states = { "�ʳf", "�ݭn�i�f", "���ݭn�i�f" };
    private Object[][] data = { { "�mJava�q�J�����q�]��2���^�n", states[0] }, { "�mPHP�q�J�����q�]��2���^�n", states[1] }, { "�mVisual C++�q�J�����q�]��2���^�n", states[1] },
            { "�mVisual Basic�q�J�����q�]��2���^�n", states[1] }, };
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public int getRowCount() {
        return data.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int column) {
        String[] names = { "�ѦW", "���A" };
        return names[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
    }
    
    public static String[] getStates() {
        return states;
    }
}
