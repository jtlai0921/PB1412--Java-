package com.lzw.widget;

import static javax.swing.BorderFactory.createEmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * ���ʭ��O
 * 
 * @author ����L
 */
public class SmallScrollPanel extends BGPanel {
    private static final long serialVersionUID = 3592329256836525981L;
    private AlphaScrollPane alphaScrollPane;// ���ʭ��O
    private JButton leftScrollButton = null;// �����L�ի��s
    private JButton rightScrollButton = null;// �k���L�ի��s
    private ScrollMouseAdapter scrollMouseAdapter = new ScrollMouseAdapter(); // ���ʨƥ�B�z��
    private ImageIcon icon1;
    private ImageIcon icon2;
    private JPanel panel;
    
    /**
     * �غc��k
     */
    public SmallScrollPanel() {
        // ��l�Ƶ{���ι�
        icon1 = new ImageIcon(getClass().getResource("top01.png"));
        icon2 = new ImageIcon(getClass().getResource("top02.png"));
        setIcon(icon1);// �]�w�ι�
        setIconFill(BOTH_FILL);// �N�ϼЦ��i�A���ɭ��j�p
        initialize();// �I�s��l�Ƥ�k
    }
    
    /**
     * ��l�Ƶ{���ɭ�����k
     */
    private void initialize() {
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(0);
        this.setLayout(borderLayout);// �]�w�G���޲z��
        this.setSize(new Dimension(300, 84));
        this.setOpaque(false);
        // �W�[�����L�ի��s
        this.add(getLeftScrollButton(), BorderLayout.WEST);
        // �W�[�k���L�ի��s
        this.add(getRightScrollButton(), BorderLayout.EAST);
        add(getPanel(), BorderLayout.CENTER);
    }
    
    /**
     * �إ߱��ʭ��O
     * 
     * @return
     */
    public AlphaScrollPane getAlphaScrollPanel() {
        if (alphaScrollPane == null) {
            alphaScrollPane = new AlphaScrollPane();
            // �]�w��l�j�p
            alphaScrollPane.setPreferredSize(new Dimension(564, 69));
            // ����ܫ������ʱ�
            alphaScrollPane
                    .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            // ����ܤ������ʱ�
            alphaScrollPane
                    .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            // �������ʭ��O���
            alphaScrollPane.setBorderPaint(false);
            // �W�[�ƥ��ť��
            alphaScrollPane
                    .addComponentListener(new ScrollButtonShowListener());
        }
        return alphaScrollPane;
    }
    
    public void setViewportView(Component view) {
        alphaScrollPane.setViewportView(view);
    }
    
    /**
     * ���ʷL�ճB�z��
     * 
     * @author ����L
     */
    private class ScrollButtonShowListener extends ComponentAdapter implements
            Serializable {
        private static final long serialVersionUID = 814596372430146361L;
        
        @Override
        public void componentResized(ComponentEvent e) {
            // ��o�������ʱ�
            JScrollBar scrollBar = alphaScrollPane.getHorizontalScrollBar();
            // ��o�d�򭭨�Ѽ�
            int scrollWidth = scrollBar.getMaximum();
            int paneWidth = alphaScrollPane.getWidth();
            // �b�e���j��]�t���e���ɭ����å��k�L�ի��s
            if (paneWidth >= scrollWidth) {
                getLeftScrollButton().setVisible(false);
                getRightScrollButton().setVisible(false);
            }
            // �b�e���p��]�t���e���ɭ���ܥ��k�L�ի��s
            if (paneWidth < scrollWidth) {
                getLeftScrollButton().setVisible(true);
                getRightScrollButton().setVisible(true);
            }
        }
    }
    
