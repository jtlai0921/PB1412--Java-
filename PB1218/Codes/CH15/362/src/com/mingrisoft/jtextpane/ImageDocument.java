package com.mingrisoft.jtextpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.Font;

public class ImageDocument extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2805667115903449650L;
    private JPanel contentPane;
    private JTextPane textPane;
    
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
                    ImageDocument frame = new ImageDocument();
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
    public ImageDocument() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("包含圖片的文檔");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textPane = new JTextPane();
        textPane.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textPane);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String heading = "吉林省明日科技有限公司\n";
        String content = "吉林省明日科技有限公司是一家以計算機軟件技術為核心的高科技型企業，公司建立於1999年12月，是專業的應用軟件開發商和服務提供商。多年來始終致力於產業管理軟件開發、數字化出版物開發製作、產業電子商務網站開發等，先後成功開發了涉及生產、管理、物流、營銷、服務等領域的多種企業管理應用軟件和應用平台，目前已成為計算機出版產業的知名品牌。";
        Style imageStyle = new StyleContext().addStyle("Image", null);
        StyleConstants.setIcon(imageStyle, new ImageIcon("src/images/logo.jpg"));
        DefaultStyledDocument document = new DefaultStyledDocument();
        try {
            document.insertString(0, "image", imageStyle);
            document.insertString(document.getLength(), heading + content, null);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
        textPane.setDocument(document);
    }
}
