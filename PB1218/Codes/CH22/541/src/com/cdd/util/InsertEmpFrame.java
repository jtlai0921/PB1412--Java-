package com.cdd.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertEmpFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField deptTextField;
    private JTextField phoneTextField;
    private JComboBox sexComboBox;
    private JTextArea remakeTextArea = new JTextArea();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertEmpFrame frame = new InsertEmpFrame();
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
    public InsertEmpFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 406, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("將員工資訊增加到資料函數庫中");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 390, 322);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(63, 24, 45, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(118, 21, 194, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel sexLabel = new JLabel("性別：");
        sexLabel.setBounds(63, 55, 45, 15);
        panel.add(sexLabel);
        
        ageTextField = new JTextField();
        ageTextField.setBounds(118, 83, 194, 21);
        panel.add(ageTextField);
        ageTextField.setColumns(10);
        
        String[] sex = new String[] { "男", "女" };
        sexComboBox = new JComboBox(sex);
        sexComboBox.setBounds(118, 52, 55, 21);
        panel.add(sexComboBox);
        
        JLabel ageLabel = new JLabel("年齡：");
        ageLabel.setBounds(63, 86, 45, 15);
        panel.add(ageLabel);
        
        JLabel deptLabel = new JLabel("部門：");
        deptLabel.setBounds(63, 118, 54, 15);
        panel.add(deptLabel);
        
        deptTextField = new JTextField();
        deptTextField.setBounds(118, 115, 194, 21);
        panel.add(deptTextField);
        deptTextField.setColumns(10);
        
        JLabel phoneLabel = new JLabel("電話：");
        phoneLabel.setBounds(63, 153, 54, 15);
        panel.add(phoneLabel);
        
        phoneTextField = new JTextField();
        phoneTextField.setBounds(118, 150, 194, 21);
        panel.add(phoneTextField);
        phoneTextField.setColumns(10);
        
        JLabel label = new JLabel("備註：");
        label.setBounds(63, 187, 54, 15);
        panel.add(label);
        
        remakeTextArea.setBounds(118, 183, 194, 69);
        panel.add(remakeTextArea);
        
        JButton insertButton = new JButton("增加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(107, 275, 66, 23);
        panel.add(insertButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(205, 275, 66, 23);
        panel.add(closeButton);
        
        JLabel messageLabel = new JLabel("*");
        messageLabel.setBounds(322, 24, 54, 15);
        panel.add(messageLabel);
        
        JLabel label_1 = new JLabel("*");
        label_1.setBounds(322, 118, 54, 15);
        panel.add(label_1);
        
        JLabel label_2 = new JLabel("*");
        label_2.setBounds(322, 153, 54, 15);
        panel.add(label_2);
    }
    
    // 關閉按鈕的單擊事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        int n = JOptionPane.showConfirmDialog(getContentPane(), "確認正確嗎？",
                "確認交談視窗", JOptionPane.YES_NO_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION) { // 如果使用者確認資訊
            System.exit(0);
        }
    }
    
    // 增加按鈕的單擊事件
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        JdbcUtil util = new JdbcUtil();
        Emp emp = new Emp();
        
        emp.setName(nameTextField.getText());
        emp.setSex(sexComboBox.getSelectedItem().toString());
        emp.setAge(Integer.parseInt(ageTextField.getText()));
        emp.setDept(deptTextField.getText());
        emp.setPhone(phoneTextField.getText());
        emp.setRemark(remakeTextArea.getText());
        if (!(nameTextField.getText().equals(""))
                && (!deptTextField.getText().equals(""))
                && (!phoneTextField.getText().equals(""))) {
            util.insertEmp(emp);
            
            JOptionPane.showMessageDialog(getContentPane(), "資料增加成功！", "資訊提示框",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "請將資訊增加完整！",
                    "資訊提示框", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
