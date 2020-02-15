package com.cdd.insert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertUserFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JTextField ageTextField;
    private JTextField jobTextField;
    private JComboBox sexComboBox;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertUserFrame frame = new InsertUserFrame();
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
    public InsertUserFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 417, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 406, 292);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("�ϥΪ̵��U");
        messageLabel.setFont(new Font("�L�n����", Font.PLAIN, 13));
        messageLabel.setBounds(152, 24, 67, 15);
        panel.add(messageLabel);
        
        JLabel userNameLabel = new JLabel("�ϥΪ̦W�١G");
        userNameLabel.setBounds(90, 61, 54, 15);
        panel.add(userNameLabel);
        
        userNameTextField = new JTextField();
        userNameTextField.setBounds(152, 58, 160, 21);
        panel.add(userNameTextField);
        userNameTextField.setColumns(10);
        
        JLabel passWordLabel = new JLabel("�K  �X�G");
        passWordLabel.setBounds(90, 92, 54, 15);
        panel.add(passWordLabel);
        
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(153, 89, 159, 21);
        panel.add(passwordTextField);
        passwordTextField.setColumns(10);
        
        JLabel ageLabel = new JLabel("�~  �֡G");
        ageLabel.setBounds(90, 126, 54, 15);
        panel.add(ageLabel);
        
        ageTextField = new JTextField();
        ageTextField.setBounds(152, 123, 159, 21);
        panel.add(ageTextField);
        ageTextField.setColumns(10);
        
        JLabel sexLabel = new JLabel("��  �O�G");
        sexLabel.setBounds(90, 160, 54, 15);
        panel.add(sexLabel);
        String [] sex = {"�k","�k"};
        sexComboBox  = new JComboBox(sex);
        sexComboBox.setBounds(152, 157, 93, 21);
        panel.add(sexComboBox);
        
        JLabel jobLabel = new JLabel("�u  �@�G");
        jobLabel.setBounds(90, 196, 54, 15);
        panel.add(jobLabel);
        
        jobTextField = new JTextField();
        jobTextField.setBounds(152, 193, 160, 21);
        panel.add(jobTextField);
        jobTextField.setColumns(10);
        
        JButton insertButton = new JButton("�W�[");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(120, 242, 67, 23);
        panel.add(insertButton);
        
        JButton closeButton = new JButton("����");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(223, 242, 67, 23);
        panel.add(closeButton);
    }
    //�W�[���s�������ƥ�
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        String userName = userNameTextField.getText();
        String passWord = passwordTextField.getText();
        if(userName.equals("") || passWord.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), 
                    "�ϥΪ̦W�٩M�K�X�����\���šI", "ĵ�i���ܮ�", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            String sex = sexComboBox.getSelectedItem().toString();
            int age = Integer.parseInt(ageTextField.getText());
            String job = jobTextField.getText();
            UserTrigger userTrigger = new UserTrigger();
            User user = new User();
            user.setUserName(userName);
            user.setSex(sex);
            user.setPassword(passWord);
            user.setAge(age);
            user.setJob(job);
            userTrigger.insertInfo(user);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "��ƼW�[���\�I", "��T���ܮ�", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    //�������s�������ƥ�
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
