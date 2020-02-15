package com.mingrisoft.jtree;

import java.awt.Component;
import java.util.Map;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public class ToolTipNode implements TreeCellRenderer {
    /**
     * 
     */
    private static final long serialVersionUID = -1884123073630846839L;
    private DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    private Map<DefaultMutableTreeNode, String> map;
    
    public ToolTipNode(Map<DefaultMutableTreeNode, String> map) {
        this.map = map;
    }
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        renderer.setToolTipText("<html><font face=·L³n¶®¶Â size=16 color=red>" + map.get(value) + "</font></html>");
        return renderer;
        
    }
}
