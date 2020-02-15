import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

public class CurstomNameSave extends JFrame {
    
    private JTextArea textArea;
    private JLabel label;
    
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
                    CurstomNameSave frame = new CurstomNameSave();
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
    public CurstomNameSave() {
        setTitle("���O�s��ܮس]�m�q�{���W");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("���");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("�s�ؤ���");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_actionPerformed(e);
            }
        });
        menu.add(menuItem);
        
        JMenuItem menuItem_2 = new JMenuItem("�h�X");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_2_actionPerformed(e);
            }
        });
        menu.add(menuItem_2);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setTabSize(4);
        ;
        textArea.setEnabled(false);
        scrollPane.setViewportView(textArea);
        
        label = new JLabel("�s�ؤ���");
        contentPane.add(label, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("�O�s");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
    }
    
    protected void do_menuItem_actionPerformed(ActionEvent e) {
        // �����ϥΪ̿�J
        String string = JOptionPane.showInputDialog("�п�J�s�W���W��");
        if (string == null)
            return;
        label.setText(string);// �μ��ұ����ܨϥΪ̿�J��í�w�W��
        textArea.setEnabled(true);// �Ұʤ�r�챱�
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = label.getText();// ��o���ұ���x�s��������
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        File file = new File(text + ".txt");// �Τ��W�٫إ��ɮ׹ﹳ
        chooser.setSelectedFile(file);// �]�w�ɮ׿�ܾ�������ɮ�
        chooser.showSaveDialog(this);// ����x�s��͵���
        File selectedFile = chooser.getSelectedFile();
        JOptionPane.showMessageDialog(this, "�ɮ��x�s���|�G\n" + selectedFile);
    }
    
    protected void do_menuItem_2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
