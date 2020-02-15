package com.lzw.widget;

import static javax.swing.BorderFactory.createEmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 移動面板
 * 
 * @author 李鍾尉
 */
public class SmallScrollPanel extends BGPanel {
    private static final long serialVersionUID = 3592329256836525981L;
    private AlphaScrollPane alphaScrollPane;// 捲動面板
    private JButton leftScrollButton = null;// 左側微調按鈕
    private JButton rightScrollButton = null;// 右側微調按鈕
    private ScrollMouseAdapter scrollMouseAdapter = new ScrollMouseAdapter(); // 捲動事件處理器
    private ImageIcon icon1;
    private ImageIcon icon2;
    private JPanel panel;
    
    /**
     * 建構方法
     */
    public SmallScrollPanel() {
        // 初始化程式用圖
        icon1 = new ImageIcon(getClass().getResource("top01.png"));
        icon2 = new ImageIcon(getClass().getResource("top02.png"));
        setIcon(icon1);// 設定用圖
        setIconFill(BOTH_FILL);// 將圖標伸展適應界面大小
        initialize();// 呼叫初始化方法
    }
    
    /**
     * 初始化程式界面的方法
     */
    private void initialize() {
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(0);
        this.setLayout(borderLayout);// 設定佈局管理器
        this.setSize(new Dimension(300, 84));
        this.setOpaque(false);
        // 增加左側微調按鈕
        this.add(getLeftScrollButton(), BorderLayout.WEST);
        // 增加右側微調按鈕
        this.add(getRightScrollButton(), BorderLayout.EAST);
        add(getPanel(), BorderLayout.CENTER);
    }
    
    /**
     * 建立捲動面板
     * 
     * @return
     */
    public AlphaScrollPane getAlphaScrollPanel() {
        if (alphaScrollPane == null) {
            alphaScrollPane = new AlphaScrollPane();
            // 設定初始大小
            alphaScrollPane.setPreferredSize(new Dimension(564, 69));
            // 不顯示垂直捲動條
            alphaScrollPane
                    .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            // 不顯示水平捲動條
            alphaScrollPane
                    .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            // 取消捲動面板邊框
            alphaScrollPane.setBorderPaint(false);
            // 增加事件監聽器
            alphaScrollPane
                    .addComponentListener(new ScrollButtonShowListener());
        }
        return alphaScrollPane;
    }
    
    public void setViewportView(Component view) {
        alphaScrollPane.setViewportView(view);
    }
    
    /**
     * 捲動微調處理器
     * 
     * @author 李鍾尉
     */
    private class ScrollButtonShowListener extends ComponentAdapter implements
            Serializable {
        private static final long serialVersionUID = 814596372430146361L;
        
        @Override
        public void componentResized(ComponentEvent e) {
            // 獲得水平捲動條
            JScrollBar scrollBar = alphaScrollPane.getHorizontalScrollBar();
            // 獲得範圍限制參數
            int scrollWidth = scrollBar.getMaximum();
            int paneWidth = alphaScrollPane.getWidth();
            // 在容器大於包含內容的時候隱藏左右微調按鈕
            if (paneWidth >= scrollWidth) {
                getLeftScrollButton().setVisible(false);
                getRightScrollButton().setVisible(false);
            }
            // 在容器小於包含內容的時候顯示左右微調按鈕
            if (paneWidth < scrollWidth) {
                getLeftScrollButton().setVisible(true);
                getRightScrollButton().setVisible(true);
            }
        }
    }
    
