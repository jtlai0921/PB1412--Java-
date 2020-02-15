package com.mingrisoft.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;

public class IOUtilsTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream("d:\\������.txt"); // �إ��ɮ׿�X�y�ﹳ
            in = new FileInputStream("d:\\������.txt"); // �إ��ɮ׿�J�y�ﹳ
            System.out.println("�V�ɮפ��g�J5���H���r��");
            for (int i = 0; i < 5; i++) {// �V�ɮפ��g�J5���H���r��
                IOUtils.write(RandomStringUtils.randomAlphanumeric(5) + "\n", out);
            }
            System.out.println("��X�ɮפ����H���r��");
            List<String> list = IOUtils.readLines(in);// �q�ɮפ�Ū���r��
            for (String string : list) {
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out); // ����귽
            IOUtils.closeQuietly(in); // ����귽
        }
    }
}
