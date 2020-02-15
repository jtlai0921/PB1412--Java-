package com.cdd.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MerchaniseFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    LocalTableModel model = new LocalTableModel();
    MerchandiseUtil util = new MerchandiseUtil();
    private    JComboBox nameComboBox;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MerchaniseFrame frame = new MerchaniseFrame();
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
    public MerchaniseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 179);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("查詢資料表中各商品的上市月份");
        JLabel messageLabel = new JLabel("上市商品：");
        messageLabel.setBounds(46, 30, 72, 15);
        contentPane.add(messageLabel);
        List list = util.getMerchandise();
        String[] merchandisse = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            Merchandise medise = (Merchandise)list.get(i);
            merchandisse[i] = medise.getWareName();
        }
        nameComboBox = new JComboBox(merchandisse);
        nameComboBox.setBounds(128, 27, 121, 21);
        contentPane.add(nameComboBox);
        
        JButton okButton = new JButton("查詢");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_okButton_actionPerformed(arg0);
            }
        });
        okButton.setBounds(278, 26, 93, 23);
        contentPane.add(okButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 62, 366, 73);
        contentPane.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    protected void do_okButton_actionPerformed(ActionEvent arg0) {
        String meName = nameComboBox.getSelectedItem().toString();
        model.setRowCount(0);  //將表格清空
        String count = util.getgetMerchandiseDate(meName);
        model.addRow(new Object[] { meName, count,});
    }
}
