import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.UIManager;


public class NimbusLookAndFeelFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    
    /**
     * Launch the application.
     */
public static void main(String[] args) {
    try {
        // 設定窗體的外觀樣式
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // 建立窗體對像
                NimbusLookAndFeelFrame frame = new NimbusLookAndFeelFrame();
                frame.setVisible(true);// 顯示窗體
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}
    
    /**
     * Create the frame.
     */
    public NimbusLookAndFeelFrame() {
        setTitle("Nimbus外觀");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 193);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("數字A：");
        label.setBounds(6, 43, 55, 18);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("數字B：");
        label_1.setBounds(6, 79, 55, 18);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setText("10");
        textField.setBounds(51, 37, 95, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setText("15");
        textField_1.setBounds(51, 73, 95, 30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton button = new JButton("加法運算");
        button.setBounds(158, 43, 90, 54);
        contentPane.add(button);
        
        JLabel label_2 = new JLabel("結果：");
        label_2.setBounds(260, 61, 55, 18);
        contentPane.add(label_2);
        
        textField_2 = new JTextField();
        textField_2.setText("25");
        textField_2.setBounds(306, 55, 122, 30);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JCheckBox checkBox = new JCheckBox("在窗體中顯示結果");
        checkBox.setSelected(true);
        checkBox.setBounds(42, 115, 122, 18);
        contentPane.add(checkBox);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setBounds(278, 114, 150, 19);
        contentPane.add(progressBar);
        
        JLabel label_3 = new JLabel("正在計算");
        label_3.setBounds(215, 115, 55, 18);
        contentPane.add(label_3);
    }
}
