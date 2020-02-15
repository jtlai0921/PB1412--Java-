package com.cdd.condition;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConditionFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField labTextField1;
    private JTextField labTextField2;
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
        setBounds(100, 100, 571, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 555, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("薪水在");
        messageLabel.setBounds(41, 28, 44, 15);
        panel.add(messageLabel);
        
        labTextField1 = new JTextField();
        labTextField1.addKeyListener(new KeyAdapter() {         
            public void keyTyped(KeyEvent event) {  //某鍵按下時呼叫的方法
                char ch = event.getKeyChar();       //獲得使用者輸入的字符             
                if((ch<'0'||ch>'9') ){  //如果使用者輸入的資訊不為數字或小數
                    event.consume();                //不允許使用者輸入
                }
                
            }
        });

        labTextField1.setBounds(95, 25, 81, 21);
        panel.add(labTextField1);
        labTextField1.setColumns(10);
        
        JLabel andLabel = new JLabel("和");
        andLabel.setBounds(186, 28, 26, 15);
        panel.add(andLabel);
        
        labTextField2 = new JTextField();
        labTextField2.addKeyListener(new KeyAdapter() {         
            public void keyTyped(KeyEvent event) {  //某鍵按下時呼叫的方法
                char ch = event.getKeyChar();       //獲得使用者輸入的字符             
                if((ch<'0'||ch>'9') ){  //如果使用者輸入的資訊不為數字或小數
                    event.consume();                //不允許使用者輸入
                }
                
            }
        });
        labTextField2.setBounds(206, 25, 98, 21);
        panel.add(labTextField2);
        labTextField2.setColumns(10);
        
        JLabel messageLabel2 = new JLabel("之間的員工資訊");
        messageLabel2.setBounds(314, 28, 108, 15);
        panel.add(messageLabel2);
        
        JButton findButton = new JButton("查詢");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
        findButton.setBounds(437, 24, 93, 23);
        panel.add(findButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(41, 67, 489, 185);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        int lab1 = Integer.parseInt(labTextField1.getText());
        int lab2 = Integer.parseInt(labTextField2.getText());
        ConditionUseIn conditionIn = new ConditionUseIn();
        List list = conditionIn.getSubTable(lab1, lab2);
        for(int i = 0;i<list.size();i++){
            Emp emp = (Emp)list.get(i);
            model.addRow(new Object[] { emp.getId(), emp.getName(),
                   emp.getDept(), emp.getHeadship(),emp.getJoinDate(),emp.getLaborage()});
        }
    }
}
