package com.mingrisoft.proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Seller seller = new HouseSeller();
        System.out.println("���ϥΥN�z�覡�G");
        seller.sell();// ���q�覡�I�ssell()��k
        System.out.println("�ϥΥN�z�覡�G");
        ClassLoader loader = Seller.class.getClassLoader();// ��oSeller���O�����O���J��
        seller = (Seller) Proxy.newProxyInstance(loader, new Class[] { Seller.class }, new Agency());
        seller.sell();// �N�z�覡�I�ssell()��k
    }
}
