import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AutoImageSizeByForm extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AutoImageSizeByForm frame = new AutoImageSizeByForm();
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
    public AutoImageSizeByForm() {
        setTitle("�ϭI���Ϥ��۰ʾA�����骺�j�p");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// �]�w�����m
        contentPane = new JPanel();// �إߤ��e���O
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        // �إߦ۩w�q�I�����O
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setImage(getToolkit().getImage(
                getClass().getResource("Penguins.jpg")));// �]�w�I�����O���Ϥ�
        contentPane.add(backgroundPanel, BorderLayout.CENTER);// �W�[�I�����O�줺�e���O
    }
    
}
