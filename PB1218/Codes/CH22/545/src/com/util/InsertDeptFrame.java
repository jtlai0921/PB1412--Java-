package com.util;

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
import java.util.Random;

public class InsertDeptFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField deptNameTextField;
    private JTextField personTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertDeptFrame frame = new InsertDeptFrame();
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
    public InsertDeptFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 362, 217);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("�W�[������T");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 351, 180);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel dNameLabel = new JLabel("�����W�١G");
        dNameLabel.setBounds(52, 30, 74, 15);
        panel.add(dNameLabel);
        
        deptNameTextField = new JTextField();
        deptNameTextField.setBounds(136, 27, 148, 21);
        panel.add(deptNameTextField);
        deptNameTextField.setColumns(10);
        
        JLabel pesonLabel = new JLabel("�����t�d�H�G");
        pesonLabel.setBounds(37, 73, 89, 15);
        panel.add(pesonLabel);
        
        personTextField = new JTextField();
        personTextField.setBounds(136, 70, 148, 21);
        panel.add(personTextField);
        personTextField.setColumns(10);
        
        JButton insertButton = new JButton("�W�[");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(71, 122, 74, 23);
        panel.add(insertButton);
        
        JButton watchButton = new JButton("�˵�");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_watchButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(176, 122, 74, 23);
        panel.add(watchButton);
    }
    //�W�[���s�������ƥ�

protected void do_insertButton_actionPerformed(ActionEvent arg0) {
    String name = deptNameTextField.getText();      //��o�ϥΪ̼W�[�������W��
    String person = personTextField.getText();      //��o�ϥΪ̼W�[�������t�d�H
    Random ran = new Random(System.currentTimeMillis());        //�ھڥثe�ɶ����@��ƫإ��H���Ƭy
    StringBuilder idb=new StringBuilder();          //�إߦr��w�Ĺﹳ
    idb.append(String.format("%019d",Math.abs(ran.nextLong()))+String.format("%03d",(int)(Math.random()*100%9)+1));
    idb=idb.reverse();              //��r��w�Ĺﹳ����
    String id=idb+ "" + String.format("%010d",Math.abs(ran.nextInt()));     
    Dept dept = new Dept();         //�إߩ��ƪ������JavaBean�ﹳ
    dept.setDid(id);                //�]�w�ﹳ�ݩ�
    dept.setdName(name);
    dept.setPriName(person);
    DeptUtil deptUtil = new DeptUtil();     //�إߤu�����O�ﹳ
    deptUtil.insertDept(dept);      //�I�s�W�[��k
    JOptionPane.showMessageDialog(getContentPane(), 
            "��ƼW�[���\�I", "��T���ܮ�", JOptionPane.WARNING_MESSAGE);
}
    
    //�˵����s�������ƥ�
    protected void do_watchButton_actionPerformed(ActionEvent arg0) {
        SelectDeptFrame frame = new SelectDeptFrame();
        frame.setVisible(true);
    }
}
