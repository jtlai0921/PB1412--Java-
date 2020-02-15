package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomBackgroundImage extends JFrame {
    
    private JPanel contentPane;
    private BackgroundPanel panel;
    private Image[] images;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RandomBackgroundImage frame = new RandomBackgroundImage();
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
    public RandomBackgroundImage() {
        initPhotoArray();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("隨機更換窗體背景");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 412);// 設定窗體位置
        contentPane = new JPanel();// 建立內容面板
        setContentPane(contentPane);// 設定窗體內容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        panel = new BackgroundPanel();
        contentPane.add(panel);// 把背景面板增加到窗體內容面板
    }
    
    private void initPhotoArray() {
        images = new Image[6];// 初始化背景圖篇陣列
        String photoPath = "";
        for (int i = 0; i < images.length; i++) {// 檢查陣列並初始化所有元素
            photoPath = "/com/img/photo" + (i + 1) + ".jpg";// 產生檔案名
            images[i] = getToolkit()
                    .getImage(getClass().getResource(photoPath));// 初始化陣列元素
        }
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        Random random = new Random();// 建立隨機數對像
        int num = random.nextInt(6);// 產生隨機數
        panel.setImage(images[num]);// 設定面板背景圖片
        repaint();// 重繪窗體界面
    }
}
