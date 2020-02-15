import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.UIManager;

public class CustomSelectFileType extends JFrame {
    
    private JPanel contentPane;
    private BackgroundPanel backgroundPanel;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomSelectFileType frame = new CustomSelectFileType();
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
    public CustomSelectFileType() {
        setTitle(" 指定打開話框的文件類型");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
                null, null, null));
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("打開圖片文件");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        FileNameExtensionFilter filter = new FileNameExtensionFilter("圖片檔案",
                "jpg", "gif", "png", "jpeg");// 建立檔案型態過濾器
        chooser.setFileFilter(filter);// 設定選擇器的過濾器
        int option = chooser.showOpenDialog(this);// 顯示開啟交談視窗
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();// 獲得使用者選擇檔案
            try {
                // 載入圖片檔案
                ImageIcon image = new ImageIcon(file.toURI().toURL());
                backgroundPanel.setImage(image.getImage());// 顯示圖片檔案
                backgroundPanel.repaint();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
