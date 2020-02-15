package com.cdd.util;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {
    Class[] types = new Class[] { java.lang.Object.class,
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class };
    boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
    
    public LocalTableModel() {
        super(new Object[][] {}, new String[] { "字段編號", "字段名", "字段長度", "字段類別別",
                "描述", "是否為空", "小數位數", "預設值" });
    }
    
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}