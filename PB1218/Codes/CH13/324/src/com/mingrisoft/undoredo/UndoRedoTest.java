package com.mingrisoft.undoredo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoRedoTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4740794263780422776L;
    private JPanel contentPane;
    private UndoManager manager = new UndoManager();
    private JButton undoButton;
    private JButton redoButton;
    
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
                    UndoRedoTest frame = new UndoRedoTest();
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
    public UndoRedoTest() {
        setTitle("ºM¾P»P­«°µªº¨Ï¥Î");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1, 2, 15, 15));
        
        undoButton = new JButton("ºM¾P«ö¶s");
        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_undoButton_actionPerformed(e);
            }
        });
        undoButton.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        undoButton.setEnabled(false);
        panel.add(undoButton);
        
        redoButton = new JButton("­«°µ«ö¶s");
        redoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_redoButton_actionPerformed(e);
            }
        });
        redoButton.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        redoButton.setEnabled(false);
        panel.add(redoButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
        
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
                updateButtons();
            }
        });
    }
    
    protected void do_undoButton_actionPerformed(ActionEvent e) {
        manager.undo();
        updateButtons();
    }
    
    protected void do_redoButton_actionPerformed(ActionEvent e) {
        manager.redo();
        updateButtons();
    }
    
    private void updateButtons() {
        undoButton.setText(manager.getUndoPresentationName());
        redoButton.setText(manager.getRedoPresentationName());
        undoButton.setEnabled(manager.canUndo());
        redoButton.setEnabled(manager.canRedo());
    }
}
