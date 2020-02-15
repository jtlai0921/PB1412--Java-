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
        setTitle("�H���Y�榡�ǿ�����ƾ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 673, 399);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel label = new JLabel("�A�Ⱦ��G");
        panel.add(label, BorderLayout.WEST);
        
        hostField = new JTextField();
        hostField.setText("127.0.0.1");
        panel.add(hostField);
        hostField.setColumns(10);
        
        JButton linkButton = new JButton("�s��");
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
     * �C�������ܨƥ�B�z��k
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
            // ��osocket����X�y
            OutputStream outputStream = socket.getOutputStream();
            // �Vsocket�o�e��T
            outputStream.write((bookName + "\n").getBytes());
            // �إ�ZIP��J�y
            ZipInputStream zis = new ZipInputStream(socket.getInputStream());
            char[] data = new char[1024];// �w�İ}�C
            int readNum;
            zis.getNextEntry();// Ū���U�@��ZIP����
            // ��ZIP�G�i���J�y�ର�r�ſ�J�y
            InputStreamReader ir = new InputStreamReader(zis);
            while ((readNum = ir.read(data)) > 0) {// Ū�����
                // ���ƼW�[���r�챱�
                infoArea.append(new String(data, 0, readNum));
            }
            infoArea.select(0, 0);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * �s�����s���ɶ��B�z��k
     * 
     * @param e
     */
    protected void do_linkButton_actionPerformed(ActionEvent e) {
        try {
            String host = hostField.getText();// ��o��J���D���W�Φa�}
            socket = new Socket(host, 1598);// �إ�socket�s��
            final ObjectInputStream ois = new ObjectInputStream(socket
                    .getInputStream());// ��osocket����H��J�y
            list.setModel(new AbstractListModel() {// �]�wJList����Ƽҫ�
                        // ��osocket�ǻ����}�C��H�A�@���C��������
                        String[] values = (String[]) ois.readObject();
                        
                        public int getSize() {
                            return values.length;
                        }
                        
                        public Object getElementAt(int index) {
                            return values[index];
                        }
                    });
        } catch (UnknownHostException e1) {// ���������D���ҥ~
            JOptionPane.showMessageDialog(null, "��J���D���L�k�s��");
            return;
        } catch (SocketException e1) {// ����socket�ҥ~
            JOptionPane.showMessageDialog(null, "��J���D���L�k�s��");
            return;
        } catch (IOException e11) {// ������J��X�ҥ~
            e11.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
