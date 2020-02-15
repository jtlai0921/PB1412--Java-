package com.order.util;

public class Student {
    private int id;
    private String name;
    private String className;
    private String sex;
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    private float math;
    private float english;
    private float chinese;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public float getMath() {
        return math;
    }
    public void setMath(float math) {
        this.math = math;
    }
    public float getEnglish() {
        return english;
    }
    public void setEnglish(float english) {
        this.english = english;
    }
    public float getChinese() {
        return chinese;
    }
    public void setChinese(float chinese) {
        this.chinese = chinese;
    }
    
}
