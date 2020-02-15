package com.mingrisoft.reflection;

import java.awt.Container;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Test {
    public static void main(String[] args) {
        TreeSet<Class<?>> treeSet = new TreeSet<Class<?>>(new ClassComparator());
        System.out.println("向樹集中增加JPanel.class");
        treeSet.add(JPanel.class);// 向樹集中增加JPanel.class
        System.out.println("向樹集中增加JComponent.class");
        treeSet.add(JComponent.class);// 向樹集中增加JComponent.class
        System.out.println("向樹集中增加Container.class");
        treeSet.add(Container.class);// 向樹集中增加Container.class
        System.out.print("獲得樹集的最後一個元素：");
        System.out.println(treeSet.last());// 獲得樹集的最後一個元素
    }
}
