import java.io.*;

public class ComminuteUtil {
    // ��{�ɮפ��Τ�k
public void fenGe(File commFile, File untieFile, int filesize) {
    FileInputStream fis = null;
    int size = 1024 * 1024; // �Ψӫ��w�����ɮ׭n�HMB�����
    try {
        if (!untieFile.isDirectory()) { // �p�G�n�x�s�����ɮצa�}���O���|
            untieFile.mkdirs(); // �إ߸Ӹ��|
        }
        size = size * filesize;
        int length = (int) commFile.length(); // ��o�ɮפj�p
        int num = length / size; // ��o�ɮפj�p���HMB���o��
        int yu = length % size; // ��o�ɮפj�p�PMB�۰����l��
        String newfengeFile = commFile.getAbsolutePath(); // ��o�x�s�ɮת��������|��T
        int fileNew = newfengeFile.lastIndexOf(".");
        String strNew = newfengeFile.substring(fileNew, newfengeFile
                .length()); // �I���r��
        fis = new FileInputStream(commFile); // �إ�FileInputStream���O�ﹳ
        File[] fl = new File[num + 1]; // �إ��ɮװ}�C
        int begin = 0;
        for (int i = 0; i < num; i++) { // �`���ˬd�}�C
            fl[i] = new File(untieFile.getAbsolutePath() + "\\" + (i + 1)
                    + strNew + ".tem"); // ���w���Ϋ�p�ɮת��ɮצW
            if (!fl[i].isFile()) {
                fl[i].createNewFile(); // �إ߸��ɮ�
            }
            FileOutputStream fos = new FileOutputStream(fl[i]);
            byte[] bl = new byte[size];
            fis.read(bl); // Ū�����Ϋ᪺�p�ɮ�
            fos.write(bl); // �g�ɮ�
            begin = begin + size * 1024 * 1024;
            fos.close(); // �����y
        }
        if (yu != 0) { // �ɮפj�p�P���w�ɮפ��Τj�p�۰����l�Ƥ���0
            fl[num] = new File(untieFile.getAbsolutePath() + "\\"
                    + (num + 1) + strNew + ".tem"); // ���w�ɮפ��Ϋ�}�C���̫�@���ɮצW
            if (!fl[num].isFile()) {
                fl[num].createNewFile(); // �s�W�ɮ�
            }
            FileOutputStream fyu = new FileOutputStream(fl[num]);
            byte[] byt = new byte[yu];
            fis.read(byt);
            fyu.write(byt);
            fyu.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public static void main(String[] args) {
        
    }
}
