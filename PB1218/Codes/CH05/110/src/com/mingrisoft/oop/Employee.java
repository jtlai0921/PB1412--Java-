package com.mingrisoft.oop;

public class Employee implements Cloneable {
    private String name;
    private int age;
    private Address address;
    
    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("©m¦W¡G" + name + ", ");
        sb.append("¦~ÄÖ¡G" + age + "\n");
        sb.append("¦a§}¡G" + address);
        return sb.toString();
    }
    
    @Override
    public Employee clone() {
        Employee employee = null;
        try {
            employee = (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
