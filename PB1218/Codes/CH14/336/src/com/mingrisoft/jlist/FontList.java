package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class FontList extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2718910561731829476L;
    private JPanel contentPane;
    private JList list;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FontList frame = new FontList();
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
    public FontList() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u53EF\u4EE5\u9884\u89C8\u5B57\u4F53\u7684\u5217\u8868");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        scrollPane.setViewportView(list);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel model = new DefaultListModel();
        for (String fontName : fontNames) {
            model.addElement(new Font(fontName, Font.PLAIN, 24));
        }
        list.setModel(model);
        ListCellRenderer renderer = new FontListCellRenderer();
        list.setCellRenderer(renderer);
    }
}
