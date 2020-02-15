import java.io.*;
import java.util.*;

public class CopyUtil {
    // ��o�ϺЩҦ��ɮפ�k
public List getList(String path) {
        LinkedList<File> list = new LinkedList<File>();     //�w�q�x�s�ؿ������X�ﹳ
        ArrayList<String> listPath = new ArrayList<String>();   //�w�q�ɮצa�}�����X�ﹳ
        File dir = new File(path);      //�ھ��ɮצa�}�إ�File�ﹳ
        File file[] = dir.listFiles();  //��o�ɮק��U���ɮװ}�C
        for (int i = 0; i < file.length; i++) { //�`���ˬd�}�C
            if (file[i].isDirectory())  //�P�_�ɮ׬O�_�O�@�ӥؿ�
                list.add(file[i]);      //�V���X���W�[����
            else {
                listPath.add(file[i].getAbsolutePath());    //�N�ɮ׸��|�W�[�춰�X��
            }
        }
        File tmp;
        while (!list.isEmpty()) {   //�p�G�x�s�x�s�ɮ׸��|�����X������
            tmp = list.removeFirst(); // �����öǦ^���X���Ĥ@��
            if (tmp.isDirectory()) {    
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) { //�`���ˬd�}�C
                    if (file[i].isDirectory())  //�p�G�ɮת�ܤ@�ӥؿ�
                        list.add(file[i]);      
                    else {          //�p�G���@���ɮ׹ﹳ
                        listPath.add(file[i].getAbsolutePath());
                    }
                }
            }
        }
        return listPath;
    }
    
    /**
     *  �Ӥ�k�H�ƻs�ɮת����|�B�ƻs���ɮת����|�@���Ѽ�
     * @param args
     */
public void copyFile(String oldPath, String newPath) {       
    try {
        int bytesum = 0;
        int byteread = 0;
        File oldfile = new File(oldPath);
        if (oldfile.exists()) { // �ɮצs�b��
            InputStream inStream = new FileInputStream(oldPath); // Ū�J���ɮ�
            FileOutputStream fs = new FileOutputStream(newPath);
            byte[] buffer = new byte[1444];
            while ((byteread = inStream.read(buffer)) != -1) {  //�`��Ū���ɮ�
                bytesum += byteread; // ��o�ɮפj�p
                fs.write(buffer, 0, byteread);  //�N�ɮפ��g���
            }
            inStream.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}    
}
