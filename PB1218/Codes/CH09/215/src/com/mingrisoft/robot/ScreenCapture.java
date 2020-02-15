package com.mingrisoft.robot;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class ScreenCapture extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5093584478732778943L;
    private JPanel contentPane;
    private JLabel imageLabel;
    
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
                    ScreenCapture frame = new ScreenCapture();
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
    public ScreenCapture() {
        setTitle("截圖軟件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("開始截圖");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        buttonPanel.add(button);
        
        JPanel imagePanel = new JPanel();
        contentPane.add(imagePanel, BorderLayout.CENTER);
        imagePanel.setLayout(new BorderLayout(0, 0));
        
        imageLabel = new JLabel("");
        imageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        try {
            Robot robot = new Robot();// 建立Robot對像
            Toolkit toolkit = Toolkit.getDefaultToolkit();// 獲得Toolkit對像
            Rectangle area = new Rectangle(toolkit.getScreenSize());// 設定截取區域為全螢幕
            // 將BufferedImage轉換成Image
            BufferedImage bufferedImage = robot.createScreenCapture(area);
            ImageProducer producer = bufferedImage.getSource();
            Image image = toolkit.createImage(producer);
            imageLabel.setIcon(new ImageIcon(image));// 顯示圖片
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }
    
}
