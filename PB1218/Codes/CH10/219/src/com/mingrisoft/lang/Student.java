package com.mingrisoft.lang;

import java.io.Serializable;

public class Student implements Serializable {
    
    private static final long serialVersionUID = -8396517822004869094L;
    private int id;
    private String name;
    
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
    
    @Override
    public String toString() {
        return "學生id：" + id + "，學生姓名：" + name;
    }
}
