package com.mingrisoft.oop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
    
    private static final long serialVersionUID = 3049633059823371192L;
    
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
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            employee = (Employee) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
