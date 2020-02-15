
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @author zhuzhen_hua@yahoo.com.cn
 */

public class WordBean {
// word���
private Dispatch doc;    
// word����{���ﹳ
private ActiveXComponent word;    
// �Ҧ�word��󶰦X
private Dispatch documents;    
// ��w���d��δ��J�I
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
     * �b�ثe���J�I���J�Ϥ�
     * 
     * @param imagePath
     *            �Ϥ����|
     */
    
public void insertImage(String imagePath, String docPath, int pos) {
    doc = Dispatch.call(documents, "Open", docPath).toDispatch();   // �}�ҹ�����word���
    selection = Dispatch.get(word, "Selection").toDispatch();       
    for (int i = 0; i < pos; i++)
        Dispatch.call(selection, "MoveRight");      //�N���J�I�V�k���ʹ�������m
    Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),
            "AddPicture", imagePath);               //�V��󤤴��J�Ϥ�
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