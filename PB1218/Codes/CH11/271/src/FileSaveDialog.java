import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class FileSaveDialog extends JFrame {
    
    private JPanel contentPane;
    private JTextArea textArea;
    
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
                    FileSaveDialog frame = new FileSaveDialog();
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
    public FileSaveDialog() {
        setTitle("文件選擇對話框指定數據備份");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 291);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("文件");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("保存");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_actionPerformed(e);
            }
        });
        menu.add(menuItem);
        
        JMenuItem menuItem_1 = new JMenuItem("退出");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_1_actionPerformed(e);
            }
        });
        menu.add(menuItem_1);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("細明體", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setTabSize(4);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_menuItem_actionPerformed(ActionEvent e) {
        String text = textArea.getText();// 獲得使用者輸入
        if (text.isEmpty()) {// 過濾空文字的儲存操作
            JOptionPane.showMessageDialog(this, "沒有需要儲存的文字");
            return;
        }
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        int option = chooser.showSaveDialog(this);// 開啟檔案儲存交談視窗
        if (option == JFileChooser.APPROVE_OPTION) {// 處理檔案儲存操作
            File file = chooser.getSelectedFile();// 獲得使用者選擇的檔案
            try {
                FileOutputStream fout = new FileOutputStream(file);// 建立該檔案的輸出流
                fout.write(text.getBytes());// 把文字儲存到檔案
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    protected void do_menuItem_1_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
