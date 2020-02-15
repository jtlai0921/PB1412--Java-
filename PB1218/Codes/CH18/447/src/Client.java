

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame implements Runnable {
	private JPanel jpanel = new JPanel(); // �w�q���O�ﹳ
	private JLabel nameLabel = new JLabel("�m�W�G"); // ���ҹﹳ
	private JTextField nameField = new JTextField(); // ��r�عﹳ
	private JTextArea msgArea = new JTextArea(); // ��r��ﹳ
	private JTextField sendField = new JTextField();
	private JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	private BufferedReader reader; // �إ�BufferedReader���O�ﹳ
	private PrintWriter writer;
	private Socket socket; // �إ߮M���r�ﹳ
	public Client(String title) {
		super(title);
		this.setSize(360, 340); // �w�q����j�p
		this.add(jpanel);
		jpanel.setLayout(null); // ����G��
		msgArea.setEditable(false); // msgView�ﹳ�����i�sĶ���A
		jpanel.add(nameLabel); // �N���ҼW�[�쭱�O�W
		nameLabel.setBounds(10, 10, 60, 20); // �]�w�G��
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
				writer.println(nameField.getText() + ":" + sendField.getText()); // �N�ϥΪ̦W�١B�ϥΪ̿�J��T�g�p�y��
				sendField.setText(""); // �N�o�e��r�ؤ����e�M��
			}
		});
	}
	@Override
	public void run() {
		while (true) {
			try {
				msgArea.append(reader.readLine() + "\n"); // �b��r�줤�NŪ�����e�������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	void getSocket() { // �إ߮M���r��k
		msgArea.append("���ջP�A�Ⱦ��s��");
		try {
			socket = new Socket("127.0.0.1", 7777); // �إ߫Ȥ�ݮM���r�ﹳ
			msgArea.append("��ѷǳƧ���"); // ��r�줤��T
			reader = new BufferedReader(new InputStreamReader(socket
					.getInputStream())); // ��Ҥ�BufferedReader�ﹳ
			writer = new PrintWriter(socket.getOutputStream(), true); // ��Ҥ�PrintWriter�ﹳ
			new Thread(this).start(); // �Ұʽu�{
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client = new Client("�g�A��ѫ�");
		client.setVisible(true); // �]�w���鬰�i��
		client.getSocket(); // �I�s�إ߮M���r��k
	}
}
