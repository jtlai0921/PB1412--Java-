package com.mingrisoft.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.apache.commons.lang.SerializationUtils;

public class SerializationUtilsTest {
    public static void main(String[] args) {
        Student student = new Student();// �إ�student�ﹳ
        student.setId(10);// ��l��id�ݩ�
        student.setName("������");// ��l��name�ݩ�
        System.out.println("�Nstudent�ﹳ�ǦC�Ʀ�byte�}�C");
        byte[] studentByte = SerializationUtils.serialize(student);// �N�ﹳ�ഫ��byte�}�C
        System.out.println("��X�ǦC�ư}�C�G");
        System.out.println(Arrays.toString(studentByte));// ��Xbyte�}�C
        System.out.println("�Nstudent�ﹳ�ǦC�ƨ쥻���ɮ�");
        FileOutputStream out = null;// �إ��ɮ׿�X�y�ﹳ
        try {
            out = new FileOutputStream(new File("d:\\student.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SerializationUtils.serialize(student, out);// �N�ﹳ�g�J��student.txt�ɮ�
        System.out.println("�ɮײ��ͦ��\�I");
        System.out.println("�q�����ɮפϧǦC��student�ﹳ");
        FileInputStream in = null;// �إ��ɮ׿�J�y�ﹳ
        try {
            in = new FileInputStream(new File("d:\\student.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Student newStudent = (Student) SerializationUtils.deserialize(in);// Ū�J�ﹳ
        System.out.println("�˵�student��H���ݩ�");
        System.out.println(newStudent);
    }
}
