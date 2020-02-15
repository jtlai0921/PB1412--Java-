package com.mingrisoft.jlist;

import java.util.TreeSet;

import javax.swing.AbstractListModel;

public class SortedListModel extends AbstractListModel {
    
    private static final long serialVersionUID = -8908769624938773296L;
    
    private TreeSet<Object> model = new TreeSet<Object>();
    
    @Override
    public Object getElementAt(int index) {
        return model.toArray()[index];
    }
    
    @Override
    public int getSize() {
        return model.size();
    }
    
    public void add(Object element) {
        if (model.add(element)) {
            fireContentsChanged(this, 0, getSize());
        }
    }
}
