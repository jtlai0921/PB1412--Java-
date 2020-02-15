package com.mingrisoft.util;

import java.io.File;
import java.util.List;

public class FileUtils {
    // 刪除檔案夾下所有檔案
    public static void deleteFiles(File rootFile) {
        if (rootFile.listFiles().length == 0) {// 如果使用者指定的是空檔案夾就退出方法
            return;
        } else {
            File[] files = rootFile.listFiles();// 將非空檔案夾轉換成File陣列
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();// 刪除指定檔案夾下的所有檔案
                } else {
                    if (file.listFiles().length == 0) {
                        file.delete();// 刪除指定檔案夾下的所有空檔案夾
                    } else {
                        deleteDirectories(file);// 刪除指定檔案夾下的所有非空檔案夾
                    }
                }
            }
        }
    }
    
    // 刪除檔案夾及檔案夾下所有檔案
    public static void deleteDirectories(File rootFile) {
        if (rootFile.isFile()) {
            rootFile.delete();// 如果指定的File對象是檔案就直接刪除
        } else {// 如果是一個檔案夾就將其轉換成File陣列
            File[] files = rootFile.listFiles();
            for (File file : files) {
                deleteDirectories(file);// 如果不是空檔案夾則就迭代deleteDictionary()方法
            }
            rootFile.delete();// 如果是空檔案夾就直接刪除
        }
        
    }
    
    // 獲得指定目錄下的所有檔案的路徑
    public static List<String> getFilePath(List<String> list, File rootFile) {
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