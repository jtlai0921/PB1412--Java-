package com.mingrisoft.jtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;

public class DeleteRows extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4540775327957798372L;
    private JPanel contentPane;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteRows frame = new DeleteRows();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public DeleteRows() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("刪除表格中的行");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("刪除");
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "請選擇要刪除的行", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        model.removeRow(table.getSelectedRow());
        table.setModel(model);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "書名", "出版社", "出版時間", "叢書類別別", "定價" });
        model.addRow(new Object[] { "Java從入門到精通（第2版）", "清華大學出版社", "2010-07-01", "軟件工程師入門叢書", "59.8元" });
        model.addRow(new Object[] { "PHP從入門到精通（第2版）", "清華大學出版社", "2010-07-01", "軟件工程師入門叢書", "69.8元" });
        model.addRow(new Object[] { "Visual Basic從入門到精通（第2版）", "清華大學出版社", "2010-07-01", "軟件工程師入門叢書", "69.8元" });
        model.addRow(new Object[] { "Visual C++從入門到精通（第2版）", "清華大學出版社", "2010-07-01", "軟件工程師入門叢書", "69.8元" });
        table.setModel(model);
    }
}
