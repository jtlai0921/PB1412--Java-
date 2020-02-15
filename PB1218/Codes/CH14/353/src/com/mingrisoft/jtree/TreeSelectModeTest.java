package com.mingrisoft.jtree;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.UIManager;

public class TreeSelectModeTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8668891664815693398L;
    private JPanel contentPane;
    private JTree tree;
    
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
                    TreeSelectModeTest frame = new TreeSelectModeTest();
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
    public TreeSelectModeTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("�𱱥󪺿�ܼҦ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("�𱱥��ܼҦ��G");
        label.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(label);
        
        JRadioButton radioButton1 = new JRadioButton("���");
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton1_actionPerformed(e);
            }
        });
        radioButton1.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(radioButton1);
        
        JRadioButton radioButton2 = new JRadioButton("�s��h��");
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton2_actionPerformed(e);
            }
        });
        radioButton2.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(radioButton2);
        
        JRadioButton radioButton3 = new JRadioButton("���N�h��");
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton3_actionPerformed(e);
            }
        });
        radioButton3.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(radioButton3);
        radioButton3.setSelected(true);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        tree = new JTree();
        tree.setFont(new Font("�L�n����", Font.PLAIN, 16));
        scrollPane.setViewportView(tree);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("�����޷s��");
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("�q�J�����q�t�C");
        parent1.add(new DefaultMutableTreeNode("�mJava�q�J�����q�]��2���^�n"));
        parent1.add(new DefaultMutableTreeNode("�mPHP�q�J�����q�]��2���^�n"));
        parent1.add(new DefaultMutableTreeNode("�mVisual Basic�q�J�����q�]��2���^�n"));
        parent1.add(new DefaultMutableTreeNode("�mVisual C++�q�J�����q�]��2���^�n"));
        root.add(parent1);
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("�s�{����t�C");
        parent2.add(new DefaultMutableTreeNode("�mJava�s�{����n"));
        parent2.add(new DefaultMutableTreeNode("�mPHP�s�{����n"));
        parent2.add(new DefaultMutableTreeNode("�mVisual Basic�s�{����n"));
        parent2.add(new DefaultMutableTreeNode("�mVisual C++�s�{����n"));
        root.add(parent2);
        DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
    }
    
    protected void do_radioButton1_actionPerformed(ActionEvent e) {
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }
    
    protected void do_radioButton2_actionPerformed(ActionEvent e) {
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    }
    
    protected void do_radioButton3_actionPerformed(ActionEvent e) {
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    }
}
