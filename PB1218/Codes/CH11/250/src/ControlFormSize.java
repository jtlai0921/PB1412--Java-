import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ControlFormSize extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControlFormSize frame = new ControlFormSize();
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
    public ControlFormSize() {
        setTitle("�]�w����j�p");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �w�]�����覡
        setSize(400, 300);// �]�w����j�p
        contentPane = new JPanel();// �إߤ��e���O
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// �]�w���e���O
        JLabel label = new JLabel("�e�סG400�A���סG300");// �إ߼��ұ��
        contentPane.add(label, BorderLayout.CENTER);// �W�[���ұ���쵡��
    }
    
}
