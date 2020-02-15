import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserMonitorFrame extends JFrame implements Runnable {    
    private JPanel contentPane;
    private JTextField pathTextField;
    private JTextField saveTextField;    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserMonitorFrame frame = new UserMonitorFrame();
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
    public UserMonitorFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 481, 231);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("在複製檔案時使用進度條");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 465, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel pathLabel = new JLabel("檔案地址：");
        pathLabel.setBounds(42, 45, 72, 15);
        panel.add(pathLabel);
        
        pathTextField = new JTextField();
        pathTextField.setBounds(124, 42, 197, 21);
        panel.add(pathTextField);
        pathTextField.setColumns(10);
        
        JButton pathButton = new JButton("選擇檔案");     
        pathButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_pathButton_actionPerformed(arg0);
            }
        });
        pathButton.setBounds(341, 41, 93, 23);
        panel.add(pathButton);
        
        JLabel saveLabel = new JLabel("複製地址：");
        saveLabel.setBounds(42, 104, 72, 15);
        panel.add(saveLabel);
        
        saveTextField = new JTextField();
        saveTextField.setBounds(124, 101, 197, 21);
        panel.add(saveTextField);
        saveTextField.setColumns(10);        
        JButton saveButton = new JButton("選擇地址");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });      
        saveButton.setBounds(341, 100, 93, 23);
        panel.add(saveButton);
        
        JButton copyButton = new JButton("確定複製");
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_copyButton_actionPerformed(arg0);
            }
        });       
        copyButton.setBounds(169, 145, 93, 23);
        panel.add(copyButton);
    }
    // 定義獲得只可以選擇檔案夾的選擇框
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
    //選擇要複製的檔案按鈕的單擊事件
    protected void do_pathButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd=new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory()+fd.getFile();
        pathTextField.setText(filePath);
    }
    //選擇儲存檔案地址的按鈕單擊事件
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if ((fd.getSelectedFile() != null)
                && (!fd.getSelectedFile().equals(""))) {
            String strPath = fd.getSelectedFile().getPath();
            saveTextField.setText(strPath);
        }
    }
    //確定複製按鈕單擊事件
    protected void do_copyButton_actionPerformed(ActionEvent arg0) {
       Thread thread = new Thread(this);
       thread.start();
    }
   //應用多線程技術實現讀取操作
    @Override
    public void run() {
        ProgressMonitorTest test = new ProgressMonitorTest();
        String path = pathTextField.getText();
        String save = saveTextField.getText();
        test.useProgressMonitor(this,path,save+path.substring(path.lastIndexOf("."),path.length()));
        
    }
}
