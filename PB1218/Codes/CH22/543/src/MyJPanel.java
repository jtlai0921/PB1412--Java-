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
            URL url = getClass().getResource("/images/enter.jpg"); // ���w�Ϥ����|
            ImageIcon image = new ImageIcon(url); // �إ�ImageIcon�ﹳ
            g.drawImage(image.getImage(), 0, 0, this); // �N�Ϥ�ø�s�쭱�O�W
         
        } catch (Exception e) {
        }
    }
}
