import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.*;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        super();
    }
    
    public void paintComponent(Graphics g) {
        try {
            URL url = getClass().getResource("/images/enter.jpg"); // 指定圖片路徑
            ImageIcon image = new ImageIcon(url); // 建立ImageIcon對像
            g.drawImage(image.getImage(), 0, 0, this); // 將圖片繪製到面板上
         
        } catch (Exception e) {
        }
    }
}
