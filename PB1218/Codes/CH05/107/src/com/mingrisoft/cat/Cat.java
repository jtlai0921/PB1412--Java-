package com.mingrisoft.cat;

import java.awt.Color;

public class Cat {
    private String name;
    private int age;
    private double weight;
    private Color color;
    
    public Cat(String name, int age, double weight, Color color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("�W�r�G" + name + "\n");
        sb.append("�~�֡G" + age + "\n");
        sb.append("���q�G" + weight + "\n");
        sb.append("�C��G" + color + "\n");
        return sb.toString();
    }
}
