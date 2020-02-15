import java.io.*;

public class ComminuteUtil {
    // 實現檔案分割方法
public void fenGe(File commFile, File untieFile, int filesize) {
    FileInputStream fis = null;
    int size = 1024 * 1024; // 用來指定分割檔案要以MB為單位
    try {
        if (!untieFile.isDirectory()) { // 如果要儲存分割檔案地址不是路徑
            untieFile.mkdirs(); // 建立該路徑
        }
        size = size * filesize;
        int length = (int) commFile.length(); // 獲得檔案大小
        int num = length / size; // 獲得檔案大小除以MB的得數
        int yu = length % size; // 獲得檔案大小與MB相除的餘數
        String newfengeFile = commFile.getAbsolutePath(); // 獲得儲存檔案的完成路徑資訊
        int fileNew = newfengeFile.lastIndexOf(".");
        String strNew = newfengeFile.substring(fileNew, newfengeFile
                .length()); // 截取字串
        fis = new FileInputStream(commFile); // 建立FileInputStream類別對像
        File[] fl = new File[num + 1]; // 建立檔案陣列
        int begin = 0;
        for (int i = 0; i < num; i++) { // 循環檢查陣列
            fl[i] = new File(untieFile.getAbsolutePath() + "\\" + (i + 1)
                    + strNew + ".tem"); // 指定分割後小檔案的檔案名
            if (!fl[i].isFile()) {
                fl[i].createNewFile(); // 建立該檔案
            }
            FileOutputStream fos = new FileOutputStream(fl[i]);
            byte[] bl = new byte[size];
            fis.read(bl); // 讀取分割後的小檔案
            fos.write(bl); // 寫檔案
            begin = begin + size * 1024 * 1024;
            fos.close(); // 關閉流
        }
        if (yu != 0) { // 檔案大小與指定檔案分割大小相除的餘數不為0
            fl[num] = new File(untieFile.getAbsolutePath() + "\\"
                    + (num + 1) + strNew + ".tem"); // 指定檔案分割後陣列中最後一個檔案名
            if (!fl[num].isFile()) {
                fl[num].createNewFile(); // 新增檔案
            }
            FileOutputStream fyu = new FileOutputStream(fl[num]);
            byte[] byt = new byte[yu];
            fis.read(byt);
            fyu.write(byt);
            fyu.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public static void main(String[] args) {
        
    }
}
