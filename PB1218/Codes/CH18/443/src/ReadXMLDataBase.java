import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXMLDataBase {
private Document document;    //�w�qDocument�ﹳ
public String readXml(String passWord) {
    File xml_file = new File("users.xml");  //�ھ�XML�ɮצa�}
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  //�w�q�qXMl�����o����DOM��H���ѪR��
    try {
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        document = builder.parse(xml_file); //�ھ�XML��oDOM�����
    } catch (Exception e) {
        e.printStackTrace();
    }      
    String subNodeTag = document.getElementsByTagName(passWord).item(0)
            .getFirstChild().getNodeValue();    //��o���w�`�I�x�s����
   return subNodeTag;           //�Ǧ^Ū������T
}
    
}
