package com.mingrisoft.cat;

import java.awt.Color;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Java", 12, 21, Color.BLACK);
        Cat cat2 = new Cat("C++", 12, 21, Color.WHITE);
        Cat cat3 = new Cat("Java", 12, 21, Color.BLACK);
        System.out.println("�߫}1�������ƽX�G" + cat1.hashCode());
        System.out.println("�߫}2�������ƽX�G" + cat2.hashCode());
        System.out.println("�߫}3�������ƽX�G" + cat3.hashCode());
        System.out.println("�߫}1���O�_�P�߫}2���ۦP�G" + cat1.equals(cat2));
        System.out.println("�߫}1���O�_�P�߫}3���ۦP�G" + cat1.equals(cat3));
    }
}
