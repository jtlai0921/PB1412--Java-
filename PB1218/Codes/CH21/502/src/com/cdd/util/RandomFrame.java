package com.cdd.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RandomFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RandomFrame frame = new RandomFrame();
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
    public RandomFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("隨機獲得3名留學生資訊：");
        messageLabel.setBounds(72, 29, 150, 15);
        panel.add(messageLabel);
        
        JButton findButton = new JButton("查詢");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
        findButton.setBounds(242, 25, 77, 23);
        panel.add(findButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(51, 83, 334,138);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    //查詢按鈕的單擊處理事件
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        AbroadUtil util = new AbroadUtil();
        model.setRowCount(0);  //將表格清空
        List list = util.getAbroad();
        for(int i = 0;i<list.size();i++){
            Abroad abroad = (Abroad)list.get(i);
            model.addRow(new Object[]{abroad.getId(),abroad.getFristName(),abroad.getLastName(),abroad.getNationality(),abroad.getSpeciality()});
        }
    }
}
