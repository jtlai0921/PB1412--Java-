package com.lzw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.lzw.BackgroundPanel;
import com.swtdesigner.SwingResourceManager;

public class MainFrame extends JFrame {

	private JTextField textField_3;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JComboBox cityComboBox;
	private JComboBox comboBox;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public MainFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 518, 379);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//獲得預設的市/縣
		String province=(String)getProvince()[0];
		setTitle("輸入指定省/直轄市查詢對應的市縣");

		final BackgroundPanel backgroundPanel = new BackgroundPanel();
		backgroundPanel.setImage(SwingResourceManager.getImage(MainFrame.class, "/images/background.jpg"));
		backgroundPanel.setBounds(0, 0, 510, 380);
		getContentPane().add(backgroundPanel);

		final JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(36, 126, 438, 70);
		backgroundPanel.add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "居住地", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		cityComboBox = new JComboBox();
		cityComboBox.setBounds(245, 25, 124, 27);
		panel.add(cityComboBox);
		
		cityComboBox.setModel(new DefaultComboBoxModel(getCity(province)));

		comboBox = new JComboBox();
		comboBox.setBounds(25, 25, 124, 27);
		panel.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent e) { // 選項狀態更改事件
				itemChange();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(getProvince())); // 增加省份資訊

		final JLabel label = new JLabel();
		label.setText("省/直轄市");
		label.setBounds(155, 30, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("市/縣");
		label_1.setBounds(375, 30, 37, 18);
		panel.add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setBounds(36, 43, 65, 18);
		backgroundPanel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setHorizontalTextPosition(SwingConstants.LEADING);
		label_2.setText("姓    名：");

		textField = new JTextField();
		textField.setBounds(113, 38, 154, 28);
		backgroundPanel.add(textField);

		final JLabel label_3 = new JLabel();
		label_3.setBounds(36, 84, 65, 18);
		backgroundPanel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setHorizontalTextPosition(SwingConstants.LEADING);
		label_3.setText("性    別：");

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(113, 81, 66, 25);
		backgroundPanel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));

		final JLabel label_4 = new JLabel();
		label_4.setBounds(36, 212, 65, 18);
		backgroundPanel.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4.setText("詳細地址：");

		textField_1 = new JTextField();
		textField_1.setBounds(113, 208, 367, 28);
		backgroundPanel.add(textField_1);

		final JLabel label_4_1 = new JLabel();
		label_4_1.setBounds(36, 252, 65, 18);
		backgroundPanel.add(label_4_1);
		label_4_1.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4_1.setText("E-mail：");

		textField_3 = new JTextField();
		textField_3.setBounds(113, 248, 367, 27);
		backgroundPanel.add(textField_3);

		final JButton button = new JButton();
		button.setBounds(159, 289, 75, 28);
		backgroundPanel.add(button);
		button.setText("儲存");

		final JButton button_1 = new JButton();
		button_1.setBounds(265, 289, 75, 28);
		backgroundPanel.add(button_1);
		button_1.setText("重置");
		//
	}

	/**
	 * 獲得省、直轄市，自治區
	 * 
	 * @return
	 */
	public Object[] getProvince() {
		Map<String, String[]> map = CityMap.model;// 獲得省份資訊儲存到Map中
		Set<String> set = map.keySet(); // 獲得Map集合中的鍵，並以Set集合傳回
		Object[] province = set.toArray(); // 轉為陣列
		return province; // 傳回獲得的省份資訊
	}

	/**
	 * 獲得指定省對應的市/縣
	 * 
	 * @param selectProvince
	 * @return
	 */
	public String[] getCity(String selectProvince) {
		Map<String, String[]> map = CityMap.model; // 獲得省份資訊儲存到Map中
		String[] arrCity = map.get(selectProvince); // 獲得指定鍵的值
		return arrCity; // 傳回獲得的市/縣
	}

    private void itemChange() {
        String selectProvince = (String) comboBox.getSelectedItem();
        cityComboBox.removeAllItems(); // 清空市/縣列表
        String[] arrCity = getCity(selectProvince); // 獲得市/縣
        cityComboBox.setModel(new DefaultComboBoxModel(arrCity)); // 重新增加市/縣列表的值
    }

}
