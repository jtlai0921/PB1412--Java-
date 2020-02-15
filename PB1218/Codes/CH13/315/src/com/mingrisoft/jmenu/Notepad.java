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
        setTitle("¼Ò¥é°O¨Æ¥»ªºµæ³æ¶µ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("¤å¥ó(F)");
        fileMenu.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        menuBar.add(fileMenu);
        
        JMenuItem newMenuItem = new JMenuItem("·s«Ø(N)");
        newMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(newMenuItem);
        
        JMenuItem openMenuItem = new JMenuItem("¥´¶}(O)...");
        openMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(openMenuItem);
        
        JMenuItem saveMenuItem = new JMenuItem("«O¦s(S)");
        saveMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(saveMenuItem);
        
        JMenuItem saveAsMenuItem = new JMenuItem("¥t¦s¬°(A)...");
        saveAsMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(saveAsMenuItem);
        
        JSeparator separator1 = new JSeparator();
        fileMenu.add(separator1);
        
        JMenuItem pageSetMenuItem = new JMenuItem("­¶­±³]¸m(U)...");
        pageSetMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(pageSetMenuItem);
        
        JMenuItem printMenuItem = new JMenuItem("¥´¦L(P)...");
        printMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(printMenuItem);
        
        JSeparator separator2 = new JSeparator();
        fileMenu.add(separator2);
        
        JMenuItem exitMenuItem = new JMenuItem("°h¥X(X)");
        exitMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        fileMenu.add(exitMenuItem);
        
        JMenu editMenu = new JMenu("½s¿è(E)");
        editMenu.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        menuBar.add(editMenu);
        
        JMenuItem undoMenuItem = new JMenuItem("ºM¾P(U)");
        undoMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(undoMenuItem);
        
        JSeparator separator3 = new JSeparator();
        editMenu.add(separator3);
        
        JMenuItem cutMenuItem = new JMenuItem("°Å¤Á(T)");
        cutMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(cutMenuItem);
        
        JMenuItem copyMenuItem = new JMenuItem("½Æ»s(C)");
        copyMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(copyMenuItem);
        
        JMenuItem pasteMenuItem = new JMenuItem("Öß¶K(P)");
        pasteMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(pasteMenuItem);
        
        JMenuItem deleteMenuItem = new JMenuItem("§R°£(L)");
        deleteMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(deleteMenuItem);
        
        JSeparator separator4 = new JSeparator();
        editMenu.add(separator4);
        
        JMenuItem findMenuItem = new JMenuItem("¬d§ä(F)...");
        findMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(findMenuItem);
        
        JMenuItem findNextMenuItem = new JMenuItem("¬d§ä¤U¤@­Ó(N)");
        findNextMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(findNextMenuItem);
        
        JMenuItem replaceMenuItem = new JMenuItem("´À´«(R)...");
        replaceMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(replaceMenuItem);
        
        JMenuItem gotoMenuItem = new JMenuItem("Âà¨ì(G)...");
        gotoMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(gotoMenuItem);
        
        JSeparator separator5 = new JSeparator();
        editMenu.add(separator5);
        
        JMenuItem allMenuItem = new JMenuItem("¥þ¿ï(A)");
        allMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(allMenuItem);
        
        JMenuItem dateMenuItem = new JMenuItem("®É¶¡/¤é´Á(D)");
        dateMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        editMenu.add(dateMenuItem);
        
        JMenu formatMenu = new JMenu("®æ¦¡(O)");
        formatMenu.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        menuBar.add(formatMenu);
        
        JMenuItem wrapMenuItem = new JMenuItem("¦Û°Ê´«¦æ(W)");
        wrapMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        formatMenu.add(wrapMenuItem);
        
        JMenuItem FontMenuItem = new JMenuItem("¦rÅé(F)...");
        FontMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        formatMenu.add(FontMenuItem);
        
        JMenu viewMenu = new JMenu("¬d¬Ý(V)");
        viewMenu.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        menuBar.add(viewMenu);
        
        JMenuItem statusMenuItem = new JMenuItem("ª¬ºAÄæ(S)");
        statusMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        viewMenu.add(statusMenuItem);
        
        JMenu helpMenu = new JMenu("À°§U(H)");
        helpMenu.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        menuBar.add(helpMenu);
        
        JMenuItem helpMenuItem = new JMenuItem("¬d¬ÝÀ°§U(H)");
        helpMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        helpMenu.add(helpMenuItem);
        
        JSeparator separator6 = new JSeparator();
        helpMenu.add(separator6);
        
        JMenuItem aboutMenuItem = new JMenuItem("Ãö©ó°O¨Æ¥»(A)");
        aboutMenuItem.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        helpMenu.add(aboutMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);
    }
    
}
