package com.mingrisoft.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();// ��o�@��Employee�ﹳ
        // ��oEmployee��H���ݩʭȡA�ѩ�ƥ��å���䵹���ȡA�ҥH���Ӭ���
        String name = employee.getName();
        String phoneNumber = employee.getPhoneNumber()[0];
        String address = employee.getAddress().get("home");
        // ��X����o���ݩʭ�
        System.out.println("�]�w�ݩʭȤ��e�G");
        System.out.println("name�ݩʡG" + name);
        System.out.println("phoneNumber�ݩʪ��Ĥ@�ӭȡG" + phoneNumber);
        System.out.println("address�ݩ�home��ҹ������ȡG" + address);
        try {// �ϥ�PropertyUtils���O��������k��Employee��H���쵹����
            PropertyUtils.setSimpleProperty(employee, "name", "������");
            PropertyUtils.setIndexedProperty(employee, "phoneNumber", 0, "1234567");
            PropertyUtils.setMappedProperty(employee, "address", "home", "����");
            // ��oEmployee��H���ݩʭȡA�ѩ����䵹���ȡA�ҥH���Ӭ�����
            name = (String) PropertyUtils.getSimpleProperty(employee, "name");
            phoneNumber = (String) PropertyUtils.getIndexedProperty(employee, "phoneNumber", 0);
            address = (String) PropertyUtils.getMappedProperty(employee, "address", "home");
            // ��X����o���ݩʭ�
            System.out.println("�]�w�ݩʭȤ���G");
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