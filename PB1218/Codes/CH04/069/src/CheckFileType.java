import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckFileType extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    CheckFileType frame = new CheckFileType();
                    frame.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the frame.
     */
    public CheckFileType() {
        setTitle("檔案類型");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 143);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("選擇檔案");
        label.setBounds(10, 10, 84, 15);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(88, 2, 289, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("瀏覽");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(389, 2, 90, 30);
        contentPane.add(button);
        
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBounds(83, 37, 396, 60);
        contentPane.add(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Scanner scan = new Scanner(getClass()// 獲得說明檔案的掃瞄器
                .getResourceAsStream("extName.inf"));
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        boolean searched = false;
        int option = chooser.showOpenDialog(this);// 開啟檔案選擇交談視窗
        if (option == JFileChooser.APPROVE_OPTION) {// 如果正確選擇檔案
            File file = chooser.getSelectedFile();// 獲得使用者選擇檔案
            textField.setText(file.getName());// 把檔案名增加到文字框
            String name = file.getName();// 獲得檔案名
            while (scan.hasNextLine()) {// 檢查說明檔案
                String line = scan.nextLine();// 獲得一行說明資訊
                String[] extInfo = line.split("\t");// 把單行說明資訊拆分成陣列
                // 陣列第一個元素是檔案擴充名，與使用者選擇檔案名比較
                if (name.endsWith(extInfo[0])) {
                    // 第二個陣列元素是檔案型態的說明資訊，增加到文字域控制項中
                    textArea.setText(extInfo[1]);
                    searched = true;
                }
            }
            scan.close();// 關閉掃瞄器
        }
        if (!searched) {// 如果沒找到相關檔案型態的說明，則提示使用者
            textArea.setText("你選擇的檔案型態沒有對應記錄，你可以在extName.info檔案中增加該型態的描述。");
        }
    }
}
