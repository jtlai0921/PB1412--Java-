import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
public class SortFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField pathTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SortFrame frame = new SortFrame();
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
    public SortFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 434, 196);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("�ɮק������O�޲z");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 418, 158);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("�����O�ɮק��G");
        messageLabel.setBounds(19, 48, 92, 15);
        panel.add(messageLabel);
        
        pathTextField = new JTextField();
        pathTextField.setBounds(121, 45, 187, 21);
        panel.add(pathTextField);
        pathTextField.setColumns(10);
        
        JButton choicBbutton = new JButton("���");
        choicBbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_choicBbutton_actionPerformed(arg0);
            }
        });
        choicBbutton.setBounds(318, 44, 77, 23);
        panel.add(choicBbutton);
        
        JButton sortButton = new JButton("�T�w�����O");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_sortButton_actionPerformed(arg0);
            }
        });
        sortButton.setBounds(156, 96, 93, 23);
        panel.add(sortButton);
    }
    
    // �w�q��o�u�i�H����ɮק�����ܮ�
    public JFileChooser getChooser() {
        JFileChooser fd = new JFileChooser();
        String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(windows);
        } catch (Exception e) {
            e.printStackTrace();
        }// �]�w��������
        SwingUtilities.updateComponentTreeUI(fd);// �ϳ]�w���ɭ�����ͮ�
        fd.setFileSelectionMode(fd.DIRECTORIES_ONLY); // ���ܥu��ܥؿ�
        fd.showOpenDialog(this);
        return fd;
    }
    
    protected void do_choicBbutton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if ((fd.getSelectedFile() != null)
                && (!fd.getSelectedFile().equals(""))) {
            String strPath = fd.getSelectedFile().getPath();
            pathTextField.setText(strPath);
        }        
        
    }

protected void do_sortButton_actionPerformed(ActionEvent arg0) {
    SortUtil sortUtil = new SortUtil();      
    List list = sortUtil.getList(pathTextField.getText()); //��o�ϥΪ̿���ɮק����Ҧ��ɮ׶��X
     for(int i = 0;i<list.size();i++){              //�`���ˬd���ɮ׶��X
         String strFile = list.get(i).toString();
         int index = strFile.lastIndexOf(".");
         if(index != -1){
             String strN = strFile.substring(index+1,strFile.length()); //���ɮק��i��I���A��o�ɮ��X�R�W
             int ind = strFile.lastIndexOf("\\");
             String strFileName = strFile.substring(ind, index);
             sortUtil.createFolder(pathTextField.getText()+"\\"+"�����O");//�I�s�إ��ɮק���k�A�s�W�ɮק�
             sortUtil.createFolder(pathTextField.getText()+"\\"+"�����O"+"\\"+strN);
             if(strFile.endsWith(strN)){                        
            //�N�ɮ׶��X���P�ɮק��W�٬ۦP���ɮ׽ƻs��������ɮק���
                 sortUtil.copyFile(strFile,pathTextField.getText()+"\\"+"�����O"+"\\"+strN+
                         "\\"+strFileName+strFile.substring(index,strFile.length()));
             }                
         }
     }
     JOptionPane.showMessageDialog(getContentPane(), //�|�X�ϥΪ̤����O�������ܮ�
             "�ɮפ����O���\�I", "��T���ܮ�", JOptionPane.WARNING_MESSAGE);        
}
}
