package com.mingrisoft.enumerationtest;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 3; i++) {
            vector.add(i);
            System.out.println("�b�V�q���W�[�����G" + i);
        }
        Enumeration<Integer> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println("��o�V�q���������G" + e.nextElement());
        }
    }
}
