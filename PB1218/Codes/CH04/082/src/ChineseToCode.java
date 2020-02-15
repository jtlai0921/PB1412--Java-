import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class ChineseToCode extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField resultField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChineseToCode frame = new ChineseToCode();
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
    public ChineseToCode() {
        setTitle("����r�P�Ϧ�X���ഫ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 321, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("��J�@�Ӥ���r�G");
        label.setBounds(21, 10, 103, 15);
        contentPane.add(label);
        
        JButton button = new JButton("�ഫ���Ϧ�X");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(21, 48, 103, 23);
        contentPane.add(button);
        
        textField = new JTextField();
        textField.setBounds(134, 2, 161, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        resultField = new JTextField();
        resultField.setBounds(134, 45, 161, 30);
        contentPane.add(resultField);
        resultField.setColumns(10);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// ��o�ϥΪ̿�J
        if (text.length() > 2) {// �T���J�h�Ӥ���r
            JOptionPane.showMessageDialog(null, "���n��J�L�h����r");
            return;
        }
        byte[] codeBit = text.getBytes();// ��o����r���r�`�}�C
        if (codeBit.length < 2) {// �T��D����r���ϽX��o
            JOptionPane.showMessageDialog(null, "�z��J���n�����O����r");
            return;
        }
        codeBit[0] -= 160;// ���R�r�`�������ϽX
        codeBit[1] -= 160;
        // �զX�̲װϽX�s��
        String code = formatNumber(codeBit[0]) + formatNumber(codeBit[1]);
        resultField.setText(code);// �b��r����ܤ���r���ϽX
    }
    
    /**
     * �O�d�Ʀr��ƪ��r��榡
     * 
     * @param num
     * @return
     */
    private String formatNumber(int num) {
        String format = String.format("%02d", num);// �Ʀr���ɹs�榡
        return format;// �Ǧ^�榡�ƫ᪺�r��
    }
}
