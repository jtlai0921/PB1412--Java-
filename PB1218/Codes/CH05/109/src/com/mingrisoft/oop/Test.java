package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        System.out.println("�ƻs���e�G");
        Employee employee1 = new Employee();
        employee1.setName("������");
        employee1.setAge(12);
        System.out.println("���u1����T�G");
        System.out.println(employee1);
        System.out.println("�ƻs����G");
        Employee employee2 = employee1;
        employee2.setName("��n��q�j��");
        employee2.setAge(114);
        System.out.println("���u2����T�G");
        System.out.println(employee2);
        System.out.println("���u1����T�G");
        System.out.println(employee1);
    }
}
