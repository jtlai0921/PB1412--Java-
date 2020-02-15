package com.mingrisoft.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        File srcDir = new File("D:\\明日科技");
        File destDir = new File("C:\\明日科技");
        List<String> list = new ArrayList<String>();
        System.out.println("複製之前檔案夾中的檔案：");
        getFilePath(list, destDir);
        for (String string : list) {
            System.out.println(string);// 輸出複製前檔案夾中所有檔案
        }
        System.out.println();
        System.out.println("複製之後檔案夾中的檔案：");
        FileUtils.copyDirectory(srcDir, destDir);
        getFilePath(list, destDir);
        for (String string : list) {
            System.out.println(string); // 輸出複製後檔案夾中所有檔案
        }
    }
    
    // 獲得rootFile檔案夾中所有檔案的絕對路徑並將其儲存在list中
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