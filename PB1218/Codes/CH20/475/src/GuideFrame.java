import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.*;

public class GuideFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1427029548189335430L;
    private JPanel contentPane;
    private JTextField filePathTextField;
    private JTextField nameTextField;
    private  JComboBox fileRootComboBox = new JComboBox();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuideFrame frame = new GuideFrame();
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
    public GuideFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 186);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("�N��r�ɮ׶פJ��word");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 517, 153);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel filePathLabel = new JLabel("�ɮץؿ��G");
        filePathLabel.setBounds(31, 39, 70, 15);
        panel.add(filePathLabel);
        
        filePathTextField = new JTextField();
        filePathTextField.setBounds(103, 36, 275, 21);
        panel.add(filePathTextField);
        filePathTextField.setColumns(10);
        
        JButton chooseButton = new JButton("����ɮ�");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        chooseButton.setBounds(388, 35, 93, 23);
        panel.add(chooseButton);
        
        JLabel saveLabel = new JLabel("�x�s�a�}�G");
        saveLabel.setBounds(31, 93, 70, 15);
        panel.add(saveLabel);
        

       
        java.io.File[] files = File.listRoots();       //�I�s��o�������ĺϺФ�k
        String str[] = new String[files.length];            //�إߦr��}�C
        for(int i = 0;i<files.length;i++){     
            str[i] = files[i].getPath();            
        }
        //�N��o���Ϻи�T�W�[��U�ԦC��
        fileRootComboBox.setModel(new javax.swing.DefaultComboBoxModel(str)); 
        fileRootComboBox.setBounds(103, 90, 70, 21);
        panel.add(fileRootComboBox);
        
        JLabel nameLabel = new JLabel("�ɮצW�١G");
        nameLabel.setBounds(183, 93, 70, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(263, 90, 115, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JButton guideButton = new JButton("�פJ");
        guideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_guideButton_actionPerformed(arg0);
            }
        });
        guideButton.setBounds(388, 89, 93, 23);
        panel.add(guideButton);
    }
    //����ɮ׫��s�������ƥ�
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd=new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory()+fd.getFile();
        if(filePath.endsWith(".txt")){
        filePathTextField.setText(filePath);
       }
    }
    //�פJ���s�������ƥ�
    protected void do_guideButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText();
        if((!name.equals(""))&&(name!=null)){           
            WordBean msWordManager = new WordBean(); // �إߥ����O�ﹳ
            try {
                msWordManager.createNewDocument(); // �I�s�s�W����k
                File file = new File(filePathTextField.getText());
                FileReader instream = new FileReader(file);
                char by[] = new char[1];
                int a = 0;
                StringBuffer buffer = new StringBuffer();
                while((a = instream.read(by)) != -1){
                    
                    String str = new String(by);        
                    buffer.append(str);
                   
                   
                }      
                msWordManager.insertText(buffer.toString()); // �V���W�[��
                msWordManager.save((String) fileRootComboBox.getSelectedItem()+name+".doc"); // �I�s�x�s����k
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(getContentPane(), 
                    "��ƶפJ���\�I", "��T���ܮ�", JOptionPane.WARNING_MESSAGE);
        }
    }
}
