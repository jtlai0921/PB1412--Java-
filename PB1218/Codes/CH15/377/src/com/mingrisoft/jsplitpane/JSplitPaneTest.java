package com.mingrisoft.jsplitpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class JSplitPaneTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5628150026016623222L;
    private JPanel contentPane;
    private JList list;
    private JLabel imageLabel;
    private JLabel discriptionLabel;
    
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
                    JSplitPaneTest frame = new JSplitPaneTest();
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
    public JSplitPaneTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("分割面板的應用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JSplitPane outerPane = new JSplitPane();
        outerPane.setResizeWeight(0.7);
        outerPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        contentPane.add(outerPane, BorderLayout.CENTER);
        
        JSplitPane innerPane = new JSplitPane();
        innerPane.setResizeWeight(0.5);
        innerPane.setOneTouchExpandable(true);
        outerPane.setLeftComponent(innerPane);
        
        list = new JList();
        list.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "圖片名稱：", TitledBorder.LEADING, TitledBorder.TOP, new Font(
                "微軟雅黑", Font.PLAIN, 14), new Color(59, 59, 59)));
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged(e);
            }
        });
        list.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        innerPane.setLeftComponent(list);
        
        imageLabel = new JLabel("");
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "圖片內容：", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("微軟雅黑", Font.PLAIN, 14), new Color(59, 59, 59)));
        imageLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        innerPane.setRightComponent(imageLabel);
        
        discriptionLabel = new JLabel("");
        discriptionLabel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "圖片說明：", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("微軟雅黑", Font.PLAIN, 14), null));
        discriptionLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        outerPane.setRightComponent(discriptionLabel);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] listData = new String[6];
        for (int i = 0; i < 6; i++) {
            listData[i] = "圖片" + (i + 1);
        }
        list.setListData(listData);
        list.setSelectedIndex(0);
        
    }
    
    protected void do_list_valueChanged(ListSelectionEvent e) {
        if (list.getSelectedValue() != null) {
            String value = (String) list.getSelectedValue();
            char imageIndex = value.charAt(2);
            imageLabel.setIcon(new ImageIcon("src/images/" + imageIndex + ".png"));
            discriptionLabel.setText("您正在瀏覽圖片" + imageIndex);
        }
    }
}
