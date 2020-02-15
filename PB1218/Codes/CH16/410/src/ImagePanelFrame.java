import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.widget.BGPanel;
import javax.swing.JButton;

public class ImagePanelFrame extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImagePanelFrame frame = new ImagePanelFrame();
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
    public ImagePanelFrame() {
        setTitle("­I´º¹Ï­±ªO±±¨î¶µ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 413, 492);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        BGPanel panel = new BGPanel();
        panel.setIconFill(BGPanel.BOTH_FILL);
        contentPane.add(panel, BorderLayout.CENTER);
        URL url = getClass().getResource("back.jpg");
        panel.setImage(getToolkit().getImage(url));
        panel.setLayout(null);
        
        JButton button = new JButton("«ö¶s1");
        button.setBounds(6, 227, 90, 30);
        panel.add(button);
        
        JButton button_1 = new JButton("«ö¶s2");
        button_1.setBounds(291, 227, 90, 30);
        panel.add(button_1);
    }
}
