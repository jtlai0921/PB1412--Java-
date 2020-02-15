import java.io.*;
import java.util.*;
public class UniteFile {
    byte b1[];
    FileInputStream fi1;
    FileOutputStream fo;    
public void writeFiles(List<File>  files, String fileName) {      
    try {
        fo = new FileOutputStream(fileName, true);  //根據檔案儲存地址建立FileOutputStream對像
        for (int i = 0; i < files.size(); i++) {    //循環檢查要複製的檔案集合        
            File file =  files.get(i);  //獲得集合中檔案對像
            fi1 = new FileInputStream(file);    //建立FileInputStream對像
            b1 = new byte[fi1.available()];     //從流中獲得字節數
            fi1.read(b1);               //讀取資料
            fo.write(b1);               //向檔案中寫資料
        }
    } catch (Exception e) {            
        e.printStackTrace();
    }        
} 
}
