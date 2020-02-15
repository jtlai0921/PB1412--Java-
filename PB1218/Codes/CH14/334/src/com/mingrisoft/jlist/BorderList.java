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
        setTitle("�]�t��ت��C��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setFont(new Font("�L�n����", Font.PLAIN, 16));
        scrollPane.setViewportView(list);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] listData = new String[7];
        listData[0] = "�mJava�q�J�����q�]��2���^�n";
        listData[1] = "�mPHP�q�J�����q�]��2���^�n";
        listData[2] = "�mVisual Basic�q�J�����q�]��2���^�n";
        listData[3] = "�mVisual C++�q�J�����q�]��2���^�n";
        listData[4] = "�mJava�s�{����n";
        listData[5] = "�m�ӻ�Java�n";
        listData[6] = "�m���T��Java�n";
        list.setListData(listData);
        
        ListCellRenderer renderer = new BorderListCellRenderer();
        list.setCellRenderer(renderer);
    }
}
