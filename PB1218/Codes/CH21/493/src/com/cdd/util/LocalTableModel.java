package com.cdd.util;
public class LocalTableModel extends javax.swing.table.DefaultTableModel {
	Class[] types = new Class[] { java.lang.Object.class,
			java.lang.String.class, java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class};
	boolean[] canEdit = new boolean[] { false, false, false,false,false,false,false};
	public LocalTableModel() {
		super(new Object[][] {}, new String[] { "編號", "姓名", "語文","數學","英語","歷史","實體",});
	}
	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}