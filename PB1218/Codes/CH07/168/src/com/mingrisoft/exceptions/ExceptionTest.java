package com.mingrisoft.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        FileInputStream fis = null;// �إߤ@���ɮ׿�J�y�ﹳ
        try {
            File file = new File("d:\\kira.txt");// �إߤ@���ɮ׹ﹳ
            fis = new FileInputStream(file);// ��l���ɮ׿�J�y�ﹳ
        } catch (FileNotFoundException e) {// �����ҥ~
            e.printStackTrace();
        } finally {
            try {
                fis.close();// ����귽
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
