import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.text.NumberFormat;

public class CharacterASCII extends JFrame {
    
    private JPanel contentPane;
    private JTextField charInputField;
    private JTextField codeOutputField;
    private JFormattedTextField codeInputField;
    private JTextField charOutputField;
    
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
                    CharacterASCII frame = new CharacterASCII();
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
    public CharacterASCII() {
        setTitle("編碼轉換");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 171);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null,
                "Unicode轉換",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
                        59)));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 3, 5, 20));
        
        charInputField = new JTextField();
        panel.add(charInputField);
        charInputField.setColumns(10);
        
        JButton codeButton = new JButton("ASCII");
        codeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_codeButton_actionPerformed(e);
            }
        });
        panel.add(codeButton);
        
        codeOutputField = new JTextField();
        codeOutputField.setEditable(false);
        panel.add(codeOutputField);
        codeOutputField.setColumns(10);
        
        codeInputField = new JFormattedTextField(NumberFormat
                .getIntegerInstance());
        panel.add(codeInputField);
        codeInputField.setColumns(10);
        
        JButton charButton = new JButton("轉字元");
        charButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_charButton_actionPerformed(e);
            }
        });
        panel.add(charButton);
        
        charOutputField = new JTextField();
        charOutputField.setEditable(false);
        panel.add(charOutputField);
        charOutputField.setColumns(10);
    }
    
    protected void do_codeButton_actionPerformed(ActionEvent e) {
        String text = charInputField.getText();// 獲得使用者輸入的字串
        char[] charArray = text.toCharArray();// 獲得字串的字符陣列
        StringBuilder builder = new StringBuilder();// 建立字串建構器
        for (char c : charArray) {// 檢查字符陣列
            builder.append((int) c + " ");// 連接各字符的寫程式
        }
        codeOutputField.setText(builder.toString());// 結果輸出到文字框
    }
    
    protected void do_charButton_actionPerformed(ActionEvent e) {
        Number value = (Number) codeInputField.getValue();// 獲得使用者輸入Unicode寫程式
        long code = value.longValue();// 取輸入數字的Long型態值
        charOutputField.setText(((char) code) + "");// 輸出寫程式到文字框
    }
}
