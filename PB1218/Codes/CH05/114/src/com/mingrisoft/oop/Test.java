package com.mingrisoft.oop;

public class Test {
    
    public static void main(String[] args) {
        Login login1 = new Login("mingrisoft", "mr");
        System.out.println("輸出原始對象的資訊：");
        System.out.println(login1);
        System.out.println("輸出複製對象的資訊：");
        Login login2 = login1.clone();
        System.out.println(login2);
    }
}
