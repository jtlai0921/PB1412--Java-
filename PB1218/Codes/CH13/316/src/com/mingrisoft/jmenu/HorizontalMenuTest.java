package com.mingrisoft.jmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class HorizontalMenuTest extends JFrame {
    private static final long serialVersionUID = 1686879401938151474L;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HorizontalMenuTest frame = new HorizontalMenuTest();
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
public HorizontalMenuTest() {
        setTitle("�a�V�����");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    Container contentPane = getContentPane();
    contentPane.setBackground(Color.WHITE);
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.PAGE_AXIS));
    contentPane.add(menuBar, BorderLayout.WEST);
    
    JMenu fileMenu = new HorizontalMenu("�ɮ�(F)");
    fileMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
    fileMenu.add("�s�W(N)");
    fileMenu.add("�}��(O)...");
    fileMenu.add("�x�s(S)");
    fileMenu.add("�t�s��(A)...");
    fileMenu.add("�����]�w(U)...");
    fileMenu.add("�C�L(P)...");
    fileMenu.add("�h�X(X)");
    menuBar.add(fileMenu);
    
    JMenu editMenu = new HorizontalMenu("�s��(E)");
    editMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
    editMenu.add("����(U)");
    editMenu.add("�ŤU(T)");
    editMenu.add("�ƻs(C)");
    editMenu.add("�K�W(P)");
    editMenu.add("�R��(L)");
    editMenu.add("�M��(F)...");
    editMenu.add("�M��U�@��(N)");
    editMenu.add("����(R)...");
    editMenu.add("���(G)...");
    editMenu.add("����(A)");
    editMenu.add("�ɶ�/���(D)");
    menuBar.add(editMenu);
    
    JMenu formatMenu = new HorizontalMenu("�榡(O)");
    formatMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
    formatMenu.add("�۰ʴ���(W)");
    formatMenu.add("�r��(F)...");
    menuBar.add(formatMenu);
    
    JMenu viewMenu = new HorizontalMenu("�˵�(V)");
    viewMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
    viewMenu.add("���A��(S)");
    menuBar.add(viewMenu);
    
    JMenu helpMenu = new HorizontalMenu("���U(H)");
    helpMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
    helpMenu.add("�˵����U(H)");
    helpMenu.add("����O�ƥ�(A)");
    menuBar.add(helpMenu);
}
}
