package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JListSelectionModelTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1890801556962652101L;
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
                    JListSelectionModelTest frame = new JListSelectionModelTest();
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
    public JListSelectionModelTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("列表項的全選與不選");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton selectAllButton = new JButton("全選");
        selectAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_selectAllButton_actionPerformed(e);
            }
        });
        selectAllButton.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        panel.add(selectAllButton);
        
        JButton selectNoneButton = new JButton("不選");
        selectNoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_selectNoneButton_actionPerformed(e);
            }
        });
        selectNoneButton.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        panel.add(selectNoneButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setVisibleRowCount(3);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(list);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] listData = new String[12];
        for (int i = 0; i < listData.length; i++) {
            listData[i] = "明日科技" + (i + 1);
        }
        list.setListData(listData);
    }
    
    protected void do_selectAllButton_actionPerformed(ActionEvent e) {
        int start = 0;
        int end = list.getModel().getSize() - 1;
        if (end >= 0) {
            list.setSelectionInterval(start, end);
        }
    }
    
    protected void do_selectNoneButton_actionPerformed(ActionEvent e) {
        list.clearSelection();
    }
}
