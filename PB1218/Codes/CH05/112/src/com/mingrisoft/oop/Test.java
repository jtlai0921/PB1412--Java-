package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        System.out.println("�ƻs���e�G");
        Address address = new Address("����", "�N�L", "���K");
        Employee employee1 = new Employee("������", 12, address);
        System.out.println("���u1����T�G");
        System.out.println(employee1);
        System.out.println("�ƻs����G");
        Employee employee2 = employee1.clone();
        employee2.getAddress().setState("����");
        employee2.getAddress().setProvince("�|�t");
        employee2.getAddress().setCity("����");
        employee2.setName("��n��q�j��");
        employee2.setAge(114);
        System.out.println("���u2����T�G");
        System.out.println(employee2);
        System.out.println("���u1����T�G");
        System.out.println(employee1);
    }
}
