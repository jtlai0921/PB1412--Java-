import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class ButtonArrayExample extends JFrame { // �~�ӵ������OJFrame
    /**
	 * 
	 */
    private static final long serialVersionUID = 6626440733001287873L;
    private JTextField textField;
    
    public static void main(String args[]) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        ButtonArrayExample frame = new ButtonArrayExample();
        frame.setVisible(true); // �]�w����i���A�w�]�����i��
    }
    
    public ButtonArrayExample() {
        super(); // �~�Ӥ����O���غc��k
        BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
        borderLayout.setHgap(20);
        borderLayout.setVgap(10);
        setTitle("���s�}�C��{�p����ɭ� "); // �]�w���骺���D
        setBounds(100, 100, 290, 282); // �]�w���骺��ܦ�m�Τj�p
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �]�w�����������s���ʧ@���h�X
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.TRAILING);
        textField.setPreferredSize(new Dimension(12, 50));
        getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);
        final GridLayout gridLayout = new GridLayout(4, 0); // �إߺ���G���޲z���ﹳ
        gridLayout.setHgap(5); // �]�w���󪺤������Z
        gridLayout.setVgap(5); // �]�w���󪺫������Z
        JPanel panel = new JPanel(); // ��o�e���ﹳ
        panel.setLayout(gridLayout); // �]�w�e���ĥκ���G���޲z��
        getContentPane().add(panel, BorderLayout.CENTER);
        String[][] names = { { "1", "2", "3", "��" }, { "4", "5", "6", "��" },
                { "7", "8", "9", "��" }, { ".", "0", "=", "��" } };
        JButton[][] buttons = new JButton[4][4];
        for (int row = 0; row < names.length; row++) {
            for (int col = 0; col < names.length; col++) {
                buttons[row][col] = new JButton(names[row][col]); // �إ߫��s�ﹳ
                panel.add(buttons[row][col]); // �N���s�W�[�쭱�O��
            }
        }
    }
}
