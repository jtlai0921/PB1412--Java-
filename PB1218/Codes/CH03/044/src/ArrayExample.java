import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.UIManager;
import java.awt.Color;

public class ArrayExample extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameField;
    private JTextArea personnelArea;
    private JTextArea resultArea;
    
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
                    ArrayExample frame = new ArrayExample();
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
    public ArrayExample() {
        setTitle("利用陣列選取幸運觀眾");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 498, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel
                .setBorder(new TitledBorder(
                        null,
                        "輸入現在觀眾",
                        TitledBorder.LEADING, TitledBorder.TOP, null,
                        new Color(59, 59, 59)));
        panel.setBounds(10, 10, 174, 242);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 5));
        
        nameField = new JTextField();
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                do_textField_keyPressed(e);
            }
        });
        panel.add(nameField, BorderLayout.NORTH);
        nameField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);
        
        personnelArea = new JTextArea();
        personnelArea.setEditable(false);
        scrollPane.setViewportView(personnelArea);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null,
                "選取觀眾人員",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
                        59)));
        panel_1.setBounds(183, 10, 219, 242);
        contentPane.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane_1 = new JScrollPane();
        panel_1.add(scrollPane_1);
        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        scrollPane_1.setViewportView(resultArea);
        
        JButton button = new JButton("抽取");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(407, 164, 63, 25);
        contentPane.add(button);
        
        JButton button_1 = new JButton("離開");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(407, 215, 63, 25);
        contentPane.add(button_1);
    }
    
    protected void do_textField_keyPressed(KeyEvent e) {
        if (e.getKeyChar() != '\n')// 不是確認字符不做處理
            return;
        String name = nameField.getText();
        if (name.isEmpty())// 如果文字框沒有字串不做處理
            return;
        personnelArea.append(name + "\n");// 把輸入人名與確認符增加到人員列表
        nameField.selectAll();// 選擇文字框所有字符
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String perstring = personnelArea.getText();// 獲得人員列表文字
        String[] personnelArray = perstring.split("\n{1,}");// 獲得人員陣列
        int index = (int) (Math.random() * personnelArray.length);// 產生隨機陣列索引
        // 定義包含格式參數的中獎資訊
        String formatArg = "本次抽取觀眾人員：\n\t%1$s\n恭喜%1$s成為本次觀眾抽獎的大獎得主。"
                + "\n\n我們將為%1$s頒發：\n\t過期的酸奶二十箱。";
        // 為中獎資訊增加人員參數
        String info = String.format(formatArg, personnelArray[index]);
        resultArea.setText(info);// 在文字域顯示中間資訊
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}
