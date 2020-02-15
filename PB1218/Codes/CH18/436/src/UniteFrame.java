import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.io.*;

public class UniteFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField savePathtextField;
    private JList fileList;
    Vector<String> vector = new Vector<String>();
    DefaultListModel list = new DefaultListModel();
    List<File> listFile = new ArrayList<File>();
   
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UniteFrame frame = new UniteFrame();
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
    public UniteFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("合併txt檔案");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton choiceButton = new JButton("選擇合併檔案");
        choiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_choiceButton_actionPerformed(arg0);
            }
        });
        choiceButton.setBounds(22, 36, 114, 23);
        panel.add(choiceButton);
        
        JButton saveButton = new JButton("儲存地址");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(22, 187, 114, 23);
        panel.add(saveButton);
        
        savePathtextField = new JTextField();
        savePathtextField.setBounds(152, 188, 228, 21);
        panel.add(savePathtextField);
        savePathtextField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(152, 36, 228, 129);
        panel.add(scrollPane);
        
        fileList = new JList(list);
        
        scrollPane.setViewportView(fileList);
        
        JButton submitbutton = new JButton("確定合併");
        submitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        submitbutton.setBounds(102, 229, 114, 23);
        panel.add(submitbutton);
    }
    
    protected void do_choiceButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this); // 建立選擇檔案交談視窗
        fd.setVisible(true); // 設定窗體為可視狀態
        String filePath = fd.getDirectory() + fd.getFile(); // 獲得使用者選擇的檔案路徑
        if (filePath.endsWith(".txt")) { // 判斷使用者選擇的是否為txt檔案
            list.addElement(fd.getDirectory() + fd.getFile()); // 將使用者選擇的檔案增加到列表中
            listFile.add(new File((fd.getDirectory() + fd.getFile()))); // 將使用者選擇的檔案名增加到集合對像中
        }
    }
    
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        FileDialog saveDialog = new FileDialog(this, "儲存檔案交談視窗", FileDialog.SAVE);
        saveDialog.setVisible(true);
        if (saveDialog.getDirectory() + saveDialog.getFile() != null) {
            savePathtextField.setText(saveDialog.getDirectory()
                    + saveDialog.getFile());
        }
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        UniteFile unitFile = new UniteFile(); // 建立UniteFile對像
        unitFile.writeFiles(listFile, savePathtextField.getText());// 呼叫合併檔案方法
        JOptionPane.showMessageDialog(getContentPane(), "檔案合併成功！", "資訊提示框",
                JOptionPane.WARNING_MESSAGE); // 為使用者提供提示資訊交談視窗
    }
    
}
