package com.lzw.widget;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ButtonPanel extends JPanel {
    
    /**
     * Create the panel.
     */
    public ButtonPanel() {
        setLayout(new GridLayout(1, 0, 0, 0));
        
        JButton button = new JButton("登入模塊");
        add(button);
        
        JButton button_1 = new JButton("郵件管理");
        add(button_1);
        
        JButton button_2 = new JButton("網站維護");
        add(button_2);
        
        JButton button_3 = new JButton("新聞模塊");
        add(button_3);
        
        JButton button_4 = new JButton("資料備份");
        add(button_4);
        
        JButton button_5 = new JButton("系統設定");
        add(button_5);
        
        JButton button_6 = new JButton("資料管理");
        add(button_6);
        
        JButton button_7 = new JButton("網絡連接");
        add(button_7);
        
        JButton button_8 = new JButton("服務管理");
        add(button_8);
        
    }
    
}
