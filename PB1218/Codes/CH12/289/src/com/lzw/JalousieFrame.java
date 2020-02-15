package com.lzw;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JalousieFrame extends JFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JalousieFrame frame = new JalousieFrame();
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
    public JalousieFrame() {
        setTitle("窗體百葉窗登場特效");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 221);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("登錄模塊");
        label.setOpaque(true);
        label.setBackground(new Color(245, 222, 179));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 30));
        label.setBounds(6, 6, 422, 72);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("用戶名：");
        label_1.setBounds(31, 90, 55, 18);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("密　碼：");
        label_2.setBounds(31, 134, 55, 18);
        contentPane.add(label_2);
        
        textField = new JTextField();
        textField.setBounds(83, 84, 184, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(83, 128, 184, 30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton button = new JButton("登錄");
        button.setBounds(304, 84, 90, 30);
        contentPane.add(button);
        
        JButton button_1 = new JButton("關閉");
        button_1.setBounds(304, 128, 90, 30);
        contentPane.add(button_1);
        setLocationRelativeTo(null);
        JalousiePanel panel = new JalousiePanel();
    }
    
    class JalousiePanel extends JPanel {
        final int step = 30;// 百業條大體高度
        int hei = step;// 百葉條漸層高度
        int recNum = 0;// 百葉條的數量
        private Timer timer;
        
        public JalousiePanel() {
            setOpaque(false);// 面板透明
            final Component oldPanel = getGlassPane();// 儲存原有玻璃面板
            final boolean visible = oldPanel.isVisible();
            setGlassPane(JalousiePanel.this);// 把目前面板設定為窗體玻璃面板
            getGlassPane().setVisible(true);// 顯示玻璃面板
            // 初始化Timer控制項
            timer = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setGlassPane(JalousiePanel.this);// 設定目前面板為窗體玻璃面板
                    getGlassPane().setVisible(true);// 顯示玻璃面板
                    if (hei-- > 0) {// 遞減百葉條漸層高度
                        repaint();// 重繪界面
                    } else {// 如果百葉條高度漸層小於0
                        timer.stop();// 停止Timer控制項
                        setGlassPane(oldPanel);// 恢復原有玻璃面板
                        hei = step;// 初始化百葉條高度
                        getGlassPane().setVisible(visible);// 恢復玻璃面板顯示狀態
                    }
                }
            });
            // 增加控制項的事件監聽器
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    fillJalousie();// 控制項顯示時呼叫的方法
                }
                
                private void fillJalousie() {
                    Dimension size = getSize();// 獲得窗體控制項大小
                    recNum = (size.height - 1) / step + 1;// 計算百葉條數量
                    timer.start();// 啟動Timer控制項
                }
                
                @Override
                public void componentResized(ComponentEvent e) {
                    fillJalousie();// 控制項調整大小時呼叫的方法
                }
            });
        }
        
        @Override
        protected void paintComponent(Graphics g1) {
            Graphics2D g = (Graphics2D) g1;// 獲得2D繪圖對像
            g.setColor(Color.BLUE);// 設定繪圖前景色
            // 設定繪圖透明度
            g.setComposite(AlphaComposite.SrcOver.derive(0.5f));
            for (int i = 0; i < recNum; i++) {
                // 繪製所有百業條
                g.fillRect(0, i * step, getWidth(), hei);
            }
            super.paintComponent(g);
        }
    }
}
