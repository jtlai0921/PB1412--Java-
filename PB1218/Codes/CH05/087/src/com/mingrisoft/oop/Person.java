package com.mingrisoft.oop;

public class Person {
    private String name;
    private String gender;
    private int age;
    
    public Person() {
        System.out.println("�ϥεL�ѫغc��k�إ߹ﹳ");
    }
    
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        System.out.println("�ϥΦ��ѫغc��k�إ߹ﹳ");
    }
    
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getAge() {
        return age;
    }
    
}
