package com.lzw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.zip.ZipInputStream;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.UIManager;

public class ClientFrame extends JFrame {
    
    private JPanel contentPane;
    private Socket socket;
    private JTextField hostField;
    private JList list;
    private JTextArea infoArea;
    
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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientFrame frame = new ClientFrame();
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
    public ClientFrame() {
        setTitle("以壓縮格式傳輸網絡數據");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 673, 399);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel label = new JLabel("服務器：");
        panel.add(label, BorderLayout.WEST);
        
        hostField = new JTextField();
        hostField.setText("127.0.0.1");
        panel.add(hostField);
        hostField.setColumns(10);
        
        JButton linkButton = new JButton("連接");
        linkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_linkButton_actionPerformed(e);
            }
        });
        panel.add(linkButton, BorderLayout.EAST);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        infoArea = new JTextArea();
        infoArea.setLineWrap(true);
        scrollPane.setViewportView(infoArea);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setPreferredSize(new Dimension(160, 100));
        contentPane.add(scrollPane_1, BorderLayout.WEST);
        
        list = new JList();
        scrollPane_1.setViewportView(list);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged(e);
            }
        });
    }
    
    /**
     * 列表控制項的選擇事件處理方法
     * 
     * @param e
     */
    protected void do_list_valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting())
            return;
        Object value = list.getSelectedValue();
        if (value == null)
            return;
        String bookName = value.toString();
        infoArea.setText("");
        try {
            // 獲得socket的輸出流
            OutputStream outputStream = socket.getOutputStream();
            // 向socket發送資訊
            outputStream.write((bookName + "\n").getBytes());
            // 建立ZIP輸入流
            ZipInputStream zis = new ZipInputStream(socket.getInputStream());
            char[] data = new char[1024];// 緩衝陣列
            int readNum;
            zis.getNextEntry();// 讀取下一個ZIP項目
            // 把ZIP二進位輸入流轉為字符輸入流
            InputStreamReader ir = new InputStreamReader(zis);
            while ((readNum = ir.read(data)) > 0) {// 讀取資料
                // 把資料增加到文字域控制項
                infoArea.append(new String(data, 0, readNum));
            }
            infoArea.select(0, 0);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * 連接按鈕的時間處理方法
     * 
     * @param e
     */
    protected void do_linkButton_actionPerformed(ActionEvent e) {
        try {
            String host = hostField.getText();// 獲得輸入的主機名或地址
            socket = new Socket(host, 1598);// 建立socket連接
            final ObjectInputStream ois = new ObjectInputStream(socket
                    .getInputStream());// 獲得socket的對象輸入流
            list.setModel(new AbstractListModel() {// 設定JList的資料模型
                        // 獲得socket傳遞的陣列對象，作為列表控制項的資料
                        String[] values = (String[]) ois.readObject();
                        
                        public int getSize() {
                            return values.length;
                        }
                        
                        public Object getElementAt(int index) {
                            return values[index];
                        }
                    });
        } catch (UnknownHostException e1) {// 捕捉未知主機例外
            JOptionPane.showMessageDialog(null, "輸入的主機無法連接");
            return;
        } catch (SocketException e1) {// 捕捉socket例外
            JOptionPane.showMessageDialog(null, "輸入的主機無法連接");
            return;
        } catch (IOException e11) {// 捕捉輸入輸出例外
            e11.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
