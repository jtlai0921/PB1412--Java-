import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringConvert extends JFrame {
    private JTextField inputTextField;
    private JTextField outputTextField;
    /**
     * @wbp.nonvisual location=538,247
     */
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
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
                    StringConvert frame = new StringConvert();
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
    public StringConvert() {
        setTitle("大小寫轉換");
        setBounds(100, 100, 450, 214);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        inputTextField = new JTextField();
        inputTextField.setBounds(23, 21, 383, 31);
        getContentPane().add(inputTextField);
        inputTextField.setColumns(10);
        
        JButton button = new JButton("轉換");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(23, 77, 93, 23);
        getContentPane().add(button);
        
        JRadioButton radioButton = new JRadioButton("大寫");
        radioButton.setActionCommand("大寫");
        radioButton.setSelected(true);
        radioButton.setBounds(169, 77, 76, 23);
        buttonGroup.add(radioButton);
        getContentPane().add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("小寫");
        radioButton_1.setBounds(280, 77, 121, 23);
        radioButton_1.setActionCommand("小寫");
        buttonGroup.add(radioButton_1);
        getContentPane().add(radioButton_1);
        
        outputTextField = new JTextField();
        outputTextField.setEditable(false);
        outputTextField.setColumns(10);
        outputTextField.setBounds(23, 122, 383, 31);
        getContentPane().add(outputTextField);
        @SuppressWarnings("unused")
        String strBook = "MingRiBook".toLowerCase();
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        // 獲得大小寫單選項的選擇
        String command = buttonGroup.getSelection().getActionCommand();
        boolean upper = command.equals("大寫");// 判斷是否選擇的大寫單選項
        String text = inputTextField.getText();// 獲得輸入字串
        if (upper) {// 大寫轉換
            outputTextField.setText(text.toUpperCase());
        } else {// 小寫轉換
            outputTextField.setText(text.toLowerCase());
        }
    }
}
