package com.cdd.encrypt;

import java.io.*;
import java.nio.channels.FileLock;

class EncryptInput {
    
    public static void fileLock(String file) {
        FileOutputStream fous = null; // �إ�FileOutputStream�ﹳ
        FileLock lock = null; // �إ�FileLock�ﹳ
        try {
            fous = new FileOutputStream(file); // ��Ҥ�FileOutputStream�ﹳ
            lock = fous.getChannel().tryLock(); // ��o�ɮ���w
            Thread.sleep(60 * 1000); // �u�{��w1����
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String file = "C://count.txt"; // �إ��ɮ׹ﹳ
        fileLock(file); // �I�s�ɮ���w��k
    }
}
