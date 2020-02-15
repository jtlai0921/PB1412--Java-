package com.mingrisoft.jtable;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Font;

public class NodeIcon extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9048535408788781352L;
    private JPanel contentPane;
    private JTree tree;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        UIManager.put("Tree.openIcon", new ImageIcon("src/image/open.png"));
        UIManager.put("Tree.closedIcon", new ImageIcon("src/image/closed.png"));
        UIManager.put("Tree.leafIcon", new ImageIcon("src/image/leaf.png"));
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NodeIcon frame = new NodeIcon();
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
    public NodeIcon() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("�ק��`�I���ϼ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
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
}
