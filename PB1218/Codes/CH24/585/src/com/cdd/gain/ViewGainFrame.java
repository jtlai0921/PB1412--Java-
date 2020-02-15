package com.cdd.gain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewGainFrame extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewGainFrame frame = new ViewGainFrame();
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
    public ViewGainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("獲得資料函數庫中所有儲存過程");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel massageLabel = new JLabel("獲得db_database24資料函數庫下的所有儲存過程名：");
        massageLabel.setFont(new Font("華文琥珀", Font.PLAIN, 13));
        massageLabel.setBounds(65, 20, 297, 27);
        panel.add(massageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(54, 71, 316, 159);
        panel.add(scrollPane);
        
        JTextArea textArea = new JTextArea();        
        scrollPane.setViewportView(textArea);
        GainProcedure procedure = new GainProcedure(); // 建立工具類別對像
        List list = procedure.executeGain(); // 呼叫獲得所有儲存過程方法
        for (int i = 0; i < list.size(); i++) { // 循環檢查查詢結果
            String name = list.get(i).toString(); // 獲得結果集中資料
            textArea.append(name + "\n"); // 向文字域中增加資訊
        }
    }
}
