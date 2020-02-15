package com.mingrisoft.jprogressbar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class ProgressBarTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1545999924967549173L;
    private JPanel contentPane;
    private JButton button;
    private JTextArea textArea;
    private JProgressBar progressBar;
    
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
                    ProgressBarTest frame = new ProgressBarTest();
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
    public ProgressBarTest() {
        setTitle("查看程序的運行狀況");
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
        
        progressBar = new JProgressBar();
        progressBar.setPreferredSize(new Dimension(200, 30));
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(progressBar);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        button.setEnabled(false);
        Activity activity = new Activity(500);
        activity.execute();
        
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
                progressBar.setValue(chunk / 5);
                if (chunk == 499) {
                    progressBar.setValue(100);
                }
            }
        }
        
        @Override
        protected void done() {
            button.setEnabled(true);
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