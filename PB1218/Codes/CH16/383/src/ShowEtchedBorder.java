import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;

public class ShowEtchedBorder extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowEtchedBorder frame = new ShowEtchedBorder();
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
    public ShowEtchedBorder() {
        setTitle("實現文本域控件的蝕化邊框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 357, 235);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 2, 10, 10));
        
        JTextArea label = new JTextArea();// 建立文字域控制項
        // 設定陰刻浮雕化邊框
        label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(label);
        
        JTextArea label_1 = new JTextArea();
        // 設定陽刻浮雕化邊框
        label_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        contentPane.add(label_1);
        
        JTextArea label_3 = new JTextArea();
        // 設定陽刻浮雕化邊框並指定反白顯示和陰影顏色
        label_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED,
                Color.GREEN));
        contentPane.add(label_3);
        
        JTextArea label_2 = new JTextArea();
        // 設定陽刻浮雕化邊框並指定反白顯示和陰影顏色
        label_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED,
                Color.GREEN));
        contentPane.add(label_2);
    }
}
