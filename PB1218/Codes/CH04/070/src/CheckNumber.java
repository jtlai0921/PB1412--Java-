import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.font.NumericShaper;

public class CheckNumber extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckNumber frame = new CheckNumber();
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
    public CheckNumber() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 281, 132);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("��J���B�G");
        label.setBounds(25, 20, 77, 22);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(88, 21, 127, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel label_1 = new JLabel("\u5143");
        label_1.setBounds(225, 24, 54, 15);
        contentPane.add(label_1);
        
        JButton button = new JButton("�P�_");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(98, 61, 93, 23);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// ��o�ϥΪ̿�J�����B�r��
        boolean isnum = NumberUtils.isNumber(text);// �P�_�O���O�Ʀr
        if (isnum) {// ��X���T���ܸ�T
            JOptionPane.showMessageDialog(null, "��J���T�A�O�Ʀr�榡");
        } else {// ��X���~���ܸ�T
            JOptionPane.showMessageDialog(null, "��J���~�A�нT�{�榡�A��J");
        }
    }
}
