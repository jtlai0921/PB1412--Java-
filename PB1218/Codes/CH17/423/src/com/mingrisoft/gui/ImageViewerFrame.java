package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mingrisoft.util.DBHelper;

public class ImageViewerFrame extends JFrame {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 264919456236278847L;
    private JPanel contentPane;
    private JTable table;
    
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
                    ImageViewerFrame frame = new ImageViewerFrame();
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
    public ImageViewerFrame() {
        setTitle("顯示數據庫中的圖片信息");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("顯示圖片");
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
        
        JScrollPane tableScrollPane = new JScrollPane();
        contentPane.add(tableScrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableScrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        String sql = "select * from images;";
        String[] tableHeaders = DBHelper.getColumnNames(sql);
        List<Object[]> tableBody = DBHelper.query(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableHeaders);
        for (int i = 0; i < tableBody.size(); i++) {
            model.addRow(tableBody.get(i));
        }
        table.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    protected void do_button_actionPerformed(ActionEvent arg0) {
        int selectedRowMode = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector row = (Vector) model.getDataVector().elementAt(selectedRowMode);
        Integer id = (Integer) row.elementAt(0);
        String sql = "select * from images where id = " + id;
        String columnLabel = "content";
        Image image = DBHelper.getImage(sql, columnLabel);
        new MyImageViewer(image);
    }
    
    private class MyImageViewer extends JFrame {
        /**
		 * 
		 */
        private static final long serialVersionUID = 2062910908817150884L;
        private Image image;
        
        public MyImageViewer(Image image) {
            this.image = image;
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            this.setSize(image.getWidth(this), image.getHeight(this));
            this.setVisible(true);
        }
        
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
