import java.io.*;
import com.jacob.*;
import com.jacob.activeX.*;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordToHtml {
    /**
     * WORD��HTML
     * 
     * @param docfilePath
     *            WORD�ɮץ����|
     * @param htmlfilePath
     *            �ഫ��HTML�s����|
     */
    
    public void wordToHtml(String docfilePath, String htmlfilePath) {
        ActiveXComponent app = new ActiveXComponent("Word.Application"); // �Ұ�word
        try {
            app.setProperty("Visible", new Variant(false)); // �]�wword�����i��
            Dispatch dispatch = app.getProperty("Documents").toDispatch(); // Ū������ݩʭ�
            Dispatch doc = Dispatch.invoke(
                    dispatch,
                    "Open",
                    Dispatch.Method,
                    new Object[] { docfilePath, new Variant(false),
                            new Variant(true) }, new int[1]).toDispatch(); // �\��I�s
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
                    htmlfilePath, new Variant(8) }, new int[1]); // �Hhtml�榡�x�s���{���ɮ�
            Variant f = new Variant(false);
            Dispatch.call(doc, "Close", f); // �N��������A�ñN��]�w�����i��
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    public static void main(String[] args) {
        WordToHtml wth = new WordToHtml(); // �إߥ����O�ﹳ
        wth.wordToHtml("c:\\�Vword��ø�s���.doc", "c:\\�Vword��ø�s���.html"); // �I�s�榡�ഫ��k
      
    }
    
}
