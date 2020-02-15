package com.mingrisoft.jtree;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeTraversalMethods extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5383028129537224585L;
    private JPanel contentPane;
    private JTree tree;
    private DefaultMutableTreeNode root;
    private JTextArea textArea;
    
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
                    TreeTraversalMethods frame = new TreeTraversalMethods();
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
    public TreeTraversalMethods() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("樹的遍歷方式");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton breadthFirstButton = new JButton("廣度優先遍歷");
        breadthFirstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_breadthFirstButton_actionPerformed(e);
            }
        });
        breadthFirstButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(breadthFirstButton);
        
        JButton depthFirstButton = new JButton("深度優先遍歷");
        depthFirstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_depthFirstButton_actionPerformed(e);
            }
        });
        depthFirstButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(depthFirstButton);
        
        JPanel contentPanel = new JPanel();
        panel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JScrollPane scrollPane1 = new JScrollPane();
        contentPanel.add(scrollPane1);
        
        tree = new JTree();
        tree.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane1.setViewportView(tree);
        
        JScrollPane scrollPane2 = new JScrollPane();
        contentPanel.add(scrollPane2);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane2.setViewportView(textArea);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        root = new DefaultMutableTreeNode("根節點");
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("父節點1");
        parent1.add(new DefaultMutableTreeNode("子節點1"));
        parent1.add(new DefaultMutableTreeNode("子節點2"));
        root.add(parent1);
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("父節點2");
        parent2.add(new DefaultMutableTreeNode("子節點3"));
        parent2.add(new DefaultMutableTreeNode("子節點4"));
        root.add(parent2);
        DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    protected void do_breadthFirstButton_actionPerformed(ActionEvent e) {
        Enumeration enums = root.breadthFirstEnumeration();
        getNodesInfor(enums);
    }
    
    @SuppressWarnings("unchecked")
    protected void do_depthFirstButton_actionPerformed(ActionEvent e) {
        Enumeration enums = root.depthFirstEnumeration();
        getNodesInfor(enums);
    }
    
    @SuppressWarnings("unchecked")
    private void getNodesInfor(Enumeration enums) {
        textArea.setText("");
        StringBuilder sb = new StringBuilder();
        while (enums.hasMoreElements()) {
            sb.append((DefaultMutableTreeNode) enums.nextElement());
            sb.append("\n");
        }
        textArea.setText(sb.toString());
    }
}
