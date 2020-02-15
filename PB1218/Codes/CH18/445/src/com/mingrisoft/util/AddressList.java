package com.mingrisoft.util;
import java.io.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;
class InputArea extends JPanel implements ActionListener{
	File f = null;
	RandomAccessFile out;
	Box baseBox,boxV1,boxV2;
	TextField name,email,phone;
	JButton button;
	public InputArea(File f) {
		setBackground(Color.cyan);
		this.f = f;
		name = new TextField(12);
		email = new TextField(12);
		phone = new TextField(12);
		button = new JButton("輸入");
		button.addActionListener(this);
		boxV1 = Box.createVerticalBox();
		boxV1.add(new Label("輸入姓名"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new Label("輸入email"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new Label("輸入電話"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new Label("單擊輸入"));
		boxV2 = Box.createVerticalBox();
		boxV2.add(name);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(email);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(phone);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(button);
		baseBox = Box.createHorizontalBox(); 
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);
		add(baseBox);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			RandomAccessFile out = new RandomAccessFile(f,"rw");
			if(f.exists()){
				long length = f.length();
				out.seek(length);
				
			}
			out.writeUTF("姓名："+name.getText());
			out.writeUTF("電子郵件："+email.getText());
			out.writeUTF("電話："+phone.getText());
			out.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
public class AddressList extends JFrame implements ActionListener{
	File file = null;
	MenuBar bar;
	Menu fileMenu;
	MenuItem kinescope,reveal;
	TextArea show;
	InputArea inputMessage;
	CardLayout card = null;
	Panel pCenter;
	public AddressList() {
		file = new File("通訊錄.txt");
		kinescope = new MenuItem("輸入");
		reveal = new MenuItem("顯示");
		bar = new MenuBar();
		fileMenu = new Menu("選單選項");
		fileMenu.add(kinescope);
		fileMenu.add(reveal);
		bar.add(fileMenu);
		setMenuBar(bar);
		kinescope.addActionListener(this);
		reveal.addActionListener(this);
		inputMessage = new InputArea(file);
		show = new TextArea(12,20);
		card = new CardLayout();
		pCenter = new Panel();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
