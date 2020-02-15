import java.io.*;
import java.util.*;

public class GetProperties {
    
    public String getProperties(String keyName) {
        InputStream ins = getClass().getResourceAsStream(
                "ApplicationResources.properties"); // �ھ��ݩ��ɮ׫إ�InputStream�ﹳ
        Properties props = new Properties(); // �إ�Properties�ﹳ
        String value = "";
        try {
            props.load(ins); // �q��J�y��Ū���ݩ��ɮפ���T
            value = props.getProperty(keyName); // ��o���w�Ѽƪ��ݩʭ�
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        return value;
    }
    
}
