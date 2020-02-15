import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * 帶背景的面板元件
 * 
 * @author ZhongWei Lee
 */
public class ShadePanel extends JPanel {
    /**
     * 建構方法
     */
    public ShadePanel() {
        super();
        setLayout(null);
    }
    
    @Override
    protected void paintComponent(Graphics g1) {// 重新定義繪製元件外觀
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);// 執行超類別方法
        int width = getWidth();// 獲得元件大小
        int height = getHeight();
        // 建立填充模式對像
        GradientPaint paint = new GradientPaint(0, 0, Color.CYAN, 0, height,
                Color.MAGENTA);
        g.setPaint(paint);// 設定繪圖對象的填充模式
        g.fillRect(0, 0, width, height);// 繪製矩形填充控制項界面
    }
}
