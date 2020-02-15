import java.io.FileOutputStream;
import java.util.Properties;

public class SaveProperties {
    
    /**
     * @param args
     */
    
public void saveProperties(String key, String value) {
    Properties properties = new Properties(); // 定義Properties對像
    properties.setProperty(key, value); // 設定屬性檔案值
    try {
        FileOutputStream out = new FileOutputStream(
                "C://message.properties");// 建立輸出流對像
        properties.store(out, "test"); // 將資訊透過流寫入到屬性檔案
        out.close(); // 關閉流
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
   
}
