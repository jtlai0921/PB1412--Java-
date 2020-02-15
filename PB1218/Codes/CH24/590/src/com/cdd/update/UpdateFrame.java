package com.cdd.update;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabableView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UpdateFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField courseTextField;
    private TransferUpdate update = new TransferUpdate();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateFrame frame = new UpdateFrame();
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
    public UpdateFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 392, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 380, 215);
        contentPane.add(panel);
        panel.setLayout(null);
        File file = new File("count.txt");
        int id = 0;
        byte[] bytes = new byte[1];
        try {
            FileInputStream input = new FileInputStream(file);          
            while((id = input.read(bytes))!= -1){
              System.out.println(new String(bytes));
            }
            input.close();
        } catch (Exception e) {            
            e.printStackTrace();
        }
        System.out.println("ssssssssssssss "+id);
        Teacher teacher = update.selectTeacher(Integer.parseInt(new String(bytes)));
        JLabel idLabel = new JLabel("編號：");
        idLabel.setBounds(70, 34, 45, 15);
        panel.add(idLabel);
        
        idTextField = new JTextField();
        idTextField.setText(teacher.getId()+"");
        idTextField.setBounds(124, 31, 174, 21);
        panel.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(70, 75, 54, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setText(teacher.gettName());
        nameTextField.setBounds(124, 72, 174, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel courseLabel = new JLabel("課程：");
        courseLabel.setBounds(70, 114, 45, 15);
        panel.add(courseLabel);
        
        courseTextField = new JTextField();
        courseTextField.setText(teacher.getCourse());
        courseTextField.setBounds(124, 111, 174, 21);
        panel.add(courseTextField);
        courseTextField.setColumns(10);
        
        JButton updateButton = new JButton("修改");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_updateButton_actionPerformed(arg0);
            }
        });
        updateButton.setBounds(111, 163, 69, 23);
        panel.add(updateButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(206, 163, 69, 23);
        panel.add(closeButton);
    }
    protected void do_updateButton_actionPerformed(ActionEvent arg0) {
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(idTextField.getText()));
        teacher.settName(nameTextField.getText());
        teacher.setCourse(courseTextField.getText());
        update.updateTeacher(teacher);
        JOptionPane.showMessageDialog(getContentPane(), 
                "資料修改成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);

    }
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
