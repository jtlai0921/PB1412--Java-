package com.mingrisoft.jtable;

import javax.swing.table.AbstractTableModel;

public class ComboBoxTableModel extends AbstractTableModel {
    
    private static final long serialVersionUID = 5523252281451951512L;
    
    private static String[] states = { "缺貨", "需要進貨", "不需要進貨" };
    private Object[][] data = { { "《Java從入門到精通（第2版）》", states[0] }, { "《PHP從入門到精通（第2版）》", states[1] }, { "《Visual C++從入門到精通（第2版）》", states[1] },
            { "《Visual Basic從入門到精通（第2版）》", states[1] }, };
    
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
        String[] names = { "書名", "狀態" };
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