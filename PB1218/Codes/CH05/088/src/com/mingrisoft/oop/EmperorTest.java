package com.mingrisoft.oop;

public class EmperorTest {
    public static void main(String[] args) {
        System.out.println("建立皇帝1對像：");
        Emperor emperor1 = Emperor.getInstance();
        emperor1.getName();
        System.out.println("建立皇帝2對像：");
        Emperor emperor2 = Emperor.getInstance();
        emperor2.getName();
        System.out.println("建立皇帝3對像：");
        Emperor emperor3 = Emperor.getInstance();
        emperor3.getName();
    }
}
