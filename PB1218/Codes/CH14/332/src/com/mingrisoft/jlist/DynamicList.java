package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DynamicList extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 890359141688419648L;
    private JPanel contentPane;
    private JList list;
    private DefaultListModel model = new DefaultListModel();
    
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
                    DynamicList frame = new DynamicList();
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
    public DynamicList() {
        setTitle("列表項的增加與刪除");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton addButton = new JButton("增加");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_addButton_actionPerformed(e);
            }
        });
        addButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(addButton);
        
        JButton deleteButton = new JButton("刪除");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_deleteButton_actionPerformed(e);
            }
        });
        deleteButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(deleteButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(list);
        
        model.addElement("《Java從入門到精通（第2版）》");
        model.addElement("《PHP從入門到精通（第2版）》");
        model.addElement("《Visual Basic從入門到精通（第2版）》");
        model.addElement("《Visual C++從入門到精通（第2版）》");
        model.addElement("《Java編程詞典》");
        model.addElement("《細說Java》");
        model.addElement("《視訊學Java》");
        list.setModel(model);
    }
    
    protected void do_addButton_actionPerformed(ActionEvent e) {
        String text = JOptionPane.showInputDialog("增加元素");
        if ((text != null) && (!text.trim().isEmpty())) {
            model.addElement(text.trim());
        } else {
            return;
        }
    }
    
    protected void do_deleteButton_actionPerformed(ActionEvent e) {
        model.removeElement(list.getSelectedValue());
    }
}
