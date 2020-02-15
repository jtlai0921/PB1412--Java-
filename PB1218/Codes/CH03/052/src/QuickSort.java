import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class QuickSort extends JFrame {
    
    private JPanel contentPane;
    
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
                    QuickSort frame = new QuickSort();
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
    public QuickSort() {
        setTitle("快速排序法");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);
        
        JButton button = new JButton("產生");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.gridx = 0;
        gbc_textField.gridy = 0;
        contentPane.add(textField, gbc_textField);
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 1;
        contentPane.add(button, gbc_button);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 0;
        gbc_scrollPane_1.gridy = 2;
        contentPane.add(scrollPane_1, gbc_scrollPane_1);
        
        textArea2 = new JTextArea();
        scrollPane_1.setViewportView(textArea2);
        
        JButton button_1 = new JButton("\u5FEB\u901F\u6392\u5E8F\u6CD5");
        button_1.setActionCommand("\u5FEB\u901F\u6392\u5E8F\u6CD5");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button_1 = new GridBagConstraints();
        gbc_button_1.gridx = 0;
        gbc_button_1.gridy = 3;
        contentPane.add(button_1, gbc_button_1);
    }
    
    private int[] array = new int[10];
    private JTextField textField;
    private JTextArea textArea2;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Random random = new Random();// 建立隨機數對像
        String text = "";
        for (int i = 0; i < array.length; i++) {// 初始化陣列元素
            array[i] = random.nextInt(90);// 產生50以內的隨機數
            text += (array[i] + "  ");// 把陣列元素顯示的文字域控制項中
        }
        textField.setText(text);
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        textArea2.setText("");// 清空文字域
        quickSort(array, 0, array.length - 1);// 呼叫快速排序算法
    }
    
    private void quickSort(int sortarray[], int lowIndex, int highIndex) {
        int lo = lowIndex;// 記錄最小索引
        int hi = highIndex;// 記錄最大索引
        int mid;// 記錄分界點元素
        if (highIndex > lowIndex) {
            mid = sortarray[(lowIndex + highIndex) / 2];// 確定中間分界點元素值
            while (lo <= hi) {
                while ((lo < highIndex) && (sortarray[lo] < mid))
                    ++lo;// 確定不大於分界元素值的最小索引
                while ((hi > lowIndex) && (sortarray[hi] > mid))
                    --hi;// 確定大於分界元素值的最大索引
                if (lo <= hi) {// 如果最小與最大索引沒有重疊
                    swap(sortarray, lo, hi);// 交換兩個索引的元素
                    ++lo;// 遞增最小索引
                    --hi;// 遞減最大索引
                }
            }
            if (lowIndex < hi)// 遞歸排序沒有未分解元素
                quickSort(sortarray, lowIndex, hi);
            if (lo < highIndex)// 遞歸排序沒有未分解元素
                quickSort(sortarray, lo, highIndex);
        }
    }
    
    private void swap(int swapArray[], int i, int j) {
        int temp = swapArray[i];// 交換陣列元素
        swapArray[i] = swapArray[j];
        swapArray[j] = temp;
        for (int k = 0; k < array.length; k++) {// 把陣列元素顯示到文字域
            textArea2.append(array[k] + "  ");
        }
        textArea2.append("\n");// 追加換行符
    }
    
}
