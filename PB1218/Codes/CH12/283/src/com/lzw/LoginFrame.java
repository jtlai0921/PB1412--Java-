package com.lzw;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import com.lzw.login.ProgressPanel;
import javax.swing.UIManager;

/**
 * @author ����L
 */
public class LoginFrame extends JFrame {
    
    /**
     * �n�J���s���ƥ��ť��
     * 
     * @author ����L
     */
    private final class LoginActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // ��ܵ��骺�n�J�i�׭��O
            getGlassPane().setVisible(true);
        }
    }
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private ProgressPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;
    
    /**
     * �D���O���J�f��k
     * 
     * @param args
     * @throws UnsupportedLookAndFeelException
     *             ���䴩���~�[
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
    
    /**
     * �n�J���骺�غc��k
     */
    public LoginFrame() {
        super();
        // �إߵn�J�i�׭��O
        panel = new ProgressPanel();
        // ��n�J�i�׭��O�]�w�����鳻�h
        setGlassPane(panel);
        jContentPane = new JPanel();
        this.setContentPane(jContentPane);
        jContentPane.setLayout(null);
        
        JLabel label = new JLabel("XX�n�J����");
        label.setFont(new Font("SansSerif", Font.PLAIN, 28));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 386, 44);
        jContentPane.add(label);
        
        JLabel label_1 = new JLabel("�ϥΪ̦W�١G");
        label_1.setBounds(38, 75, 55, 18);
        jContentPane.add(label_1);
        
        JLabel label_2 = new JLabel("�K�@�X�G");
        label_2.setBounds(38, 115, 55, 18);
        jContentPane.add(label_2);
        
        textField = new JTextField();
        textField.setBounds(105, 69, 168, 30);
        jContentPane.add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(105, 109, 168, 30);
        jContentPane.add(passwordField);
        
        button = new JButton("�n�J");
        button.setBounds(287, 62, 90, 71);
        button.addActionListener(new LoginActionListener());
        jContentPane.add(button);
        // �]�w����j�p
        setSize(new Dimension(414, 243));
        setLocationRelativeTo(null);// ����~��
    }
}
