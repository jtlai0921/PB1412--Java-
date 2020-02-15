import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ExcelToHtml {
    
    /**
     * EXCEL��HTML
     * 
     * @param xlsfilePath
     *            EXCEL�ɮץ����|
     * @param htmlfilePath
     *            �ഫ��HTML�s����|
     */
    
public void excelToHtml(String xlsfilePath, String htmlfilePath) {
    ActiveXComponent app = new ActiveXComponent("Excel.Application"); // �Ұ�excel
try {
    app.setProperty("Visible", new Variant(false));                //�]�wExcel�ﹳ�����i��
    Dispatch excels = app.getProperty("Workbooks").toDispatch();
    Dispatch excel = Dispatch.invoke(
            excels,
            "Open",
            Dispatch.Method,
            new Object[] { xlsfilePath, new Variant(false),
                    new Variant(true) }, new int[1]).toDispatch(); // �\��I�s
    Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
            htmlfilePath, new Variant(44) }, new int[1]); // �Hhtml�榡�x�s���{���ɮ�
    Variant f = new Variant(false);
    Dispatch.call(excel, "Close", f); // ����excel�ɮ�
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    ExcelToHtml eth = new ExcelToHtml();        //�إߥ����O�ﹳ
    eth.excelToHtml("d:\\test.xls", "d:\\test.html"); //�I�s�NExcel�ରHtml�榡��k
}

}
