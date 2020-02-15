import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReverseString extends JFrame {
    
    private JPanel contentPane;
    private JTextArea sourceArea;
    private JTextArea destinationArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReverseString frame = new ReverseString();
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
    public ReverseString() {
        setTitle("將字串的每個字元進行倒序輸出");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 155, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);
        
        JLabel label = new JLabel("輸入字串：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.WEST;
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPane.add(scrollPane, gbc_scrollPane);
        
        sourceArea = new JTextArea();
        sourceArea.setLineWrap(true);
        scrollPane.setViewportView(sourceArea);
        
        JButton button = new JButton("反轉");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 2;
        contentPane.add(button, gbc_button);
        
        JLabel label_1 = new JLabel("反轉結果：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.WEST;
        gbc_label_1.insets = new Insets(0, 0, 5, 0);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 3;
        contentPane.add(label_1, gbc_label_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 0;
        gbc_scrollPane_1.gridy = 4;
        contentPane.add(scrollPane_1, gbc_scrollPane_1);
        
        destinationArea = new JTextArea();
        destinationArea.setLineWrap(true);
        scrollPane_1.setViewportView(destinationArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = sourceArea.getText();// 獲得使用者輸入
        StringBuilder sbuilder = new StringBuilder(text);// 建立建構器包含使用者輸入
        StringBuilder reverse = sbuilder.reverse();// 呼叫反轉方法獲得反轉後的建構器
        String reverseText = reverse.toString();// 從建構器獲得反轉的字串
        destinationArea.setText(reverseText);// 把翻轉後的結果增加到文字域中
    }
}
