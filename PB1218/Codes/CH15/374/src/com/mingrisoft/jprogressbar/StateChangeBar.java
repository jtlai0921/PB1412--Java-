package com.mingrisoft.jprogressbar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StateChangeBar extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3631585803783649593L;
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JLabel label;
    
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
                    StateChangeBar frame = new StateChangeBar();
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
    public StateChangeBar() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("閃屏界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 100);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        progressBar.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                do_progressBar_stateChanged(e);
            }
        });
        contentPane.add(progressBar, BorderLayout.SOUTH);
        
        label = new JLabel("程序正在啟動中。。。");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_progressBar_stateChanged(ChangeEvent e) {
        JProgressBar comp = (JProgressBar) e.getSource();
        int value = comp.getValue();
        if (value == 100) {
            label.setText("程式啟動完畢！");
            comp.setVisible(false);
        }
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        Activity activity = new Activity();
        activity.execute();
    }
    
    private class Activity extends SwingWorker<Void, Integer> {
        
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 1; i < 101; i++) {
                Thread.sleep(100);
                publish(i);
            }
            return null;
        }
        
        @Override
        protected void process(List<Integer> chunks) {
            for (Integer chunk : chunks) {
                progressBar.setValue(chunk);
            }
        }
    }
}
