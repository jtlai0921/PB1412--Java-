import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class CompositorFrame extends JFrame {    
    /**
     * 
     */
    private static final long serialVersionUID = 6958862396834653216L;
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CompositorFrame frame = new CompositorFrame();
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
    public CompositorFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("½sµ{µü¨å¾P¶q±Æ¦æ");
        messageLabel.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 14));
        messageLabel.setBounds(152, 29, 132, 15);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 68, 339, 159);
        panel.add(scrollPane);
        Compositor compositor = new Compositor();
        List list = compositor.getBccdSell();
        for(int i = 0;i<list.size();i++){
            Bccd bccd = (Bccd)list.get(i);
            model.addRow(new Object[]{bccd.getBccdName(),bccd.getBccdCount()});
        }
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
}
