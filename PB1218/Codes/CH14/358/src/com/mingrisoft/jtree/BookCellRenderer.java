package com.mingrisoft.jtree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public class BookCellRenderer implements TreeCellRenderer {
    
    private JLabel titleLabel = new JLabel();
    private JLabel pressLabel = new JLabel();
    private JLabel publicationDateLabel = new JLabel();
    private JLabel booksCategoryLabel = new JLabel();
    private JLabel priceLabel = new JLabel();
    private JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
    
    public BookCellRenderer() {
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(titleLabel);
        pressLabel.setForeground(Color.GREEN);
        pressLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(pressLabel);
        publicationDateLabel.setForeground(Color.BLUE);
        publicationDateLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(publicationDateLabel);
        booksCategoryLabel.setForeground(Color.ORANGE);
        booksCategoryLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(booksCategoryLabel);
        priceLabel.setForeground(Color.PINK);
        priceLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        panel.add(priceLabel);
        panel.setPreferredSize(new Dimension(350, 110));
    }
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        
        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
        if (userObject instanceof Book) {
            Book book = (Book) userObject;
            titleLabel.setText("書名：" + book.getTitle());
            pressLabel.setText("出版社：" + book.getPress());
            publicationDateLabel.setText("出版時間：" + book.getPublicationDate());
            booksCategoryLabel.setText("叢書類別別：" + book.getBooksCategory());
            priceLabel.setText("定價：" + book.getPrice() + "元");
            return panel;
        } else {
            return new DefaultTreeCellRenderer().getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        }
    }
    
}
