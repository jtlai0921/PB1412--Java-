package com.lzw;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ModifyFileAttribute extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JPanel jPanel = null;
    private JPanel jPanel1 = null;
    private JButton jButton = null;
    private JLabel fileLabel = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JLabel jLabel3 = null;
    private JTextField sizeField = null;
    private JTextField pathField = null;
    private JTextField uriField = null;
    private JTextField modifyDateField = null;
    private JCheckBox readCheckBox = null;
    private JCheckBox writeCheckBox = null;
    private JCheckBox hideCheckBox = null;
    
    /**
     * This is the default constructor
     */
    public ModifyFileAttribute() {
        super();
        initialize();
    }
    
    /**
     * This method initializes jPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setVgap(0);
            jPanel = new JPanel();
            jPanel.setLayout(flowLayout);
            jPanel.add(getReadCheckBox(), null);
            jPanel.add(getWriteCheckBox(), null);
            jPanel.add(getHideCheckBox(), null);
        }
        return jPanel;
    }
    
    /**
     * This method initializes jPanel1
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
            gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints8.gridy = 4;
            gridBagConstraints8.weightx = 1.0;
            gridBagConstraints8.insets = new Insets(0, 5, 5, 0);
            gridBagConstraints8.gridx = 1;
            GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
            gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints7.gridy = 3;
            gridBagConstraints7.weightx = 1.0;
            gridBagConstraints7.insets = new Insets(0, 5, 5, 0);
            gridBagConstraints7.gridx = 1;
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
            gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints6.gridy = 2;
            gridBagConstraints6.weightx = 1.0;
            gridBagConstraints6.insets = new Insets(0, 5, 5, 0);
            gridBagConstraints6.gridx = 1;
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints5.gridy = 1;
            gridBagConstraints5.weightx = 1.0;
            gridBagConstraints5.insets = new Insets(0, 5, 5, 0);
            gridBagConstraints5.gridx = 1;
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.gridx = 0;
            gridBagConstraints4.gridy = 3;
            jLabel3 = new JLabel();
            jLabel3.setText("URI���|");
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
            gridBagConstraints3.gridx = 0;
            gridBagConstraints3.gridy = 1;
            jLabel2 = new JLabel();
            jLabel2.setText("�ɮפj�p");
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.gridy = 4;
            jLabel1 = new JLabel();
            jLabel1.setText("�̫�ק���");
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
            gridBagConstraints11.gridx = 0;
            gridBagConstraints11.gridy = 2;
            jLabel = new JLabel();
            jLabel.setText("�ɮ׸��|");
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 1;
            gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints1.weightx = 1.0;
            gridBagConstraints1.insets = new Insets(0, 5, 0, 0);
            gridBagConstraints1.gridy = 0;
            fileLabel = new JLabel();
            fileLabel.setText("�ɮצW");
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.insets = new Insets(0, 5, 0, 0);
            gridBagConstraints.gridy = 0;
            jPanel1 = new JPanel();
            jPanel1.setLayout(new GridBagLayout());
            jPanel1.add(getJButton(), gridBagConstraints);
            jPanel1.add(fileLabel, gridBagConstraints1);
            jPanel1.add(jLabel, gridBagConstraints11);
            jPanel1.add(jLabel1, gridBagConstraints2);
            jPanel1.add(jLabel2, gridBagConstraints3);
            jPanel1.add(jLabel3, gridBagConstraints4);
            jPanel1.add(getSizeField(), gridBagConstraints5);
            jPanel1.add(getPathField(), gridBagConstraints6);
            jPanel1.add(getUriField(), gridBagConstraints7);
            jPanel1.add(getModifyDateField(), gridBagConstraints8);
        }
        return jPanel1;
    }
    
    /**
     * ����ɮ׫��s
     * 
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
jButton.setText("����ɮ�");
// �W�[���s�ƥ��ť��
jButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // �إ��ɮ׿�ܾ�
        JFileChooser chooser = new JFileChooser();
        // ����ɮ׶}�ҥ�͵���
        chooser.showOpenDialog(ModifyFileAttribute.this);
        File file = chooser.getSelectedFile();// ��o����ɮ�
        fileLabel.setText(file.getName());// ����ɮצW��
        sizeField.setText(file.length() + "");// ����ɮפj�p
        pathField.setText(file.getPath());// ����ɮ׸��|
        pathField.select(0, 0);
        uriField.setText(file.toURI() + "");// ����ɮת�URI���|
        uriField.select(0, 0);
        // ����ɮ׳̫�ק�ɶ�
        modifyDateField.setText(new Date(file.lastModified()) + "");
        // ���Ū���ݩ�
        readCheckBox.setSelected(file.canRead());
        // ��ܼg�J�ݩ�
        writeCheckBox.setSelected(file.canWrite());
        // ��������ݩ�
        hideCheckBox.setSelected(file.isHidden());
    }
});
        }
        return jButton;
    }
    
    /**
     * This method initializes sizeField
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getSizeField() {
        if (sizeField == null) {
            sizeField = new JTextField();
        }
        return sizeField;
    }
    
    /**
     * This method initializes pathField
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getPathField() {
        if (pathField == null) {
            pathField = new JTextField();
        }
        return pathField;
    }
    
    /**
     * This method initializes uriField
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getUriField() {
        if (uriField == null) {
            uriField = new JTextField();
        }
        return uriField;
    }
    
    /**
     * This method initializes modifyDateField
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getModifyDateField() {
        if (modifyDateField == null) {
            modifyDateField = new JTextField();
        }
        return modifyDateField;
    }
    
    /**
     * This method initializes readCheckBox
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getReadCheckBox() {
        if (readCheckBox == null) {
            readCheckBox = new JCheckBox();
            readCheckBox.setText("Ū��");
        }
        return readCheckBox;
    }
    
    /**
     * This method initializes writeCheckBox
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getWriteCheckBox() {
        if (writeCheckBox == null) {
            writeCheckBox = new JCheckBox();
            writeCheckBox.setText("�g�J");
        }
        return writeCheckBox;
    }
    
    /**
     * This method initializes hideCheckBox
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getHideCheckBox() {
        if (hideCheckBox == null) {
            hideCheckBox = new JCheckBox();
            hideCheckBox.setText("����");
        }
        return hideCheckBox;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ModifyFileAttribute thisClass = new ModifyFileAttribute();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(385, 226);
        this.setResizable(false);
        this.setContentPane(getJContentPane());
        this.setTitle("Ū���ɮ��ݩ�");
    }
    
    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            BorderLayout borderLayout = new BorderLayout();
            borderLayout.setVgap(0);
            borderLayout.setHgap(0);
            jContentPane = new JPanel();
            jContentPane.setLayout(borderLayout);
            jContentPane.add(getJPanel(), BorderLayout.SOUTH);
            jContentPane.add(getJPanel1(), BorderLayout.CENTER);
        }
        return jContentPane;
    }
    
} // @jve:decl-index=0:visual-constraint="10,10"
