import java.io.*;
import java.util.*;

public class CopyUtil {
    // 獲得磁碟所有檔案方法
public List getList(String path) {
        LinkedList<File> list = new LinkedList<File>();     //定義儲存目錄的集合對像
        ArrayList<String> listPath = new ArrayList<String>();   //定義檔案地址的集合對像
        File dir = new File(path);      //根據檔案地址建立File對像
        File file[] = dir.listFiles();  //獲得檔案夾下的檔案陣列
        for (int i = 0; i < file.length; i++) { //循環檢查陣列
            if (file[i].isDirectory())  //判斷檔案是否是一個目錄
                list.add(file[i]);      //向集合中增加元素
            else {
                listPath.add(file[i].getAbsolutePath());    //將檔案路徑增加到集合中
            }
        }
        File tmp;
        while (!list.isEmpty()) {   //如果儲存儲存檔案路徑的集合不為空
            tmp = list.removeFirst(); // 移除並傳回集合中第一項
            if (tmp.isDirectory()) {    
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) { //循環檢查陣列
                    if (file[i].isDirectory())  //如果檔案表示一個目錄
                        list.add(file[i]);      
                    else {          //如果為一個檔案對像
                        listPath.add(file[i].getAbsolutePath());
                    }
                }
            }
        }
        return listPath;
    }
    
    /**
     *  該方法以複製檔案的路徑、複製後檔案的路徑作為參數
     * @param args
     */
public void copyFile(String oldPath, String newPath) {       
    try {
        int bytesum = 0;
        int byteread = 0;
        File oldfile = new File(oldPath);
        if (oldfile.exists()) { // 檔案存在時
            InputStream inStream = new FileInputStream(oldPath); // 讀入原檔案
            FileOutputStream fs = new FileOutputStream(newPath);
            byte[] buffer = new byte[1444];
            while ((byteread = inStream.read(buffer)) != -1) {  //循環讀取檔案
                bytesum += byteread; // 獲得檔案大小
                fs.write(buffer, 0, byteread);  //將檔案中寫資料
            }
            inStream.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}    
}
