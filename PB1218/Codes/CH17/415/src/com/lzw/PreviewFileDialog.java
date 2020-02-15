package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreviewFileDialog extends JFrame {
    
    private JPanel contentPane;
    private JFileChooser fileChooser;
    private ImagePreviewer imageLabel;
    private ImagePreviewer previewer;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PreviewFileDialog frame = new PreviewFileDialog();
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
    public PreviewFileDialog() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 629, 428);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        JButton chooseButton = new JButton(
                "選擇圖片文件");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(chooseButton);
        
        imageLabel = new ImagePreviewer((JFileChooser) null);
        contentPane.add(imageLabel, BorderLayout.CENTER);
        initFileChooser();
    }
    
    /**
     * 初始化檔案選擇器
     */
    private void initFileChooser() {
        fileChooser = new JFileChooser();// 建立檔案選擇器
        previewer = new ImagePreviewer(fileChooser);// 建立圖片預覽標籤
        fileChooser.setFileFilter(new FileNameExtensionFilter("圖片檔案", "jpg",
                "gif", "png"));
        // 為指定屬性變更增加事件監聽器
        fileChooser.addPropertyChangeListener("SelectedFileChangedProperty",
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent evt) {
                        // 屬性改變時設定預覽標籤的圖片
                        previewer.setImageFile((File) evt.getNewValue());
                    }
                });
        fileChooser.setAccessory(previewer);
    }
    
    /**
     * 選擇圖片檔案按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_button_actionPerformed(ActionEvent e) {
        int option = fileChooser.showOpenDialog(this);// 顯示開啟檔案交談視窗
        if (option == JFileChooser.APPROVE_OPTION) {
            // 獲得選擇的檔案對像
            File file = fileChooser.getSelectedFile();
            // 更新窗體中圖片
            imageLabel.setImageFile(file);
        }
    }
}

/**
 * 自定義圖片預覽標籤
 * 
 * @author 李鍾尉
 */
class ImagePreviewer extends JLabel {
    public ImagePreviewer(JFileChooser chooser) {
        // 初始大小
        setPreferredSize(new Dimension(200, 200));
        setHorizontalAlignment(JLabel.CENTER);// 水平居中
        setBorder(new LineBorder(Color.GRAY));// 設定邊框
        setOpaque(true);// 標籤不透明
        setBackground(Color.WHITE);// 設定背景色
        setText("沒有設定圖片");// 預設文字
    }
    
    /**
     * 設定標籤圖片的方法
     * 
     * @param file
     */
    public void setImageFile(File file) {
        setText("");// 清空圖片預覽標籤的文字
        if (file == null) {// 如果檔案對像為空
            setText("沒有設定圖片");// 設定預設提示文字
            return;// 終止方法
        }
        // 建立圖標對像
        ImageIcon icon = new ImageIcon(file.getPath());
        if (icon.getIconWidth() > getWidth()) {// 設定圖標大小
            icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(),
                    -1, Image.SCALE_DEFAULT));
        }
        setIcon(icon);// 為標籤設定圖標
        repaint();// 重新繪製界面
    }
}