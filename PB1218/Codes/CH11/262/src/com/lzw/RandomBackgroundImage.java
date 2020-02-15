package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomBackgroundImage extends JFrame {
    
    private JPanel contentPane;
    private BackgroundPanel panel;
    private Image[] images;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RandomBackgroundImage frame = new RandomBackgroundImage();
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
    public RandomBackgroundImage() {
        initPhotoArray();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("�H���󴫵���I��");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 412);// �]�w�����m
        contentPane = new JPanel();// �إߤ��e���O
        setContentPane(contentPane);// �]�w���餺�e���O
        contentPane.setLayout(new BorderLayout(0, 0));
        panel = new BackgroundPanel();
        contentPane.add(panel);// ��I�����O�W�[�쵡�餺�e���O
    }
    
    private void initPhotoArray() {
        images = new Image[6];// ��l�ƭI���Ͻg�}�C
        String photoPath = "";
        for (int i = 0; i < images.length; i++) {// �ˬd�}�C�ê�l�ƩҦ�����
            photoPath = "/com/img/photo" + (i + 1) + ".jpg";// �����ɮצW
            images[i] = getToolkit()
                    .getImage(getClass().getResource(photoPath));// ��l�ư}�C����
        }
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        Random random = new Random();// �إ��H���ƹﹳ
        int num = random.nextInt(6);// �����H����
        panel.setImage(images[num]);// �]�w���O�I���Ϥ�
        repaint();// ��ø����ɭ�
    }
}
