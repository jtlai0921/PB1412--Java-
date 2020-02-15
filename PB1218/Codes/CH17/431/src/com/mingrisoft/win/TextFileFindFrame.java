package com.mingrisoft.win;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;
import javax.swing.UIManager;

public class TextFileFindFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5582155191183049854L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private File chooseFile;
    private JTextArea resultTextArea;
    
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
                    TextFileFindFrame frame = new TextFileFindFrame();
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
    public TextFileFindFrame() {
        setTitle("����ϽL�Ҧ��奻���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        JLabel chooseLabel = new JLabel("��ܯ��ޤ��G");
        chooseLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        choosePanel.add(chooseLabel);
        
        chooseTextField = new JTextField();
        chooseTextField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(10);
        
        JButton chooseButton = new JButton("��ܤ��");
        chooseButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel searchPanel = new JPanel();
        contentPane.add(searchPanel, BorderLayout.SOUTH);
        
        JButton searchButton = new JButton("�}�l�d��");
        searchButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_searchButton_actionPerformed(arg0);
            }
        });
        searchPanel.add(searchButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        resultTextArea = new JTextArea();
        resultTextArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        scrollPane.setViewportView(resultTextArea);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("��r�ɮ�", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chooseFile = fileChooser.getSelectedFile();
            chooseTextField.setText(chooseFile.getAbsolutePath());
        }
    }
    
    protected void do_searchButton_actionPerformed(ActionEvent arg0) {
        if (chooseFile == null) {
            JOptionPane.showMessageDialog(this, "�п�ܯ����ɮ�", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String keyword = ".txt";// �N����r���w����r�ɮת����
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(chooseFile);// �Q�ΨϥΪ̿�ܪ��ɮ׫إ�FileReader�ﹳ
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder builder = new StringBuilder();// �Q��StringBuilder�ﹳ�x�s����
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {// Ū�J��r�ɮ�
                builder.append(temp);
                builder.append("\n");// �b�C�@�檺���ݼW�[�@�Ӥ��j��
            }
            
            String[] rows = builder.toString().split("\n");// �N���ޫ�����Ť���
            resultTextArea.setText("");// �M�Ť�r��
            for (String row : rows) {// �ˬdŪ�J����r�ɮ�
                if (row.endsWith(keyword)) {// �P�_Ū�J����r�ɮ׬O�_�]�t���w������r
                    resultTextArea.append(row + "\n");// �Ǧ^���G
                }
            }
            
            if (resultTextArea.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "�S�����z�ݭn���ɮ�", null, JOptionPane.WARNING_MESSAGE);
                return;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
