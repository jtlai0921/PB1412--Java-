package com.cdd.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JComboBox;

public class ResumeFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField fileNameTextField;
    private JButton browseButton;
    private JLabel dataBaseLabel;
    private JComboBox dataBaseComboBox;
    private JButton resumeButton;
    private Resume resume = new Resume();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResumeFrame frame = new ResumeFrame();
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
    public ResumeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 504, 208);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("資料恢復");
        JPanel panel = new JPanel();
        panel.setBounds(10, 0, 488, 173);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("資料函數庫備份檔案名稱：");
        nameLabel.setBounds(10, 41, 133, 15);
        panel.add(nameLabel);
        
        fileNameTextField = new JTextField();
        fileNameTextField.setBounds(153, 38, 191, 21);
        panel.add(fileNameTextField);
        fileNameTextField.setColumns(10);
        
        browseButton = new JButton("瀏覽");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_browseButton_actionPerformed(arg0);
            }
        });
        browseButton.setBounds(361, 37, 93, 23);
        panel.add(browseButton);
        
        dataBaseLabel = new JLabel("選擇恢復的資料函數庫：");
        dataBaseLabel.setBounds(21, 86, 118, 15);
        panel.add(dataBaseLabel);
        List list = resume.getDatabase();
        String name[] = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            name[i] = (String)list.get(i); 
        }
        dataBaseComboBox = new JComboBox(name);
        dataBaseComboBox.setBounds(153, 83, 191, 21);
        panel.add(dataBaseComboBox);
        
        resumeButton = new JButton("恢復");
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_resumeButton_actionPerformed(arg0);
            }
        });
        resumeButton.setBounds(361, 82, 93, 23);
        panel.add(resumeButton);
    }
    
    //瀏覽按鈕的單擊事件
    protected void do_browseButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd=new FileDialog(this);
        fd.setVisible(true);        
        fileNameTextField.setText(fd.getDirectory()+fd.getFile());
       
    }
    //恢復按鈕的單擊事件
    protected void do_resumeButton_actionPerformed(ActionEvent arg0) {
        String datePath = fileNameTextField.getText() ;
        String dateName = dataBaseComboBox.getSelectedItem().toString();
        resume.getBak(dateName, datePath);
        JOptionPane.showMessageDialog(getContentPane(), 
                "資料恢復成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);

    }
}
