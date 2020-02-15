import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SavePropertiesFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField keyTextField;
    private JTextField valueTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SavePropertiesFrame frame = new SavePropertiesFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public SavePropertiesFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 374, 227);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("向屬性檔案中寫資料");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 364, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel keyLabel = new JLabel("Key值：");
        keyLabel.setBounds(41, 52, 54, 15);
        panel.add(keyLabel);
        
        JLabel valueLabel = new JLabel("Value值：");
        valueLabel.setBounds(34, 101, 61, 21);
        panel.add(valueLabel);
        
        keyTextField = new JTextField();
        keyTextField.setBounds(92, 49, 184, 21);
        panel.add(keyTextField);
        keyTextField.setColumns(10);
        
        valueTextField = new JTextField();
        valueTextField.setBounds(93, 101, 183, 21);
        panel.add(valueTextField);
        valueTextField.setColumns(10);
        
        JButton saveButton = new JButton("寫入");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(141, 149, 77, 23);
        panel.add(saveButton);
    }
    //寫入按鈕的單擊處理事件
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        String key = keyTextField.getText();
        String value = valueTextField.getText();
        if((!key.equals("")&&(key!=null)) && ((!value.equals(""))&&(value != null))){
            SaveProperties properties = new SaveProperties();
            properties.saveProperties(key, value);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "資料寫入成功！", "資訊交談視窗", JOptionPane.WARNING_MESSAGE);
        }       
    

    }
}
