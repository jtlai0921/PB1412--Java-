package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.UIManager;
import java.awt.Font;

public class EventQueueFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7974095246371185446L;
    private JPanel contentPane;
    private JLabel label;
    
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
                    EventQueueFrame frame = new EventQueueFrame();
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
    public EventQueueFrame() {
        setTitle("使用事件分配執行緒更新Swing控制項");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel labelPanel = new JPanel();
        contentPane.add(labelPanel);
        labelPanel.setLayout(new BorderLayout(0, 0));
        
        label = new JLabel("");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(label, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton button = new JButton("開始生成");
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        new Thread(new RandomRunnable()).start();
    }
    
    private class RandomRunnable implements Runnable {
        @Override
        public void run() {// 實現Runnable接口的run()方法
            EventQueue.invokeLater(new Runnable() {// 利用EventQueue類別來更新Swing控制項
                @Override
                public void run() {
                    label.setText("新產生的隨機數是：" + (new Random().nextInt()));// 更新標籤
                }
            });
        }
    }
}
