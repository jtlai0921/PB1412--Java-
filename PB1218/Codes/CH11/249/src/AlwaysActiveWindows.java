import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AlwaysActiveWindows extends JFrame {
    
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
                    AlwaysActiveWindows frame = new AlwaysActiveWindows();
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
    public AlwaysActiveWindows() {
        setTitle("�l�צb�ୱ�̳��h��ܪ�����");// �]�w������D
        setAlwaysOnTop(true);// �]�w������ܦb�̳��ݡC����Ҫ��֤ߵ{���X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 319, 206);// �]�w�����m
        contentPane = new JPanel();// �إߤ��e���O
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// �]�w���e���O
        JLabel label = new JLabel("�ڴN�b�W�����U�h�F�A�Q�w�C");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);// �W�[���ұ��
    }
    
}
