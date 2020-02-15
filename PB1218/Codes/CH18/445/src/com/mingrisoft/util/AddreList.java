package com.mingrisoft.util;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
public class AddreList extends JFrame implements ActionListener {
	private JTextField phonetextField;			//�إߤ�r�ؤ���
	private JTextField emailtextField;
	private JTextField nametextField;
	final JPanel panel = new JPanel();			//�إ߭��O����
	JMenu fileMenu;								//�w�q���ﹳ
	JMenuItem reveal;
	JMenuItem kinescope;
	JPanel jPanel  = new JPanel();
	File file = new File("C://addressList.txt");	//�إ��ɮ׹ﹳ
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddreList frame = new AddreList();		//�إߥ����O�ﹳ
					frame.setVisible(true);			//�]�w����i�����A
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public AddreList() {				//�غc��k����{����G��
		super();
		setTitle("�ӤH�q�T��");			//�]�w������D
		getContentPane().setLayout(null);		//�]�w����G��
		setBounds(100, 100, 382, 237);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar bar = new JMenuBar();	
		fileMenu = new JMenu("�ɮ�");
		reveal = new JMenuItem("���");
		kinescope = new JMenuItem("��J");
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
		namelabel.setText("��J�m�W�G");
		panel.add(namelabel);

		nametextField = new JTextField();
		nametextField.setBounds(149, 27, 122, 22);
		panel.add(nametextField);

		final JLabel emaillabel = new JLabel();
		emaillabel.setBounds(77, 66, 66, 18);
		emaillabel.setText("��JEmail:");
		panel.add(emaillabel);

		emailtextField = new JTextField();
		emailtextField.setBounds(149, 64, 122, 22);
		panel.add(emailtextField);

		final JLabel phonelabel = new JLabel();
		phonelabel.setText("��J�q�ܡG");
		phonelabel.setBounds(77, 103, 66, 18);
		panel.add(phonelabel);

		phonetextField = new JTextField();
		phonetextField.setBounds(149, 101, 122, 22);
		panel.add(phonetextField);

		final JLabel label = new JLabel();
		label.setText("������J�G");
		label.setBounds(77, 137, 66, 18);
		panel.add(label);

		final JButton kinbutton = new JButton();
		kinbutton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				kinbuttonActionPerformed(e);
				
			}
		});
		kinbutton.setText("��J");
		kinbutton.setBounds(149, 132, 122, 28);
		panel.add(kinbutton);	
	}

private void kinbuttonActionPerformed(java.awt.event.ActionEvent evt) {
	try {
		if(nametextField.getText().equals("")||
				(emailtextField.getText().equals(""))||
				(phonetextField.getText().equals(""))){		//�p�G�ϥΪ̨S���N��T��J����
			JOptionPane.showMessageDialog(this, "�п�J���㤺�e", "��T���ܮ�",
					JOptionPane.WARNING_MESSAGE);			//�|�X���ܸ�T
			return;				//�h�X�{��
		}
		if(!file.exists())		//�p�G�ɮפ��s�b
			file.createNewFile();		//�s�W�ɮ�
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file,true)));		//�إ�BufferedWriter�ﹳ
		out.write("�m�W�G"+nametextField.getText()+"�A ");		//�V�ɮפ��g���e
		out.write("�q�l�l��G"+emailtextField.getText()+"�A ");
		out.write("�q�ܡG"+phonetextField.getText());
		out.newLine();			//�s�W�@��
		out.close();			//�����y
	} catch (Exception e1) {					
		e1.printStackTrace();
	}
}
	@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == reveal){			//�p�G�ϥΪ̳������O��ܿ�涵			
	try {
		getContentPane().remove(panel);			
		jPanel.setLayout(null);				//�]�w����G��		
		jPanel.setBounds(0, 0, 374, 178);
		JTextArea jtextarea = new JTextArea(20,10);		//�إߤ�r��ﹳ
		jtextarea.setBounds(0, 0, 374, 178);	//�]�w��r����ܦ�m�P�j�p	
		getContentPane().add(jPanel);			//���餤�W�[���O
		jPanel.add(jtextarea);					//�V���O���W�[��r��
		BufferedReader in = new BufferedReader(new FileReader(file));	//�إ�BufferedReader	�ﹳ
		String name = null;
		int number = 1;
		while((name = in.readLine())!= null){	//�`���q�ɮפ�Ū���			
			jtextarea.append("\n"+number+"�B "+name);		//�NŪ�������ܦb��r�줤			
			name = new String(name);			
			number++;
		}
		in.close();
		repaint();
	} catch (Exception e1) {		
		e1.printStackTrace();
	}
}
	if(e.getSource() == kinescope){				//�p�G�ϥΪ̳�����J��涵
		getContentPane().remove(jPanel);		//�N���O��������
		getContentPane().add(panel);
		repaint();						//���魫ø
	}
}
}
