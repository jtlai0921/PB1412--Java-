package com.mingrisoft.oop;

public class EmperorTest {
    public static void main(String[] args) {
        System.out.println("�إ߬ӫ�1�ﹳ�G");
        Emperor emperor1 = Emperor.getInstance();
        emperor1.getName();
        System.out.println("�إ߬ӫ�2�ﹳ�G");
        Emperor emperor2 = Emperor.getInstance();
        emperor2.getName();
        System.out.println("�إ߬ӫ�3�ﹳ�G");
        Emperor emperor3 = Emperor.getInstance();
        emperor3.getName();
    }
}
