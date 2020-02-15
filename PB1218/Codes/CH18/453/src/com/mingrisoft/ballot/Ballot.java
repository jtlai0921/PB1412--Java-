package com.mingrisoft.ballot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

class Candidate extends JCheckBox { // �w�q���e���O�A�����O�~��JCheckBox���O
    int len = 0;
    
    Candidate(String name, Icon icon) { // �����O�]�t����ӰѼ�
        super(name, icon);
    }
    
    public int getBallot(String name) {
        File file = new File("C://count.txt"); // �إ��ɮ׹ﹳ
        FileReader fis;
        try {
            if (!file.exists()) // �p�G���ɮפ��s�b
                file.createNewFile(); // �s�W�ɮ�
            fis = new FileReader(file);
            BufferedReader bis = new BufferedReader(fis); // �إ�BufferedReader�ﹳ
            String str[] = new String[3];
            String size;
            int i = 0;
            while ((size = bis.readLine()) != null) { // �`��Ū���ɮפ��e
                str[i] = size.trim(); // �h���r�ꤤ���Ů�
                if (str[i].startsWith(name)) {
                    int length = str[i].indexOf(":");
                    String sub = str[i].substring(length + 1, str[i].length()); // ��r��i��I��
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
    
    public void addBallot(String name) { // �w�q�W�[�ﲼ��k
        File file = new File("C://count.txt"); // �إ��ɮ׹ﹳ
        FileReader fis;
        try {
            if (!file.exists()) // �p�G���ɮפ��s�b
                file.createNewFile(); // �s�W�ɮ�
            fis = new FileReader(file); // ��FileReader�ﹳ�i���Ҥ�
            BufferedReader bis = new BufferedReader(fis);
            String str[] = new String[3];
            String size;
            int i = 0;
            while ((size = bis.readLine()) != null) { // �`��Ū���ɮ�
                str[i] = size.trim();
                if (str[i].startsWith(name)) {
                    int length = str[i].indexOf(":"); // ��o���w�r�ů��ަ�m
                    String sub = str[i].substring(length + 1, str[i].length()); // ��r��i��I��
                    len = Integer.parseInt(sub) + 1;
                    break;
                }
                i++;
            }
            FileWriter fw = new FileWriter(file); // �إ�FileWriter �ﹳ
            BufferedWriter bufw = new BufferedWriter(fw);
            bufw.write(name + ":" + len); // �V�y���g���
            
            bufw.close(); // �����y
            fw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyMin extends JFrame implements ActionListener {
    Box baseBox, boxH, boxV; // �إ�Box�ﹳ
    JTextArea text; // �إ�JTextArea�ﹳ
    JButton button; // �إ�JButton�ﹳ
    Candidate candidateOne, candidateTwo, candidateThree;
    
    public MyMin() { // �b�غc��k���]�w����G��
        setBounds(100, 100, 500, 120);
        setVisible(true);
        setTitle("��X�A�ߤ����n�F���I�I");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // ���������ƥ�
                System.exit(0);
            }
        });
        baseBox = Box.createHorizontalBox();
        boxH = Box.createHorizontalBox();
        boxV = Box.createHorizontalBox();
        candidateOne = new Candidate("�p�L", new ImageIcon(getClass()
                .getResource("0.gif")));
        candidateTwo = new Candidate("�p��", new ImageIcon(getClass()
                .getResource("1.gif")));
        candidateThree = new Candidate("�p��", new ImageIcon(getClass()
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
        button = new JButton("��ܱo����");
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
        File file = new File("C://count.txt"); // �إ��ɮ׹ﹳ
        if (!file.exists()) { // �p�G���ɮפ��s�b
            try {
                file.createNewFile(); // �s�W�ɮ�
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
        // �V��r�ؤ��l�[��T
        text.append(candidateTwo.getText() + ":"
                + candidateTwo.getBallot(candidateTwo.getText()) + "\n");
        text.append(candidateThree.getText() + ":"
                + candidateThree.getBallot(candidateThree.getText()) + "\n");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file); // �إ�FileWriter���O�ﹳ
            BufferedWriter bufw = new BufferedWriter(fw); // �إ�BufferedWriter���O�ﹳ
            bufw.write(text.getText()); // �N�r��}�C�������g�J��Ϻ��ɮפ�
            bufw.close(); // �NBufferedWriter�y����
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