package com.mingrisoft.io;

import java.io.File;

import org.apache.commons.io.filefilter.SizeFileFilter;

public class SizeFileFilterTest {
    public static void main(String[] args) {
        File dir = new File("d:\\������");// �إߤ@���ɮק��ﹳ
        System.out.println("�L�o�e�ɮק������ɮסG");
        File[] files = dir.listFiles();// ��o���ɮק����Ҧ��ɮשM�l�ɮק�
        for (File file : files) {// ��X�ɮק����ɮת��W�r�M�j�p
            System.out.println(file.getName() + "���j�p�O�G" + file.length());
        }
        System.out.println("�L�o���ɮק������ɮסG");
        String[] fileNames = dir.list(new SizeFileFilter(1024 * 1024));// �L�o��<1M���ɮ�
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i]);
        }
    }
}
