import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ExcelToHtml {
    
    /**
     * EXCEL轉HTML
     * 
     * @param xlsfilePath
     *            EXCEL檔案全路徑
     * @param htmlfilePath
     *            轉換後HTML存放路徑
     */
    
public void excelToHtml(String xlsfilePath, String htmlfilePath) {
    ActiveXComponent app = new ActiveXComponent("Excel.Application"); // 啟動excel
try {
    app.setProperty("Visible", new Variant(false));                //設定Excel對像為不可見
    Dispatch excels = app.getProperty("Workbooks").toDispatch();
    Dispatch excel = Dispatch.invoke(
            excels,
            "Open",
            Dispatch.Method,
            new Object[] { xlsfilePath, new Variant(false),
                    new Variant(true) }, new int[1]).toDispatch(); // 功能呼叫
    Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
            htmlfilePath, new Variant(44) }, new int[1]); // 以html格式儲存到臨時檔案
    Variant f = new Variant(false);
    Dispatch.call(excel, "Close", f); // 關閉excel檔案
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    ExcelToHtml eth = new ExcelToHtml();        //建立本類別對像
    eth.excelToHtml("d:\\test.xls", "d:\\test.html"); //呼叫將Excel轉為Html格式方法
}

}
