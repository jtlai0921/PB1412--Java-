package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class DiskTree extends JFrame {
    
    /**
     * 本實例樹控制項單元的著色器
     * 
     * @author 李鍾尉
     */
    private final class FileRenderer implements TreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value,
                boolean selected, boolean expanded, boolean leaf, int row,
                boolean hasFocus) {
            // 轉換value為節點對像
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();
            if (!(userObject instanceof File)) {
                return new JLabel(userObject.toString());
            }
            File folder = (File) userObject;
            FileSystemView view = FileSystemView.getFileSystemView();
            Icon icon = view.getSystemIcon(folder);
            JLabel label = new JLabel("" + folder, icon, JLabel.LEADING);
            label.setBackground(Color.CYAN);
            if (selected) {
                label.setOpaque(true);
            } else {
                label.setOpaque(false);
            }
            return label;
        }
    }
    
    private JPanel contentPane;
    private JTree tree;
    private DefaultMutableTreeNode rootNode;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DiskTree frame = new DiskTree();
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
    public DiskTree() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        tree = new JTree();
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                do_tree_valueChanged(e);
            }
        });
        tree.setCellRenderer(new FileRenderer());
        scrollPane.setViewportView(tree);
        rootNode = new DefaultMutableTreeNode("我的電腦");
        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        tree.setModel(model);
    }
    
    /**
     * 窗體啟動時呼叫的方法
     * 
     * @param e
     */
    protected void do_this_windowActivated(WindowEvent e) {
        File[] disks = File.listRoots();// 獲得磁碟列表
        for (File file : disks) {// 檢查列表
            // 使用檔案對像建立樹節點
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
            rootNode.add(node);// 增加節點到樹控制項的根節點
        }
        tree.expandPath(new TreePath(rootNode));// 展開根節點
    }
    
    public JTree getTree() {
        return tree;
    }
    
    /**
     * 改變節點選項時，執行的方法
     * 
     * @param e
     */
    protected void do_tree_valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();// 獲得樹選擇路徑
        // 獲得選擇路徑中的節點
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
                .getLastPathComponent();
        // 獲得節點中的使用者對像
        Object userObject = node.getUserObject();
        if (!(userObject instanceof File)) {
            return;
        }
        File folder = (File) userObject;// 把使用者對像轉為檔案對像
        if (!folder.isDirectory())// 過濾非檔案夾的選擇操作
            return;
        File[] files = folder.listFiles();// 獲得檔案夾中的檔案列表
        for (File file : files) {// 檢查檔案列表陣列
            // 使用檔案做使用者對像建立節點
            node.add(new DefaultMutableTreeNode(file));
        }
    }
}
