package com.lzw;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class LimpidityTable extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    
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
                    LimpidityTable frame = new LimpidityTable();
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
    public LimpidityTable() {
        setTitle("實現透明效果的表格控制項");// 設定窗體標題
        setResizable(false);// 禁止調整大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        ImgPanel imgPanel = new ImgPanel();// 建立圖片面板
        contentPane.add(imgPanel, BorderLayout.CENTER);
        imgPanel.setLayout(null);// 取消佈局管理器
        table = new JTable() {// 建立自定義表格
            {
                setOpaque(false);// 初始化表格為透明
                setGridColor(Color.MAGENTA);// 設定表格網格顏色
                setShowVerticalLines(true);// 顯示網格豎線
                setShowHorizontalLines(true);// 顯示網格橫線
                setRowHeight(20);// 設定表格行高
                setBorder(new LineBorder(Color.PINK));// 設定邊框
                setForeground(Color.BLACK);// 設定表格文字顏色
                setFont(new Font("SansSerif", Font.PLAIN, 18));// 設定表格單元格字體
            }
            
            @Override
            public Component prepareRenderer(TableCellRenderer renderer,
                    int row, int column) {// 重新定義著色方法
                // 獲得著色後的控制項
                Component component = super.prepareRenderer(renderer, row,
                        column);
                ((JComponent) component).setOpaque(false);// 設定控制項透明
                return component;// 傳回控制項
            }
        };
        table.setModel(new DefaultTableModel(
                new Object[][] {// 初始化表格內容與列名
                { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" } },
                new String[] { "列名1", "列名2", "列名3", "列名4", "列名5" }));
        table.setBounds(40, 161, 421, 254);// 設定表格大小
        imgPanel.add(table);
        JPanel panel = new JPanel();// 建立表頭面板
        panel.setLayout(new BorderLayout(0, 0));
        panel.add(table.getTableHeader(), BorderLayout.CENTER);// 增加表頭
        panel.setBounds(40, 126, 421, 34);
        imgPanel.add(panel);
    }
}
