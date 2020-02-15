package com.mingrisoft.progressmonitor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ProgressMonitorTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9181550456932875640L;
    private JPanel contentPane;
    private JButton button;
    private JTextArea textArea;
    private ProgressMonitor monitor;
    private Activity activity;
    
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
                    ProgressMonitorTest frame = new ProgressMonitorTest();
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
    public ProgressMonitorTest() {
        setTitle("進度監視器的使用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 396, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        button = new JButton("運行程序");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        button.setEnabled(false);
        int max = 500;
        activity = new Activity(max);
        activity.execute();
        monitor = new ProgressMonitor(ProgressMonitorTest.this, "正在計算質數", null, 0, max);
        new Timer(500, new CancelAction()).start();
    }
    
    private class CancelAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (monitor.isCanceled()) {
                activity.cancel(true);
            } else if (activity.isDone()) {
                monitor.close();
                button.setEnabled(true);
            } else {
                monitor.setProgress(activity.getProgress());
            }
            
        }
        
    }
    
    private class Activity extends SwingWorker<Void, Integer> {
        private int current;
        private int target;
        
        public Activity(int target) {
            this.target = target;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            while (current < target) {
                Thread.sleep(100);
                if (isPrime(current)) {
                    publish(current);
                }
                current++;
            }
            return null;
        }
        
        @Override
        protected void process(List<Integer> chunks) {
            for (Integer chunk : chunks) {
                textArea.append(chunk + " ");
                setProgress(chunk / 5);
            }
        }
        
        private boolean isPrime(int number) {
            if (number < 2) {
                return false;
            } else {
                int sqrt = (int) Math.sqrt(number);
                for (int i = 2; i <= sqrt; i++) {
                    if (number % i == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        
    }
}
