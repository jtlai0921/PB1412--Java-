package com.mingrisoft.ProgressMonitorInputStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ProgressMonitorInputStream;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProgressMonitorInputStreamTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3507295831463384535L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
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
                    ProgressMonitorInputStreamTest frame = new ProgressMonitorInputStreamTest();
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
    public ProgressMonitorInputStreamTest() {
        setTitle("監視文件讀取進度");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        JLabel label = new JLabel("文件名：");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(15);
        
        JButton button = new JButton("打開文件");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new FileNameExtensionFilter("TXT檔案", "txt"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            textField.setText(file.getName());
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ProgressMonitorInputStream progressIn = new ProgressMonitorInputStream(this, "正在讀入檔案：" + file.getName(), fileIn);
                final Scanner in = new Scanner(progressIn);
                textArea.setText("");
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    
                    @Override
                    protected Void doInBackground() throws Exception {
                        while (in.hasNextLine()) {
                            textArea.append(in.nextLine());
                        }
                        in.close();
                        return null;
                    }
                    
                };
                worker.execute();
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
