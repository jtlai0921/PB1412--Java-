package com.mingrisoft.oop;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("������", "�k", 11);
        System.out.println("���u1����T");
        System.out.println("���u�m�W�G" + person1.getName());
        System.out.println("���u�ʧO�G" + person1.getGender());
        System.out.println("���u�~�֡G" + person1.getAge());
        System.out.println("���u2����T");
        System.out.println("���u�m�W�G" + person2.getName());
        System.out.println("���u�ʧO�G" + person2.getGender());
        System.out.println("���u�~�֡G" + person2.getAge());
    }
}
