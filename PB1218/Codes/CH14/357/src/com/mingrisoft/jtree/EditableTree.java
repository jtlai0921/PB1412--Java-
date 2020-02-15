package com.mingrisoft.jtree;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class EditableTree extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2734697597567545697L;
    private JPanel contentPane;
    private JTextField textField;
    private JTree tree;
    private DefaultMutableTreeNode root;
    
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
                    EditableTree frame = new EditableTree();
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
    public EditableTree() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("可以查找子節點的樹");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("關鍵字：");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("查找節點");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        tree = new JTree();
        tree.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(tree);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        root = new DefaultMutableTreeNode("明日科技新書");
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
    
    @SuppressWarnings("unchecked")
    protected void do_button_actionPerformed(ActionEvent e) {
        String key = textField.getText();
        if ((key == null) || (key.isEmpty())) {
            JOptionPane.showMessageDialog(this, "請輸入關鍵字", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode targetNode = null;
        Enumeration enums = root.breadthFirstEnumeration();
        while (enums.hasMoreElements()) {
            DefaultMutableTreeNode tempNode = (DefaultMutableTreeNode) enums.nextElement();
            if (("" + tempNode).equals(key)) {
                targetNode = tempNode;
            }
        }
        if (targetNode == null) {
            JOptionPane.showMessageDialog(this, "未找到需要的結果", "", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            TreeNode[] nodes = model.getPathToRoot(targetNode);
            TreePath path = new TreePath(nodes);
            tree.scrollPathToVisible(path);
            tree.setSelectionPath(path);
        }
    }
}
