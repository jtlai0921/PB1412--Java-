import com.jacob.com.*;
import com.jacob.activeX.ActiveXComponent;

public class Inerttable {
    // word文件
    private Dispatch doc;
    
    // word執行程式對像
    private ActiveXComponent word;
    
    // 所有word文件集合
    private Dispatch documents;
    
    // 選定的範圍或插入點
    private Dispatch selection;
    
    private boolean saveOnExit = true;
    
    public Inerttable() {
        ComThread.InitSTA();// 初始化com的線程，非常重要！！使用結束後要呼叫 realease方法
        if (word == null) {
            word = new ActiveXComponent("Word.Application");
            word.setProperty("Visible", new Variant(false));
        }
        if (documents == null)
            documents = word.getProperty("Documents").toDispatch();
    }
    
    /**
     * 建立一個新的word文件
     */
    public void createNewDocument() {
        doc = Dispatch.call(documents, "Add").toDispatch();
        selection = Dispatch.get(word, "Selection").toDispatch();
    }
    
    /**
     * 在指定的單元格裡填寫資料
     * 
     * @param tableIndex
     * @param cellRowIdx
     * @param cellColIdx
     * @param txt
     */
    
    public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,
            String txt) {
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch(); // 獲得表格屬性
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
                .toDispatch(); // 要填充的表格
        Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
                new Variant(cellColIdx)).toDispatch();
        Dispatch.call(cell, "Select");
        Dispatch.put(selection, "Text", txt); // put()方法設定表格內容
    }
    
    /**
     * 建立表格
     * 
     * @param pos
     *            位置
     * @param cols
     *            列數
     * @param rows
     *            行數
     */
    
    public void createTable(int numCols, int numRows) {
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch(); // 獲得表格屬性
        Dispatch range = Dispatch.get(selection, "Range").toDispatch(); // 獲得表格行列屬性
        Dispatch newTable = Dispatch.call(tables, "Add", range,
                new Variant(numRows), new Variant(numCols)).toDispatch(); // 向表格中增加內容
        Dispatch.call(selection, "MoveRight");
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
     * 關閉全部應用
     */
    public void close() {
        
        if (word != null) {
            Dispatch.call(word, "Quit");
            word = null;
        }
        selection = null;
        documents = null;
    }
    
    public static void main(String args[]) {
        
        Inerttable msWordManager = new Inerttable(); // 建立本類別對像
        try {
            msWordManager.createNewDocument(); // 新增文件
            msWordManager.createTable(5, 5); // 建立5行5列的表格
            msWordManager.putTxtToCell(1, 1, 1, "編號"); // 向第1行第1列中增加內容
            msWordManager.putTxtToCell(1, 2, 1, "1"); // 向第2行第1列中增加內容
            msWordManager.putTxtToCell(1, 1, 2, "姓名"); 
            msWordManager.putTxtToCell(1, 2, 2, "李四");
            msWordManager.putTxtToCell(1, 1, 3, "年齡");
            msWordManager.putTxtToCell(1, 2, 3, "30");
            msWordManager.putTxtToCell(1, 1, 4, "性別");
            msWordManager.putTxtToCell(1, 2, 4, "男");
            msWordManager.putTxtToCell(1, 1, 5, "學歷");
            msWordManager.putTxtToCell(1, 2, 5, "本科");
            msWordManager.save("c:\\向word中繪製表格.doc"); // 呼叫儲存文件方法
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            msWordManager.close();
        }
        
    }
    
}
