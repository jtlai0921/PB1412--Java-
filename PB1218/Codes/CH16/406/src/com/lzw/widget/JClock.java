package com.lzw.widget;

import static java.util.Calendar.HOUR;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * �������O
 * 
 * @author ����L
 */
public class JClock extends JLabel implements Runnable {
    // 3�ӫ��Ъ��ʲ�
    private static final BasicStroke HOURS_POINT_WIDTH = new BasicStroke(5);
    private static final BasicStroke MINUETES_POINT_WIDTH = new BasicStroke(3);
    private static final BasicStroke SEC_POINT_WIDTH = new BasicStroke(2);
    private ImageIcon background;
    private int centerX; // ���߮y��
    private int centerY;
    private final static int secLen = 60; // ���Ъ���
    private final static int minuesLen = 55; // ���Ъ���
    private final static int hoursLen = 36; // ���Ъ���
    
    /**
     * �غc��k
     */
    public JClock() {
        setOpaque(false);
        background = new ImageIcon(getClass().getResource("Core.data"));
        int iconWidth = background.getIconWidth();
        centerX = iconWidth / 2;
        int iconHeight = background.getIconHeight();
        centerY = iconHeight / 2;
        setPreferredSize(new Dimension(iconWidth, iconHeight));
        new Thread(this).start();
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();// �ର2Dø�ϤW�U��
        Composite composite = g2.getComposite();// �x�s�즳�X���W�h
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));// �]�w60%�z�����X���W�h
        Calendar calendar = Calendar.getInstance();
        drawClock(g2, calendar);// ø�s����
        g2.setComposite(composite);// ��_�즳�X���W�h
        g2.drawImage(background.getImage(), 0, 0, this);// ø�s�I����
        g2.dispose();
    }
    
    private void drawClock(Graphics2D g2, Calendar calendar) {
        int millisecond = calendar.get(MILLISECOND);
        int sec = calendar.get(SECOND);
        int minutes = calendar.get(MINUTE);
        int hours = calendar.get(HOUR);
        double secAngle = (60 - sec) * 6 - (millisecond / 150); // ��w����
        int minutesAngle = (60 - minutes) * 6;// ���w����
        int hoursAngle = (12 - hours) * 360 / 12 - (minutes / 2);// �ɰw����
        // �p���w�B���w�B�ɰw���V�y��
        int secX = (int) (secLen * Math.sin(Math.toRadians(secAngle)));
        int secY = (int) (secLen * Math.cos(Math.toRadians(secAngle)));
        int minutesX = (int) (minuesLen * Math
                .sin(Math.toRadians(minutesAngle)));
        int minutesY = (int) (minuesLen * Math
                .cos(Math.toRadians(minutesAngle)));
        int hoursX = (int) (hoursLen * Math.sin(Math.toRadians(hoursAngle)));
        int hoursY = (int) (hoursLen * Math.cos(Math.toRadians(hoursAngle)));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // ���Oø�s�ɰw�B���w�B��w
        g2.setColor(Color.BLACK);
        g2.setStroke(HOURS_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - hoursX, centerY - hoursY);
        g2.setStroke(MINUETES_POINT_WIDTH);
        g2.setColor(new Color(0x2F2F2F));
        g2.drawLine(centerX, centerY, centerX - minutesX, centerY - minutesY);
        g2.setColor(Color.RED);
        g2.setStroke(SEC_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - secX, centerY - secY);
        // ø�s3�ӫ��Ъ����߶�
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                if (getRootPane() != null) {
                    JFrame main = (JFrame) getRootPane().getParent();
                    if (main != null && main.isVisible()) {
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                JClock.this.repaint();
                            }
                        });
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
