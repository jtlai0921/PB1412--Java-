package com.mingrisoft.jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class TipOfDay extends JDialog {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6493879146336970741L;
    private final JPanel contentPanel = new JPanel();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            TipOfDay dialog = new TipOfDay();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public TipOfDay() {
        setTitle("今日提示");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.NORTH);
            {
                JLabel label = new JLabel("今日提示");
                label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
                panel.add(label);
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.SOUTH);
            panel.setLayout(new BorderLayout(0, 0));
            {
                JCheckBox checkBox = new JCheckBox("不再顯示");
                checkBox.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
                panel.add(checkBox);
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.WEST);
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.EAST);
        }
        {
            JScrollPane scrollPane = new JScrollPane();
            contentPanel.add(scrollPane, BorderLayout.CENTER);
            {
                JTextArea textArea = new JTextArea();
                textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
                textArea.setLineWrap(true);
                textArea
                        .setText("公司簡介：吉林省明日科技有限公司是一家以計算機軟件技術為核心的高科技型企業，公司建立於1999年12月，是專業的應用軟件開發商和服務提供商。多年來始終致力於產業管理軟件開發、數字化出版物開發製作、產業電子商務網站開發等，先後成功開發了涉及生產、管理、物流、營銷、服務等領域的多種企業管理應用軟件和應用平台。");
                scrollPane.setViewportView(textArea);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("下條信息");
                okButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("關閉窗體");
                cancelButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
