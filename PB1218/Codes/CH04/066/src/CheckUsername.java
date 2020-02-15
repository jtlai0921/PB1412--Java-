import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckUsername extends JFrame {
    
    private JPanel contentPane;
    private JTextField usernameField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckUsername frame = new CheckUsername();
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
    public CheckUsername() {
        setTitle("��K�X");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 312, 181);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("��K�X");
        label.setBounds(22, 54, 58, 17);
        contentPane.add(label);
        
        usernameField = new JTextField();
        usernameField.setBounds(77, 51, 180, 23);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        
        JButton button = new JButton("�e�X");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(67, 88, 71, 25);
        contentPane.add(button);
        
        JButton button_1 = new JButton("����");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(165, 88, 71, 25);
        contentPane.add(button_1);
        
        JLabel label_1 = new JLabel(
                "<html>��K�X</font>�Τ�W</html>");
        label_1.setBounds(12, 14, 343, 25);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String name = usernameField.getText();// ��o�ϥΪ̿�J
        if (name.equals("admin")) {// �P�_�O�_�޲z���㸹
            JOptionPane.showMessageDialog(null, "�藍�_�A�o�ӨϥΪ̦W�٬O�޲z�����A���O�A��");
        } else if (name.equals("mingri")) {// �P�_�O�_���U�ϥΪ�
            JOptionPane.showMessageDialog(null, "�ӨϥΪ̦W�ٹ������K�X�w�g�o�e����U�ɪ��q�l�l��A�Ьd��");
        } else {// �����~�ϥΪ̦W�٪����ܥ�͵���
            JOptionPane.showMessageDialog(null, "�A��J���ϥΪ̦W�٤��s�b�A�d�NCaps Lock��O�_���U�C");
        }
    }
    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}
