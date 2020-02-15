package com.lzw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ControlFormStatus extends JFrame {
    
    private JPanel contentPane;
    private Point pressedPoint;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControlFormStatus frame = new ControlFormStatus();
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
    public ControlFormStatus() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        BackgroundPanel topPanel = new BackgroundPanel();
        topPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                do_topPanel_mouseDragged(e);
            }
        });
        topPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                do_topPanel_mousePressed(e);
            }
        });
        Image centerImage = new ImageIcon(getClass()
                .getResource("frameTop.png")).getImage();
        Dimension dimension = new Dimension(centerImage.getWidth(this),
                centerImage.getHeight(this));
        topPanel.setPreferredSize(dimension);
        topPanel.setImage(centerImage);
        
        contentPane.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(60, 22));
        panel.setOpaque(false);
        topPanel.add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
        
        JButton button = new JButton("");
        button.setRolloverIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/minBH.jpg")));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_itemStateChanged(e);
            }
        });
        button.setFocusPainted(false);// 取消焦點繪製
        button.setBorderPainted(false);// 取消邊框繪製
        button.setContentAreaFilled(false);// 取消內容繪製
        button.setIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/minB.jpg")));
        panel.add(button);
        
        JToggleButton button_1 = new JToggleButton("");
        button_1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                do_button_1_itemStateChanged(e);
            }
        });
        button_1.setRolloverIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/maxBH.jpg")));
        button_1.setSelectedIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/maxBH.jpg")));
        button_1.setIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/maxB.jpg")));
        button_1.setContentAreaFilled(false);
        button_1.setBorderPainted(false);
        button_1.setFocusPainted(false);
        panel.add(button_1);
        
        JButton button_2 = new JButton("");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_2_actionPerformed(e);
            }
        });
        button_2.setRolloverIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/closeBH.jpg")));
        button_2.setFocusPainted(false);
        button_2.setContentAreaFilled(false);
        button_2.setBorderPainted(false);
        button_2.setIcon(new ImageIcon(ControlFormStatus.class
                .getResource("/com/lzw/closeB.jpg")));
        panel.add(button_2);
        
        BackgroundPanel backgroundPanel_1 = new BackgroundPanel();
        Image topImage = new ImageIcon(getClass()
                .getResource("frameCenter.png")).getImage();
        backgroundPanel_1.setImage(topImage);
        contentPane.add(backgroundPanel_1, BorderLayout.CENTER);
    }
    
    protected void do_button_itemStateChanged(ActionEvent e) {
        setExtendedState(JFrame.ICONIFIED);// 窗體最小化
    }
    
    protected void do_button_2_actionPerformed(ActionEvent e) {
        dispose();// 銷毀窗體
    }
    
    protected void do_button_1_itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);// 最大化窗體
        } else {
            setExtendedState(JFrame.NORMAL);// 恢復普通窗體狀態
        }
    }
    
    protected void do_topPanel_mousePressed(MouseEvent e) {
        pressedPoint = e.getPoint();// 記錄鼠標座標
    }
    
    protected void do_topPanel_mouseDragged(MouseEvent e) {
        Point point = e.getPoint();// 獲得目前座標
        Point locationPoint = getLocation();// 獲得窗體座標
        int x = locationPoint.x + point.x - pressedPoint.x;// 計算移動後的新座標
        int y = locationPoint.y + point.y - pressedPoint.y;
        setLocation(x, y);// 改變窗體位置
    }
}
