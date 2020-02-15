package com.mingrisoft.codec;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.digest.DigestUtils;
import java.awt.Font;

public class MD5Viewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8722656519909578699L;
    private JPanel contentPane;
    private JTextField textField;
    private String md5;
    private JLabel messageLabel;
    
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
                    MD5Viewer frame = new MD5Viewer();
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
    public MD5Viewer() {
        setTitle("MD5�d�ݾ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 175);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel filePanel = new JPanel();
        contentPane.add(filePanel);
        
        JLabel fileLabel = new JLabel("��ܤ��G");
        fileLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        filePanel.add(fileLabel);
        
        textField = new JTextField();
        textField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        filePanel.add(textField);
        textField.setColumns(10);
        
        JButton fileButton = new JButton("���}���");
        fileButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_fileButton_actionPerformed(arg0);
            }
        });
        filePanel.add(fileButton);
        
        JPanel messagePanel = new JPanel();
        contentPane.add(messagePanel);
        
        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("�L�n����", Font.PLAIN, 18));
        messagePanel.add(messageLabel);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton md5Button = new JButton("�p��MD5");
        md5Button.setFont(new Font("�L�n����", Font.PLAIN, 16));
        md5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_md5Button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(md5Button);
    }
    
    protected void do_fileButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// ���ɮ׿�ܾ��u�����ɮ�
        fileChooser.setMultiSelectionEnabled(false);// �����ܦh���ɮ�
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = fileChooser.getSelectedFile();// ��o�ϥΪ̿�ܪ��ɮ�
            textField.setText(selectFile.getName());// ��ܿ���ɮת�������|
            FileInputStream in = null;
            try {
                in = new FileInputStream(selectFile);// ��o�ɮ׿�J�y
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                md5 = DigestUtils.md5Hex(in);// �p��MD5�ȡA���x�s�b���ܼ�md5��
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    protected void do_md5Button_actionPerformed(ActionEvent arg0) {
        if (md5 == null) {
            JOptionPane.showConfirmDialog(this, "�п�ܭn�p�⪺�ɮ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        messageLabel.setText(md5);
    }
}
