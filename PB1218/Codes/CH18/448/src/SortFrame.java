import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
public class SortFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField pathTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SortFrame frame = new SortFrame();
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
    public SortFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 434, 196);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("檔案夾分類別管理");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 418, 158);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("分類別檔案夾：");
        messageLabel.setBounds(19, 48, 92, 15);
        panel.add(messageLabel);
        
        pathTextField = new JTextField();
        pathTextField.setBounds(121, 45, 187, 21);
        panel.add(pathTextField);
        pathTextField.setColumns(10);
        
        JButton choicBbutton = new JButton("選擇");
        choicBbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_choicBbutton_actionPerformed(arg0);
            }
        });
        choicBbutton.setBounds(318, 44, 77, 23);
        panel.add(choicBbutton);
        
        JButton sortButton = new JButton("確定分類別");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_sortButton_actionPerformed(arg0);
            }
        });
        sortButton.setBounds(156, 96, 93, 23);
        panel.add(sortButton);
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
    
    protected void do_choicBbutton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if ((fd.getSelectedFile() != null)
                && (!fd.getSelectedFile().equals(""))) {
            String strPath = fd.getSelectedFile().getPath();
            pathTextField.setText(strPath);
        }        
        
    }

protected void do_sortButton_actionPerformed(ActionEvent arg0) {
    SortUtil sortUtil = new SortUtil();      
    List list = sortUtil.getList(pathTextField.getText()); //獲得使用者選擇檔案夾中所有檔案集合
     for(int i = 0;i<list.size();i++){              //循環檢查該檔案集合
         String strFile = list.get(i).toString();
         int index = strFile.lastIndexOf(".");
         if(index != -1){
             String strN = strFile.substring(index+1,strFile.length()); //對檔案夾進行截取，獲得檔案擴充名
             int ind = strFile.lastIndexOf("\\");
             String strFileName = strFile.substring(ind, index);
             sortUtil.createFolder(pathTextField.getText()+"\\"+"分類別");//呼叫建立檔案夾方法，新增檔案夾
             sortUtil.createFolder(pathTextField.getText()+"\\"+"分類別"+"\\"+strN);
             if(strFile.endsWith(strN)){                        
            //將檔案集合中與檔案夾名稱相同的檔案複製到對應的檔案夾中
                 sortUtil.copyFile(strFile,pathTextField.getText()+"\\"+"分類別"+"\\"+strN+
                         "\\"+strFileName+strFile.substring(index,strFile.length()));
             }                
         }
     }
     JOptionPane.showMessageDialog(getContentPane(), //舉出使用者分類別完成提示框
             "檔案分類別成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);        
}
}
