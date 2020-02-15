package com.mingrisoft.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        File srcDir = new File("D:\\������");
        File destDir = new File("C:\\������");
        List<String> list = new ArrayList<String>();
        System.out.println("�ƻs���e�ɮק������ɮסG");
        getFilePath(list, destDir);
        for (String string : list) {
            System.out.println(string);// ��X�ƻs�e�ɮק����Ҧ��ɮ�
        }
        System.out.println();
        System.out.println("�ƻs�����ɮק������ɮסG");
        FileUtils.copyDirectory(srcDir, destDir);
        getFilePath(list, destDir);
        for (String string : list) {
            System.out.println(string); // ��X�ƻs���ɮק����Ҧ��ɮ�
        }
    }
    
    // ��orootFile�ɮק����Ҧ��ɮת�������|�ñN���x�s�blist��
    private static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", File.separator));
            }
        }
        return list;
    }
}
