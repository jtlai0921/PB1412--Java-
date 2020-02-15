import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SortArray extends JFrame {
    
    private JPanel contentPane;
    private JTextField arrayField;
    private JTextArea sortArea;
    
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
                    SortArray frame = new SortArray();
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
    public SortArray() {
        setTitle("用sort排序陣列");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "輸入內容，以空格分隔");
        label.setBounds(6, 6, 265, 18);
        contentPane.add(label);
        
        arrayField = new JTextField();
        arrayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                String mask = "0123456789 " + (char) 8;
                if (mask.indexOf(key) == -1) {
                    e.consume();
                }
            }
            
        });
        arrayField.setBounds(6, 36, 422, 30);
        contentPane.add(arrayField);
        arrayField.setColumns(10);
        
        JButton button = new JButton("\u6392\u5E8F");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(164, 78, 90, 30);
        contentPane.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 118, 422, 138);
        contentPane.add(scrollPane);
        
        sortArea = new JTextArea();
        sortArea.setLineWrap(true);
        scrollPane.setViewportView(sortArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = arrayField.getText();// 獲得使用者輸入
        String[] arrayStr = text.split(" {1,}");// 拆分輸入為陣列
        int[] array = new int[arrayStr.length];// 建立整數型態陣列
        sortArea.setText("陣列原有內容：\n");
        for (String string : arrayStr) {// 輸出原有陣列內容
            sortArea.append(string + "    ");
        }
        for (int i = 0; i < array.length; i++) {// 初始化整形陣列
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        sortArea.append("\n");
        Arrays.sort(array);// 使用sort方法對整形陣列進行排序
        sortArea.append("陣列排序後的內容：\n");
        for (int value : array) {// 輸出排序後的陣列內容
            sortArea.append(value + "    ");
        }
    }
    
    protected void do_arrayField_keyPressed(KeyEvent e) {
        char key = e.getKeyChar();// 獲得使用者按鍵字符
        String mask = "0123456789 " + (char) 8;// 定義規範化字符模板
        if (mask.indexOf(key) == -1) {// 判斷按鍵字符是否屬於規範化字符範圍
            e.consume();// 取消非規範化字符的輸入有效性
        }
    }
}
