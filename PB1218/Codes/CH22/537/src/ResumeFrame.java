import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JComboBox;

public class ResumeFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField fileTextField;
    private JComboBox databaseComboBox;
    ResumeUtil userDao = new ResumeUtil();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResumeFrame frame = new ResumeFrame();
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
    public ResumeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 176);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("資料恢復");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 139);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel fileLabel = new JLabel("備份檔案：");
        fileLabel.setBounds(48, 43, 67, 15);
        panel.add(fileLabel);
        
        fileTextField = new JTextField();
        fileTextField.setBounds(125, 40, 174, 21);
        panel.add(fileTextField);
        fileTextField.setColumns(10);
        
        JButton browseButton = new JButton("瀏覽");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_browseButton_actionPerformed(arg0);
            }
        });
        browseButton.setBounds(320, 39, 74, 23);
        panel.add(browseButton);
        
        JLabel databaseLabel = new JLabel("恢復資料函數庫：");
        databaseLabel.setBounds(36, 89, 80, 15);
        panel.add(databaseLabel);
        List list = userDao.getDatabase();
        String name[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            name[i] = (String) list.get(i);
        }
        databaseComboBox = new JComboBox(name);
        databaseComboBox.setBounds(125, 86, 174, 21);
        panel.add(databaseComboBox);
        
        JButton resumeButton = new JButton("恢復");
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_resumeButton_actionPerformed(arg0);
            }
        });
        resumeButton.setBounds(320, 85, 74, 23);
        panel.add(resumeButton);
    }
    
    // 瀏覽按鈕的單擊處理事件
    protected void do_browseButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        fileTextField.setText(fd.getDirectory() + fd.getFile());        
    }    
    // 恢復按鈕的單擊事件
    protected void do_resumeButton_actionPerformed(ActionEvent arg0) {        
        String fileName = fileTextField.getText();
        String dataName = databaseComboBox.getSelectedItem().toString();
        if (!fileName.equals("") && (!dataName.equals(""))) {
            boolean bool = userDao.mysqlresume(dataName, fileName);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "資料恢復成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
