import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowTitleBorder extends JFrame {
    
    private JPanel contentPane;
    private ButtonGroup bg;
    private Font font = null;
    private TitledBorder titledBorder;
    private JPanel panel;
    
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
                    ShowTitleBorder frame = new ShowTitleBorder();
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
    public ShowTitleBorder() {
        setTitle("���w�r�骺���D���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 322, 221);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        panel = new JPanel();// �إ߭��O
        font = new Font("����", Font.BOLD, 18);// ��l�Ʀr��ﹳ
        titledBorder = new TitledBorder(null, "�۩w�q�r����D", TitledBorder.LEADING,
                TitledBorder.TOP, font, new Color(255, 0, 0));// �إ߼��D��عﹳ
        panel.setBorder(titledBorder);// �]�w���O�����
        contentPane.add(panel);
        panel.setLayout(null);
        
        JRadioButton radioButton = new JRadioButton("����");// �إ߶�������s
        radioButton.setActionCommand(radioButton.getText());
        radioButton.setSelected(true);// �w�]����ܪ��A
        radioButton.setBounds(14, 31, 104, 32);
        panel.add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("�ө���");// �إ߲ө�������s
        radioButton_1.setActionCommand(radioButton_1.getText());
        radioButton_1.setBounds(14, 63, 104, 32);
        panel.add(radioButton_1);
        
        JRadioButton radioButton_2 = new JRadioButton("����");// �إ����ѳ����s
        radioButton_2.setActionCommand(radioButton_2.getText());
        radioButton_2.setBounds(14, 95, 104, 32);
        panel.add(radioButton_2);
        
        JRadioButton radioButton_3 = new JRadioButton("�駺");// �إߥ駺�����s
        radioButton_3.setActionCommand(radioButton_3.getText());
        radioButton_3.setBounds(14, 127, 104, 32);
        panel.add(radioButton_3);
        
        bg = new ButtonGroup();// �إ߫��s��
        bg.add(radioButton);// ��4�ӳ����s�W�[����s�դ�
        bg.add(radioButton_1);
        bg.add(radioButton_2);
        bg.add(radioButton_3);
        
        JButton button = new JButton("�]�w");// �إ߳]�w���s
        button.addActionListener(new ActionListener() {// ���]�w���s�W�[�ƥ��ť��
                    public void actionPerformed(ActionEvent e) {
                        do_button_actionPerformed(e);
                    }
                });
        button.setBounds(161, 128, 90, 30);
        panel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        // ��o�Q��ܪ������s����r
        String command = bg.getSelection().getActionCommand();
        font = new Font(command, Font.BOLD, 18);// �إ߷s�r��ﹳ
        titledBorder.setTitleFont(font);// ����عﹳ�]�w�r��
        panel.setBorder(titledBorder);// ��s���O����عﹳ
        panel.repaint();// ��s���O�ɭ�
    }
}
