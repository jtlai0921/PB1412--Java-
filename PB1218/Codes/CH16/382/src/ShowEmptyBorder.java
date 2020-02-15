import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ShowEmptyBorder extends JFrame {
    
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
                    ShowEmptyBorder frame = new ShowEmptyBorder();
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
    public ShowEmptyBorder() {
        setTitle("實現按鈕控件邊框留白");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 328, 336);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton button = new JButton("示範按鈕");
        button.setBorder(new EmptyBorder(40, 0, 0, 0));// 頂部留白：40pix
        button.setBounds(19, 106, 109, 64);
        contentPane.add(button);
        
        JButton button_1 = new JButton("示範按鈕");
        button_1.setBorder(new EmptyBorder(0, 40, 0, 0));// 左側留白：40pix
        button_1.setBounds(177, 14, 109, 64);
        contentPane.add(button_1);
        
        JButton button_2 = new JButton("示範按鈕");
        button_2.setBorder(new EmptyBorder(0, 0, 0, 40));// 右側留白：40pix
        button_2.setBounds(19, 14, 109, 64);
        contentPane.add(button_2);
        
        JButton button_3 = new JButton("示範按鈕");
        button_3.setBorder(new EmptyBorder(0, 0, 40, 0));// 底部留白：40pix
        button_3.setBounds(177, 106, 109, 64);
        contentPane.add(button_3);
        
        JButton button_4 = new JButton("示範按鈕");
        button_4.setBorder(new EmptyBorder(0, 0, 40, 40));// 右側和底部留白：40pix
        button_4.setBounds(19, 201, 109, 64);
        contentPane.add(button_4);
        
        JButton button_5 = new JButton("示範按鈕");
        button_5.setBorder(new EmptyBorder(40, 40, 0, 0));// 左側和頂部留白：40pix
        button_5.setBounds(177, 198, 109, 64);
        contentPane.add(button_5);
        
        JLabel lblpix = new JLabel("右側留白：40pix");
        lblpix.setHorizontalAlignment(SwingConstants.CENTER);
        lblpix.setBounds(19, 76, 109, 18);
        contentPane.add(lblpix);
        
        JLabel lblpix_4 = new JLabel(
                "右側和底部留白：40pix");
        lblpix_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblpix_4.setBounds(6, 263, 134, 18);
        contentPane.add(lblpix_4);
        
        JLabel lblpix_5 = new JLabel(
                "左側和頂部留白：40pix");
        lblpix_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblpix_5.setBounds(161, 263, 145, 18);
        contentPane.add(lblpix_5);
        
        JLabel lblpix_1 = new JLabel("左側留白：40pix");
        lblpix_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblpix_1.setBounds(177, 76, 109, 18);
        contentPane.add(lblpix_1);
        
        JLabel lblpix_2 = new JLabel("頂部留白：40pix");
        lblpix_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblpix_2.setBounds(19, 171, 109, 18);
        contentPane.add(lblpix_2);
        
        JLabel lblpix_3 = new JLabel("底部留白：40pix");
        lblpix_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblpix_3.setBounds(177, 171, 109, 18);
        contentPane.add(lblpix_3);
        
    }
}
