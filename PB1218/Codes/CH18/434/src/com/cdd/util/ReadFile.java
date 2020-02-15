package com.cdd.util;
import java.io.*;
public class ReadFile {
    
public static void main(String args[]){
    int bytes[]={1,2,3,4,5};    //�w�q�g�J�ɮת��}�C
    try {
        //�إ�RandomAccessFile���O���ﹳ
        File file = new File("Example9.txt");
        if(!file.exists()){             //�P�_���ɮ׬O�_�s�b
            file.createNewFile();       //�s�W�ɮ�
        }
        RandomAccessFile raf=new RandomAccessFile(file,"rw");   //�w�qRandomAccessFile�ﹳ
        for(int i=0;i<bytes.length;i++){        //�`���ˬd�}�C
            raf.writeInt(bytes[i]);             //�N�}�C�g�J�ɮ�
        }
        System.out.println("�f�ǿ�X��T");
        for(int i=bytes.length-1;i>=0;i--){     //�ϦV�ˬd�}�C
            raf.seek(i*4);                      //int����ƥe4�Ӧr�`
            System.out.println(+raf.readInt());
        }
        raf.close();                    //�����y
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
