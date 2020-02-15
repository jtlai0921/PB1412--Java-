package com.util;
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
import java.util.List;
public class InsertWareFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField specTextField;
    private JTextField casingTextField;
    private JTextField unitTextField;
    private JTextField amountTextField;
    private WareUtil util = new WareUtil();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertWareFrame frame = new InsertWareFrame();
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
    public InsertWareFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 324);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("�W�[�ӫ~��T");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 358, 292);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("�W�١G");
        nameLabel.setBounds(57, 31, 54, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(108, 28, 184, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel specLabel = new JLabel("�W��G");
        specLabel.setBounds(57, 70, 54, 15);
        panel.add(specLabel);
        
        specTextField = new JTextField();
        specTextField.setBounds(108, 67, 184, 21);
        panel.add(specTextField);
        specTextField.setColumns(10);
        
        JLabel casingLabel = new JLabel("�]�ˡG");
        casingLabel.setBounds(57, 111, 54, 15);
        panel.add(casingLabel);
        
        casingTextField = new JTextField();
        casingTextField.setColumns(10);
        casingTextField.setBounds(108, 108, 184, 21);
        panel.add(casingTextField);
        
        JLabel unitLabel = new JLabel("���G");
        unitLabel.setBounds(57, 150, 54, 15);
        panel.add(unitLabel);
        
        unitTextField = new JTextField();
        unitTextField.setBounds(107, 147, 185, 21);
        panel.add(unitTextField);
        unitTextField.setColumns(10);
        
        JLabel amountLabel = new JLabel("�ƶq�G");
        amountLabel.setBounds(57, 191, 54, 15);
        panel.add(amountLabel);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(108, 188, 184, 21);
        panel.add(amountTextField);
        amountTextField.setColumns(10);
        
        JButton insertButton = new JButton("�W�[");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(86, 230, 65, 23);
        panel.add(insertButton);
        
        JButton watchButton = new JButton("�˵�");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_watchButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(201, 230, 65, 23);
        panel.add(watchButton);
    }
    
    // �W�[���s�������B�z�ƥ�
    
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText(); // ��o�ϥΪ̼W�[���ӫ~�W��
        String spec = specTextField.getText(); // ��o�ϥΪ̼W�[���ӫ~�W��
        String unit = unitTextField.getText(); // ��o�ϥΪ̼W�[���ӫ~���
        String casing = casingTextField.getText(); // ��o�ϥΪ̼W�[���ӫ~�]��
        int count = Integer.parseInt(amountTextField.getText()); // ��o�ϥΪ̼W�[���ӫ~�ƶq
        int ID = 0;
        String sDate = WareUtil.getDateTime(); // �I�s��o�t�ήɶ���k
        List list = util.selectWare(); // ��o�ӫ~���������ӫ~
        String sid = "";
        for (int i = 0; i < list.size(); i++) { // �`���ˬd�d�ߵ��G��
            Ware ware = (Ware) list.get(i); // ��o�ӫ~
            sid = ware.getSID(); // ��o�ӫ~�s��
        }
        if (list.size() == 0) { // �p�G�ӫ~���X������
            sid = "CS" + sDate.replace("-", "") + "00001"; // �w�q�ӫ~�s��
        } else { // �p�G�ӫ~���X������
            sid = sid.trim();
            ID = Integer.parseInt(sid.substring(sid.length() - 5)); // �I���ӫ~�s�������᤭��
            sid = sid.substring(0, sid.length() - 5)
                    + String.format("%05d", ID + 1); // �w�q�ӫ~�s��
        }
        Ware ware = new Ware(); // �w�q�P�ӫ~�������JavaBean�ﹳ
        ware.setSID(sid); // �]�wJavaBean�s��
        ware.setsName(name);
        ware.setSpec(spec);
        ware.setUnit(unit);
        ware.setsDate(sDate);
        ware.setCasing(casing);
        ware.setAmout(count);
        util.insertWare(ware); // �W�[�ӫ~��T
        JOptionPane.showMessageDialog(getContentPane(), "��ƼW�[���\�I", "��T���ܮ�",
                JOptionPane.CANCEL_OPTION);
        
    }
    
    // �˵����s�������B�z�ƥ�
    protected void do_watchButton_actionPerformed(ActionEvent arg0) {
        SelectWareFrame selectWare = new SelectWareFrame();
        selectWare.setVisible(true);
    }
}
