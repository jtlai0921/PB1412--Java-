import java.io.*;
import java.util.*;
public class UniteFile {
    byte b1[];
    FileInputStream fi1;
    FileOutputStream fo;    
public void writeFiles(List<File>  files, String fileName) {      
    try {
        fo = new FileOutputStream(fileName, true);  //�ھ��ɮ��x�s�a�}�إ�FileOutputStream�ﹳ
        for (int i = 0; i < files.size(); i++) {    //�`���ˬd�n�ƻs���ɮ׶��X        
            File file =  files.get(i);  //��o���X���ɮ׹ﹳ
            fi1 = new FileInputStream(file);    //�إ�FileInputStream�ﹳ
            b1 = new byte[fi1.available()];     //�q�y����o�r�`��
            fi1.read(b1);               //Ū�����
            fo.write(b1);               //�V�ɮפ��g���
        }
    } catch (Exception e) {            
        e.printStackTrace();
    }        
} 
}
