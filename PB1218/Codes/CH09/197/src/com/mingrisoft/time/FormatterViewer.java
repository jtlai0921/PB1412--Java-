package com.mingrisoft.time;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.UIManager;

public class FormatterViewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5988076597643890566L;
    private JPanel contentPane;
    private JComboBox formatterComboBox;
    private JLabel resultLabel;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormatterViewer frame = new FormatterViewer();
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
    public FormatterViewer() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("格式查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel formatterPanel = new JPanel();
        contentPane.add(formatterPanel);
        formatterPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel formatterLabel = new JLabel("選擇或輸入格式：");
        formatterLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        formatterPanel.add(formatterLabel);
        
        formatterComboBox = new JComboBox();
        formatterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_foramtterComboBox_actionPerformed(e);
            }
        });
        formatterComboBox.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        formatterComboBox.setEditable(true);
        formatterPanel.add(formatterComboBox);
        
        JPanel resultPanel = new JPanel();
        contentPane.add(resultPanel);
        resultPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel tipLabel = new JLabel("格式化後的日期：");
        tipLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        resultPanel.add(tipLabel);
        
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        resultPanel.add(resultLabel);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] patternExamples = { "yyyy-MM-dd", "MM-dd-yyyy", "a h:m:s", "z H:m:s" };
        for (String patten : patternExamples) {// 檢查整個陣列
            formatterComboBox.addItem(patten); // 給組合框增加元素
        }
    }
    
    protected void do_foramtterComboBox_actionPerformed(ActionEvent e) {
        String currentPattern = (String) formatterComboBox.getSelectedItem(); // 獲得目前文字
        SimpleDateFormat formatter = new SimpleDateFormat(currentPattern); // 設定格式
        String result = formatter.format(new Date());// 格式化目前時間
        resultLabel.setText(result);// 顯示格式化結果
    }
    
}
