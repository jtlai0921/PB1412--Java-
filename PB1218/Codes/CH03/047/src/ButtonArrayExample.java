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

public class ButtonArrayExample extends JFrame { // 繼承窗體類別JFrame
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
        frame.setVisible(true); // 設定窗體可見，預設為不可見
    }
    
    public ButtonArrayExample() {
        super(); // 繼承父類別的建構方法
        BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
        borderLayout.setHgap(20);
        borderLayout.setVgap(10);
        setTitle("按鈕陣列實現計算機界面 "); // 設定窗體的標題
        setBounds(100, 100, 290, 282); // 設定窗體的顯示位置及大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設定窗體關閉按鈕的動作為退出
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.TRAILING);
        textField.setPreferredSize(new Dimension(12, 50));
        getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);
        final GridLayout gridLayout = new GridLayout(4, 0); // 建立網格佈局管理器對像
        gridLayout.setHgap(5); // 設定元件的水平間距
        gridLayout.setVgap(5); // 設定元件的垂直間距
        JPanel panel = new JPanel(); // 獲得容器對像
        panel.setLayout(gridLayout); // 設定容器採用網格佈局管理器
        getContentPane().add(panel, BorderLayout.CENTER);
        String[][] names = { { "1", "2", "3", "＋" }, { "4", "5", "6", "－" },
                { "7", "8", "9", "×" }, { ".", "0", "=", "÷" } };
        JButton[][] buttons = new JButton[4][4];
        for (int row = 0; row < names.length; row++) {
            for (int col = 0; col < names.length; col++) {
                buttons[row][col] = new JButton(names[row][col]); // 建立按鈕對像
                panel.add(buttons[row][col]); // 將按鈕增加到面板中
            }
        }
    }
}
