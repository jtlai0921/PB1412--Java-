package com.mingrisoft.jtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SortedTable extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2215793712885732497L;
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
                    SortedTable frame = new SortedTable();
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
    public SortedTable() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("����Ƨǥ\�઺���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("�L�n����", Font.PLAIN, 14));
        table.setRowHeight(35);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("�L�n����", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[] { "�ѦW", "�X����", "�X���ɶ�", "�O�����O�O", "�w��" });
        tableModel.addRow(new Object[] { "Java�q�J�����q�]��2���^", "�M�ؤj�ǥX����", "2010-07-01", "�n��u�{�v�J���O��", "59.8��" });
        tableModel.addRow(new Object[] { "PHP�q�J�����q�]��2���^", "�M�ؤj�ǥX����", "2010-07-01", "�n��u�{�v�J���O��", "69.8��" });
        tableModel.addRow(new Object[] { "Visual Basic�q�J�����q�]��2���^", "�M�ؤj�ǥX����", "2010-07-01", "�n��u�{�v�J���O��", "69.8��" });
        tableModel.addRow(new Object[] { "Visual C++�q�J�����q�]��2���^", "�M�ؤj�ǥX����", "2010-07-01", "�n��u�{�v�J���O��", "69.8��" });
        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
    }
}
