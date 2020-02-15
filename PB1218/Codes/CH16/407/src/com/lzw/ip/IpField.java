package com.lzw.ip;

import java.awt.Component;
import java.awt.Dimension;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.swtdesigner.FocusTraversalOnArray;

public class IpField extends JPanel {
    private CText textField;
    private CText textField_1;
    private CText textField_2;
    private CText textField_3;
    
    /**
     * Create the panel.
     */
    public IpField() {
        setPreferredSize(new Dimension(141, 25));// �]�w�����l����j�p
        setBorder(UIManager.getBorder("TextField.border"));// �ĥΤ�r�عw�]�����
        setBackground(UIManager.getColor("TextField.background"));// �ĥΤ�r�عw�]���I����
        setSize(200, 25);// ��l�j�p
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));// �]�w�G���޲z��
        textField = new CText();// �إߦ۩w�q��r��
        add(textField);// �W�[��r�ب쭱�O
        JLabel label = new JLabel(".");// �إ�IP���j�Ū����ұ��
        add(label);
        textField_1 = new CText();// �إߦ۩w�q��r��
        add(textField_1);// �W�[��r�ب쭱�O
        JLabel label_3 = new JLabel(".");// �إ�IP���j�Ū����ұ��
        add(label_3);
        textField_2 = new CText();// �إߦ۩w�q��r��
        add(textField_2);
        JLabel label_2 = new JLabel(".");// �إ�IP���j�Ū����ұ��
        add(label_2);
        textField_3 = new CText();// �إߦ۩w�q��r��
        add(textField_3);// �W�[��r�ب쭱�O
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]
            { textField, textField_1, textField_2, textField_3 }));
    }
    
    public String getIpString() {// ���g��oIP�r��Ȫ���k
        String ipstr = textField + "." + textField_1 + "." + textField_2 + "."
                + textField_3;// ��4�Ӥ�r�ت��ȳs����IP�a�}�r��
        return ipstr;
    }
    
    public InetAddress getIpAddress() {// ���g��oIP��H����k
        InetAddress ia = null;// �إߤ@�ӪŪ�IP�a�}�ﹳ
        try {
            ia = InetAddress.getByName(getIpString());// ��r���ରIP�a�}�ﹳ
        } catch (UnknownHostException e) {
            e.printStackTrace();// �B�z�ҥ~
        }
        return ia;// �Ǧ^�a�}�ﹳ
    }
}
