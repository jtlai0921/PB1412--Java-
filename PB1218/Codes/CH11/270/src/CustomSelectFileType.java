import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.UIManager;

public class CustomSelectFileType extends JFrame {
    
    private JPanel contentPane;
    private BackgroundPanel backgroundPanel;
    
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
                    CustomSelectFileType frame = new CustomSelectFileType();
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
    public CustomSelectFileType() {
        setTitle(" ���w���}�ܮت��������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
                null, null, null));
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("���}�Ϥ����");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        FileNameExtensionFilter filter = new FileNameExtensionFilter("�Ϥ��ɮ�",
                "jpg", "gif", "png", "jpeg");// �إ��ɮ׫��A�L�o��
        chooser.setFileFilter(filter);// �]�w��ܾ����L�o��
        int option = chooser.showOpenDialog(this);// ��ܶ}�ҥ�͵���
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();// ��o�ϥΪ̿���ɮ�
            try {
                // ���J�Ϥ��ɮ�
                ImageIcon image = new ImageIcon(file.toURI().toURL());
                backgroundPanel.setImage(image.getImage());// ��ܹϤ��ɮ�
                backgroundPanel.repaint();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
