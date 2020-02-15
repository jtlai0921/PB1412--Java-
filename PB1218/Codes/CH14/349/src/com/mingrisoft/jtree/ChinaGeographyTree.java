package com.mingrisoft.jtree;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChinaGeographyTree extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6221329006071145576L;
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
                    ChinaGeographyTree frame = new ChinaGeographyTree();
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
    public ChinaGeographyTree() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("�����F�ϰ��");
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
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode municipalities = new DefaultMutableTreeNode("���ҥ�");
        municipalities.add(new DefaultMutableTreeNode("�_��"));
        municipalities.add(new DefaultMutableTreeNode("�W��"));
        municipalities.add(new DefaultMutableTreeNode("�Ѭz"));
        municipalities.add(new DefaultMutableTreeNode("���y"));
        DefaultMutableTreeNode province = new DefaultMutableTreeNode("��");
        province.add(new DefaultMutableTreeNode("���s��"));
        province.add(new DefaultMutableTreeNode("�N�L"));
        province.add(new DefaultMutableTreeNode("���"));
        province.add(new DefaultMutableTreeNode("��Ĭ"));
        province.add(new DefaultMutableTreeNode("�w��"));
        province.add(new DefaultMutableTreeNode("�|�t"));
        province.add(new DefaultMutableTreeNode("�C��"));
        province.add(new DefaultMutableTreeNode("�s�F"));
        province.add(new DefaultMutableTreeNode("�s�F"));
        province.add(new DefaultMutableTreeNode("�e�n"));
        province.add(new DefaultMutableTreeNode("��n"));
        province.add(new DefaultMutableTreeNode("���n"));
        province.add(new DefaultMutableTreeNode("����"));
        province.add(new DefaultMutableTreeNode("�s��"));
        province.add(new DefaultMutableTreeNode("����"));
        province.add(new DefaultMutableTreeNode("�e�_"));
        province.add(new DefaultMutableTreeNode("��_"));
        province.add(new DefaultMutableTreeNode("�Q�{"));
        province.add(new DefaultMutableTreeNode("����"));
        province.add(new DefaultMutableTreeNode("�֫�"));
        province.add(new DefaultMutableTreeNode("�̵�"));
        province.add(new DefaultMutableTreeNode("���n"));
        DefaultMutableTreeNode ARegion = new DefaultMutableTreeNode("�۪v��");
        ARegion.add(new DefaultMutableTreeNode("���X�j�۪v��"));
        ARegion.add(new DefaultMutableTreeNode("��L�^�ڦ۪v��"));
        ARegion.add(new DefaultMutableTreeNode("�sæ���^���ڦ۪v��"));
        ARegion.add(new DefaultMutableTreeNode("���æ۪v��"));
        ARegion.add(new DefaultMutableTreeNode("�s�觧�ڦ۪v��"));
        DefaultMutableTreeNode SARegion = new DefaultMutableTreeNode("�S�O��F��");
        SARegion.add(new DefaultMutableTreeNode("����"));
        SARegion.add(new DefaultMutableTreeNode("�D��"));
        root.add(municipalities);
        root.add(province);
        root.add(ARegion);
        root.add(SARegion);
        DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
    }
}
