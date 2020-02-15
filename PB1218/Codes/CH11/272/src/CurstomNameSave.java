import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

public class CurstomNameSave extends JFrame {
    
    private JTextArea textArea;
    private JLabel label;
    
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
                    CurstomNameSave frame = new CurstomNameSave();
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
    public CurstomNameSave() {
        setTitle("為保存對話框設置默認文件名");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("文件");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("新建文檔");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_actionPerformed(e);
            }
        });
        menu.add(menuItem);
        
        JMenuItem menuItem_2 = new JMenuItem("退出");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_2_actionPerformed(e);
            }
        });
        menu.add(menuItem_2);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setTabSize(4);
        ;
        textArea.setEnabled(false);
        scrollPane.setViewportView(textArea);
        
        label = new JLabel("新建文檔");
        contentPane.add(label, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("保存");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
    }
    
    protected void do_menuItem_actionPerformed(ActionEvent e) {
        // 接收使用者輸入
        String string = JOptionPane.showInputDialog("請輸入新增文件名稱");
        if (string == null)
            return;
        label.setText(string);// 用標籤控制項顯示使用者輸入的穩定名稱
        textArea.setEnabled(true);// 啟動文字域控制項
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = label.getText();// 獲得標籤控制項儲存的文件民初
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        File file = new File(text + ".txt");// 用文件名稱建立檔案對像
        chooser.setSelectedFile(file);// 設定檔案選擇器的選擇檔案
        chooser.showSaveDialog(this);// 顯示儲存交談視窗
        File selectedFile = chooser.getSelectedFile();
        JOptionPane.showMessageDialog(this, "檔案儲存路徑：\n" + selectedFile);
    }
    
    protected void do_menuItem_2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
