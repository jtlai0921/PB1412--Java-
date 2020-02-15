package com.lzw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author ����L
 */
public class ImgPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private ImageIcon bg;// �I���Ϥ��ﹳ
    
    /**
     * This is the default constructor
     */
    public ImgPanel() {
        super();
        // ��o�Ϥ����|
        URL url = getClass().getResource("back.jpg");
        bg = new ImageIcon(url);// ���J�Ϥ��ﹳ
        // �]�w���O�P�I���ۦP�j�p
        setSize(bg.getIconWidth(), bg.getIconHeight());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g2);
        if (bg != null) {// �p�G�I���Ϥ��ﹳ��l�Ƨ���
            // ø�s�Ϥ���ɭ���
            g2.drawImage(bg.getImage(), 0, 0, this);
        }
    }
}
