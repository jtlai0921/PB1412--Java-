import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * �a�I�������O����
 * 
 * @author ZhongWei Lee
 */
public class ShadePanel extends JPanel {
    /**
     * �غc��k
     */
    public ShadePanel() {
        super();
        setLayout(null);
    }
    
    @Override
    protected void paintComponent(Graphics g1) {// ���s�w�qø�s����~�[
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);// ����W���O��k
        int width = getWidth();// ��o����j�p
        int height = getHeight();
        // �إ߶�R�Ҧ��ﹳ
        GradientPaint paint = new GradientPaint(0, 0, Color.CYAN, 0, height,
                Color.MAGENTA);
        g.setPaint(paint);// �]�wø�Ϲ�H����R�Ҧ�
        g.fillRect(0, 0, width, height);// ø�s�x�ζ�R����ɭ�
    }
}
