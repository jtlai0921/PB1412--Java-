package com.order.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class TaxisFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private JComboBox stockComboBox = null;
    private JComboBox priceComboBox = null;
    private   LocalTableModel model = new LocalTableModel();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TaxisFrame frame = new TaxisFrame();
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
    public TaxisFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("逼琩高");
        JPanel panel = new JPanel();
        panel.setBounds(432, 0, 433, 262);
        contentPane.add(panel);
        String[] order = {"ど",""};
        JLabel priceLabel = new JLabel("扳基");
        priceLabel.setBounds(56, 33, 54, 15);
        contentPane.add(priceLabel);
        
        priceComboBox = new JComboBox(order);
        priceComboBox.setBounds(98, 30, 54, 21);
        contentPane.add(priceComboBox);
        
        JLabel stockLabel = new JLabel("ㄧ计畐");
        stockLabel.setBounds(173, 33, 48, 15);
        contentPane.add(stockLabel);
        
        stockComboBox = new JComboBox(order);
        stockComboBox.setBounds(220, 30, 60, 21);
        contentPane.add(stockComboBox);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 61, 365, 191);
        contentPane.add(scrollPane);
      
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        JButton queryButton = new JButton("琩高");
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_queryButton_actionPerformed(arg0);
            }
        });
        queryButton.setBounds(290, 29, 93, 23);
        contentPane.add(queryButton);
    }
    
    //琩高秙虫阑矪瞶ㄆン
    protected void do_queryButton_actionPerformed(ActionEvent arg0) {
        model.setRowCount(0);
        String stockCombo = (String) stockComboBox.getSelectedItem();
        String priceCombo = (String) priceComboBox.getSelectedItem();
        String stock = "";
        String price = "";
        if(stockCombo.equals("")){
            stock = "desc";
        }
        else if(stockCombo.equals("ど")){
            stock = "asc";
        }
        if(priceCombo.equals("")){
            price ="desc";
        }
        else if(priceCombo.equals("ど")){
            price = "asc";
        }
        JDBCUtil util = new JDBCUtil();
        List list = util.getBooKDesc(price, stock);
        for(int i = 0;i<list.size();i++){
            Book book = (Book)list.get(i);
            model.addRow(new Object[] { book.getId(), book.getBookName(),
                    book.getAuthor(), book.getPrice(), book.getStock() });
        }
    }
}
