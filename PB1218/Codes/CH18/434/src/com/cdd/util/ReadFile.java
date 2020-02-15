package com.cdd.util;
import java.io.*;
public class ReadFile {
    
public static void main(String args[]){
    int bytes[]={1,2,3,4,5};    //定義寫入檔案的陣列
    try {
        //建立RandomAccessFile類別的對像
        File file = new File("Example9.txt");
        if(!file.exists()){             //判斷該檔案是否存在
            file.createNewFile();       //新增檔案
        }
        RandomAccessFile raf=new RandomAccessFile(file,"rw");   //定義RandomAccessFile對像
        for(int i=0;i<bytes.length;i++){        //循環檢查陣列
            raf.writeInt(bytes[i]);             //將陣列寫入檔案
        }
        System.out.println("逆序輸出資訊");
        for(int i=bytes.length-1;i>=0;i--){     //反向檢查陣列
            raf.seek(i*4);                      //int型資料占4個字節
            System.out.println(+raf.readInt());
        }
        raf.close();                    //關閉流
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
