package com.util;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
public class InsertWareFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField specTextField;
    private JTextField casingTextField;
    private JTextField unitTextField;
    private JTextField amountTextField;
    private WareUtil util = new WareUtil();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertWareFrame frame = new InsertWareFrame();
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
    public InsertWareFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 324);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("增加商品資訊");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 358, 292);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("名稱：");
        nameLabel.setBounds(57, 31, 54, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(108, 28, 184, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel specLabel = new JLabel("規格：");
        specLabel.setBounds(57, 70, 54, 15);
        panel.add(specLabel);
        
        specTextField = new JTextField();
        specTextField.setBounds(108, 67, 184, 21);
        panel.add(specTextField);
        specTextField.setColumns(10);
        
        JLabel casingLabel = new JLabel("包裝：");
        casingLabel.setBounds(57, 111, 54, 15);
        panel.add(casingLabel);
        
        casingTextField = new JTextField();
        casingTextField.setColumns(10);
        casingTextField.setBounds(108, 108, 184, 21);
        panel.add(casingTextField);
        
        JLabel unitLabel = new JLabel("單位：");
        unitLabel.setBounds(57, 150, 54, 15);
        panel.add(unitLabel);
        
        unitTextField = new JTextField();
        unitTextField.setBounds(107, 147, 185, 21);
        panel.add(unitTextField);
        unitTextField.setColumns(10);
        
        JLabel amountLabel = new JLabel("數量：");
        amountLabel.setBounds(57, 191, 54, 15);
        panel.add(amountLabel);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(108, 188, 184, 21);
        panel.add(amountTextField);
        amountTextField.setColumns(10);
        
        JButton insertButton = new JButton("增加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(86, 230, 65, 23);
        panel.add(insertButton);
        
        JButton watchButton = new JButton("檢視");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_watchButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(201, 230, 65, 23);
        panel.add(watchButton);
    }
    
    // 增加按鈕的單擊處理事件
    
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText(); // 獲得使用者增加的商品名稱
        String spec = specTextField.getText(); // 獲得使用者增加的商品規格
        String unit = unitTextField.getText(); // 獲得使用者增加的商品單位
        String casing = casingTextField.getText(); // 獲得使用者增加的商品包裝
        int count = Integer.parseInt(amountTextField.getText()); // 獲得使用者增加的商品數量
        int ID = 0;
        String sDate = WareUtil.getDateTime(); // 呼叫獲得系統時間方法
        List list = util.selectWare(); // 獲得商品表中全部的商品
        String sid = "";
        for (int i = 0; i < list.size(); i++) { // 循環檢查查詢結果集
            Ware ware = (Ware) list.get(i); // 獲得商品
            sid = ware.getSID(); // 獲得商品編號
        }
        if (list.size() == 0) { // 如果商品集合中為空
            sid = "CS" + sDate.replace("-", "") + "00001"; // 定義商品編號
        } else { // 如果商品集合不為空
            sid = sid.trim();
            ID = Integer.parseInt(sid.substring(sid.length() - 5)); // 截取商品編號中的後五位
            sid = sid.substring(0, sid.length() - 5)
                    + String.format("%05d", ID + 1); // 定義商品編號
        }
        Ware ware = new Ware(); // 定義與商品表對應的JavaBean對像
        ware.setSID(sid); // 設定JavaBean編號
        ware.setsName(name);
        ware.setSpec(spec);
        ware.setUnit(unit);
        ware.setsDate(sDate);
        ware.setCasing(casing);
        ware.setAmout(count);
        util.insertWare(ware); // 增加商品資訊
        JOptionPane.showMessageDialog(getContentPane(), "資料增加成功！", "資訊提示框",
                JOptionPane.CANCEL_OPTION);
        
    }
    
    // 檢視按鈕的單擊處理事件
    protected void do_watchButton_actionPerformed(ActionEvent arg0) {
        SelectWareFrame selectWare = new SelectWareFrame();
        selectWare.setVisible(true);
    }
}
