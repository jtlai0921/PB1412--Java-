package com.mingrisoft.beanutils;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    
    private String name;// ²���ݩ�
    private String[] phoneNumber = new String[10];// �����ݩ�
    private Map<String, String> address = new HashMap<String, String>();// �M�g�ݩ�
    
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