package com.mingrisoft.jeditorpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class HighLightKeyWord extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5747183545714998015L;
    private JPanel contentPane;
    private JTextField textField;
    private JEditorPane editorPane;
    
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
                    HighLightKeyWord frame = new HighLightKeyWord();
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
    public HighLightKeyWord() {
        setTitle("高亮指定的關鍵字");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("關鍵字：");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(15);
        
        JButton button = new JButton("高亮");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        editorPane = new JEditorPane();
        editorPane
                .setText("       吉林省明日科技有限公司是一家以計算機軟件技術為核心的高科技型企業，公司建立於1999年12月，是專業的應用軟件開發商和服務提供商。多年來始終致力於產業管理軟件開發、數字化出版物開發製作、產業電子商務網站開發等，先後成功開發了涉及生產、管理、物流、營銷、服務等領域的多種企業管理應用軟件和應用平台，目前已成為計算機出版產業的知名品牌。");
        editorPane.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(editorPane);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String key = textField.getText();
        String content = editorPane.getText();
        Highlighter highlighter = editorPane.getHighlighter();
        highlighter.removeAllHighlights();
        if (content.contains(key)) {
            int index = content.indexOf(key);
            while (true) {
                if (index != -1) {
                    try {
                        highlighter.addHighlight(index, index + key.length(), DefaultHighlighter.DefaultPainter);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    index = content.indexOf(key, ++index);
                    
                } else {
                    break;
                }
            }
        }
    }
}
