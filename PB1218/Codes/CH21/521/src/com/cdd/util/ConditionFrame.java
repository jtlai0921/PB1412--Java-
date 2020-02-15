package com.cdd.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;

public class ConditionFrame extends JFrame {
    
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
                    ConditionFrame frame = new ConditionFrame();
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
    public ConditionFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("去除查詢結果中字串的空格");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("在查詢結果中去掉字串空格：");
        messageLabel.setFont(new Font("方正姚體", Font.PLAIN, 14));
        messageLabel.setBounds(123, 32, 203, 15);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(37, 82, 359, 156);
        panel.add(scrollPane);
        
        table = new JTable(model);
        ConditionUtil util = new ConditionUtil();
        List list = util.getBookSell();
        for(int i = 0;i<list.size();i++){
            BookSell sell = (BookSell)list.get(i);
            model.addRow(new Object[]{sell.getId(),sell.getBookName(),sell.getStock(),sell.getPrice(),sell.getBookConcern()});
        }
        scrollPane.setViewportView(table);
    }
}
