import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ColorChooser extends JFrame {
    
    private JPanel contentPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    
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
                    ColorChooser frame = new ColorChooser();
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
    public ColorChooser() {
        setTitle("�C���ܹ�ܮ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 348, 162);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel label = new JLabel("�j�����C��G");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label);
        
        label1 = new JLabel("");
        label1.setOpaque(true);
        label1.setBackground(Color.WHITE);
        contentPane.add(label1);
        
        JButton button1 = new JButton("���");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        contentPane.add(button1);
        
        JLabel label_2 = new JLabel("�𸭪��C��G");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label_2);
        
        label2 = new JLabel("");
        label2.setBackground(Color.WHITE);
        label2.setOpaque(true);
        contentPane.add(label2);
        
        JButton button2 = new JButton("���");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button2_actionPerformed(e);
            }
        });
        contentPane.add(button2);
        
        JLabel label_4 = new JLabel("�������C��G");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label_4);
        
        label3 = new JLabel("");
        label3.setBackground(Color.WHITE);
        label3.setOpaque(true);
        contentPane.add(label3);
        
        JButton button3 = new JButton("���");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button3_actionPerformed(e);
            }
        });
        contentPane.add(button3);
        
        JLabel label_6 = new JLabel("�ڪ�����G");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label_6);
        
        label4 = new JLabel("");
        label4.setBackground(Color.WHITE);
        label4.setOpaque(true);
        contentPane.add(label4);
        
        JButton button4 = new JButton("���");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button4_actionPerformed(e);
            }
        });
        contentPane.add(button4);
    }
    
    protected void do_button1_actionPerformed(ActionEvent e) {
        setColor(label1);// ���w���Ҫ��C��]�w
    }
    
    private void setColor(JLabel label) {
        Color color = label.getBackground();// ��o��Ӫ��C��ﹳ
        // ����C���ܥ�͵���
        Color newColor = JColorChooser.showDialog(this, "����C��", color);
        label.setBackground(newColor);// ����o���C��]�w�����Ҫ��I����
    }
    
    protected void do_button2_actionPerformed(ActionEvent e) {
        setColor(label2);
    }
    
    protected void do_button3_actionPerformed(ActionEvent e) {
        setColor(label3);
    }
    
    protected void do_button4_actionPerformed(ActionEvent e) {
        setColor(label4);
    }
}
