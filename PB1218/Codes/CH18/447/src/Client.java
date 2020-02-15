

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame implements Runnable {
	private JPanel jpanel = new JPanel(); // 定義面板對像
	private JLabel nameLabel = new JLabel("姓名："); // 標籤對像
	private JTextField nameField = new JTextField(); // 文字框對像
	private JTextArea msgArea = new JTextArea(); // 文字域對像
	private JTextField sendField = new JTextField();
	private JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	private BufferedReader reader; // 建立BufferedReader類別對像
	private PrintWriter writer;
	private Socket socket; // 建立套接字對像
	public Client(String title) {
		super(title);
		this.setSize(360, 340); // 定義窗體大小
		this.add(jpanel);
		jpanel.setLayout(null); // 窗體佈局
		msgArea.setEditable(false); // msgView對像為不可編譯狀態
		jpanel.add(nameLabel); // 將標籤增加到面板上
		nameLabel.setBounds(10, 10, 60, 20); // 設定佈局
		jpanel.add(nameField);
		nameField.setBounds(60, 10, 270, 21);
		jpanel.add(sendField);
		sendField.setBounds(10, 270, 320, 21);
		msgArea.setColumns(20);
		msgArea.setRows(5);
		jScrollPane1.setViewportView(msgArea);
		jpanel.add(jScrollPane1);
		jScrollPane1.setBounds(10, 40, 320, 220);
		sendField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(nameField.getText() + ":" + sendField.getText()); // 將使用者名稱、使用者輸入資訊寫如流中
				sendField.setText(""); // 將發送文字框中內容清空
			}
		});
	}
	@Override
	public void run() {
		while (true) {
			try {
				msgArea.append(reader.readLine() + "\n"); // 在文字域中將讀取內容分行顯示
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	void getSocket() { // 建立套接字方法
		msgArea.append("嘗試與服務器連接");
		try {
			socket = new Socket("127.0.0.1", 7777); // 建立客戶端套接字對像
			msgArea.append("聊天準備完畢"); // 文字域中資訊
			reader = new BufferedReader(new InputStreamReader(socket
					.getInputStream())); // 實例化BufferedReader對像
			writer = new PrintWriter(socket.getOutputStream(), true); // 實例化PrintWriter對像
			new Thread(this).start(); // 啟動線程
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client = new Client("迷你聊天屋");
		client.setVisible(true); // 設定窗體為可見
		client.getSocket(); // 呼叫建立套接字方法
	}
}
