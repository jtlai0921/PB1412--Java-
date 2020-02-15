package com.mingrisoft.oop;

public class Worker implements Cloneable {
    private String name;
    private int age;
    
    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("©m¦W¡G" + name + ", ");
        sb.append("¦~ÄÖ¡G" + age + "\n");
        return sb.toString();
    }
    
    @Override
    protected Worker clone() {
        Worker worker = null;
        try {
            worker = (Worker) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return worker;
    }
}
