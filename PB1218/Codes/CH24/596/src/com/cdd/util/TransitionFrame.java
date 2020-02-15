package com.cdd.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;

public class TransitionFrame extends JFrame {
    
    private JPanel contentPane;
    private JLabel shiftLabel;
    private JLabel monthLabel;
    private JTextField moneyTextField;
    private JButton closeButton;
    private JComboBox idComboBox ;
    private JComboBox comeComboBox;
    private BatchAffair batchAffair = new BatchAffair();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TransitionFrame frame = new TransitionFrame();
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
    public TransitionFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 375, 248);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("轉賬窗體");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 359, 210);
        contentPane.add(panel);
        panel.setLayout(null);
        List list = batchAffair.selectIds();
        String ids[] = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            ids[i] = list.get(i).toString();
        }
        JLabel idLabel = new JLabel("轉帳賬戶：");
        idLabel.setBounds(61, 24, 65, 15);
        panel.add(idLabel);
        
        shiftLabel = new JLabel("轉入賬戶：");
        shiftLabel.setBounds(61, 64, 65, 15);
        panel.add(shiftLabel);
        
        monthLabel = new JLabel("轉賬金額：");
        monthLabel.setBounds(61, 107, 65, 15);
        panel.add(monthLabel);
        
        moneyTextField = new JTextField();
        moneyTextField.setBounds(136, 104, 162, 21);
        panel.add(moneyTextField);
        moneyTextField.setColumns(10);
        
        JButton transitionButton = new JButton("轉賬");
        transitionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_transitionButton_actionPerformed(arg0);
            }
        });
        transitionButton.setBounds(87, 148, 65, 23);
        panel.add(transitionButton);
        
        closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(202, 148, 65, 23);
        panel.add(closeButton);
        
        idComboBox = new JComboBox(ids);
        idComboBox.setBounds(136, 21, 162, 21);
        panel.add(idComboBox);
        
        comeComboBox = new JComboBox(ids);
        comeComboBox.setBounds(136, 61, 162, 21);
        panel.add(comeComboBox);
    }
    
    // 轉賬按鈕的單擊事件
    protected void do_transitionButton_actionPerformed(ActionEvent arg0) {
        String comeNumber = comeComboBox.getSelectedItem().toString();
        String goNumber = idComboBox.getSelectedItem().toString();
        float month = Float.parseFloat(moneyTextField.getText());
        try {
            batchAffair.Batch(comeNumber, goNumber, month);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "轉賬成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(getContentPane(), 
                    "轉賬失敗！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    // 關閉按鈕的單擊事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
