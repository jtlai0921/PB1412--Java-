package com.mingrisoft.time;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class WorldTimeViewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5988076597643890566L;
    private JPanel contentPane;
    private JComboBox TZComboBox;
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
                    WorldTimeViewer frame = new WorldTimeViewer();
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
    public WorldTimeViewer() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("世界時間查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel TZPanel = new JPanel();
        contentPane.add(TZPanel);
        TZPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel TZLabel = new JLabel("選擇目標時區：");
        TZLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        TZPanel.add(TZLabel);
        
        TZComboBox = new JComboBox();
        TZComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_foramtterComboBox_actionPerformed(e);
            }
        });
        TZComboBox.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        TZPanel.add(TZComboBox);
        
        JPanel resultPanel = new JPanel();
        contentPane.add(resultPanel);
        resultPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel tipLabel = new JLabel("目標時區日期：");
        tipLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        resultPanel.add(tipLabel);
        
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        resultPanel.add(resultLabel);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] timezones = TimeZone.getAvailableIDs();// 獲得所有可用的時區ID
        for (String patten : timezones) {
            TZComboBox.addItem(patten);// 將所有ID增加到組合框中
        }
    }
    
    protected void do_foramtterComboBox_actionPerformed(ActionEvent e) {
        String currentTimezone = (String) TZComboBox.getSelectedItem();// 獲得選擇的ID
        Calendar calendar = Calendar.getInstance();// 獲得日曆對像
        calendar.setTimeZone(TimeZone.getTimeZone(currentTimezone));// 設定日曆所在時區
        StringBuilder result = new StringBuilder();// 利用StringBuilder來儲存結果
        result.append(calendar.getTimeZone().getDisplayName() + " ");// 獲得目前時區描述名稱
        result.append(calendar.get(Calendar.HOUR_OF_DAY) + ":");// 獲得目前時鐘的小時
        result.append(calendar.get(Calendar.MINUTE));// 獲得目前時區的分鐘
        resultLabel.setText(result.toString());// 更新結果
    }
    
}
