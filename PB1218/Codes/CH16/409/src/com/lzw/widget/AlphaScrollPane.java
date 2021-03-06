package com.lzw.widget;

import java.awt.*;
import java.beans.*;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * @author 李鍾尉
 */
public class AlphaScrollPane extends JScrollPane {
    
    private static final long serialVersionUID = 1L;
    private boolean borderPaint = false;
    private boolean headerOpaquae = true;
    private boolean viewportBorderPaint = false;
    
    /**
     * This is the default constructor
     */
    public AlphaScrollPane() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        setBackground(new Color(151, 188, 229));
        setOpaque(false);
        addPropertyChangeListener(new PropertyChangeAdapter());
    }
    
    private final class PropertyChangeAdapter implements
            PropertyChangeListener, Serializable {
        
        public void propertyChange(PropertyChangeEvent e) {
            String name = e.getPropertyName();
            if (name.equals("ancestor")) {
                JViewport header = getColumnHeader();
                if (header != null) {
                    // header.setBackground(getBackground());
                    JComponent view = (JComponent) header.getView();
                    header.setOpaque(headerOpaquae);
                }
                getViewport().setOpaque(isOpaque());// 使捲動檢視透明
                if (!viewportBorderPaint)
                    setViewportBorder(null);// 取消捲動檢視的邊框
                if (!isBorderPaint())// 繪製邊框
                    setBorder(null);
            }
            if (name.equals("background")) {
                setBorder(new LineBorder(getBackground(), 1, true));
            }
        }
    }
    
    public boolean isBorderPaint() {
        return borderPaint;
    }
    
    public void setBorderPaint(boolean borderPaint) {
        this.borderPaint = borderPaint;
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Component[] components = getComponents();
        for (Component component : components) {
            component.setEnabled(enabled);
        }
        Component view = getViewport().getView();
        if (view != null)
            view.setEnabled(enabled);
        if (getColumnHeader() != null)
            getColumnHeader().setEnabled(enabled);
    }
    
    public void setHeaderOpaquae(boolean headerOpaquae) {
        this.headerOpaquae = headerOpaquae;
    }
    
    public boolean isViewportBorderPaint() {
        return viewportBorderPaint;
    }
    
    public void setViewportBorderPaint(boolean viewportBorderPaint) {
        this.viewportBorderPaint = viewportBorderPaint;
    }
}
