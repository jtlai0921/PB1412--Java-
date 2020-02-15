package com.mingrisoft.enums;

public enum Size {
    SMALL("我是小號匹薩"), MEDIUM("我是中號匹薩"), LARGE("我是大號匹薩");
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