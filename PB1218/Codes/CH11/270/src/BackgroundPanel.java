import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 帶背景的面板元件
 * 
 * @author ZhongWei Lee
 */
public class BackgroundPanel extends JPanel {
    
    /**
     * 背景圖片
     */
    private Image image;
    
    /**
     * 建構方法
     */
    public BackgroundPanel() {
        super();
        setOpaque(false);
        setLayout(null);
    }
    
    /**
     * 設定圖片的方法
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) {// 重新定義繪製元件外觀
        int width = getWidth();// 獲得元件大小
        int height = getHeight();
        if (image != null) {
            g.drawImage(image, 0, 0, width, height, this);// 繪製圖片與元件大小相同
        }else{
            String str="沒有圖片預覽";
            int strWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), str);
            g.drawString(str, (width-strWidth)/2, height/2);
        }
        super.paintComponent(g);// 執行超類別方法
    }
}
