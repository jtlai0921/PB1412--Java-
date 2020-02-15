import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.lzw.widget.SmallScrollPanel;
import com.lzw.widget.ButtonPanel;
import javax.swing.UIManager;
import java.awt.Color;

public class PanelFrame extends JFrame {
    
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
                    PanelFrame frame = new PanelFrame();
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
    public PanelFrame() {
        setTitle("�������O���");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 133);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 204, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));// �]�w�G���޲z��
        setContentPane(contentPane);
        // �إߥ������ʭ��O
        SmallScrollPanel smallScrollPanel = new SmallScrollPanel();
        // �W�[���O�쵡��
        contentPane.add(smallScrollPanel, BorderLayout.CENTER);
        ButtonPanel buttonPanel = new ButtonPanel();// �إ߫��s�խ��O
        buttonPanel.setOpaque(false);
        // ����s�խ��O�]�w�ڥ������O���޲z�˵�
        smallScrollPanel.setViewportView(buttonPanel);
    }
    
}
