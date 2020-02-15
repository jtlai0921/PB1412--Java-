package com.mingrisoft.enums;

public enum Size {
    SMALL("�ڬO�p������"), MEDIUM("�ڬO��������"), LARGE("�ڬO�j������");
    private String description;
    
    private Size(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public static void main(String[] args) {
        for (Size size : Size.values()) {
            System.out.println(size + ":" + size.getDescription());
        }
    }
}
