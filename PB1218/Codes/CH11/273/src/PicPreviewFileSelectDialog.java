import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PicPreviewFileSelectDialog extends JFrame {
    
    private JPanel contentPane;
    private PaintPanel paint;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PicPreviewFileSelectDialog frame = new PicPreviewFileSelectDialog();
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
    public PicPreviewFileSelectDialog() {
        setTitle("����Ϥ��w��������ܹ�ܮ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JFileChooser fileChooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        contentPane.add(fileChooser, BorderLayout.CENTER);// �W�[�쵡��
        paint = new PaintPanel();// �إ߹Ϥ��w�����O
        paint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
                null));// �]�w���O�����
        paint.setPreferredSize(new Dimension(150, 300));// �]�w�w�����O���j�p
        fileChooser.setAccessory(paint);// �⭱�O�]�w���ɮ׿�ܾ����
        // �W�[��ܾ����ݩʨƥ��ť��
        fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent arg0) {
                do_this_propertyChange(arg0);
            }
        });
        // �]�w�ɮ׿�ܾ����L�o��
        fileChooser.setFileFilter(new FileNameExtensionFilter("�Ϥ��ɮ�", "jpg",
                "png", "gif"));
    }
    
    protected void do_this_propertyChange(PropertyChangeEvent e) {
        // �B�z���ܿ�w�ɮת��ݩʨƥ�B�z
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY == e.getPropertyName()) {
            File picfile = (File) e.getNewValue();// ��o��w���ɮ�
            if (picfile != null && picfile.isFile()) {
                try {
                    // �q�ɮ׸��J�Ϥ�
                    Image image = getToolkit()
                            .getImage(picfile.toURI().toURL());
                    paint.setImage(image);// �]�w�w�����O���Ϥ�
                    paint.repaint();// ��s�w�����O���ɭ�
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
