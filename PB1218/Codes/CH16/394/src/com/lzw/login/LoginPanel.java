package com.lzw.login;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author 李鍾尉
 */
public class LoginPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private ImageIcon bg;// 背景圖片對像
    
    /**
     * This is the default constructor
     */
    public LoginPanel() {
        super();
        // 獲得圖片路徑
        URL url = getClass().getResource("loginBG.png");
        bg = new ImageIcon(url);// 載入圖片對像
        // 設定面板與背景相同大小
        setSize(bg.getIconWidth(), bg.getIconHeight());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g2);
        if (bg != null) {// 如果背景圖片對像初始化完畢
            // 繪製圖片到界面中
            g2.drawImage(bg.getImage(), 0, 0, this);
        }
    }
}
