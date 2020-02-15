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
                "��ܹϤ����");
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
     * ��l���ɮ׿�ܾ�
     */
    private void initFileChooser() {
        fileChooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        previewer = new ImagePreviewer(fileChooser);// �إ߹Ϥ��w������
        fileChooser.setFileFilter(new FileNameExtensionFilter("�Ϥ��ɮ�", "jpg",
                "gif", "png"));
        // �����w�ݩ��ܧ�W�[�ƥ��ť��
        fileChooser.addPropertyChangeListener("SelectedFileChangedProperty",
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent evt) {
                        // �ݩʧ��ܮɳ]�w�w�����Ҫ��Ϥ�
                        previewer.setImageFile((File) evt.getNewValue());
                    }
                });
        fileChooser.setAccessory(previewer);
    }
    
    /**
     * ��ܹϤ��ɮ׫��s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_button_actionPerformed(ActionEvent e) {
        int option = fileChooser.showOpenDialog(this);// ��ܶ}���ɮץ�͵���
        if (option == JFileChooser.APPROVE_OPTION) {
            // ��o��ܪ��ɮ׹ﹳ
            File file = fileChooser.getSelectedFile();
            // ��s���餤�Ϥ�
            imageLabel.setImageFile(file);
        }
    }
}

/**
 * �۩w�q�Ϥ��w������
 * 
 * @author ����L
 */
class ImagePreviewer extends JLabel {
    public ImagePreviewer(JFileChooser chooser) {
        // ��l�j�p
        setPreferredSize(new Dimension(200, 200));
        setHorizontalAlignment(JLabel.CENTER);// �����~��
        setBorder(new LineBorder(Color.GRAY));// �]�w���
        setOpaque(true);// ���Ҥ��z��
        setBackground(Color.WHITE);// �]�w�I����
        setText("�S���]�w�Ϥ�");// �w�]��r
    }
    
    /**
     * �]�w���ҹϤ�����k
     * 
     * @param file
     */
    public void setImageFile(File file) {
        setText("");// �M�ŹϤ��w�����Ҫ���r
        if (file == null) {// �p�G�ɮ׹ﹳ����
            setText("�S���]�w�Ϥ�");// �]�w�w�]���ܤ�r
            return;// �פ��k
        }
        // �إ߹ϼйﹳ
        ImageIcon icon = new ImageIcon(file.getPath());
        if (icon.getIconWidth() > getWidth()) {// �]�w�ϼФj�p
            icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(),
                    -1, Image.SCALE_DEFAULT));
        }
        setIcon(icon);// �����ҳ]�w�ϼ�
        repaint();// ���sø�s�ɭ�
    }
}