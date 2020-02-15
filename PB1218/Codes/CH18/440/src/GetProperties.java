import java.io.*;
import java.util.*;

public class GetProperties {
    
    public String getProperties(String keyName) {
        InputStream ins = getClass().getResourceAsStream(
                "ApplicationResources.properties"); // 根據屬性檔案建立InputStream對像
        Properties props = new Properties(); // 建立Properties對像
        String value = "";
        try {
            props.load(ins); // 從輸入流中讀取屬性檔案中資訊
            value = props.getProperty(keyName); // 獲得指定參數的屬性值
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        return value;
    }
    
}
