package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class MouseZoomButton extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MouseZoomButton frame = new MouseZoomButton();
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
    public MouseZoomButton() {
        setTitle("鼠標經過時按鈕放大效果");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 449, 241);// 設定窗體大小和位置
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // 建立問題標籤控制項
        JLabel label = new JLabel("<html><body align=center>你是否喜歡使用Java"
                + "語言來<br>撰寫應用程式？</body></html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);// 標籤文字居中
        label.setFont(new Font("SansSerif", Font.PLAIN, 32));
        label.setBounds(6, 6, 421, 106);
        contentPane.add(label);
        JButton button = new JButton("喜歡");// 建立按鈕控制項
        MouseAdapter mouseAdapter = new MouseAdapter() {// 建立鼠標事件監聽器
            private Rectangle sourceRec;// 建立矩形對像
            
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();// 獲得事件源按鈕
                sourceRec = button.getBounds();// 儲存按鈕大小
                button.setBounds(sourceRec.x - 10, sourceRec.y - 10,
                        sourceRec.width + 20, sourceRec.height + 20);// 把按鈕放大
                super.mouseEntered(e);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();// 獲得事件源按鈕
                if (sourceRec != null) {// 如果有備份矩形則用它恢復按鈕大小
                    button.setBounds(sourceRec);// 設定按鈕大小
                }
                super.mouseExited(e);
            }
            
        };
        button.addMouseListener(mouseAdapter);// 為按鈕增加事件監聽器
        button.setBounds(59, 145, 90, 30);// 設定按鈕大小
        contentPane.add(button);
        JButton button_1 = new JButton("不喜歡");// 建立按鈕控制項
        button_1.setBounds(259, 145, 90, 30);// 色繪製按鈕初始大小
        button_1.addMouseListener(mouseAdapter);// 為按鈕增加事件監聽器
        contentPane.add(button_1);
    }
}
