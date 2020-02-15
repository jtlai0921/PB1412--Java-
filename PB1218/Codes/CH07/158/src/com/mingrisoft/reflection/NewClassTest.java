package com.mingrisoft.reflection;

import java.io.File;
import java.lang.reflect.Constructor;

public class NewClassTest {
    
    public static void main(String[] args) {
        try {
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            System.out.println("�ϥΤϮg�إ�File�ﹳ");
            File file = constructor.newInstance("d://������.txt");
            System.out.println("�ϥ�File�ﹳ�bD�Ыإ��ɮסG������.txt");
            file.createNewFile();
            System.out.println("�ɮ׬O�_�إߦ��\�G" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
