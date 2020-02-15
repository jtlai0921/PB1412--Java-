import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

public class SplitFrame extends JFrame {
    
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
                    SplitFrame frame = new SplitFrame();
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
    public SplitFrame() {
        setTitle("���Ϊ�����ɭ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JSplitPane splitPane = new JSplitPane();// �إߤ��έ��O
        splitPane.setResizeWeight(0.5);// �]�w���O������t���ʤ���
        splitPane.setContinuousLayout(true);// �s��G�����έ��O
        contentPane.add(splitPane, BorderLayout.CENTER);
        // �إ߭I�����O
        BGPanel panel = new BGPanel();
        panel.setIconFill(BGPanel.BOTH_FILL);// �I�����V��R
        // �]�w�I���Ϥ�
        panel.setImage(getToolkit().getImage(
                getClass().getResource("photo1.jpg")));// �]�w�I���Ϥ�
        splitPane.setLeftComponent(panel);
        // �إ߭I�����O
        BGPanel panel_1 = new BGPanel();
        panel_1.setIconFill(BGPanel.BOTH_FILL);// �I�����V��R
        panel_1.setImage(getToolkit().getImage(
                getClass().getResource("photo2.jpg")));// �]�w�I���Ϥ�
        splitPane.setRightComponent(panel_1);
    }
    
}
