import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class CancelFrameTitleBorder extends JFrame {
    
    private JPanel contentPane;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CancelFrameTitleBorder frame = new CancelFrameTitleBorder();
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
public CancelFrameTitleBorder() {
    // �]�w�I����
    getContentPane().setBackground(new Color(240, 255, 255));
    setUndecorated(true);// ��������׹��ĪG************
    setTitle("����i�P�s�޲z�t��");// �]�w���D��
    getContentPane().setLayout(null);
    setBounds(100, 100, 354, 206);
    setLocationRelativeTo(null);// ����~��
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JLabel label = new JLabel();// �μ������logo
    label.setIcon(new ImageIcon(getClass().getResource("logo.png")));
    label.setBounds(10, 27, 112, 98);
    getContentPane().add(label);
    textArea = new JTextArea();// �Τ�r����ܨt�θ�T
    textArea.setOpaque(false);// ����z��
    textArea.setText("�t�ΡG\n  Microsoft Windows Server 2003\n" +
            "  Standard Editon\n  Service Pack 2\n\n\n" +
            "�n��G�i�P�s�޲z�t��\n���v�G������");
    textArea.setBounds(154, 6, 187, 154);
    getContentPane().add(textArea);// �W�[����쵡��
    JButton button = new JButton("����");// �إߡu�����v���s
    button.addActionListener(new ActionListener() {// �W�[���s���ƥ��ť��
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// �I�s���s�ƥ�B�z��k
        }
    });
    button.setBounds(230, 172, 90, 30);
    getContentPane().add(button);// �W�[���s�쵡��
}
    
protected void do_button_actionPerformed(ActionEvent e) {
    dispose();// �P������
}
}
