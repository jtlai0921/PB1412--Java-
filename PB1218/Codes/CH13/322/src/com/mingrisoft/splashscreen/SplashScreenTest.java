package com.mingrisoft.splashscreen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SplashScreen;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class SplashScreenTest {
    
    private static void inital() {
        SplashScreen splashScreen = SplashScreen.getSplashScreen();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Image image = toolkit.getImage(splashScreen.getImageURL());
        final JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true);
        final JPanel splashPanel = new JPanel() {
            
            /**
             * 
             */
            private static final long serialVersionUID = -1289515968041228683L;
            
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        };
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        splashPanel.setLayout(new BorderLayout());
        splashPanel.add(progressBar, BorderLayout.SOUTH);
        
        splashFrame.add(splashPanel);
        splashFrame.setSize(splashScreen.getSize().width, splashScreen.getSize().height + 20);
        Dimension splashSize = new Dimension();
        splashSize.width = splashScreen.getSize().width;
        splashSize.height = splashScreen.getSize().height + 20;
        Dimension screenSize = toolkit.getScreenSize();
        splashFrame.setLocation((screenSize.width - splashSize.width) / 2, (screenSize.height - splashSize.height) / 2);
        splashFrame.setVisible(true);
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    progressBar.setString("¤w¸g¸ü¤J¡G" + i + "%");
                    progressBar.setValue(i);
                    splashPanel.repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                splashFrame.setVisible(false);
            }
        }).start();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                inital();
            }
        });
    }
}
