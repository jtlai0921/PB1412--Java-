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
			URL url = getClass().getResource("bg.jpg"); // 指定圖片路徑
			ImageIcon image = new ImageIcon(url); // 建立ImageIcon對像
			g.drawImage(image.getImage(), 0, 0, this); // 繪製圖片
		} catch (Exception e) {
		}
	}
}
