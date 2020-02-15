package com.mingrisoft.time;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SimulatedClock extends JFrame {
    
    /**
     * �i�H�ק令�ϥ�Rectangle2D
     */
    private static final long serialVersionUID = 1557083478271086551L;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimulatedClock frame = new SimulatedClock();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public SimulatedClock() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("\u6A21\u62DF\u65F6\u949F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
    }
    
    public void paint(Graphics g) {
        super.paint(g);// �I�s�����O��paint()��k�A�o�˯�b�e�Ϯɯ��x�s�~�[
        Rectangle rectangle = getBounds();// ��o���󪺰ϰ�
        Insets insets = getInsets();// ��o�������
        int radius = 120;// �]�w�ꪺ�b�|�O120px
        int x = (rectangle.width - 2 * radius - insets.left - insets.right) / 2 + insets.left;
        int y = (rectangle.height - 2 * radius - insets.top - insets.bottom) / 2 + insets.top;
        Point2D.Double center = new Point2D.Double(x + radius, y + radius);// ��o��߮y��
        g.drawOval(x, y, 2 * radius, 2 * radius);// ø�s���
        Point2D.Double[] scales = new Point2D.Double[60];// ��60���I�x�s��Ъ����
        double angle = Math.PI / 30;// ��ФW����I�����������OPI/30
        for (int i = 0; i < scales.length; i++) {// ��o�Ҧ���ת��y��
            scales[i] = new Point2D.Double();// ��l���I�ﹳ
            scales[i].setLocation(x + radius + radius * Math.sin(angle * i), y + radius - radius * Math.cos(angle * i));// �Q�ΤT����ƭp���I���y��
        }
        for (int i = 0; i < scales.length; i++) {// �e�Ҧ����
            if (i % 5 == 0) {// �p�G�Ǹ��O5�h�e���j�I�A�o���I�۷��ۭ^��W���Ʀr
                g.setColor(Color.RED);
                g.fillOval((int) scales[i].x - 4, (int) scales[i].y - 4, 8, 8);
            } else {// �p�G�Ǹ����O5�h�e���p�I�A�o���I�۷��ۭ^��W���p���
                g.setColor(Color.CYAN);
                g.fillOval((int) scales[i].x - 2, (int) scales[i].y - 2, 4, 4);
            }
        }
        Calendar calendar = new GregorianCalendar();// �إߤ���ﹳ
        int hour = calendar.get(Calendar.HOUR);// ��o�ثe�p�ɼ�
        int minute = calendar.get(Calendar.MINUTE);// ��o�ثe������
        int second = calendar.get(Calendar.SECOND);// ��o�ثe���
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);// �N�C��]�w������
        g2d.draw(new Line2D.Double(center, scales[second]));// ø�s��w
        BasicStroke bs = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.blue);// �N�C��]�w���Ŧ�
        g2d.draw(new Line2D.Double(center, scales[minute]));// ø�s���w
        bs = new BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.green);// �N�C��]�w�����
        g2d.draw(new Line2D.Double(center, scales[hour * 5 + minute / 12]));// ø�s�ɰw
    }
    
    private class ClockRunnable implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        new Thread(new ClockRunnable()).start();
    }
}
