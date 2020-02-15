package com.mingrisoft.runtime;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.UIManager;

public class MemoryStatus extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3225753245258184286L;
    private JPanel contentPane;
    private JPanel statusPanel;
    private JLabel totalLabel;
    private JLabel freeLabel;
    private JScrollPane scrollPane;
    private JProgressBar progressBar;
    
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
                    MemoryStatus frame = new MemoryStatus();
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
    public MemoryStatus() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("記憶體狀態");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        statusPanel = new JPanel();
        contentPane.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setLayout(new GridLayout(2, 1, 5, 5));
        
        freeLabel = new JLabel("");
        freeLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        statusPanel.add(freeLabel);
        
        totalLabel = new JLabel("");
        totalLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        statusPanel.add(totalLabel);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        progressBar.setOrientation(SwingConstants.VERTICAL);
        scrollPane.setViewportView(progressBar);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        new Thread(new Memory()).start();
    }
    
    private class Memory implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.gc();// 強制虛擬機進行垃圾回收以釋放記憶體
                int free = (int) Runtime.getRuntime().freeMemory() / 1024;// 獲得可用記憶體
                int total = (int) Runtime.getRuntime().totalMemory() / 1024;// 獲得總共記憶體
                int status = free * 100 / total;// 獲得記憶體使用率
                freeLabel.setText("可用記憶體：" + free + "Kb"); // 顯示可用記憶體
                totalLabel.setText("總共記憶體：" + total + "Kb"); // 顯示總共記憶體
                progressBar.setValue(status); // 顯示記憶體的使用率
                progressBar.setString("可用記憶體：" + status + "%");
                try {
                    Thread.sleep(1000);// 線程休眠1秒鐘進行動態更新
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
