package com.mingrisoft.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mingrisoft.util.FileUtil;
import javax.swing.UIManager;
import java.awt.Font;

public class FileCopyFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7163184739179614764L;
    private JPanel contentPane;
    private JTextField sourceTextField;
    private JTextField targetTextField;
    private File targetFile;
    
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
                    FileCopyFrame frame = new FileCopyFrame();
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
    public FileCopyFrame() {
        setTitle("������󧨳ƥ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel sourcePanel = new JPanel();
        contentPane.add(sourcePanel);
        
        JLabel sourceLabel = new JLabel("����󧨡G");
        sourceLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        sourcePanel.add(sourceLabel);
        
        sourceTextField = new JTextField();
        sourceTextField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        sourceTextField.setText("�п�JURI�a�}");
        sourcePanel.add(sourceTextField);
        sourceTextField.setColumns(18);
        
        JPanel targetPanel = new JPanel();
        contentPane.add(targetPanel);
        
        JLabel targetLabel = new JLabel("�J��󧨡G");
        targetLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        targetPanel.add(targetLabel);
        
        targetTextField = new JTextField();
        targetTextField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        targetPanel.add(targetTextField);
        targetTextField.setColumns(10);
        
        JButton targetButton = new JButton("��ܤ��");
        targetButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        targetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_targetButton_actionPerformed(arg0);
            }
        });
        targetPanel.add(targetButton);
        
        JPanel downloadPanel = new JPanel();
        contentPane.add(downloadPanel);
        
        JButton downloadButton = new JButton("�}�l�ƥ�");
        downloadButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        downloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_downloadButton_actionPerformed(arg0);
            }
        });
        downloadPanel.add(downloadButton);
    }
    
    protected void do_targetButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(this.getContentPane());
        if (result == JFileChooser.APPROVE_OPTION) {
            targetFile = chooser.getSelectedFile();
            targetTextField.setText(targetFile.getAbsolutePath());
            
        }
    }
    
    protected void do_downloadButton_actionPerformed(ActionEvent arg0) {
        String uri = sourceTextField.getText();
        String target = targetTextField.getText();
        try {
            File sourceFile = new File(new URI(uri));
            if (sourceFile.isFile()) {
                JOptionPane.showMessageDialog(this, "�п�J�ɮק��a�}", null, JOptionPane.WARNING_MESSAGE);
                return;
            }
            File targetFile = new File(target);
            FileUtil.copyDirectory(sourceFile, targetFile);
            JOptionPane.showMessageDialog(this, "�ƻs���\");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
