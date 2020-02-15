import java.io.*;
import java.util.*;

public class UniteUtil {
    /**
     * @param file
     *            :要進行合併的檔案陣列對像
     * @param cunDir
     *            ：合併後檔案的儲存路徑
     * @param hz
     *            ：合併後檔案的格式
     */
public void heBing(File[] file, File cunDir, String hz) {
    try {
        File heBingFile = new File(cunDir.getAbsoluteFile() + "\\UNTIE" + hz); // 指定分割後檔案的檔案名
        if (!heBingFile.isFile()) {
            heBingFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(heBingFile); // 建立FileOutputStream對像
        for (int i = 0; i < file.length; i++) { // 循環檢查要進行合併的檔案陣列對像
            FileInputStream fis = new FileInputStream(file[i]);
            int len = (int) file[i].length(); // 獲得檔案長度
            byte[] bRead = new byte[len];
            fis.read(bRead); // 讀取檔案
            fos.write(bRead); // 寫入檔案
            fis.close(); // 將流關閉
        }
        fos.close();            
    } catch (Exception e) {
        e.printStackTrace();
    }
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
   
    
}
