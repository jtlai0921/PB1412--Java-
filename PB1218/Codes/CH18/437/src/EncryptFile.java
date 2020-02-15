import java.io.*;

public class EncryptFile {
    // �ɮ�²��[�K��k
public void encry(String frontFile, String backFile) {
    try {
        File f = new File(frontFile);   //�ھڥ[�K�ɮצa�}�إ��ɮ׹ﹳ
        FileInputStream fileInputStream = new FileInputStream(f);   //�إ�FileInputStream�ﹳ
        byte[] buffer = new byte[fileInputStream.available()];  //�q�y��Ū���r�`
        fileInputStream.read(buffer);       //�q�y��Ū���r�`
        fileInputStream.close();            //���X�y����
        for (int i = 0; i < buffer.length; i++) {   //�`���ˬd�q�y��Ū�����}�C
            int ibt = buffer[i];
            ibt += 100;                     //�N�}�C����ư��ۥ[�B��
            ibt %= 256;
            buffer[i] = (byte) ibt;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(
                backFile));                 //�ھڥ[�K���ɮ��x�s�a�}�إ߿�X�y�ﹳ
        fileOutputStream.write(buffer, 0, buffer.length);   //�V��X�y���g���
        fileOutputStream.close();   //�N�y����
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // �ɮ�²��ѱK��k

public void unEncry(String frontFile, String backFile) {
    try {
        File f = new File(frontFile);               //�إ߭n�������ɮ׹ﹳ
        FileInputStream fileInputStream = new FileInputStream(f);   //�إ��ɮ׿�J�y�ﹳ
        byte[] buffer = new byte[fileInputStream.available()];  //�q�y����oŪ�����r�`��
        fileInputStream.read(buffer);          //�q�y��Ū���r�`
        fileInputStream.close();                //�����y
        for (int i = 0; i < buffer.length; i++) {   
            int ibt = buffer[i];    
            ibt -= 100;             //��q�y��Ū������ƶi��B��B�z
            ibt += 256;
            ibt %= 256;
            buffer[i] = (byte) ibt;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(backFile));   //�ھڭn�g�J���ɮצa�}�إ߿�X�y
        fileOutputStream.write(buffer, 0, buffer.length);       //�V��X�y���g���
        fileOutputStream.close();       //�N�y����
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
