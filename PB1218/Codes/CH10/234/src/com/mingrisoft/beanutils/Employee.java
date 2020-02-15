package com.mingrisoft.beanutils;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    
    private String name;// 簡單屬性
    private String[] phoneNumber = new String[10];// 索引屬性
    private Map<String, String> address = new HashMap<String, String>();// 映射屬性
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String[] getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Map<String, String> getAddress() {
        return address;
    }
    
    public void setAddress(Map<String, String> address) {
        this.address = address;
    }
}
