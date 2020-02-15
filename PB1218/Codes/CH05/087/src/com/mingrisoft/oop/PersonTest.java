package com.mingrisoft.oop;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("明日科技", "男", 11);
        System.out.println("員工1的資訊");
        System.out.println("員工姓名：" + person1.getName());
        System.out.println("員工性別：" + person1.getGender());
        System.out.println("員工年齡：" + person1.getAge());
        System.out.println("員工2的資訊");
        System.out.println("員工姓名：" + person2.getName());
        System.out.println("員工性別：" + person2.getGender());
        System.out.println("員工年齡：" + person2.getAge());
    }
}
