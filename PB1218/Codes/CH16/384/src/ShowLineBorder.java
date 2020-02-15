import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ShowLineBorder extends JFrame {
    
    private JPanel contentPane;
    
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
                    ShowLineBorder frame = new ShowLineBorder();
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
    public ShowLineBorder() {
        setTitle("���奻�ر���K�[LineBorder�u�����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 368, 249);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));
        JTextArea textArea = new JTextArea();// �إ߹w�]��ت���r�챱�
        textArea.setText("�w�]��r�챱��~�[");
        contentPane.add(textArea);
        JTextArea textArea_1 = new JTextArea();// �إߤ�r�챱�
        textArea_1.setText("�ꨤ���u��ت���r�챱�");
        // �]�w�w�]�C�⪺�ꨤ���u���
        textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
        contentPane.add(textArea_1);
        JTextArea textArea_2 = new JTextArea();// �إߤ�r�챱�
        textArea_2.setText("������⪽�u��ت���r�챱��~�[");
        // �]�w��⪺�������u���
        textArea_2.setBorder(new LineBorder(Color.GREEN, 5));
        contentPane.add(textArea_2);
    }
}
