package com.cdd.readJar;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
public class ReadJar {

static List process(String fileName){
    List list = new ArrayList();        //�إ�List���X�ﹳ
    try {            
        JarFile jarFile = new JarFile(fileName);    //�إ�JarFile�ﹳ
        Enumeration en = jarFile.entries();            
        while(en.hasMoreElements()){            //���զC�|���O�_�]�t��h������
            FileName file = new FileName();     //�w�qJavaBean�ﹳ
            JarEntry entry = (JarEntry)en.nextElement();    //��o���X��������
            String name = entry.getName();      //��o�ɮצW��
            long size = entry.getSize();         //��o�ɮפj�p     
            file.setName(name);                 
            file.setSize(size+"");
            list.add(file);                     //�N�ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {           
        e.printStackTrace();
    }        
    return list;
}
}
