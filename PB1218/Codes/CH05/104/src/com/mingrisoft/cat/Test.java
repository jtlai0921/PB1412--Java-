package com.mingrisoft.cat;

import java.awt.Color;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Java", 12, 21, Color.BLACK);
        Cat cat2 = new Cat("C++", 12, 21, Color.WHITE);
        Cat cat3 = new Cat("Java", 12, 21, Color.BLACK);
        System.out.println("�߫}1���G" + cat1);
        System.out.println("�߫}2���G" + cat2);
        System.out.println("�߫}3���G" + cat3);
        System.out.println("�߫}1���O�_�P�߫}2���ۦP�G" + cat1.equals(cat2));
        System.out.println("�߫}1���O�_�P�߫}3���ۦP�G" + cat1.equals(cat3));
    }
}
