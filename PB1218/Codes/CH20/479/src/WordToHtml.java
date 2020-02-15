import java.io.*;
import com.jacob.*;
import com.jacob.activeX.*;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordToHtml {
    /**
     * WORD轉HTML
     * 
     * @param docfilePath
     *            WORD檔案全路徑
     * @param htmlfilePath
     *            轉換後HTML存放路徑
     */
    
    public void wordToHtml(String docfilePath, String htmlfilePath) {
        ActiveXComponent app = new ActiveXComponent("Word.Application"); // 啟動word
        try {
            app.setProperty("Visible", new Variant(false)); // 設定word為不可視
            Dispatch dispatch = app.getProperty("Documents").toDispatch(); // 讀取文件屬性值
            Dispatch doc = Dispatch.invoke(
                    dispatch,
                    "Open",
                    Dispatch.Method,
                    new Object[] { docfilePath, new Variant(false),
                            new Variant(true) }, new int[1]).toDispatch(); // 功能呼叫
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
                    htmlfilePath, new Variant(8) }, new int[1]); // 以html格式儲存到臨時檔案
            Variant f = new Variant(false);
            Dispatch.call(doc, "Close", f); // 將文件關閉，並將其設定為不可視
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    public static void main(String[] args) {
        WordToHtml wth = new WordToHtml(); // 建立本類別對像
        wth.wordToHtml("c:\\向word中繪製表格.doc", "c:\\向word中繪製表格.html"); // 呼叫格式轉換方法
      
    }
    
}