    /**
     * �إߥ����L�ի��s
     * 
     * @return javax.swing.JButton
     */
    private JButton getLeftScrollButton() {
        if (leftScrollButton == null) {
            leftScrollButton = new JButton();
            // �إ߫��s�ϼ�
            ImageIcon icon1 = new ImageIcon(getClass().getResource(
                    "zuoyidongoff.png"));
            // �إ߫��s�ϼ�2
            ImageIcon icon2 = new ImageIcon(getClass().getResource(
                    "zuoyidongon.png"));
            leftScrollButton.setOpaque(false);// ���s�z��
            // �]�w���
            leftScrollButton.setBorder(createEmptyBorder(0, 10, 0, 0));
            // �]�w���s�ϼ�
            leftScrollButton.setIcon(icon1);
            leftScrollButton.setPressedIcon(icon2);
            leftScrollButton.setRolloverIcon(icon2);
            // �������s���e��R
            leftScrollButton.setContentAreaFilled(false);
            // �]�w��l�j�p
            leftScrollButton.setPreferredSize(new Dimension(38, 0));
            // �������s�J�I�\��
            leftScrollButton.setFocusable(false);
            // �W�[���ʨƥ��ť��
            leftScrollButton.addMouseListener(scrollMouseAdapter);
        }
        return leftScrollButton;
    }
    
    /**
     * �إߥk�����ʷL�ի��s
     * 
     * @return javax.swing.JButton
     */
    private JButton getRightScrollButton() {
        if (rightScrollButton == null) {
            rightScrollButton = new JButton();
            // �إ߫��s�ϼ�
            ImageIcon icon1 = new ImageIcon(getClass().getResource(
                    "youyidongoff.png"));
            // �إ߫��s�ϼ�2
            ImageIcon icon2 = new ImageIcon(getClass().getResource(
                    "youyidongon.png"));
            // ���s�z��
            rightScrollButton.setOpaque(false);
            // �]�w���
            rightScrollButton.setBorder(createEmptyBorder(0, 0, 0, 10));
            rightScrollButton.setIcon(icon1);// �]�w���s�ϼ�
            rightScrollButton.setPressedIcon(icon2);
            rightScrollButton.setRolloverIcon(icon2);
            // �������s���eø�s
            rightScrollButton.setContentAreaFilled(false);
            // �]�w���s��l�j�p
            rightScrollButton.setPreferredSize(new Dimension(38, 92));
            // �������s�J�I�\��
            rightScrollButton.setFocusable(false);
            // �W�[���ʨƥ��ť��
            rightScrollButton.addMouseListener(scrollMouseAdapter);
        }
        return rightScrollButton;
    }
    
    /**
     * ���k�L�ի��s���ƥ��ť��
     * 
     * @author ����L
     */
    private final class ScrollMouseAdapter extends MouseAdapter implements
            Serializable {
        private static final long serialVersionUID = 5589204752770150732L;
        // ��o���ʭ��O���������ʱ�
        JScrollBar scrollBar = getAlphaScrollPanel().getHorizontalScrollBar();
        // �w�q�u�{�����ܼ�
        private boolean isPressed = true;
        
        public void mousePressed(MouseEvent e) {
            Object source = e.getSource();// ��o�ƥ�
            isPressed = true;
            // �P�_�ƥ󷽬O�������s�٬O�k�����s�A�ð�������ާ@
            if (source == getLeftScrollButton()) {
                scrollMoved(-1);
            } else {
                scrollMoved(1);
            }
        }
        
        /**
         * ���ʱ��ʱ�����k
         * 
         * @param orientation
         *            ���ʤ�V -1�O���ΤW���ʡA1�O�k�ΤU����
         */
        private void scrollMoved(final int orientation) {
            new Thread() {// �}�P�s���u�{
                // �x�s�즳���ʱ�����
                private int oldValue = scrollBar.getValue();
                
                public void run() {
                    while (isPressed) {// �`�����ʭ��O
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        // ��o���ʱ��ثe��
                        oldValue = scrollBar.getValue();
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                // �]�w���ʱ�����3�ӹ���
                                scrollBar.setValue(oldValue + 4 * orientation);
                            }
                        });
                    }
                }
            }.start();
        }
        
        public void mouseExited(java.awt.event.MouseEvent e) {
            isPressed = false;
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            isPressed = false;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // �b���󳻼hø�s�Ϥ�
        g.drawImage(icon2.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setOpaque(false);
            panel.setBorder(new EmptyBorder(5, 0, 5, 0));
            panel.setLayout(new BorderLayout(0, 0));
            panel.add(getAlphaScrollPanel());
        }
        return panel;
    }
}
