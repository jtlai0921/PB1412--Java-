package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println("�N�c�l�����׳]�w��-1");
        box.setLength(-1);
        System.out.println("�N�c�l���e�׳]�w��-1");
        box.setWidth(-1);
        System.out.println("�N�c�l�����׳]�w��-1");
        box.setHeight(-1);
        System.out.println("�c�l�����׬O�G" + box.getLength());
        System.out.println("�c�l���e�׬O�G" + box.getWidth());
        System.out.println("�c�l�����׬O�G" + box.getHeight());
    }
}
