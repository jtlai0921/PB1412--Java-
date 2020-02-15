package com.lzw.login;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ProgressPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JProgressBar jProgressBar = null;// 進度條
    private BufferedImage bgimage;// 背景圖片
    private JLabel jLabel = null;// 標籤控制項
    
    /**
     * 建構方法
     */
    public ProgressPanel() {
        super();
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        jLabel = new JLabel();// 初始化標籤控制項
        jLabel.setText("正在登入系統……");
        // 設定字體
        jLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        // 設定前景色
        jLabel.setForeground(new Color(0x28629e));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(0, 50, 0, 50);
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 0;
        gridBagConstraints.gridy = 1;
        // 設定佈局管理器
        this.setLayout(new GridBagLayout());
        this.setSize(300, 200);// 設定界面大小
        // 設定前景色
        this.setForeground(Color.white);
        this.setOpaque(false);
        // 增加登入進度面板到面板
        this.add(getJProgressBar(), gridBagConstraints);
        // 增加登入資訊標籤到面板
        this.add(jLabel, gridBagConstraints2);
    }
    
    /**
     * 初始化進度條控制項
     * 
     * @return javax.swing.JProgressBar
     */
    private JProgressBar getJProgressBar() {
        if (jProgressBar == null) {
            jProgressBar = new JProgressBar();
            // 設定進度條為不確定狀態
            jProgressBar.setIndeterminate(true);
        }
        return jProgressBar;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();// 轉為2D繪圖上下文
        g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));// 設定透明合成規則
        g2.setPaint(Color.GREEN);// 使用綠色前景色
        g2.fillRect(0, 0, getWidth(), getHeight());// 繪製半透明矩形
        g2.dispose();
        super.paint(g);// 執行父類別繪圖方法
    }
}
