import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * �a�I�������O����
 * 
 * @author ZhongWei Lee
 */
public class BackgroundPanel extends JPanel {
    
    /**
     * �I���Ϥ�
     */
    private Image image;
    
    /**
     * �غc��k
     */
    public BackgroundPanel() {
        super();
        setOpaque(false);
        setLayout(null);
    }
    
    /**
     * �]�w�Ϥ�����k
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) {// ���s�w�qø�s����~�[
        int width = getWidth();// ��o����j�p
        int height = getHeight();
        if (image != null) {
            g.drawImage(image, 0, 0, width, height, this);// ø�s�Ϥ��P����j�p�ۦP
        }else{
            String str="�S���Ϥ��w��";
            int strWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), str);
            g.drawString(str, (width-strWidth)/2, height/2);
        }
        super.paintComponent(g);// ����W���O��k
    }
}
