package com.mingrisoft.reflection;

import java.awt.Container;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Test {
    public static void main(String[] args) {
        TreeSet<Class<?>> treeSet = new TreeSet<Class<?>>(new ClassComparator());
        System.out.println("�V�𶰤��W�[JPanel.class");
        treeSet.add(JPanel.class);// �V�𶰤��W�[JPanel.class
        System.out.println("�V�𶰤��W�[JComponent.class");
        treeSet.add(JComponent.class);// �V�𶰤��W�[JComponent.class
        System.out.println("�V�𶰤��W�[Container.class");
        treeSet.add(Container.class);// �V�𶰤��W�[Container.class
        System.out.print("��o�𶰪��̫�@�Ӥ����G");
        System.out.println(treeSet.last());// ��o�𶰪��̫�@�Ӥ���
    }
}
