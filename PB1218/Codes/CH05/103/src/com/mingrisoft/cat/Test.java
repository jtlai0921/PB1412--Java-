package com.mingrisoft.cat;

import java.awt.Color;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Java", 12, 21, Color.BLACK);
        Cat cat2 = new Cat("C++", 12, 21, Color.WHITE);
        Cat cat3 = new Cat("Java", 12, 21, Color.BLACK);
        System.out.println("貓咪1號：" + cat1);
        System.out.println("貓咪2號：" + cat2);
        System.out.println("貓咪3號：" + cat3);
        System.out.println("貓咪1號是否與貓咪2號相同：" + cat1.equals(cat2));
        System.out.println("貓咪1號是否與貓咪3號相同：" + cat1.equals(cat3));
    }
}
