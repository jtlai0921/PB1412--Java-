import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SystemPropertiesDemo extends JFrame {
	
	private JTextArea textArea;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemPropertiesDemo frame = new SystemPropertiesDemo();
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
	public SystemPropertiesDemo() {
		super();
		setTitle("����i�P�s�޲z�t��");
		getContentPane().setLayout(null);
		setBounds(100, 100, 354, 206);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getResource("logo.png")));
		label.setText("New JLabel");
		label.setBounds(10, 27, 112, 98);
		getContentPane().add(label);

		textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setText("�t�ΡG\n  Microsoft Windows Server 2003\n" +
				"  Standard Editon\n  Service Pack 2\n\n\n" +
				"�n��G�i�P�s�޲z�t��\n���v�G������");
		textArea.setBounds(154, 6, 187, 154);
		getContentPane().add(textArea);
	}
	
}
