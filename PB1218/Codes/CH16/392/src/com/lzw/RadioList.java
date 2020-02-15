package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ListSelectionModel;

public class RadioList extends JFrame {
    
    private JPanel contentPane;
    
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
                    RadioList frame = new RadioList();
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
    public RadioList() {
        setTitle("在列表控制項中顯示單選按鈕");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 294);
        contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        final String[] values = new String[] { "Java", "Visual C++", "C/C++",
                "C#", "Asp.net", "Visual Basic", "PHP", "Java Web" };// 建立列記錄陣列
        JList list = new JList(values);// 建立列表控制項
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 列記錄單選
        list.setSelectedIndex(0);// 設定預設選擇狀態的選項
        list.setFixedCellHeight(30);// 設定列記錄的固定高度
        ListCellRenderer renderer = new ListCellRenderer() {// 建立著色器實現
            JRadioButton radio = new JRadioButton();// 建立單選按鈕控制項
            Color background = new Color(0, 0, 0, 0);// 建立透明的背景色
            
            @Override
            public Component getListCellRendererComponent(final JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                radio.setBackground(background);// 設定單選按鈕控制項的背景色
                radio.setOpaque(true);// 使單選按鈕不透明
                if (value.equals(values[index])) {
                    radio.setText(value + "");// 設定單選按鈕文字
                }
                radio.setSelected(isSelected);
                return radio;// 傳回單選按鈕控制項作為著色控制項
            }
        };
        list.setCellRenderer(renderer);// 設定列表控制項的著色器
        scrollPane.setViewportView(list);// 把列表控制項增加到捲動面板
        JLabel label = new JLabel("請選擇您所在的開發部門：");
        scrollPane.setColumnHeaderView(label);
    }
}
