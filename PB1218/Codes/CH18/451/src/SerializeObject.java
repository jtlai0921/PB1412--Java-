import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializeObject {
    
    static class Bowel implements Serializable {
        private int number1, number2; // �w�q���q������ܼ�
        private transient int number3; // �w�q���|�Q�ǦC�ƩM�ϧǦC�ƪ���H
        private static int number4;
        
        public Bowel(int number1, int number2, int c, int number3) { // �غc��k
            this.number1 = number1;
            this.number2 = number2;
            this.number3 = number3;
            this.number4 = number4;
        }
    }
    
    public static void serialize(String fileName) {
        try {
            File file = new File(fileName); // �ھ��ɮצa�}�إ��ɮ׹ﹳ
            if (!file.exists()) { // �p�G�ӹﹳ���s�b
                file.createNewFile(); // �إ߸��ɮ׹ﹳ
            }
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName)); // �إ߹ﹳ��X�y�ﹳ
            out.writeObject("���ѬO:"); // �V�ɮפ��g�J���
            out.writeObject(new Date());
            Bowel my1 = new Bowel(5, 6, 7, 3);// �w�q�������O�ﹳ
            out.writeObject(my1); // �N�ﹳ�g�J���ɮפ�
            out.close(); // �N�y����
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Object[] deserialize(String fileName) {
        try {
            File file = new File(fileName); // �ھ��ɮצa�}�إ��ɮ׹ﹳ
            if (!file.exists()) { // �p�G���ɮפ��s�b
                file.createNewFile(); // �s�W�ɮ�
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    fileName)); // �إ߹ﹳ��J�y
            String today = (String) (in.readObject()); // �q�y��Ū����T
            Date date = (Date) (in.readObject());
            System.out.println(date.toString());
            Object[] object = { today, date };
            Bowel my1 = (Bowel) (in.readObject());
            in.close(); // �����y
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
