package com.mingrisoft.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;

public class Test {
    public static void main(String[] args) {
        DynaProperty[] properties = new DynaProperty[3];// �n���x�s3���ݩʭȪ��}�C
        // ���w�ݩʦW�٩M���A
        properties[0] = new DynaProperty("name", String.class);
        properties[1] = new DynaProperty("phoneNumber", String[].class, String.class);
        properties[2] = new DynaProperty("address", Map.class, String.class);
        BasicDynaClass dynaClass = new BasicDynaClass("employee", null, properties);
        DynaBean employee = null;
        try {
            employee = dynaClass.newInstance();// ��oDynaBean�����
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        // ���ݩʵ�����
        employee.set("name", "������");
        employee.set("phoneNumber", new String[10]);// ���ޫ��A�n����l��
        employee.set("phoneNumber", 0, "1234567");
        employee.set("address", new HashMap<String, String>());// �M�g���A�n����l��
        employee.set("address", "home", "����");
        String name = (String) employee.get("name");
        String phoneNumber = (String) employee.get("phoneNumber", 0);
        String address = (String) employee.get("address", "home");
        // ��X�ݩʭ�
        System.out.println("�s�WJavaBean��name�ݩʡG" + name);
        System.out.println("�s�WJavaBean��phoneNumber�ݩʪ��Ĥ@�ӭȡG" + phoneNumber);
        System.out.println("�s�WJavaBean��address�ݩ�home��ҹ������ȡG" + address);
    }
}
