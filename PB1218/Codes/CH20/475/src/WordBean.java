import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.*;

/**
 * @author zhuzhen_hua@yahoo.com.cn
 */

public class WordBean {
    
    private Dispatch doc; // word���
    private ActiveXComponent word;// word����{���ﹳ
    private Dispatch documents; // �Ҧ�word��󶰦X
    private Dispatch selection; // ��w���d��δ��J�I
    
    public WordBean() {
        if (word == null) {
            word = new ActiveXComponent("Word.Application"); // �Ұ�word
            word.setProperty("Visible", new Variant(true)); // �]�wword���i�����A
        }
        if (documents == null)
            documents = word.getProperty("Documents").toDispatch(); // Ū���ݩʭ�
    }
    
    /**
     * �إߤ@�ӷs��word���
     */
    
    public void createNewDocument() {
        doc = Dispatch.call(documents, "Add").toDispatch(); // ��kcom/dll�ﹳ
        selection = Dispatch.get(word, "Selection").toDispatch(); // Ū��com��H���ݩʭ�
    }
    
    /**
     * �ɮ��x�s�Υt�s��
     * 
     * @param savePath
     *            �x�s�Υt�s�����|
     */
    
    public void save(String savePath) {
        Dispatch.call(
                (Dispatch) Dispatch.call(word, "WordBasic").getDispatch(),
                "FileSaveAs", savePath);
    }
    
    /**
     * �b�ثe���J�I���J�r��
     * 
     * @param newText
     *            �n���J���s�r��
     */
    
    public void insertText(String newText) {
        Dispatch.put(selection, "Text", newText); // �]�w�ݩʭ�
    }
    
    public static void main(String args[]) {
        
    }
    
}