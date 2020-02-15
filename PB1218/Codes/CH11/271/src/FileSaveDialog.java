import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class FileSaveDialog extends JFrame {
    
    private JPanel contentPane;
    private JTextArea textArea;
    
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
                    FileSaveDialog frame = new FileSaveDialog();
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
    public FileSaveDialog() {
        setTitle("����ܹ�ܮث��w�ƾڳƥ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 291);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("���");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("�O�s");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_actionPerformed(e);
            }
        });
        menu.add(menuItem);
        
        JMenuItem menuItem_1 = new JMenuItem("�h�X");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_1_actionPerformed(e);
            }
        });
        menu.add(menuItem_1);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("�ө���", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setTabSize(4);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_menuItem_actionPerformed(ActionEvent e) {
        String text = textArea.getText();// ��o�ϥΪ̿�J
        if (text.isEmpty()) {// �L�o�Ť�r���x�s�ާ@
            JOptionPane.showMessageDialog(this, "�S���ݭn�x�s����r");
            return;
        }
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        int option = chooser.showSaveDialog(this);// �}���ɮ��x�s��͵���
        if (option == JFileChooser.APPROVE_OPTION) {// �B�z�ɮ��x�s�ާ@
            File file = chooser.getSelectedFile();// ��o�ϥΪ̿�ܪ��ɮ�
            try {
                FileOutputStream fout = new FileOutputStream(file);// �إ߸��ɮת���X�y
                fout.write(text.getBytes());// ���r�x�s���ɮ�
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    protected void do_menuItem_1_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
