package com.mingrisoft.proxy;

public class HouseSeller implements Seller {
    public void sell() {
        System.out.println("銷售人員在賣房子");// 實現接口的方法，用輸出來區別該類別
    }
}
