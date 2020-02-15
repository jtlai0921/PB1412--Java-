package com.lzw.ip;

import java.awt.Component;
import java.awt.Dimension;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.swtdesigner.FocusTraversalOnArray;

public class IpField extends JPanel {
    private CText textField;
    private CText textField_1;
    private CText textField_2;
    private CText textField_3;
    
    /**
     * Create the panel.
     */
    public IpField() {
        setPreferredSize(new Dimension(141, 25));// 設定控制項初始首選大小
        setBorder(UIManager.getBorder("TextField.border"));// 採用文字框預設的邊框
        setBackground(UIManager.getColor("TextField.background"));// 採用文字框預設的背景色
        setSize(200, 25);// 初始大小
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));// 設定佈局管理器
        textField = new CText();// 建立自定義文字框
        add(textField);// 增加文字框到面板
        JLabel label = new JLabel(".");// 建立IP分隔符的標籤控制項
        add(label);
        textField_1 = new CText();// 建立自定義文字框
        add(textField_1);// 增加文字框到面板
        JLabel label_3 = new JLabel(".");// 建立IP分隔符的標籤控制項
        add(label_3);
        textField_2 = new CText();// 建立自定義文字框
        add(textField_2);
        JLabel label_2 = new JLabel(".");// 建立IP分隔符的標籤控制項
        add(label_2);
        textField_3 = new CText();// 建立自定義文字框
        add(textField_3);// 增加文字框到面板
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]
            { textField, textField_1, textField_2, textField_3 }));
    }
    
    public String getIpString() {// 撰寫獲得IP字串值的方法
        String ipstr = textField + "." + textField_1 + "." + textField_2 + "."
                + textField_3;// 把4個文字框的值連接為IP地址字串
        return ipstr;
    }
    
    public InetAddress getIpAddress() {// 撰寫獲得IP對象的方法
        InetAddress ia = null;// 建立一個空的IP地址對像
        try {
            ia = InetAddress.getByName(getIpString());// 把字串轉為IP地址對像
        } catch (UnknownHostException e) {
            e.printStackTrace();// 處理例外
        }
        return ia;// 傳回地址對像
    }
}
