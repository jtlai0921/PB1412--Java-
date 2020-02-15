package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class IconList extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IconList frame = new IconList();
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
    public IconList() {
        setTitle("支援圖標的列表控制項");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        final String[] values = new String[] { "西瓜", "吃剩的蘋果", "香蕉", "玉米", "葡萄",
                "菠蘿", "西紅柿" };// 建立列記錄陣列
        final ImageIcon[] icons = new ImageIcon[values.length];// 建立圖標陣列
        for (int i = 0; i < icons.length; i++) {// 檢查圖標陣列
            icons[i] = new ImageIcon(getClass().getResource(
                    "/res/" + i + ".png"));// 初始化每一個陣列元素
        }
        JList list = new JList(values);// 建立列表控制項
        list.setSelectedIndex(0);
        ListCellRenderer renderer = new ListCellRenderer() {// 建立著色器實現
            JLabel label = new JLabel();// 建立標籤控制項
            Color background = new Color(0, 0, 0, 0);// 建立透明的背景色
            
            @Override
            public Component getListCellRendererComponent(final JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                label.setBackground(background);// 設定標籤控制項的背景色
                label.setOpaque(true);// 使標籤不透明
                if (value.equals(values[index])) {
                    label.setText(value + "");// 設定標籤文字
                    label.setIcon(icons[index]);// 設定標籤圖標
                }
                if (isSelected) {
                    label.setBackground(Color.PINK);// 設定選擇時的背景色
                } else {
                    label.setBackground(background);// 設定未選擇時的背景色
                }
                return label;// 傳回標籤控制項作為著色控制項
            }
        };
        list.setCellRenderer(renderer);// 設定列表控制項的著色器
        scrollPane.setViewportView(list);// 把列表控制項增加到捲動面板
    }
}
