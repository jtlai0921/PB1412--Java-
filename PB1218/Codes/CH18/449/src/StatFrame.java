import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField pathTextField;
    private JTextArea resultTextArea = new JTextArea();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StatFrame frame = new StatFrame();
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
    public StatFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 371, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("統計txt檔案字符數");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 355, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("選擇檔案：");
        messageLabel.setBounds(0, 22, 70, 22);
        panel.add(messageLabel);
        
        pathTextField = new JTextField();
        pathTextField.setBounds(63, 23, 202, 21);
        panel.add(pathTextField);
        pathTextField.setColumns(10);
        
        JButton chooseButton = new JButton("選擇");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        chooseButton.setBounds(275, 22, 77, 23);
        panel.add(chooseButton);
        
       
        resultTextArea.setBounds(0, 54, 352, 134);
        panel.add(resultTextArea);
    }
    
    // 選擇按鈕的單擊事件方法
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory() + fd.getFile();
        if (filePath.endsWith(".txt")) {
            pathTextField.setText(filePath);
            StatUtil util = new StatUtil();
            int[] sum = util.statis(filePath);
            int number = sum[0];
            int word = sum[1];
            int total = sum[2];
            int sumNumber = sum[3];
            resultTextArea.setText("統計結果為：\n"+"數字總數為："+number+"\n字母數為："+word+"\n英文標點為："+total+"\n總字符數為："+sumNumber);
        }
    }
}
