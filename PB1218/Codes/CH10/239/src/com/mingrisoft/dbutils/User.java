package com.mingrisoft.dbutils;

public class User {
    
    private int id;
    private String username;
    private String password;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "序號：" + id + "，使用者名稱：" + username + "，密碼：" + password;
    }
}
