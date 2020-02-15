package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

/**
 * @author ����L
 */
public class LoginFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTextField userName = null;
    private JPasswordField password = null;
    private JButton loginButton = null;
    
    /**
     * �إߨϥΪ̦W�٤�r��
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getUserName() {
        if (userName == null) {
            userName = new JTextField();// �إߤ�r��
            userName.setBackground(new Color(0, 0, 0, 0));// �]�w��r�سz���I����
            // �]�w��r�ئ�m�P�j�p
            userName.setBounds(new Rectangle(70, 26, 162, 21));// �]�w��r�ؤj�p
            MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(0, 250,
                    154));// �إ����
            userName.setBorder(border);// ��ø�s���
        }
        return userName;
    }
    
    /**
     * �إ߱K�X��
     * 
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getPassword() {
        if (password == null) {
            password = new JPasswordField();// �إ߱K�X��
            // �]�w�K�X�ئ�m�M�j�p
            password.setBounds(new Rectangle(71, 57, 159, 22));
            password.setBackground(new Color(0, 0, 0, 0));// �]�w�z���C��
            password.setOpaque(false);// �]�w�z��
            password.setBorder(new MatteBorder(0, 0, 2, 0, new Color(255, 215,
                    0)));// �]�w���
            password.setEchoChar('��');// �]�w�K�X�ئr��
        }
        return password;
    }
    
    /**
     * �إߵn�J���s
     * 
     * @return javax.swing.JButton
     */
    private JButton getLoginButton() {
        if (loginButton == null) {
            loginButton = new JButton("�n�J");
            // �]�w���s��m�P�j�p
            loginButton.setBounds(new Rectangle(244, 22, 68, 68));
        }
        return loginButton;
    }
    
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("��r�ت��U���u���");
        jContentPane = new JPanel();
        // �]�w���餺�e���O
        this.setContentPane(jContentPane);
        // �]�w�G���޲z��
        jContentPane.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(getUserName(), null);// �W�[��r��
        panel.add(getPassword(), null);// �W�[�K�X��
        panel.add(getLoginButton(), null);// �W�[�n�J���s
        jContentPane.add(panel, BorderLayout.CENTER);
        
        JLabel label = new JLabel("�ϥΪ̦W�١G");
        label.setBounds(22, 26, 55, 18);
        panel.add(label);
        
        JLabel label_1 = new JLabel("�K�@�X�G");
        label_1.setBounds(22, 59, 55, 18);
        panel.add(label_1);
        // �]�w����j�p
        setSize(new Dimension(375, 143));
        setLocationRelativeTo(null);// ����~��
    }
}
