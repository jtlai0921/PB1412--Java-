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
        setTitle("增加部門資訊");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 351, 180);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel dNameLabel = new JLabel("部門名稱：");
        dNameLabel.setBounds(52, 30, 74, 15);
        panel.add(dNameLabel);
        
        deptNameTextField = new JTextField();
        deptNameTextField.setBounds(136, 27, 148, 21);
        panel.add(deptNameTextField);
        deptNameTextField.setColumns(10);
        
        JLabel pesonLabel = new JLabel("部門負責人：");
        pesonLabel.setBounds(37, 73, 89, 15);
        panel.add(pesonLabel);
        
        personTextField = new JTextField();
        personTextField.setBounds(136, 70, 148, 21);
        panel.add(personTextField);
        personTextField.setColumns(10);
        
        JButton insertButton = new JButton("增加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(71, 122, 74, 23);
        panel.add(insertButton);
        
        JButton watchButton = new JButton("檢視");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_watchButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(176, 122, 74, 23);
        panel.add(watchButton);
    }
    //增加按鈕的單擊事件

protected void do_insertButton_actionPerformed(ActionEvent arg0) {
    String name = deptNameTextField.getText();      //獲得使用者增加的部門名稱
    String person = personTextField.getText();      //獲得使用者增加的部門負責人
    Random ran = new Random(System.currentTimeMillis());        //根據目前時間的毫秒數建立隨機數流
    StringBuilder idb=new StringBuilder();          //建立字串緩衝對像
    idb.append(String.format("%019d",Math.abs(ran.nextLong()))+String.format("%03d",(int)(Math.random()*100%9)+1));
    idb=idb.reverse();              //對字串緩衝對像取反
    String id=idb+ "" + String.format("%010d",Math.abs(ran.nextInt()));     
    Dept dept = new Dept();         //建立於資料表對應的JavaBean對像
    dept.setDid(id);                //設定對像屬性
    dept.setdName(name);
    dept.setPriName(person);
    DeptUtil deptUtil = new DeptUtil();     //建立工具類別對像
    deptUtil.insertDept(dept);      //呼叫增加方法
    JOptionPane.showMessageDialog(getContentPane(), 
            "資料增加成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
}
    
    //檢視按鈕的單擊事件
    protected void do_watchButton_actionPerformed(ActionEvent arg0) {
        SelectDeptFrame frame = new SelectDeptFrame();
        frame.setVisible(true);
    }
}
