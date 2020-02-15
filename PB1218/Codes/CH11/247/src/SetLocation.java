import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.NumberFormat;

public class SetLocation extends JFrame {
    
    private JPanel contentPane;
    private JFormattedTextField leftField;
    private JFormattedTextField topField;
    
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
                    SetLocation frame = new SetLocation();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        File file = new File("ac.txt");
    }
    
    /**
     * Create the frame.
     */
    public SetLocation() {
        setTitle("設置窗體在屏幕中的位置");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 295, 157);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("左邊距：");
        label.setBounds(6, 12, 55, 18);
        contentPane.add(label);
        
        leftField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        leftField.setBounds(69, 6, 204, 30);
        contentPane.add(leftField);
        leftField.setColumns(10);
        
        JLabel label_1 = new JLabel("上邊距：");
        label_1.setBounds(6, 42, 55, 18);
        contentPane.add(label_1);
        
        topField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        topField.setBounds(69, 36, 204, 30);
        contentPane.add(topField);
        topField.setColumns(10);
        
        JButton button = new JButton("設置");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(97, 83, 90, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Object value = leftField.getValue();// 獲得左邊距座標文字
        Object value2 = topField.getValue();// 獲得上邊距座標文字
        if (value == null || value2 == null)
            return;
        int left = ((Number) value).intValue();// 分析左邊距座標值
        int top = ((Number) value2).intValue();// 分析上邊距座標值
        setLocation(left, top);// 用左邊距和上邊距座標值設定窗體位置
    }
}
