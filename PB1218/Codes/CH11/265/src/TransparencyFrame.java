import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.sun.awt.AWTUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class TransparencyFrame extends JFrame {
    
    private JPanel contentPane;
    private JSlider slider;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TransparencyFrame frame = new TransparencyFrame();
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
    public TransparencyFrame() {
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 400, 440);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        URL resource = getClass().getResource("photo6.jpg");
        Image image = getToolkit().getImage(resource);
        backgroundPanel.setImage(image);
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        
        JLabel label = new JLabel("\u900F\u660E\u5EA6\uFF1A");
        label.setBounds(6, 372, 55, 18);
        backgroundPanel.add(label);
        
        slider = new JSlider();
        slider.setValue(100);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                do_slider_stateChanged(e);
            }
        });
        slider.setOpaque(false);
        slider.setBounds(59, 372, 200, 16);
        backgroundPanel.add(slider);
    }
    
    @SuppressWarnings("restriction")
    protected void do_slider_stateChanged(ChangeEvent e) {
        int value = slider.getValue();// 獲得滑動區塊目前值
        AWTUtilities.setWindowOpacity(this, value / 100f);// 使用滑動區塊值改變窗體透明度
    }
}
