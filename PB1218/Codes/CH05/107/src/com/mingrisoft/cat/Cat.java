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
        sb.append("名字：" + name + "\n");
        sb.append("年齡：" + age + "\n");
        sb.append("重量：" + weight + "\n");
        sb.append("顏色：" + color + "\n");
        return sb.toString();
    }
}
