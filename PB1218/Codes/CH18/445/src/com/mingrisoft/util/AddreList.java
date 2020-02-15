package com.mingrisoft.util;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
public class AddreList extends JFrame implements ActionListener {
	private JTextField phonetextField;			//建立文字框元件
	private JTextField emailtextField;
	private JTextField nametextField;
	final JPanel panel = new JPanel();			//建立面板元件
	JMenu fileMenu;								//定義選單對像
	JMenuItem reveal;
	JMenuItem kinescope;
	JPanel jPanel  = new JPanel();
	File file = new File("C://addressList.txt");	//建立檔案對像
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddreList frame = new AddreList();		//建立本類別對像
					frame.setVisible(true);			//設定窗體可視狀態
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public AddreList() {				//建構方法中實現窗體佈局
		super();
		setTitle("個人通訊錄");			//設定窗體標題
		getContentPane().setLayout(null);		//設定窗體佈局
		setBounds(100, 100, 382, 237);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar bar = new JMenuBar();	
		fileMenu = new JMenu("檔案");
		reveal = new JMenuItem("顯示");
		kinescope = new JMenuItem("輸入");
		reveal.addActionListener(this);
		kinescope.addActionListener(this);
		this.setJMenuBar(bar);
		bar.add(fileMenu);
		fileMenu.add(reveal);
		fileMenu.add(kinescope);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 374, 178);
		getContentPane().add(panel);

		final JLabel namelabel = new JLabel();
		namelabel.setBounds(77, 29, 66, 18);
		namelabel.setText("輸入姓名：");
		panel.add(namelabel);

		nametextField = new JTextField();
		nametextField.setBounds(149, 27, 122, 22);
		panel.add(nametextField);

		final JLabel emaillabel = new JLabel();
		emaillabel.setBounds(77, 66, 66, 18);
		emaillabel.setText("輸入Email:");
		panel.add(emaillabel);

		emailtextField = new JTextField();
		emailtextField.setBounds(149, 64, 122, 22);
		panel.add(emailtextField);

		final JLabel phonelabel = new JLabel();
		phonelabel.setText("輸入電話：");
		phonelabel.setBounds(77, 103, 66, 18);
		panel.add(phonelabel);

		phonetextField = new JTextField();
		phonetextField.setBounds(149, 101, 122, 22);
		panel.add(phonetextField);

		final JLabel label = new JLabel();
		label.setText("單擊輸入：");
		label.setBounds(77, 137, 66, 18);
		panel.add(label);

		final JButton kinbutton = new JButton();
		kinbutton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				kinbuttonActionPerformed(e);
				
			}
		});
		kinbutton.setText("輸入");
		kinbutton.setBounds(149, 132, 122, 28);
		panel.add(kinbutton);	
	}

private void kinbuttonActionPerformed(java.awt.event.ActionEvent evt) {
	try {
		if(nametextField.getText().equals("")||
				(emailtextField.getText().equals(""))||
				(phonetextField.getText().equals(""))){		//如果使用者沒有將資訊輸入完整
			JOptionPane.showMessageDialog(this, "請輸入完整內容", "資訊提示框",
					JOptionPane.WARNING_MESSAGE);			//舉出提示資訊
			return;				//退出程式
		}
		if(!file.exists())		//如果檔案不存在
			file.createNewFile();		//新增檔案
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file,true)));		//建立BufferedWriter對像
		out.write("姓名："+nametextField.getText()+"， ");		//向檔案中寫內容
		out.write("電子郵件："+emailtextField.getText()+"， ");
		out.write("電話："+phonetextField.getText());
		out.newLine();			//新增一行
		out.close();			//關閉流
	} catch (Exception e1) {					
		e1.printStackTrace();
	}
}
	@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == reveal){			//如果使用者單擊的是顯示選單項			
	try {
		getContentPane().remove(panel);			
		jPanel.setLayout(null);				//設定窗體佈局		
		jPanel.setBounds(0, 0, 374, 178);
		JTextArea jtextarea = new JTextArea(20,10);		//建立文字域對像
		jtextarea.setBounds(0, 0, 374, 178);	//設定文字域顯示位置與大小	
		getContentPane().add(jPanel);			//窗體中增加面板
		jPanel.add(jtextarea);					//向面板中增加文字域
		BufferedReader in = new BufferedReader(new FileReader(file));	//建立BufferedReader	對像
		String name = null;
		int number = 1;
		while((name = in.readLine())!= null){	//循環從檔案中讀資料			
			jtextarea.append("\n"+number+"、 "+name);		//將讀取資料顯示在文字域中			
			name = new String(name);			
			number++;
		}
		in.close();
		repaint();
	} catch (Exception e1) {		
		e1.printStackTrace();
	}
}
	if(e.getSource() == kinescope){				//如果使用者單擊輸入選單項
		getContentPane().remove(jPanel);		//將面板移除窗體
		getContentPane().add(panel);
		repaint();						//窗體重繪
	}
}
}
