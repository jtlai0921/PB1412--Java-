package com.cdd.openWord;

import java.io.*;
import java.text.*;
import java.util.*;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class FileHeald {
    
    private Dispatch doc;
    private ActiveXComponent word; // word執行程式對像
    private Dispatch documents; // 所有word文件集合
    
    public FileHeald() {
        if (word == null) {
            word = new ActiveXComponent("Word.Application"); // 啟動word
            word.setProperty("Visible", new Variant(true)); // 設定word為可視狀態
        }
        if (documents == null)
            documents = word.getProperty("Documents").toDispatch();// 讀取屬性值
    }
    
    // 讀取整個檔案夾內容
    public List getFileList(String strPath) {
        LinkedList filelist = new LinkedList();
        File dir = new File(strPath);
        File[] file = dir.listFiles();
        if ((file != null) && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].isDirectory()) {
                    getFileList(file[i].getAbsolutePath());
                } else {
                    filelist.add(file[i]);
                }
            }
        }
        return filelist;
    }
    
    // 獲得磁碟所有檔案方法
    public List getList(String path) {
        LinkedList<File> list = new LinkedList<File>();
        ArrayList<String> listPath = new ArrayList<String>();
        File dir = new File(path);
        File file[] = dir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory())
                list.add(file[i]);
            else {
                listPath.add(file[i].getAbsolutePath());
            }
        }
        File tmp;
        while (!list.isEmpty()) {
            tmp = list.removeFirst(); // 移除並傳回集合中第一項
            if (tmp.isDirectory()) {
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory())
                        list.add(file[i]);
                    else {
                        listPath.add(file[i].getAbsolutePath());
                    }
                    
                }
            } else {
                
            }
        }
        return listPath;
    }    

    /**
     * 開啟一個已存在的文件
     * 
     * @param docPath
     */
    
public void openDocument(String docPath) {  
    doc = Dispatch.call(documents, "Open", docPath).toDispatch(); // 呼叫開啟word文件指令        
}

}
