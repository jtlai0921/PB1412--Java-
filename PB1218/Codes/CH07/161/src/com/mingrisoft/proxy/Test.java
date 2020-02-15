package com.mingrisoft.proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Seller seller = new HouseSeller();
        System.out.println("不使用代理方式：");
        seller.sell();// 普通方式呼叫sell()方法
        System.out.println("使用代理方式：");
        ClassLoader loader = Seller.class.getClassLoader();// 獲得Seller類別的類別載入器
        seller = (Seller) Proxy.newProxyInstance(loader, new Class[] { Seller.class }, new Agency());
        seller.sell();// 代理方式呼叫sell()方法
    }
}
