
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @author zhuzhen_hua@yahoo.com.cn
 */

public class WordBean {
// word文件
private Dispatch doc;    
// word執行程式對像
private ActiveXComponent word;    
// 所有word文件集合
private Dispatch documents;    
// 選定的範圍或插入點
private Dispatch selection;
    
public WordBean() {
    if (word == null) {
        word = new ActiveXComponent("Word.Application");
        word.setProperty("Visible", new Variant(false));
    }
    if (documents == null)
        documents = word.getProperty("Documents").toDispatch();
}    
  
    
    /**
     * 在目前插入點插入圖片
     * 
     * @param imagePath
     *            圖片路徑
     */
    
public void insertImage(String imagePath, String docPath, int pos) {
    doc = Dispatch.call(documents, "Open", docPath).toDispatch();   // 開啟對應的word文件
    selection = Dispatch.get(word, "Selection").toDispatch();       
    for (int i = 0; i < pos; i++)
        Dispatch.call(selection, "MoveRight");      //將插入點向右移動對應的位置
    Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),
            "AddPicture", imagePath);               //向文件中插入圖片
}
    

    public static void main(String args[]) {
        try {
            WordBean wordBean = new WordBean();           
            wordBean.insertImage("c:\\6.jpg", "C://a.doc", 14);           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}