import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowTitleBorder extends JFrame {
    
    private JPanel contentPane;
    private ButtonGroup bg;
    private Font font = null;
    private TitledBorder titledBorder;
    private JPanel panel;
    
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
                    ShowTitleBorder frame = new ShowTitleBorder();
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
    public ShowTitleBorder() {
        setTitle("指定字體的標題邊框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 322, 221);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        panel = new JPanel();// 建立面板
        font = new Font("黑體", Font.BOLD, 18);// 初始化字體對像
        titledBorder = new TitledBorder(null, "自定義字體標題", TitledBorder.LEADING,
                TitledBorder.TOP, font, new Color(255, 0, 0));// 建立標題邊框對像
        panel.setBorder(titledBorder);// 設定面板的邊框
        contentPane.add(panel);
        panel.setLayout(null);
        
        JRadioButton radioButton = new JRadioButton("黑體");// 建立黑體單選按鈕
        radioButton.setActionCommand(radioButton.getText());
        radioButton.setSelected(true);// 預設為選擇狀態
        radioButton.setBounds(14, 31, 104, 32);
        panel.add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("細明體");// 建立細明體單選按鈕
        radioButton_1.setActionCommand(radioButton_1.getText());
        radioButton_1.setBounds(14, 63, 104, 32);
        panel.add(radioButton_1);
        
        JRadioButton radioButton_2 = new JRadioButton("隸書");// 建立隸書單選按鈕
        radioButton_2.setActionCommand(radioButton_2.getText());
        radioButton_2.setBounds(14, 95, 104, 32);
        panel.add(radioButton_2);
        
        JRadioButton radioButton_3 = new JRadioButton("仿宋");// 建立仿宋單選按鈕
        radioButton_3.setActionCommand(radioButton_3.getText());
        radioButton_3.setBounds(14, 127, 104, 32);
        panel.add(radioButton_3);
        
        bg = new ButtonGroup();// 建立按鈕組
        bg.add(radioButton);// 把4個單選按鈕增加到按鈕組中
        bg.add(radioButton_1);
        bg.add(radioButton_2);
        bg.add(radioButton_3);
        
        JButton button = new JButton("設定");// 建立設定按鈕
        button.addActionListener(new ActionListener() {// 為設定按鈕增加事件監聽器
                    public void actionPerformed(ActionEvent e) {
                        do_button_actionPerformed(e);
                    }
                });
        button.setBounds(161, 128, 90, 30);
        panel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        // 獲得被選擇的單選按鈕的文字
        String command = bg.getSelection().getActionCommand();
        font = new Font(command, Font.BOLD, 18);// 建立新字體對像
        titledBorder.setTitleFont(font);// 為邊框對像設定字體
        panel.setBorder(titledBorder);// 更新面板的邊框對像
        panel.repaint();// 跟新面板界面
    }
}
