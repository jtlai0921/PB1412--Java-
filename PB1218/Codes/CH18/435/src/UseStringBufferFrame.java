import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class UseStringBufferFrame extends JFrame {
    
    private JPanel contentPane;
    JCheckBox checkBox;
    JCheckBox checkBox_1;
    JCheckBox checkBox_2;
    JCheckBox checkBox_3;
    JCheckBox checkBox_4;
    JCheckBox checkBox_5;
    StringBuffer buffer = new StringBuffer();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UseStringBufferFrame frame = new UseStringBufferFrame();
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
    public UseStringBufferFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 344, 224);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("個人愛好");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 335, 186);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel label = new JLabel("你的個人愛好是：");
        label.setBounds(41, 21, 105, 24);
        panel.add(label);
        
        checkBox = new JCheckBox("游泳");
        checkBox.setBounds(41, 51, 103, 23);
        panel.add(checkBox);
        
        checkBox_1 = new JCheckBox("旅遊");
        checkBox_1.setBounds(187, 51, 103, 23);
        panel.add(checkBox_1);
        
        checkBox_2 = new JCheckBox("看書");
        checkBox_2.setBounds(41, 76, 103, 23);
        panel.add(checkBox_2);
        
        checkBox_3 = new JCheckBox("上網");
        checkBox_3.setBounds(187, 76, 103, 23);
        panel.add(checkBox_3);
        
        checkBox_4 = new JCheckBox("乒乓球");
        checkBox_4.setBounds(41, 101, 103, 23);
        panel.add(checkBox_4);
        
        checkBox_5 = new JCheckBox("羽毛球");
        checkBox_5.setBounds(187, 101, 103, 23);
        panel.add(checkBox_5);
        
        JButton saveButton = new JButton("寫入檔案");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(176, 140, 93, 23);
        panel.add(saveButton);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        if (checkBox.isSelected()) { // 判斷指定的復選框checkBox是否被勾選
            buffer.append(checkBox.getText() + " "); // 將可變的字符序列進行追加資訊
        }
        if (checkBox_1.isSelected()) {
            buffer.append(checkBox_1.getText() + " ");
        }
        if (checkBox_2.isSelected()) {
            buffer.append(checkBox_2.getText() + " ");
        }
        if (checkBox_3.isSelected()) {
            buffer.append(checkBox_3.getText() + " ");
        }
        if (checkBox_4.isSelected()) {
            buffer.append(checkBox_4.getText() + " ");
        }
        if (checkBox_5.isSelected()) {
            buffer.append(checkBox_5.getText() + " ");
        }
        File file = new File("C://w.txt"); // 根據指定檔案建立File對像
        try {
            FileOutputStream out = new FileOutputStream(file); // 建立FileOutputStream實例
            String str = buffer.toString(); // 將可變的字符序列轉為字串對像
            out.write(str.getBytes()); // 向輸出流中寫資料
            JOptionPane.showMessageDialog(getContentPane(), "資訊寫入完成！", "資訊提示框",
                    JOptionPane.WARNING_MESSAGE); // 給使用者提供提示資訊交談視窗
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
