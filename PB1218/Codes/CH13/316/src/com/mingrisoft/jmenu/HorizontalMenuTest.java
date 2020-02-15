package com.mingrisoft.jmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class HorizontalMenuTest extends JFrame {
    private static final long serialVersionUID = 1686879401938151474L;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HorizontalMenuTest frame = new HorizontalMenuTest();
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
public HorizontalMenuTest() {
        setTitle("縱向菜單欄");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    Container contentPane = getContentPane();
    contentPane.setBackground(Color.WHITE);
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.PAGE_AXIS));
    contentPane.add(menuBar, BorderLayout.WEST);
    
    JMenu fileMenu = new HorizontalMenu("檔案(F)");
    fileMenu.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
    fileMenu.add("新增(N)");
    fileMenu.add("開啟(O)...");
    fileMenu.add("儲存(S)");
    fileMenu.add("另存為(A)...");
    fileMenu.add("頁面設定(U)...");
    fileMenu.add("列印(P)...");
    fileMenu.add("退出(X)");
    menuBar.add(fileMenu);
    
    JMenu editMenu = new HorizontalMenu("編輯(E)");
    editMenu.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
    editMenu.add("取消(U)");
    editMenu.add("剪下(T)");
    editMenu.add("複製(C)");
    editMenu.add("貼上(P)");
    editMenu.add("刪除(L)");
    editMenu.add("尋找(F)...");
    editMenu.add("尋找下一個(N)");
    editMenu.add("替換(R)...");
    editMenu.add("轉到(G)...");
    editMenu.add("全選(A)");
    editMenu.add("時間/日期(D)");
    menuBar.add(editMenu);
    
    JMenu formatMenu = new HorizontalMenu("格式(O)");
    formatMenu.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
    formatMenu.add("自動換行(W)");
    formatMenu.add("字體(F)...");
    menuBar.add(formatMenu);
    
    JMenu viewMenu = new HorizontalMenu("檢視(V)");
    viewMenu.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
    viewMenu.add("狀態欄(S)");
    menuBar.add(viewMenu);
    
    JMenu helpMenu = new HorizontalMenu("幫助(H)");
    helpMenu.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
    helpMenu.add("檢視幫助(H)");
    helpMenu.add("關於記事本(A)");
    menuBar.add(helpMenu);
}
}
