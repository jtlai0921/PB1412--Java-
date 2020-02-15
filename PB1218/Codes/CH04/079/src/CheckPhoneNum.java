import static javax.swing.JOptionPane.showMessageDialog;

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
import javax.swing.UIManager;

public class CheckPhoneNum extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckPhoneNum frame = new CheckPhoneNum();
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
    public CheckPhoneNum() {
        setTitle("�P�_��������X�k��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 191);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "<html>����벼������ʡA�бN�z��������X��J��t�Τ��A�ڭ̷|�ھ��H�������������X�ӽT�w���N�H���C</html>");
        label.setBounds(12, 14, 410, 48);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel(
                "��J������X�G");
        label_1.setBounds(12, 76, 100, 15);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setBounds(124, 76, 298, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(165, 111, 93, 23);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// ��o�ϥΪ̿�J���X
        String regex = "^13\\d{9}|15\\d{9}|18\\d{9}$";// �w�q���h���F��
        if (text.matches(regex)) {// ���դ�ﵲ�G
            showMessageDialog(null, text + " �O�X�k�������");// ���ܦX�k������X
        } else {
            showMessageDialog(null, text + " ���O�X�k�������");// ���ܫD�k������X
        }
    }
}
