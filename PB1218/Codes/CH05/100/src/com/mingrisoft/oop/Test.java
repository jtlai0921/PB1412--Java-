package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("�ϧΪ��W�٬O�G" + circle.getName());
        System.out.println("�ϧΪ����n�O�G" + circle.getArea());
        Rectangle rectangle = new Rectangle(1, 1);
        System.out.println("�ϧΪ��W�٬O�G" + rectangle.getName());
        System.out.println("�ϧΪ����n�O�G" + rectangle.getArea());
    }
}
