import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class StringLinewrap extends JFrame {
    
    private JPanel contentPane;
    private JTextArea sourceTextArea;
    private JTextArea destinationTextArea;
    
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
                    StringLinewrap frame = new StringLinewrap();
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
    public StringLinewrap() {
        setTitle("根據標點對字串分行");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 475, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "<html>在下面的文字方塊輸入字串段落，其中要包括（，）標點符號。然後點擊“分行顯示”按鈕，程式將根據（，）符號分行。</html>");
        label.setBorder(new TitledBorder(null, "說明",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        label.setBounds(10, 10, 439, 76);
        contentPane.add(label);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 84, 439, 98);
        contentPane.add(scrollPane);
        
        sourceTextArea = new JTextArea();
        sourceTextArea.setLineWrap(true);
        scrollPane.setViewportView(sourceTextArea);
        
        JButton button = new JButton("分行顯示");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(177, 192, 101, 25);
        contentPane.add(button);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 233, 439, 156);
        contentPane.add(scrollPane_1);
        
        destinationTextArea = new JTextArea();
        scrollPane_1.setViewportView(destinationTextArea);
        
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String sourceString = sourceTextArea.getText();// 獲得使用者輸入字段
        String[] lines = sourceString.split(",|，");// 根據中英文逗號分割字串為陣列
        StringBuilder sbuilder = new StringBuilder();// 建立字串建構器
        for (String line : lines) {// 檢查分割後的字串陣列
            // 把每個陣列元素的字串與確認符相連並增加到字串建構器中
            sbuilder.append(line + "\n");
        }
        // 把字串增加到換行顯示字串的文字域中
        destinationTextArea.setText(sbuilder.toString());
    }
}
