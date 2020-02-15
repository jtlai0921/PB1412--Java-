import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.*;

/**
 * @author zhuzhen_hua@yahoo.com.cn
 */

public class WordBean {
    
    private Dispatch doc; // word文件
    private ActiveXComponent word;// word執行程式對像
    private Dispatch documents; // 所有word文件集合
    private Dispatch selection; // 選定的範圍或插入點
    
    public WordBean() {
        if (word == null) {
            word = new ActiveXComponent("Word.Application"); // 啟動word
            word.setProperty("Visible", new Variant(true)); // 設定word為可視狀態
        }
        if (documents == null)
            documents = word.getProperty("Documents").toDispatch(); // 讀取屬性值
    }
    
    /**
     * 建立一個新的word文件
     */
    
    public void createNewDocument() {
        doc = Dispatch.call(documents, "Add").toDispatch(); // 方法com/dll對像
        selection = Dispatch.get(word, "Selection").toDispatch(); // 讀取com對象的屬性值
    }
    
    /**
     * 檔案儲存或另存為
     * 
     * @param savePath
     *            儲存或另存為路徑
     */
    
    public void save(String savePath) {
        Dispatch.call(
                (Dispatch) Dispatch.call(word, "WordBasic").getDispatch(),
                "FileSaveAs", savePath);
    }
    
    /**
     * 在目前插入點插入字串
     * 
     * @param newText
     *            要插入的新字串
     */
    
    public void insertText(String newText) {
        Dispatch.put(selection, "Text", newText); // 設定屬性值
    }
    
    public static void main(String args[]) {
        
    }
    
}