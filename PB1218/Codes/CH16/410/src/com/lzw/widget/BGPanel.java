package com.lzw.widget;

import java.awt.*;
import java.io.Serializable;

import javax.swing.*;

/**
 * @author 李鍾尉
 */
public class BGPanel extends JPanel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Image image; // @jve:decl-index=0:
    public static final int HORIZONGTAL_FILL = 1;
    public static final int VERTICAL_FILL = 2;
    public static final int BOTH_FILL = 3;
    public static final int NO_FILL = 0;
    private int iconFill = NO_FILL;
    
    /**
     * This is the default constructor
     */
    public BGPanel() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(new Dimension(300, 200));
        this.setLayout(new GridBagLayout());
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setImage(Image icon) {
        this.image = icon;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// 完成原來控制項外觀的繪製
        if (image != null) {// 開始自定義背景的繪製
            switch (iconFill) {// 判斷背景填充方式
                case NO_FILL:// 不填充
                    g.drawImage(image, 0, 0, this);// 繪製原始圖片大小
                    break;
                case HORIZONGTAL_FILL:// 水平填充
                    // 繪製與控制項等寬的圖片
                    g.drawImage(image, 0, 0, getWidth(), image.getHeight(this),
                            this);
                    break;
                case VERTICAL_FILL:// 垂直填充
                    // 繪製與控制項等高的圖片
                    g.drawImage(image, 0, 0, image.getWidth(this), getHeight(),
                            this);
                    break;
                case BOTH_FILL:// 雙向填充
                    // 繪製與控制項同等大小的圖片
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                    break;
                default:
                    break;
            }
        }
    }
    
    public int getIconFill() {
        return iconFill;
    }
    
    /**
     * 設定背景重複方式
     * 
     * @param repeat
     *            重複方式
     */
    public void setIconFill(int iconFill) {
        this.iconFill = iconFill;
    }
    
}
