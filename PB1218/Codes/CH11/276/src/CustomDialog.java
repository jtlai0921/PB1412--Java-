import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CustomDialog extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomDialog frame = new CustomDialog();
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
    public CustomDialog() {
        setTitle("�w�s�H����ܮ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 364, 179);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton button = new JButton("�i�J�t��");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(222, 98, 90, 30);
        contentPane.add(button);
        
        JLabel label = new JLabel(
                "�`��y��޲z�t��");
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 324, 34);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel(
                "���T�^�����D�A�N�i�H�i�J���t�ΡC");
        label_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label_1.setBounds(16, 52, 261, 34);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        // ��͵����ާ@�����W��
        String[] options = new String[] { "7��1��", "8��1��", "5��1��", "10��1��" };
        String message = "�ڰꪺ�حx�`�O�C�~���X��X��H";// ��͵���������T
        int num = JOptionPane.showOptionDialog(this, message, "��¦�Ҹ�",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, "8��1��");// ��ܦ۩w�q��͵���
        if (options[num].equals("8��1��")) {
            JOptionPane.showMessageDialog(this, "���߱z�^�����T�C");// �^�����T������
        } else {
            JOptionPane.showMessageDialog(this, "�^�����~�A�A���C");// �^�����~������
        }
    }
}
