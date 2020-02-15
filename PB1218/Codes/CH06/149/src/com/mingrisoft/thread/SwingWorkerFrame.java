package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.UIManager;

public class SwingWorkerFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4547196011936458775L;
    private JPanel contentPane;
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
                    SwingWorkerFrame frame = new SwingWorkerFrame();
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
    public SwingWorkerFrame() {
        setTitle("�ϥ�SwingWorker���O�����Ӯɾާ@");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel labelPanel = new JPanel();
        contentPane.add(labelPanel);
        labelPanel.setLayout(new BorderLayout(0, 0));
        
        label = new JLabel("");
        label.setFont(new Font("�L�n����", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(label, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton button = new JButton("�}�l�ͦ�");
        button.setFont(new Font("�L�n����", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        RandomNumber random = new RandomNumber();
        random.execute();
    }
    
    private class RandomNumber extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            int[] intArray = new int[1000];// �إߤ@�Ӯe�q��1000���}�C
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = new Random().nextInt();// ���}�C���C�Ӥ��������Ȥ@���H�����
            }
            Arrays.sort(intArray);// ��}�C�Ƨ�
            label.setText("���ͪ��̤j�H���ƬO�G" + intArray[intArray.length - 1]);// ��o�̤j��
            return null;
        }
    }
    
}
