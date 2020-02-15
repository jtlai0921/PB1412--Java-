package com.lzw.ip;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CText extends JTextField {
    public CText() {
        setBorder(null);// �������
        setHorizontalAlignment(SwingConstants.CENTER);// ��r�~��
        setFont(getFont().deriveFont(16f));// ��ø�s�w�]16���r��
        addKeyListener(new KeyAdapter() {// �W�[����ƥ��ť��
            @Override
            public void keyTyped(KeyEvent e) {
                if (("0123456789" + (char) 8).indexOf(e.getKeyChar()) < 0) {
                    e.consume();// �̽��D�Ʀr�P�^�_�䪺��J
                    return;
                }
                if (e.getKeyChar() == (char) 8) {
                    return;// �̽��^�_��
                }
                String text = getText() + e.getKeyChar();// ��o�̷s��J
                if (!text.isEmpty()) {// �p�G��J�D��
                    int value = Integer.parseInt(text);// ���J�ѪR�����
                    if (value > 225) {// �p�G��Ƥj��225
                        e.consume();// ����������J
                        return;
                    }
                }
                // �p�G��J��r�L���ο�J���Odot�r��
                if (getText().length() > 2 || e.getKeyChar() == '.') {
                    e.consume();// ����������J
                    transferFocus();// ���J�J�I�ǻ����U�@�ӱ��
                    return;
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // �̽��K�W�ֳt��
                if (e.getKeyCode() == KeyEvent.VK_V && e.isControlDown()) {
                    e.consume();
                }
            }
        });
    }
    
    /**
     * ��o��J��ƭȪ���k
     * 
     * @return
     */
    public int getInt() {
        String text = getText();// ��o��J��r
        if (text.isEmpty())// �̽��ſ�J
            return 0;
        int value = Integer.parseInt(text);// �ѪR��J�����
        return value;
    }
    
    @Override
    public String toString() {
        return getInt() + "";
    }
    
}
