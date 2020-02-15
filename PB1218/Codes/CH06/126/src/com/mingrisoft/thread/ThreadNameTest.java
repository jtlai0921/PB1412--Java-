package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadNameTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -191531973146137575L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField1;
    private JTextField textField2;
    
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
                    ThreadNameTest frame = new ThreadNameTest();
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
    public ThreadNameTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("check and change thread name");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        textField1 = new JTextField();
        textField1.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(textField1);
        textField1.setColumns(6);
        
        JButton button1 = new JButton("new thread");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        button1.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(button1);
        
        textField2 = new JTextField();
        textField2.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(textField2);
        textField2.setColumns(6);
        
        JButton button2 = new JButton("change thread");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button2_actionPerformed(e);
            }
        });
        
        button2.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(button2);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "½uµ{ID", "½uµ{¦WºÙ" });
        for (Thread thread : threads) {
            model.addRow(new Object[] { thread.getId(), thread.getName() });
        }
        table.setModel(model);
    }
    
    protected void do_button1_actionPerformed(ActionEvent e) {
        Object[] newThread = null;
        String name = textField1.getText();
        if (name.isEmpty()) {
            Thread thread = new Thread(new Forever());
            thread.start();
            newThread = new Object[] { thread.getId(), thread.getName() };
        } else {
            Thread thread = new Thread(new Forever(), name);
            thread.start();
            newThread = new Object[] { thread.getId(), name };
        }
        ((DefaultTableModel) table.getModel()).addRow(newThread);
    }
    
    protected void do_button2_actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        String newName = textField2.getText();
        if ((selectedRow == -1) || newName.isEmpty()) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(newName, selectedRow, 1);
        repaint();
    }
    
    private class Forever implements Runnable {
        
        @Override
        public void run() {
            while (true) {
            }
        }
        
    }
    
}
