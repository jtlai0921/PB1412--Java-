import java.io.FileInputStream;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.ProgressMonitorInputStream;
public class ProgressMonitorTest {
    
    public void useProgressMonitor(JFrame frame, String copyPath, String newPath) {
        try {
            File file = new File(copyPath); // 根據要複製的檔案建立File對像
            File newFile = new File(newPath); // 根據複製後檔案的儲存地址建立File對像
            FileOutputStream fop = new FileOutputStream(newFile); // 建立FileOutputStream對像
            InputStream in = new FileInputStream(file);
            // 讀取檔案，如果總耗時超過2秒，將會自動出現一個進度監視視窗。
            ProgressMonitorInputStream pm = new ProgressMonitorInputStream(
                    frame, "檔案讀取中，請稍後...", in);
            int c = 0;
            byte[] bytes = new byte[1024]; // 定義byte陣列
            while ((c = pm.read(bytes)) != -1) { // 循環讀取檔案
                fop.write(bytes, 0, c); // 透過流寫資料
            }
            fop.close(); // 關閉輸出流
            pm.close(); // 關閉輸入流
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
