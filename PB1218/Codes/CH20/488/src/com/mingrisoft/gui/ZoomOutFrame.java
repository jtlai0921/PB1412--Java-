package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import javax.swing.UIManager;
import java.awt.Font;

public class ZoomOutFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 318773725547929917L;
    private JPanel contentPane;
    private JPanel pdfPanel;
    private PDFPage pdfPage;
    
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
                    ZoomOutFrame frame = new ZoomOutFrame();
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
    public ZoomOutFrame() {
        setTitle("應用PDF Renderer組件實現縮小PDF文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton chooseButton = new JButton("選擇文件");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(chooseButton);
        
        JButton zoomoutButton = new JButton("縮小文件");
        zoomoutButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        zoomoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_zoomoutButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(zoomoutButton);
        
        pdfPanel = new JPanel();
        contentPane.add(pdfPanel, BorderLayout.CENTER);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF檔案", "pdf"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = fileChooser.getSelectedFile();
            try {
                pdfPage = getPDFPage(selectFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PagePanel pagePanel = new PagePanel();
            pdfPanel.add(pagePanel);
            validate();
            pagePanel.showPage(pdfPage);
        }
    }
    
    private static PDFPage getPDFPage(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        PDFFile pdfFile = new PDFFile(buffer);
        return pdfFile.getPage(2);
    }
    
    protected void do_zoomoutButton_actionPerformed(ActionEvent arg0) {
        if (pdfPage == null) {
            JOptionPane.showMessageDialog(this, "請選擇PDF檔案", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        Rectangle rect = new Rectangle(0, 0, (int) pdfPage.getBBox().getWidth(), (int) pdfPage.getBBox().getHeight());// 獲得使用者勾選的PDF頁面的邊框
        // 將使用者勾選的PDF頁面轉換成圖片並將其縮小一倍
        Image image = pdfPage.getImage(rect.width / 2, rect.height / 2, rect, null, true, true);
        if (pdfPanel != null) {
            pdfPanel.removeAll();// 清空JPanel控制項包含的控制項
        }
        pdfPanel.add(new JLabel(new ImageIcon(image))); // 以JLabel的方式顯示縮小的圖片
        validate(); // 驗證容器及所有子控制項
        repaint(); // 更新JPanel
        
    }
}
