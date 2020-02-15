import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class DynamicArray extends JFrame {
    
    private JPanel contentPane;
    private final JPanel panel = new JPanel();
    
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
                    DynamicArray frame = new DynamicArray();
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
    public DynamicArray() {
        setTitle("用動態陣列保存學生姓名");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 269);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        scrollPane.setViewportView(list);
        
        JPanel panel_1 = new JPanel();
        scrollPane.setColumnHeaderView(panel_1);
        
        JLabel label = new JLabel("學生姓名");
        panel_1.add(label);
        
        textField = new JTextField();
        panel_1.add(textField);
        textField.setColumns(10);
        panel.setPreferredSize(new Dimension(100, 10));
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton button = new JButton("加學生");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
        
        JButton button_1 = new JButton("刪學生");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        panel.add(button_1);
    }
    
    private ArrayList<String> arraylist = new ArrayList<String>();
    private JTextField textField;
    private JList list;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        textField.requestFocusInWindow();
        textField.selectAll();// 選擇文字框文字準備下次輸入
        String text = textField.getText();// 獲得使用者輸入姓名
        if (text.isEmpty())// 過濾為輸入姓名的情況
            return;
        arraylist.add(text);// 把姓名增加到陣列集合中
        replaceModel();// 把陣列集合中內容顯示到界面列表控制項中
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        Object value = list.getSelectedValue();// 獲得列表控制項的選擇項
        arraylist.remove(value);// 從陣列集合中移除使用者的選擇項
        replaceModel();// 把陣列集合中內容顯示到界面列表控制項中
    }
    
    private void replaceModel() {
        // 為列表控制項設定資料模型顯示陣列集合中的資料
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() {// 獲得陣列大小
                return arraylist.size();
            }
            
            @Override
            public Object getElementAt(int index) {// 獲得指定索引元素
                return arraylist.get(index);
            }
        });
    }
}
