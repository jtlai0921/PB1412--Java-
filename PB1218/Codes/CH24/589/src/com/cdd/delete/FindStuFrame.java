package com.cdd.delete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class FindStuFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableStuModel model = new LocalTableStuModel();
    private DeleteGrade deleteGrade = new DeleteGrade();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindStuFrame frame = new FindStuFrame();
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
    public FindStuFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 337);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 299);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("學生表資訊：");
        messageLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 15));
        messageLabel.setBounds(144, 44, 127, 25);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(41, 86, 356, 152);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
        List list = deleteGrade.executeStu();
        for(int i = 0;i<list.size();i++){
            Stu stu = (Stu)list.get(i);
            model.addRow(new Object[]{stu.getId(),stu.getName(),stu.getSex(),stu.getSpecialty()});
        }
        JButton watchButton = new JButton("檢視成績表");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_deleteButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(98, 255, 101, 23);
        panel.add(watchButton);
        
       
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_1_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(255, 255, 85, 23);
        panel.add(closeButton);
    }
    protected void do_deleteButton_actionPerformed(ActionEvent arg0) {
        GradeFrame gradeFrame = new GradeFrame();
        gradeFrame.setVisible(true);
    }
  
    protected void do_button_1_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
