package com.mingrisoft.system;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SystemPropertiesViewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5988076597643890566L;
    private JPanel contentPane;
    private JComboBox keyComboBox;
    private JLabel resultLabel;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SystemPropertiesViewer frame = new SystemPropertiesViewer();
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
    public SystemPropertiesViewer() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("系統屬性查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel keyPanel = new JPanel();
        contentPane.add(keyPanel);
        keyPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel keyLabel = new JLabel("選擇系統屬性：");
        keyLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        keyPanel.add(keyLabel);
        
        keyComboBox = new JComboBox();
        keyComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_foramtterComboBox_actionPerformed(e);
            }
        });
        keyComboBox.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        keyPanel.add(keyComboBox);
        
        JPanel resultPanel = new JPanel();
        contentPane.add(resultPanel);
        resultPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel tipLabel = new JLabel("系統屬性的值：");
        tipLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        resultPanel.add(tipLabel);
        
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        resultPanel.add(resultLabel);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] properties = { "java.runtime.name", "sun.boot.library.path", "java.vm.version", "java.vm.vendor", "java.vendor.url", "path.separator", "java.vm.name",
                "file.encoding.pkg", "user.country", "sun.java.launcher", "sun.os.patch.level", "java.vm.specification.name", "user.dir", "java.runtime.version",
                "java.awt.graphicsenv", "java.endorsed.dirs", "os.arch", "java.io.tmpdir", "line.separator", "java.vm.specification.vendor", "user.variant", "os.name",
                "sun.jnu.encoding", "java.library.path", "java.specification.name", "java.class.version", "sun.management.compiler", "os.version", "user.home", "user.timezone",
                "java.awt.printerjob", "file.encoding", "java.specification.version", "user.name", "java.class.path", "java.vm.specification.version", "sun.arch.data.model",
                "java.home", "java.specification.vendor", "user.language", "awt.toolkit", "java.vm.info", "java.version", "java.ext.dirs", "sun.boot.class.path", "java.vendor",
                "file.separator", "java.vendor.url.bug", "sun.cpu.endian", "sun.io.unicode.encoding", "sun.desktop", "sun.cpu.isalist" };
        for (String property : properties) {
            keyComboBox.addItem(property);// 將所有屬性鍵增加到組合框中
        }
    }
    
    protected void do_foramtterComboBox_actionPerformed(ActionEvent e) {
        String currentProperty = (String) keyComboBox.getSelectedItem();// 獲得屬性值
        resultLabel.setText(System.getProperty(currentProperty));// 顯示屬性值
    }
    
}
