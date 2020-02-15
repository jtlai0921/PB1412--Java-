import com.jacob.com.*;
import com.jacob.activeX.ActiveXComponent;

public class Inerttable {
    // word���
    private Dispatch doc;
    
    // word����{���ﹳ
    private ActiveXComponent word;
    
    // �Ҧ�word��󶰦X
    private Dispatch documents;
    
    // ��w���d��δ��J�I
    private Dispatch selection;
    
    private boolean saveOnExit = true;
    
    public Inerttable() {
        ComThread.InitSTA();// ��l��com���u�{�A�D�`���n�I�I�ϥε�����n�I�s realease��k
        if (word == null) {
            word = new ActiveXComponent("Word.Application");
            word.setProperty("Visible", new Variant(false));
        }
        if (documents == null)
            documents = word.getProperty("Documents").toDispatch();
    }
    
    /**
     * �إߤ@�ӷs��word���
     */
    public void createNewDocument() {
        doc = Dispatch.call(documents, "Add").toDispatch();
        selection = Dispatch.get(word, "Selection").toDispatch();
    }
    
    /**
     * �b���w���椸��̶�g���
     * 
     * @param tableIndex
     * @param cellRowIdx
     * @param cellColIdx
     * @param txt
     */
    
    public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,
            String txt) {
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch(); // ��o����ݩ�
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
                .toDispatch(); // �n��R�����
        Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
                new Variant(cellColIdx)).toDispatch();
        Dispatch.call(cell, "Select");
        Dispatch.put(selection, "Text", txt); // put()��k�]�w��椺�e
    }
    
    /**
     * �إߪ��
     * 
     * @param pos
     *            ��m
     * @param cols
     *            �C��
     * @param rows
     *            ���
     */
    
    public void createTable(int numCols, int numRows) {
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch(); // ��o����ݩ�
        Dispatch range = Dispatch.get(selection, "Range").toDispatch(); // ��o����C�ݩ�
        Dispatch newTable = Dispatch.call(tables, "Add", range,
                new Variant(numRows), new Variant(numCols)).toDispatch(); // �V��椤�W�[���e
        Dispatch.call(selection, "MoveRight");
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
     * ������������
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
        
        Inerttable msWordManager = new Inerttable(); // �إߥ����O�ﹳ
        try {
            msWordManager.createNewDocument(); // �s�W���
            msWordManager.createTable(5, 5); // �إ�5��5�C�����
            msWordManager.putTxtToCell(1, 1, 1, "�s��"); // �V��1���1�C���W�[���e
            msWordManager.putTxtToCell(1, 2, 1, "1"); // �V��2���1�C���W�[���e
            msWordManager.putTxtToCell(1, 1, 2, "�m�W"); 
            msWordManager.putTxtToCell(1, 2, 2, "���|");
            msWordManager.putTxtToCell(1, 1, 3, "�~��");
            msWordManager.putTxtToCell(1, 2, 3, "30");
            msWordManager.putTxtToCell(1, 1, 4, "�ʧO");
            msWordManager.putTxtToCell(1, 2, 4, "�k");
            msWordManager.putTxtToCell(1, 1, 5, "�Ǿ�");
            msWordManager.putTxtToCell(1, 2, 5, "����");
            msWordManager.save("c:\\�Vword��ø�s���.doc"); // �I�s�x�s����k
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            msWordManager.close();
        }
        
    }
    
}
