import java.io.*;

public class EncryptFile {
    // 檔案簡單加密方法
public void encry(String frontFile, String backFile) {
    try {
        File f = new File(frontFile);   //根據加密檔案地址建立檔案對像
        FileInputStream fileInputStream = new FileInputStream(f);   //建立FileInputStream對像
        byte[] buffer = new byte[fileInputStream.available()];  //從流中讀取字節
        fileInputStream.read(buffer);       //從流中讀取字節
        fileInputStream.close();            //把輸出流關閉
        for (int i = 0; i < buffer.length; i++) {   //循環檢查從流中讀取的陣列
            int ibt = buffer[i];
            ibt += 100;                     //將陣列中資料做相加運算
            ibt %= 256;
            buffer[i] = (byte) ibt;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(
                backFile));                 //根據加密後檔案儲存地址建立輸出流對像
        fileOutputStream.write(buffer, 0, buffer.length);   //向輸出流中寫資料
        fileOutputStream.close();   //將流關閉
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // 檔案簡單解密方法

public void unEncry(String frontFile, String backFile) {
    try {
        File f = new File(frontFile);               //建立要解壓的檔案對像
        FileInputStream fileInputStream = new FileInputStream(f);   //建立檔案輸入流對像
        byte[] buffer = new byte[fileInputStream.available()];  //從流中獲得讀取的字節數
        fileInputStream.read(buffer);          //從流中讀取字節
        fileInputStream.close();                //關閉流
        for (int i = 0; i < buffer.length; i++) {   
            int ibt = buffer[i];    
            ibt -= 100;             //對從流中讀取的資料進行運算處理
            ibt += 256;
            ibt %= 256;
            buffer[i] = (byte) ibt;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(backFile));   //根據要寫入的檔案地址建立輸出流
        fileOutputStream.write(buffer, 0, buffer.length);       //向輸出流中寫資料
        fileOutputStream.close();       //將流關閉
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
