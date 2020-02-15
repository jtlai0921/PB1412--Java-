package com.mingrisoft.jmenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;

public class Notepad extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5927958872707427777L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Notepad frame = new Notepad();
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
    public Notepad() {
        setTitle("�ҥ�O�ƥ�����涵");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("���(F)");
        fileMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
        menuBar.add(fileMenu);
        
        JMenuItem newMenuItem = new JMenuItem("�s��(N)");
        newMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(newMenuItem);
        
        JMenuItem openMenuItem = new JMenuItem("���}(O)...");
        openMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(openMenuItem);
        
        JMenuItem saveMenuItem = new JMenuItem("�O�s(S)");
        saveMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(saveMenuItem);
        
        JMenuItem saveAsMenuItem = new JMenuItem("�t�s��(A)...");
        saveAsMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(saveAsMenuItem);
        
        JSeparator separator1 = new JSeparator();
        fileMenu.add(separator1);
        
        JMenuItem pageSetMenuItem = new JMenuItem("�����]�m(U)...");
        pageSetMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(pageSetMenuItem);
        
        JMenuItem printMenuItem = new JMenuItem("���L(P)...");
        printMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(printMenuItem);
        
        JSeparator separator2 = new JSeparator();
        fileMenu.add(separator2);
        
        JMenuItem exitMenuItem = new JMenuItem("�h�X(X)");
        exitMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        fileMenu.add(exitMenuItem);
        
        JMenu editMenu = new JMenu("�s��(E)");
        editMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
        menuBar.add(editMenu);
        
        JMenuItem undoMenuItem = new JMenuItem("�M�P(U)");
        undoMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(undoMenuItem);
        
        JSeparator separator3 = new JSeparator();
        editMenu.add(separator3);
        
        JMenuItem cutMenuItem = new JMenuItem("�Ť�(T)");
        cutMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(cutMenuItem);
        
        JMenuItem copyMenuItem = new JMenuItem("�ƻs(C)");
        copyMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(copyMenuItem);
        
        JMenuItem pasteMenuItem = new JMenuItem("�߶K(P)");
        pasteMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(pasteMenuItem);
        
        JMenuItem deleteMenuItem = new JMenuItem("�R��(L)");
        deleteMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(deleteMenuItem);
        
        JSeparator separator4 = new JSeparator();
        editMenu.add(separator4);
        
        JMenuItem findMenuItem = new JMenuItem("�d��(F)...");
        findMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(findMenuItem);
        
        JMenuItem findNextMenuItem = new JMenuItem("�d��U�@��(N)");
        findNextMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(findNextMenuItem);
        
        JMenuItem replaceMenuItem = new JMenuItem("����(R)...");
        replaceMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(replaceMenuItem);
        
        JMenuItem gotoMenuItem = new JMenuItem("���(G)...");
        gotoMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(gotoMenuItem);
        
        JSeparator separator5 = new JSeparator();
        editMenu.add(separator5);
        
        JMenuItem allMenuItem = new JMenuItem("����(A)");
        allMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(allMenuItem);
        
        JMenuItem dateMenuItem = new JMenuItem("�ɶ�/���(D)");
        dateMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        editMenu.add(dateMenuItem);
        
        JMenu formatMenu = new JMenu("�榡(O)");
        formatMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
        menuBar.add(formatMenu);
        
        JMenuItem wrapMenuItem = new JMenuItem("�۰ʴ���(W)");
        wrapMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        formatMenu.add(wrapMenuItem);
        
        JMenuItem FontMenuItem = new JMenuItem("�r��(F)...");
        FontMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        formatMenu.add(FontMenuItem);
        
        JMenu viewMenu = new JMenu("�d��(V)");
        viewMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
        menuBar.add(viewMenu);
        
        JMenuItem statusMenuItem = new JMenuItem("���A��(S)");
        statusMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        viewMenu.add(statusMenuItem);
        
        JMenu helpMenu = new JMenu("���U(H)");
        helpMenu.setFont(new Font("�L�n����", Font.PLAIN, 16));
        menuBar.add(helpMenu);
        
        JMenuItem helpMenuItem = new JMenuItem("�d�����U(H)");
        helpMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        helpMenu.add(helpMenuItem);
        
        JSeparator separator6 = new JSeparator();
        helpMenu.add(separator6);
        
        JMenuItem aboutMenuItem = new JMenuItem("����O�ƥ�(A)");
        aboutMenuItem.setFont(new Font("�L�n����", Font.PLAIN, 16));
        helpMenu.add(aboutMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);
    }
    
}
