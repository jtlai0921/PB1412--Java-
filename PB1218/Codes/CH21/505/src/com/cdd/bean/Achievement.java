package com.cdd.bean;

public class Achievement {
    private int id;
    private String dept;
    private float achievement;
    private int monthCount;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public float getAchievement() {
        return achievement;
    }
    public void setAchievement(float achievement) {
        this.achievement = achievement;
    }
    public int getMonthCount() {
        return monthCount;
    }
    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }
}
