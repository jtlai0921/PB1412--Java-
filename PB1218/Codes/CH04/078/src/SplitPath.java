import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SplitPath extends JFrame {
    
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
                    SplitPath frame = new SplitPath();
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
    public SplitPath() {
        setTitle("從字串中分離檔案路徑、檔案名及副檔名");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 408, 252);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(10, 0));
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("選擇檔案");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button, BorderLayout.EAST);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(null, "檔案資訊",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        scrollPane.setOpaque(false);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        int option = chooser.showOpenDialog(this);// 顯示檔案開啟交談視窗
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();// 獲得使用者選擇的檔案
            String path = file.getAbsolutePath();// 獲得檔案絕對路徑
            textField.setText(path);// 跟新路經資訊到文字框
            int splitIndex = path.lastIndexOf("\\");// 檔案分隔符索引
            int typeIndex = path.lastIndexOf(".");// 檔案型態分割符索引
            if (typeIndex < 0)
                typeIndex = path.length();
            String filePath = path.substring(0, splitIndex);// 截取路徑
            String fileName = path.substring(splitIndex + 1, typeIndex);// 截取檔案名
            String extName = path.substring(typeIndex);// 截取擴充名
            textArea.setText("");// 清空文字域
            textArea.append("檔案名稱：" + fileName + "\n");// 增加檔案名資訊到文字域
            textArea.append("擴充名稱：" + extName + "\n");// 增加擴充名資訊到文字域
            textArea.append("檔案路徑：" + filePath + "\n");// 增加檔案路徑資訊到文字域
        }
    }
}
