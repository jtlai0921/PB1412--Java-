package com.lzw.widget;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class BGPanelBeanInfo extends SimpleBeanInfo {
    
    private PropertyDescriptor[] pds;
    
    public BGPanelBeanInfo() {
        try {
            PropertyDescriptor iconFillProperty = new PropertyDescriptor(
                    "iconFill", BGPanel.class);
            iconFillProperty.setDisplayName("­I´º¶ñ¥R¤è¦¡");
            iconFillProperty.setPropertyEditorClass(IconFillEditor.class);
            pds = new PropertyDescriptor[] {
                    new PropertyDescriptor("image", BGPanel.class),
                    iconFillProperty, };
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return pds;
    }
}
