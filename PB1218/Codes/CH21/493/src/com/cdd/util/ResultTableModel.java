package com.cdd.util;
public class ResultTableModel extends javax.swing.table.DefaultTableModel {
	Class[] types = new Class[] { java.lang.Object.class,
			java.lang.String.class, java.lang.Object.class};
	boolean[] canEdit = new boolean[] { false, false, false };
	public ResultTableModel() {
		super(new Object[][] {}, new String[] { "編號", "姓名", "總分" });
	}
	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}