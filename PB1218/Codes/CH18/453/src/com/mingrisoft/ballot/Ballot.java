package com.mingrisoft.ballot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

class Candidate extends JCheckBox { // 定義內容類別，該類別繼承JCheckBox類別
    int len = 0;
    
    Candidate(String name, Icon icon) { // 該類別包含有兩個參數
        super(name, icon);
    }
    
    public int getBallot(String name) {
        File file = new File("C://count.txt"); // 建立檔案對像
        FileReader fis;
        try {
            if (!file.exists()) // 如果該檔案不存在
                file.createNewFile(); // 新增檔案
            fis = new FileReader(file);
            BufferedReader bis = new BufferedReader(fis); // 建立BufferedReader對像
            String str[] = new String[3];
            String size;
            int i = 0;
            while ((size = bis.readLine()) != null) { // 循環讀取檔案內容
                str[i] = size.trim(); // 去除字串中的空格
                if (str[i].startsWith(name)) {
                    int length = str[i].indexOf(":");
                    String sub = str[i].substring(length + 1, str[i].length()); // 對字串進行截取
                    len = Integer.parseInt(sub);
                    continue;
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return len;
    }
    
    public void addBallot(String name) { // 定義增加選票方法
        File file = new File("C://count.txt"); // 建立檔案對像
        FileReader fis;
        try {
            if (!file.exists()) // 如果該檔案不存在
                file.createNewFile(); // 新增檔案
            fis = new FileReader(file); // 對FileReader對像進行實例化
            BufferedReader bis = new BufferedReader(fis);
            String str[] = new String[3];
            String size;
            int i = 0;
            while ((size = bis.readLine()) != null) { // 循環讀取檔案
                str[i] = size.trim();
                if (str[i].startsWith(name)) {
                    int length = str[i].indexOf(":"); // 獲得指定字符索引位置
                    String sub = str[i].substring(length + 1, str[i].length()); // 對字串進行截取
                    len = Integer.parseInt(sub) + 1;
                    break;
                }
                i++;
            }
            FileWriter fw = new FileWriter(file); // 建立FileWriter 對像
            BufferedWriter bufw = new BufferedWriter(fw);
            bufw.write(name + ":" + len); // 向流中寫資料
            
            bufw.close(); // 關閉流
            fw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyMin extends JFrame implements ActionListener {
    Box baseBox, boxH, boxV; // 建立Box對像
    JTextArea text; // 建立JTextArea對像
    JButton button; // 建立JButton對像
    Candidate candidateOne, candidateTwo, candidateThree;
    
    public MyMin() { // 在建構方法中設定窗體佈局
        setBounds(100, 100, 500, 120);
        setVisible(true);
        setTitle("選出你心中的好幹部！！");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // 窗體關閉事件
                System.exit(0);
            }
        });
        baseBox = Box.createHorizontalBox();
        boxH = Box.createHorizontalBox();
        boxV = Box.createHorizontalBox();
        candidateOne = new Candidate("小兵", new ImageIcon(getClass()
                .getResource("0.gif")));
        candidateTwo = new Candidate("小陳", new ImageIcon(getClass()
                .getResource("1.gif")));
        candidateThree = new Candidate("小李", new ImageIcon(getClass()
                .getResource("2.gif")));
        candidateOne.setSelectedIcon(new ImageIcon(getClass().getResource(
                "0.gif")));
        candidateTwo.setSelectedIcon(new ImageIcon(getClass().getResource(
                "1.gif")));
        candidateThree.setSelectedIcon(new ImageIcon(getClass().getResource(
                "2.gif")));
        boxH.add(candidateOne);
        boxH.add(candidateTwo);
        boxH.add(candidateThree);
        text = new JTextArea();
        button = new JButton("顯示得票數");
        button.addActionListener(this);
        boxV.add(text);
        boxV.add(button);
        boxV.add(boxH);
        baseBox.add(boxV);
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        con.add(baseBox);
        con.validate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText(null);
        File file = new File("C://count.txt"); // 建立檔案對像
        if (!file.exists()) { // 如果該檔案不存在
            try {
                file.createNewFile(); // 新增檔案
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (candidateOne.isSelected()) {
            candidateOne.addBallot(candidateOne.getText());
        }
        if (candidateTwo.isSelected()) {
            candidateTwo.addBallot(candidateTwo.getText());
        }
        if (candidateThree.isSelected()) {
            candidateThree.addBallot(candidateThree.getText());
        }
        text.append(candidateOne.getText() + ":"
                + candidateOne.getBallot(candidateOne.getText()) + "\n");
        // 向文字框中追加資訊
        text.append(candidateTwo.getText() + ":"
                + candidateTwo.getBallot(candidateTwo.getText()) + "\n");
        text.append(candidateThree.getText() + ":"
                + candidateThree.getBallot(candidateThree.getText()) + "\n");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file); // 建立FileWriter類別對像
            BufferedWriter bufw = new BufferedWriter(fw); // 建立BufferedWriter類別對像
            bufw.write(text.getText()); // 將字串陣列中元素寫入到磁碟檔案中
            bufw.close(); // 將BufferedWriter流關閉
            fw.close();
            
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        candidateOne.setSelected(false);
        candidateTwo.setSelected(false);
        candidateThree.setSelected(false);
    }
    
}

public class Ballot {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MyMin();
    }
}
