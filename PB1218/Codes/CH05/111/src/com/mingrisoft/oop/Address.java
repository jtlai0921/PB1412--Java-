package com.mingrisoft.oop;

public class Address implements Cloneable {
    private String state;
    private String province;
    private String city;
    
    public Address(String state, String province, String city) {
        this.state = state;
        this.province = province;
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getProvince() {
        return province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("°ê®a¡G" + state + ", ");
        sb.append("¬Ù¡G" + province + ", ");
        sb.append("¥«¡G" + city);
        return sb.toString();
    }
    
    @Override
    protected Address clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}
