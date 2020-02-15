package com.mingrisoft.runtime;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.UIManager;

public class MemoryStatus extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3225753245258184286L;
    private JPanel contentPane;
    private JPanel statusPanel;
    private JLabel totalLabel;
    private JLabel freeLabel;
    private JScrollPane scrollPane;
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
                    MemoryStatus frame = new MemoryStatus();
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
    public MemoryStatus() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("�O���骬�A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        statusPanel = new JPanel();
        contentPane.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setLayout(new GridLayout(2, 1, 5, 5));
        
        freeLabel = new JLabel("");
        freeLabel.setFont(new Font("�L�n����", Font.PLAIN, 18));
        statusPanel.add(freeLabel);
        
        totalLabel = new JLabel("");
        totalLabel.setFont(new Font("�L�n����", Font.PLAIN, 18));
        statusPanel.add(totalLabel);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("�L�n����", Font.PLAIN, 18));
        progressBar.setOrientation(SwingConstants.VERTICAL);
        scrollPane.setViewportView(progressBar);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        new Thread(new Memory()).start();
    }
    
    private class Memory implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.gc();// �j��������i��U���^���H����O����
                int free = (int) Runtime.getRuntime().freeMemory() / 1024;// ��o�i�ΰO����
                int total = (int) Runtime.getRuntime().totalMemory() / 1024;// ��o�`�@�O����
                int status = free * 100 / total;// ��o�O����ϥβv
                freeLabel.setText("�i�ΰO����G" + free + "Kb"); // ��ܥi�ΰO����
                totalLabel.setText("�`�@�O����G" + total + "Kb"); // ����`�@�O����
                progressBar.setValue(status); // ��ܰO���骺�ϥβv
                progressBar.setString("�i�ΰO����G" + status + "%");
                try {
                    Thread.sleep(1000);// �u�{��v1�����i��ʺA��s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
