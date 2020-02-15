package com.mingrisoft.oop;

public class Employee implements Comparable<Employee> {
    
    private int id;
    private String name;
    private int age;
    
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int compareTo(Employee o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("���u���s���G" + id + ", ");
        sb.append("���u���m�W�G" + name + ", ");
        sb.append("���u���~�֡G" + age);
        return sb.toString();
    }
}
