import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXMLDataBase {
private Document document;    //定義Document對像
public String readXml(String passWord) {
    File xml_file = new File("users.xml");  //根據XML檔案地址
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  //定義從XMl文件獲得產生DOM對象的解析器
    try {
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        document = builder.parse(xml_file); //根據XML獲得DOM文件實例
    } catch (Exception e) {
        e.printStackTrace();
    }      
    String subNodeTag = document.getElementsByTagName(passWord).item(0)
            .getFirstChild().getNodeValue();    //獲得指定節點儲存的值
   return subNodeTag;           //傳回讀取的資訊
}
    
}
