package com.cdd.avg;

public class Grade {
    private int id;
    private String name;
    private String sex;
    private float english;
    private float math;
    private float chinese;
    private float avgEng;
    private float balance;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public float getEnglish() {
        return english;
    }
    public void setEnglish(float english) {
        this.english = english;
    }
    public float getMath() {
        return math;
    }
    public void setMath(float math) {
        this.math = math;
    }
    public float getChinese() {
        return chinese;
    }
    public void setChinese(float chinese) {
        this.chinese = chinese;
    }
    public float getAvgEng() {
        return avgEng;
    }
    public void setAvgEng(float avgEng) {
        this.avgEng = avgEng;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
}
