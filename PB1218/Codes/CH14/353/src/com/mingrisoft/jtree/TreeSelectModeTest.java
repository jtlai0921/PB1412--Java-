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
        setTitle("樹控件的選擇模式");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("樹控件選擇模式：");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        JRadioButton radioButton1 = new JRadioButton("單行");
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton1_actionPerformed(e);
            }
        });
        radioButton1.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(radioButton1);
        
        JRadioButton radioButton2 = new JRadioButton("連續多行");
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton2_actionPerformed(e);
            }
        });
        radioButton2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(radioButton2);
        
        JRadioButton radioButton3 = new JRadioButton("任意多行");
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton3_actionPerformed(e);
            }
        });
        radioButton3.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(radioButton3);
        radioButton3.setSelected(true);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        tree = new JTree();
        tree.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(tree);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("明日科技新書");
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("從入門到精通系列");
        parent1.add(new DefaultMutableTreeNode("《Java從入門到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《PHP從入門到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《Visual Basic從入門到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《Visual C++從入門到精通（第2版）》"));
        root.add(parent1);
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("編程詞典系列");
        parent2.add(new DefaultMutableTreeNode("《Java編程詞典》"));
        parent2.add(new DefaultMutableTreeNode("《PHP編程詞典》"));
        parent2.add(new DefaultMutableTreeNode("《Visual Basic編程詞典》"));
        parent2.add(new DefaultMutableTreeNode("《Visual C++編程詞典》"));
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