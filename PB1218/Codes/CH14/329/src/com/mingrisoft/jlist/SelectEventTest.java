package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;

public class SelectEventTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7020163320919418696L;
    private JPanel contentPane;
    private JLabel label;
    private JList list;
    
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
                    SelectEventTest frame = new SelectEventTest();
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
    public SelectEventTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u5217\u8868\u9879\u5355\u51FB\u4E8B\u4EF6\u6D4B\u8BD5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        label = new JLabel("\u56FE\u4E66\u8D2D\u4E70\u4FE1\u606F");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged(e);
            }
        });
        list.setVisibleRowCount(3);
        list.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        scrollPane.setViewportView(list);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] listData = new String[7];
        listData[0] = "《Java從入門到精通（第2版）》";
        listData[1] = "《PHP從入門到精通（第2版）》";
        listData[2] = "《Visual Basic從入門到精通（第2版）》";
        listData[3] = "《Visual C++從入門到精通（第2版）》";
        listData[4] = "《Java編程詞典》";
        listData[5] = "《細說Java》";
        listData[6] = "《視訊學Java》";
        list.setListData(listData);
    }
    
    protected void do_list_valueChanged(ListSelectionEvent e) {
        label.setText("感謝您購買：" + list.getSelectedValue());
    }
    
}
