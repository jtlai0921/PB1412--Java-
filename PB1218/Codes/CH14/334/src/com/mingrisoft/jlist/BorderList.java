package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderList extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2670265257224261565L;
    private JPanel contentPane;
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
                    BorderList frame = new BorderList();
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
    public BorderList() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("包含邊框的列表項");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
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
        
        ListCellRenderer renderer = new BorderListCellRenderer();
        list.setCellRenderer(renderer);
    }
}
