package com.cdd.readJar;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
public class ReadJar {

static List process(String fileName){
    List list = new ArrayList();        //建立List集合對像
    try {            
        JarFile jarFile = new JarFile(fileName);    //建立JarFile對像
        Enumeration en = jarFile.entries();            
        while(en.hasMoreElements()){            //測試列舉中是否包含更多的元素
            FileName file = new FileName();     //定義JavaBean對像
            JarEntry entry = (JarEntry)en.nextElement();    //獲得集合中的元素
            String name = entry.getName();      //獲得檔案名稱
            long size = entry.getSize();         //獲得檔案大小     
            file.setName(name);                 
            file.setSize(size+"");
            list.add(file);                     //將對像增加到集合中
        }
    } catch (Exception e) {           
        e.printStackTrace();
    }        
    return list;
}
}
