import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
public class CopyFileFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField filePathTextField;
    private JTextField saveTextField;
    JComboBox typeComboBox;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CopyFileFrame frame = new CopyFileFrame();
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
    public CopyFileFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("複製指定格式的檔案");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel filePathLabel = new JLabel("檔案地址：");
        filePathLabel.setBounds(35, 46, 66, 15);
        panel.add(filePathLabel);
        
        filePathTextField = new JTextField();
        filePathTextField.setBounds(108, 43, 208, 21);
        panel.add(filePathTextField);
        filePathTextField.setColumns(10);
        
        JButton choiceButton = new JButton("選擇");
        choiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_choiceButton_actionPerformed(arg0);
            }
        });
        choiceButton.setBounds(331, 42, 66, 23);
        panel.add(choiceButton);
        
        JLabel saveLabel = new JLabel("儲存地址：");
        saveLabel.setBounds(35, 101, 66, 15);
        panel.add(saveLabel);
        
        saveTextField = new JTextField();
        saveTextField.setBounds(108, 98, 208, 21);
        panel.add(saveTextField);
        saveTextField.setColumns(10);
        
        JButton saveButton = new JButton("選擇");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(331, 97, 66, 23);
        panel.add(saveButton);
        
        JLabel typeLabel = new JLabel("檔案型態：");
        typeLabel.setBounds(35, 157, 66, 15);
        panel.add(typeLabel);
        String types[] = {".doc",".txt",".jpg"};
        typeComboBox = new JComboBox(types);
        typeComboBox.setBounds(111, 154, 85, 21);
        panel.add(typeComboBox);
        
        JButton copyButton = new JButton("複製");
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_copyButton_actionPerformed(arg0);
            }
        });
        copyButton.setBounds(331, 157, 66, 23);
        panel.add(copyButton);
        
    }
    //定義獲得只可以選擇檔案夾的選擇框
    public JFileChooser getChooser() {
        JFileChooser fd = new JFileChooser();
        String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(windows);
        } catch (Exception e) {
            e.printStackTrace();
        }// 設定見面風格
        SwingUtilities.updateComponentTreeUI(fd);// 使設定的界面風格生效
        fd.setFileSelectionMode(fd.DIRECTORIES_ONLY); // 指示只顯示目錄
        fd.showOpenDialog(this);
        return fd;
    }
    //選擇按鈕單擊事件
    protected void do_choiceButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if((fd.getSelectedFile()!=null)&&(!fd.getSelectedFile().equals(""))){
        String strPath = fd.getSelectedFile().getPath();
        filePathTextField.setText(strPath);        
        }        
    }
    //選擇檔案儲存地址按鈕單擊事件
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if((fd.getSelectedFile()!=null)&&(!fd.getSelectedFile().equals(""))){
        String strPath = fd.getSelectedFile().getPath();
        saveTextField.setText(strPath);        
        }        
    }
    //複製按鈕的單擊事件
    protected void do_copyButton_actionPerformed(ActionEvent arg0) {
        CopyUtil util = new CopyUtil();
        List fileList = util.getList(filePathTextField.getText());
        String savePath = saveTextField.getText();
        String type = typeComboBox.getSelectedItem().toString();
        for(int i = 0;i<fileList.size();i++){
            String strPath = fileList.get(i).toString();
            if(strPath.endsWith(type)){
                String strNewName = strPath.substring(strPath.lastIndexOf("\\")+1,strPath.length());               
                util.copyFile(strPath, saveTextField.getText()+"\\"+strNewName);   
            }
        }
        JOptionPane.showMessageDialog(getContentPane(), 
                "檔案複製成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
    }
}
