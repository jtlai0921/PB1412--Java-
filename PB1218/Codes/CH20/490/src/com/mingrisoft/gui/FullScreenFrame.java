package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
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

import com.sun.pdfview.FullScreenWindow;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import javax.swing.UIManager;
import java.awt.Font;

public class FullScreenFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5506015730370161973L;
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
                    FullScreenFrame frame = new FullScreenFrame();
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
    public FullScreenFrame() {
        setTitle("�������PDF���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton chooseButton = new JButton("��ܤ��");
        chooseButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(chooseButton);
        
        JButton fullscreenButton = new JButton("�������");
        fullscreenButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fullscreenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_fullscreenButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(fullscreenButton);
        
        pdfPanel = new JPanel();
        contentPane.add(pdfPanel, BorderLayout.CENTER);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF�ɮ�", "pdf"));
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
    
    protected void do_fullscreenButton_actionPerformed(ActionEvent arg0) {
        if (pdfPage == null) {
            JOptionPane.showMessageDialog(this, "�п��PDF�ɮ�", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        Rectangle rect = new Rectangle(0, 0, (int) pdfPage.getBBox().getWidth(), (int) pdfPage.getBBox().getHeight());// ��o�ϥΪ̤Ŀ諸PDF���������
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize(); // ��o�ϥΪ̪���ܾ��j�p
        double times = dimension.getHeight() / rect.height;// ��o���׻ݭn��j������
        Image image = pdfPage.getImage((int) (rect.width * times), dimension.height, rect, null, true, true);// �]�w�Ϥ����j�p
        if (pdfPanel != null) {
            pdfPanel.removeAll();
        }
        pdfPanel.add(new JLabel(new ImageIcon(image))); // ��ܲ��ͪ��Ϥ�
        new FullScreenWindow(pdfPanel);
    }
}
