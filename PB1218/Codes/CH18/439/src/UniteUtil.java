import java.io.*;
import java.util.*;

public class UniteUtil {
    /**
     * @param file
     *            :�n�i��X�֪��ɮװ}�C�ﹳ
     * @param cunDir
     *            �G�X�֫��ɮת��x�s���|
     * @param hz
     *            �G�X�֫��ɮת��榡
     */
public void heBing(File[] file, File cunDir, String hz) {
    try {
        File heBingFile = new File(cunDir.getAbsoluteFile() + "\\UNTIE" + hz); // ���w���Ϋ��ɮת��ɮצW
        if (!heBingFile.isFile()) {
            heBingFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(heBingFile); // �إ�FileOutputStream�ﹳ
        for (int i = 0; i < file.length; i++) { // �`���ˬd�n�i��X�֪��ɮװ}�C�ﹳ
            FileInputStream fis = new FileInputStream(file[i]);
            int len = (int) file[i].length(); // ��o�ɮת���
            byte[] bRead = new byte[len];
            fis.read(bRead); // Ū���ɮ�
            fos.write(bRead); // �g�J�ɮ�
            fis.close(); // �N�y����
        }
        fos.close();            
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    // ��o�ϺЩҦ��ɮפ�k
    public List getList(String path) {
        LinkedList<File> list = new LinkedList<File>();
        ArrayList<String> listPath = new ArrayList<String>();
        File dir = new File(path);
        File file[] = dir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory())
                list.add(file[i]);
            else {
                listPath.add(file[i].getAbsolutePath());
            }
        }
        File tmp;
        while (!list.isEmpty()) {
            tmp = list.removeFirst(); // �����öǦ^���X���Ĥ@��
            if (tmp.isDirectory()) {
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory())
                        list.add(file[i]);
                    else {
                        listPath.add(file[i].getAbsolutePath());
                    }
                    
                }
            } else {
                
            }
        }
        return listPath;
    }
   
    
}
