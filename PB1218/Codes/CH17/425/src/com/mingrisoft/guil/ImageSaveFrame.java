package com.mingrisoft.guil;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mingrisoft.util.DBHelper;
import java.awt.Font;
import javax.swing.UIManager;

public class ImageSaveFrame extends JFrame {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 2023927771503799059L;
    private JPanel contentPane;
    private JTextField pathTextField;
    private JTextField nameTextField;
    
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
                    ImageSaveFrame frame = new ImageSaveFrame();
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
    public ImageSaveFrame() {
        setTitle("讀取文件路徑到數據庫");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel pathPanel = new JPanel();
        contentPane.add(pathPanel);
        
        JLabel pathLabel = new JLabel("路徑名：");
        pathLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        pathPanel.add(pathLabel);
        
        pathTextField = new JTextField();
        pathTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        pathPanel.add(pathTextField);
        pathTextField.setColumns(15);
        
        JPanel namePanel = new JPanel();
        contentPane.add(namePanel);
        
        JLabel nameLabel = new JLabel("文件名：");
        nameLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        namePanel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        namePanel.add(nameTextField);
        nameTextField.setColumns(15);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton chooseButton = new JButton("選擇圖片");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(chooseButton);
        
        JButton saveButton = new JButton("保存圖片");
        saveButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(saveButton);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            pathTextField.setText(path);
            int lastDot = path.lastIndexOf(".");
            int lastSeparatopr = path.lastIndexOf(File.separator);
            String name = path.substring(lastSeparatopr + 1, lastDot);
            nameTextField.setText(name);
        }
    }
    
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText();
        String path = pathTextField.getText();
        int lastDot = path.lastIndexOf(".");
        if (path.length() == 0) {
            JOptionPane.showMessageDialog(this, "請選擇圖片", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String type = path.substring(lastDot + 1, path.length());
        DBHelper.saveImage(name, type, new File(path));
        JOptionPane.showMessageDialog(this, "圖片儲存成功");
    }
}
