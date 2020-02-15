package com.cdd.createView;


import java.awt.Graphics;
import java.net.URL;
import javax.swing.*;

public class MyJPanel extends JPanel {
	public MyJPanel() {
		super();
	}

	public void paintComponent(Graphics g) {
		try {
			URL url = getClass().getResource("bg.jpg"); // ���w�Ϥ����|
			ImageIcon image = new ImageIcon(url); // �إ�ImageIcon�ﹳ
			g.drawImage(image.getImage(), 0, 0, this); // ø�s�Ϥ�
		} catch (Exception e) {
		}
	}
}
