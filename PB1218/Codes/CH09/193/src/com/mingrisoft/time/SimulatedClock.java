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
     * 可以修改成使用Rectangle2D
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
        super.paint(g);// 呼叫父類別的paint()方法，這樣能在畫圖時能儲存外觀
        Rectangle rectangle = getBounds();// 獲得元件的區域
        Insets insets = getInsets();// 獲得元件的邊框
        int radius = 120;// 設定圓的半徑是120px
        int x = (rectangle.width - 2 * radius - insets.left - insets.right) / 2 + insets.left;
        int y = (rectangle.height - 2 * radius - insets.top - insets.bottom) / 2 + insets.top;
        Point2D.Double center = new Point2D.Double(x + radius, y + radius);// 獲得圓心座標
        g.drawOval(x, y, 2 * radius, 2 * radius);// 繪製圓形
        Point2D.Double[] scales = new Point2D.Double[60];// 用60個點儲存表碟的刻度
        double angle = Math.PI / 30;// 表碟上兩個點之間的夾角是PI/30
        for (int i = 0; i < scales.length; i++) {// 獲得所有刻度的座標
            scales[i] = new Point2D.Double();// 初始化點對像
            scales[i].setLocation(x + radius + radius * Math.sin(angle * i), y + radius - radius * Math.cos(angle * i));// 利用三角函數計算點的座標
        }
        for (int i = 0; i < scales.length; i++) {// 畫所有刻度
            if (i % 5 == 0) {// 如果序號是5則畫成大點，這些點相當於石英鍾上的數字
                g.setColor(Color.RED);
                g.fillOval((int) scales[i].x - 4, (int) scales[i].y - 4, 8, 8);
            } else {// 如果序號不是5則畫成小點，這些點相當於石英鍾上的小刻度
                g.setColor(Color.CYAN);
                g.fillOval((int) scales[i].x - 2, (int) scales[i].y - 2, 4, 4);
            }
        }
        Calendar calendar = new GregorianCalendar();// 建立日期對像
        int hour = calendar.get(Calendar.HOUR);// 獲得目前小時數
        int minute = calendar.get(Calendar.MINUTE);// 獲得目前分鐘數
        int second = calendar.get(Calendar.SECOND);// 獲得目前秒數
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);// 將顏色設定成紅色
        g2d.draw(new Line2D.Double(center, scales[second]));// 繪製秒針
        BasicStroke bs = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.blue);// 將顏色設定成藍色
        g2d.draw(new Line2D.Double(center, scales[minute]));// 繪製分針
        bs = new BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.green);// 將顏色設定成綠色
        g2d.draw(new Line2D.Double(center, scales[hour * 5 + minute / 12]));// 繪製時針
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