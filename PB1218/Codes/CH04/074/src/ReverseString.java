import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReverseString extends JFrame {
    
    private JPanel contentPane;
    private JTextArea sourceArea;
    private JTextArea destinationArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReverseString frame = new ReverseString();
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
    public ReverseString() {
        setTitle("�N�r�ꪺ�C�Ӧr���i��˧ǿ�X");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 155, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);
        
        JLabel label = new JLabel("��J�r��G");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.WEST;
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPane.add(scrollPane, gbc_scrollPane);
        
        sourceArea = new JTextArea();
        sourceArea.setLineWrap(true);
        scrollPane.setViewportView(sourceArea);
        
        JButton button = new JButton("����");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 2;
        contentPane.add(button, gbc_button);
        
        JLabel label_1 = new JLabel("���൲�G�G");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.WEST;
        gbc_label_1.insets = new Insets(0, 0, 5, 0);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 3;
        contentPane.add(label_1, gbc_label_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 0;
        gbc_scrollPane_1.gridy = 4;
        contentPane.add(scrollPane_1, gbc_scrollPane_1);
        
        destinationArea = new JTextArea();
        destinationArea.setLineWrap(true);
        scrollPane_1.setViewportView(destinationArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = sourceArea.getText();// ��o�ϥΪ̿�J
        StringBuilder sbuilder = new StringBuilder(text);// �إ߫غc���]�t�ϥΪ̿�J
        StringBuilder reverse = sbuilder.reverse();// �I�s�����k��o����᪺�غc��
        String reverseText = reverse.toString();// �q�غc����o���઺�r��
        destinationArea.setText(reverseText);// ��½��᪺���G�W�[���r�줤
    }
}
