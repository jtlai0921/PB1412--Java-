import java.io.FileOutputStream;
import java.util.Properties;

public class SaveProperties {
    
    /**
     * @param args
     */
    
public void saveProperties(String key, String value) {
    Properties properties = new Properties(); // �w�qProperties�ﹳ
    properties.setProperty(key, value); // �]�w�ݩ��ɮ׭�
    try {
        FileOutputStream out = new FileOutputStream(
                "C://message.properties");// �إ߿�X�y�ﹳ
        properties.store(out, "test"); // �N��T�z�L�y�g�J���ݩ��ɮ�
        out.close(); // �����y
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
   
}
