import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameShowException extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameShowException frame = new FrameShowException();
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
    public FrameShowException() {
        setTitle("顯示例外資訊");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 253);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "請輸入非數位字串，檢視轉為數字時發生的例外。");
        label.setBounds(10, 10, 414, 15);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(10, 32, 248, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btninteger = new JButton(
                "轉換為Integer類型");
        btninteger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btninteger_actionPerformed(e);
            }
        });
        btninteger.setBounds(268, 31, 156, 23);
        contentPane.add(btninteger);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        scrollPane.setBounds(10, 63, 414, 142);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setText("資訊提示框");
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_btninteger_actionPerformed(ActionEvent e) {
        // 建立字節陣列輸出流
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(stream));// 重新導向err輸出流
        String numStr = textField.getText();// 獲得使用者輸入
        try {
            Integer value = Integer.valueOf(numStr);// 字串轉整數
        } catch (NumberFormatException e1) {
            e1.printStackTrace();// 輸出錯誤例外資訊
        }
        String info = stream.toString();// 獲得字節輸出流的字串
        if (info.isEmpty()) {// 顯示正常轉換的提示資訊
            textArea.setText("字串到Integer的轉換沒有發生例外。");
        } else {// 顯示出現例外的提示資訊與例外
            textArea.setText("錯錯啦！轉換過程中出現了如下例外錯誤：\n" + info);
        }
    }
}