package com.mingrisoft.jpopupmenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class PopupMenuTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5570749657628665431L;
    private JPanel contentPane;
    
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
                    PopupMenuTest frame = new PopupMenuTest();
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
    public PopupMenuTest() {
        setTitle("彈出式菜單的應用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JPopupMenu popupMenu = new JPopupMenu();
        contentPane.setComponentPopupMenu(popupMenu);
        
        JMenuItem cut = new JMenuItem("剪切");
        cut.setIcon(new ImageIcon(PopupMenuTest.class.getResource("/images/cut.png")));
        cut.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        cut.addActionListener(listener);
        popupMenu.add(cut);
        
        JMenuItem find = new JMenuItem("查詢");
        find.setIcon(new ImageIcon(PopupMenuTest.class.getResource("/images/find.png")));
        find.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        find.addActionListener(listener);
        popupMenu.add(find);
        
        JMenuItem open = new JMenuItem("打開");
        open.setIcon(new ImageIcon(PopupMenuTest.class.getResource("/images/open.png")));
        open.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        open.addActionListener(listener);
        popupMenu.add(open);
        
        JMenuItem save = new JMenuItem("保存");
        save.setIcon(new ImageIcon(PopupMenuTest.class.getResource("/images/save.png")));
        save.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        save.addActionListener(listener);
        popupMenu.add(save);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("單擊鼠標右鍵彈出菜單");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 20));
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(e.getActionCommand());// 設定標籤的文字為使用者選擇的操作
        }
    };
    private JLabel label;
    
}
