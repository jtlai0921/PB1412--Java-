package com.mingrisoft.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.apache.commons.lang.SerializationUtils;

public class SerializationUtilsTest {
    public static void main(String[] args) {
        Student student = new Student();// 建立student對像
        student.setId(10);// 初始化id屬性
        student.setName("明日科技");// 初始化name屬性
        System.out.println("將student對像序列化成byte陣列");
        byte[] studentByte = SerializationUtils.serialize(student);// 將對像轉換成byte陣列
        System.out.println("輸出序列化陣列：");
        System.out.println(Arrays.toString(studentByte));// 輸出byte陣列
        System.out.println("將student對像序列化到本機檔案");
        FileOutputStream out = null;// 建立檔案輸出流對像
        try {
            out = new FileOutputStream(new File("d:\\student.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SerializationUtils.serialize(student, out);// 將對像寫入到student.txt檔案
        System.out.println("檔案產生成功！");
        System.out.println("從本機檔案反序列化student對像");
        FileInputStream in = null;// 建立檔案輸入流對像
        try {
            in = new FileInputStream(new File("d:\\student.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Student newStudent = (Student) SerializationUtils.deserialize(in);// 讀入對像
        System.out.println("檢視student對象的屬性");
        System.out.println(newStudent);
    }
}
