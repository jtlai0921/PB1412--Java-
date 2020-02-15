package com.mingrisoft.cat;

import java.awt.Color;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(name).append(age).append(weight).append(color).toString();
    }
}
