package com.mingrisoft.jeditorpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class HTMLViewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8102788557698714466L;
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
                    HTMLViewer frame = new HTMLViewer();
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
    public HTMLViewer() {
        setTitle("¦Û©w¸qÂsÄý¾¹");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("¿é¤Jºô§}¡G");
        label.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_textField_actionPerformed(e);
            }
        });
        textField.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(22);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        scrollPane.setViewportView(editorPane);
    }
    
    protected void do_textField_actionPerformed(ActionEvent e) {
        String url = textField.getText();
        try {
            editorPane.setPage(url);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
