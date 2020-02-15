package com.lzw.login;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ProgressPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JProgressBar jProgressBar = null;// �i�ױ�
    private BufferedImage bgimage;// �I���Ϥ�
    private JLabel jLabel = null;// ���ұ��
    
    /**
     * �غc��k
     */
    public ProgressPanel() {
        super();
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        jLabel = new JLabel();// ��l�Ƽ��ұ��
        jLabel.setText("���b�n�J�t�ΡK�K");
        // �]�w�r��
        jLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        // �]�w�e����
        jLabel.setForeground(new Color(0x28629e));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(0, 50, 0, 50);
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 0;
        gridBagConstraints.gridy = 1;
        // �]�w�G���޲z��
        this.setLayout(new GridBagLayout());
        this.setSize(300, 200);// �]�w�ɭ��j�p
        // �]�w�e����
        this.setForeground(Color.white);
        this.setOpaque(false);
        // �W�[�n�J�i�׭��O�쭱�O
        this.add(getJProgressBar(), gridBagConstraints);
        // �W�[�n�J��T���Ҩ쭱�O
        this.add(jLabel, gridBagConstraints2);
    }
    
    /**
     * ��l�ƶi�ױ����
     * 
     * @return javax.swing.JProgressBar
     */
    private JProgressBar getJProgressBar() {
        if (jProgressBar == null) {
            jProgressBar = new JProgressBar();
            // �]�w�i�ױ������T�w���A
            jProgressBar.setIndeterminate(true);
        }
        return jProgressBar;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();// �ର2Dø�ϤW�U��
        g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));// �]�w�z���X���W�h
        g2.setPaint(Color.GREEN);// �ϥκ��e����
        g2.fillRect(0, 0, getWidth(), getHeight());// ø�s�b�z���x��
        g2.dispose();
        super.paint(g);// ��������Oø�Ϥ�k
    }
}
