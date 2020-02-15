import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class InsertSort extends JFrame {
    
    private JPanel contentPane;
    
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
                    InsertSort frame = new InsertSort();
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
    public InsertSort() {
        setTitle("\u4F7F\u7528\u76F4\u63A5\u63D2\u5165\u6CD5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 335, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textArea1 = new JTextArea();
        textArea1.setBounds(6, 6, 86, 250);
        contentPane.add(textArea1);
        
        JButton button = new JButton("產生亂數");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(104, 49, 114, 30);
        contentPane.add(button);
        
        JButton button_1 = new JButton("\u63D2\u5165\u6392\u5E8F\u6CD5");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(104, 161, 114, 30);
        contentPane.add(button_1);
        
        textArea2 = new JTextArea();
        textArea2.setBounds(230, 6, 86, 250);
        contentPane.add(textArea2);
    }
    
    private int[] array = new int[10];
    private JTextArea textArea1;
    private JTextArea textArea2;
    
protected void do_button_actionPerformed(ActionEvent e) {
    Random random = new Random();// 建立隨機數對像
    textArea1.setText("");
    for (int i = 0; i < array.length; i++) {// 初始化陣列元素
        array[i] = random.nextInt(90);// 產生50以內的隨機數
        textArea1.append(array[i] + "\n");// 把陣列元素顯示的文字域控制項中
    }
}
    
protected void do_button_1_actionPerformed(ActionEvent e) {
    int tmp;// 定義臨時變數
    int j;
    for (int i = 1; i < array.length; i++) {
        tmp = array[i];// 儲存臨時變數
        for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
            array[j + 1] = array[j];// 陣列元素交換
        }
        array[j + 1] = tmp;// 在排序位置插入資料
    }
    textArea2.setText("");
    for (int i = 0; i < array.length; i++) {// 初始化陣列元素
        textArea2.append(array[i] + "\n");// 把陣列元素顯示的文字域控制項中
    }
}
}
