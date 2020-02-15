package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class TransactionFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4239009401384819805L;
    private JPanel contentPane;
    private JTextArea senderTextArea;
    private JTextArea receiverTextArea;
    
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
                    TransactionFrame frame = new TransactionFrame();
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
    public TransactionFrame() {
        setTitle("²�檺������q�T");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("�}�l���");
        button.setFont(new Font("�L�n����", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
        
        JPanel transactionPanel = new JPanel();
        contentPane.add(transactionPanel, BorderLayout.CENTER);
        transactionPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel senderPanel = new JPanel();
        transactionPanel.add(senderPanel);
        senderPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel senderLabel = new JLabel("��a");
        senderLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        senderPanel.add(senderLabel, BorderLayout.NORTH);
        
        JScrollPane senderScrollPane = new JScrollPane();
        senderPanel.add(senderScrollPane, BorderLayout.CENTER);
        
        senderTextArea = new JTextArea();
        senderTextArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        senderScrollPane.setViewportView(senderTextArea);
        
        JPanel receiverPanel = new JPanel();
        transactionPanel.add(receiverPanel);
        receiverPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel receiverLabel = new JLabel("�R�a");
        receiverLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        receiverPanel.add(receiverLabel, BorderLayout.NORTH);
        
        JScrollPane receiverScrollPane = new JScrollPane();
        receiverPanel.add(receiverScrollPane, BorderLayout.CENTER);
        
        receiverTextArea = new JTextArea();
        receiverTextArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        receiverScrollPane.setViewportView(receiverTextArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        Thread st = new Thread(sender);
        Thread rt = new Thread(receiver);
        st.start();
        rt.start();
    }
    
    private class Sender implements Runnable {
        private String[] products = { "�mJava�s�{����n", "�mJava�d�Ҥj���n", "�m���T��Java�s�{�n", "�m�ӻ�Java�n", "�mJava�}�o����_��n" };// ����ӫ~�C��
        private volatile String product;// �x�s�@�Ӱӫ~�W��
        private volatile boolean isValid;// �x�s��a�O�_�o�e�ӫ~�����A
        
        public boolean isIsValid() {// Ū�����A
            return isValid;
        }
        
        public void setIsValid(boolean isValid) {// �]�w���A
            this.isValid = isValid;
        }
        
        public String getProduct() {// ��o�ӫ~
            return product;
        }
        
        public void run() {
            for (int i = 0; i < 5; i++) {// �V�R�a�o�e5���ӫ~
                while (isValid) {// �p�G�w�g�o�e�ӫ~�N�i�J���ݪ��A�A���ݶR�a����
                    Thread.yield();
                }
                product = products[i];// ��o�@��ӫ~
                String text = senderTextArea.getText();// ��o��a��r���T
                senderTextArea.setText(text + "�o�e�G" + product + "\n");// ��s��a��r���T
                try {
                    Thread.sleep(100);// �ثe�u�{��v0.1���{�o�e���ĪG
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isValid = true;// �N���A�]�w���w�g�o�e�ӫ~
            }
        }
    }
    
    private class Receiver implements Runnable {
        private Sender sender;// �إߤ@�ӹ�o�e�̪��Ѧ�
        
        public Receiver(Sender sender) {// �Q�Ϋغc��k��l�Ƶo�e�̰Ѧ�
            this.sender = sender;
        }
        
        public void run() {
            for (int i = 0; i < 5; i++) {// ����5���ӫ~
                while (!sender.isIsValid()) {// �p�G�o�e�̨S���o�e�ӫ~�N�i�浥��
                    Thread.yield();
                }
                String text = receiverTextArea.getText();// ��o��a��r���T
                // ��s��a��r���T
                receiverTextArea.setText(text + "����G" + sender.getProduct() + "\n");
                try {
                    Thread.sleep(1000);// �u�{��v1���{�ʺA�o�e���ĪG
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sender.setIsValid(false);// �]�w��a�o�e�ӫ~�����A�����o�e�A�o�˽�a�N�i�H�~��o�e�ӫ~
            }
        }
    }
    
}
