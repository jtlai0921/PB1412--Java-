package com.mingrisoft.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee();// �n��Employee�ܼ�
        Employee employee2 = new Employee();// �n��Employee�ܼ�
        try {
            // ��employee1������
            PropertyUtils.setSimpleProperty(employee1, "name", "������");
            PropertyUtils.setIndexedProperty(employee1, "phoneNumber", 0, "1234567");
            PropertyUtils.setMappedProperty(employee1, "address", "home", "����");
            BeanUtils.copyProperties(employee2, employee1);// �Nemployee1�ƻs��employee2
            // ��oemployee2���ݩʭ�
            String name = (String) PropertyUtils.getSimpleProperty(employee2, "name");
            String phoneNumber = (String) PropertyUtils.getIndexedProperty(employee2, "phoneNumber", 0);
            String address = (String) PropertyUtils.getMappedProperty(employee2, "address", "home");
            // ��Xemployee2���ݩʭ�
            System.out.println("�ƻs�ݩʭȤ���G");
            System.out.println("name�ݩʡG" + name);
            System.out.println("phoneNumber�ݩʪ��Ĥ@�ӭȡG" + phoneNumber);
            System.out.println("address�ݩ�home��ҹ������ȡG" + address);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
