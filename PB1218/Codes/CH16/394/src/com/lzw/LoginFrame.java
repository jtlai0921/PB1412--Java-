package com.lzw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lzw.login.LoginPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

/**
 * @author ����L
 */
public class LoginFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private LoginPanel loginPanel = null;
    private JTextField textField;
    private JPasswordField passwordField;
    
    /**
     * �D���O���J�f��k
     * 
     * @param args
     * @throws UnsupportedLookAndFeelException
     *             ���䴩���~�[
     */
    public static void main(String[] args)
            throws UnsupportedLookAndFeelException {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // �]�w����~�[
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // �إߵn�J����
                LoginFrame loginFrame = new LoginFrame();
                // ��ܵn�J����
                loginFrame.setVisible(true);
            }
        });
    }
    
    /**
     * �n�J���骺�غc��k
     */
    public LoginFrame() {
        super();
        setTitle("�ϥιϤ��s�@���R���s");
        // �]�w���餺�e���O
        jContentPane = new JPanel();
        // �]�w�G���޲z��
        jContentPane.setLayout(new BorderLayout());
        loginPanel = new LoginPanel();
        loginPanel.setLayout(null);
        JButton loginButton = new JButton();
        loginButton.setBounds(266, 81, 68, 68);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        // �]�w���s�ϼ�
        loginButton.setIcon(new ImageIcon(getClass().getResource(
                "/com/lzw/logBut1.png")));
        loginButton.setContentAreaFilled(false);
        // �]�w���s���U�ʧ@���ϼ�
        loginButton.setPressedIcon(new ImageIcon(getClass().getResource(
                "/com/lzw/logBut2.png")));
        // �]�w���иg�L���s���ϼ�
        loginButton.setRolloverIcon(new ImageIcon(getClass().getResource(
                "/com/lzw/logBut3.png")));
        // �W�[���s�ƥ��ť��
        loginPanel.add(loginButton);// �W�[�n�J���s
        
        textField = new JTextField();// �إߤ�r��
        textField.setBounds(94, 81, 155, 30);
        loginPanel.add(textField);// �W�[��r�ب쵡��
        
        passwordField = new JPasswordField();// �إ߱K�X��
        passwordField.setBounds(94, 113, 155, 30);
        loginPanel.add(passwordField);// �W�[�K�X�ب쵡��
        // �W�[�n�J���O�줺�e���O
        jContentPane.add(loginPanel, BorderLayout.CENTER);
        this.setContentPane(jContentPane);
        // �]�w����j�p
        setSize(new Dimension(513, 248));// �I�s��l�Ƭɭ�����k
        setLocationRelativeTo(null);// ����~��
    }
}
