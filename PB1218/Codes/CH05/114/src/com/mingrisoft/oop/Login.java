package com.mingrisoft.oop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Login implements Serializable {
    
    private static final long serialVersionUID = 181569760561269743L;
    private String username;
    private transient String password;
    
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("使用者名稱：" + username + ", ");
        sb.append("密碼：" + password);
        return sb.toString();
    }
    
    @Override
    public Login clone() {
        Login login = null;
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
            login = (Login) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return login;
    }
}
