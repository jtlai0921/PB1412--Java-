import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ModalDialog extends JFrame {
    
    private final JPanel contentPanel = new JPanel();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            ModalDialog dialog = new ModalDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public ModalDialog() {
        setTitle("模態對話框與非模態對話框");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JButton button = new JButton(
                "模態顯示對話框");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(103, 64, 206, 30);
        contentPanel.add(button);
        
        JButton button_1 = new JButton(
                "非模態顯示對話框");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(103, 106, 206, 30);
        contentPanel.add(button_1);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("確定");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("取消");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(this);// 建立目前窗體的交談視窗
        dialog.setModal(true);// 設定交談視窗為模態
        dialog.setSize(300, 200);// 設定交談視窗大小
        dialog.setLocationByPlatform(true);// 由系統平台佈置窗體位置
        dialog.setTitle("模態交談視窗");// 交談視窗標題
        dialog.setVisible(true);// 顯示交談視窗
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(this);// 建立目前窗體的交談視窗
        dialog.setModal(false);// 設定交談視窗為模態
        dialog.setSize(300, 200);// 設定交談視窗大小
        dialog.setLocationByPlatform(true);// 由系統平台佈置窗體位置
        dialog.setTitle("非模態交談視窗");// 交談視窗標題
        dialog.setVisible(true);// 顯示交談視窗
    }
}