    /**
     * 建立左側微調按鈕
     * 
     * @return javax.swing.JButton
     */
    private JButton getLeftScrollButton() {
        if (leftScrollButton == null) {
            leftScrollButton = new JButton();
            // 建立按鈕圖標
            ImageIcon icon1 = new ImageIcon(getClass().getResource(
                    "zuoyidongoff.png"));
            // 建立按鈕圖標2
            ImageIcon icon2 = new ImageIcon(getClass().getResource(
                    "zuoyidongon.png"));
            leftScrollButton.setOpaque(false);// 按鈕透明
            // 設定邊框
            leftScrollButton.setBorder(createEmptyBorder(0, 10, 0, 0));
            // 設定按鈕圖標
            leftScrollButton.setIcon(icon1);
            leftScrollButton.setPressedIcon(icon2);
            leftScrollButton.setRolloverIcon(icon2);
            // 取消按鈕內容填充
            leftScrollButton.setContentAreaFilled(false);
            // 設定初始大小
            leftScrollButton.setPreferredSize(new Dimension(38, 0));
            // 取消按鈕焦點功能
            leftScrollButton.setFocusable(false);
            // 增加捲動事件監聽器
            leftScrollButton.addMouseListener(scrollMouseAdapter);
        }
        return leftScrollButton;
    }
    
    /**
     * 建立右側捲動微調按鈕
     * 
     * @return javax.swing.JButton
     */
    private JButton getRightScrollButton() {
        if (rightScrollButton == null) {
            rightScrollButton = new JButton();
            // 建立按鈕圖標
            ImageIcon icon1 = new ImageIcon(getClass().getResource(
                    "youyidongoff.png"));
            // 建立按鈕圖標2
            ImageIcon icon2 = new ImageIcon(getClass().getResource(
                    "youyidongon.png"));
            // 按鈕透明
            rightScrollButton.setOpaque(false);
            // 設定邊框
            rightScrollButton.setBorder(createEmptyBorder(0, 0, 0, 10));
            rightScrollButton.setIcon(icon1);// 設定按鈕圖標
            rightScrollButton.setPressedIcon(icon2);
            rightScrollButton.setRolloverIcon(icon2);
            // 取消按鈕內容繪製
            rightScrollButton.setContentAreaFilled(false);
            // 設定按鈕初始大小
            rightScrollButton.setPreferredSize(new Dimension(38, 92));
            // 取消按鈕焦點功能
            rightScrollButton.setFocusable(false);
            // 增加捲動事件監聽器
            rightScrollButton.addMouseListener(scrollMouseAdapter);
        }
        return rightScrollButton;
    }
    
    /**
     * 左右微調按鈕的事件監聽器
     * 
     * @author 李鍾尉
     */
    private final class ScrollMouseAdapter extends MouseAdapter implements
            Serializable {
        private static final long serialVersionUID = 5589204752770150732L;
        // 獲得捲動面板的水平捲動條
        JScrollBar scrollBar = getAlphaScrollPanel().getHorizontalScrollBar();
        // 定義線程控制變數
        private boolean isPressed = true;
        
        public void mousePressed(MouseEvent e) {
            Object source = e.getSource();// 獲得事件源
            isPressed = true;
            // 判斷事件源是左側按鈕還是右側按鈕，並執行對應操作
            if (source == getLeftScrollButton()) {
                scrollMoved(-1);
            } else {
                scrollMoved(1);
            }
        }
        
        /**
         * 移動捲動條的方法
         * 
         * @param orientation
         *            移動方向 -1是左或上移動，1是右或下移動
         */
        private void scrollMoved(final int orientation) {
            new Thread() {// 開闢新的線程
                // 儲存原有捲動條的值
                private int oldValue = scrollBar.getValue();
                
                public void run() {
                    while (isPressed) {// 循環移動面板
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        // 獲得捲動條目前值
                        oldValue = scrollBar.getValue();
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                // 設定捲動條移動3個像素
                                scrollBar.setValue(oldValue + 4 * orientation);
                            }
                        });
                    }
                }
            }.start();
        }
        
        public void mouseExited(java.awt.event.MouseEvent e) {
            isPressed = false;
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            isPressed = false;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 在元件頂層繪製圖片
        g.drawImage(icon2.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setOpaque(false);
            panel.setBorder(new EmptyBorder(5, 0, 5, 0));
            panel.setLayout(new BorderLayout(0, 0));
            panel.add(getAlphaScrollPanel());
        }
        return panel;
    }
}
