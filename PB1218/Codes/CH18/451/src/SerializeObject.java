import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializeObject {
    
    static class Bowel implements Serializable {
        private int number1, number2; // 定義普通的實例變數
        private transient int number3; // 定義不會被序列化和反序列化的對象
        private static int number4;
        
        public Bowel(int number1, int number2, int c, int number3) { // 建構方法
            this.number1 = number1;
            this.number2 = number2;
            this.number3 = number3;
            this.number4 = number4;
        }
    }
    
    public static void serialize(String fileName) {
        try {
            File file = new File(fileName); // 根據檔案地址建立檔案對像
            if (!file.exists()) { // 如果該對像不存在
                file.createNewFile(); // 建立該檔案對像
            }
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName)); // 建立對像輸出流對像
            out.writeObject("今天是:"); // 向檔案中寫入資料
            out.writeObject(new Date());
            Bowel my1 = new Bowel(5, 6, 7, 3);// 定義內部類別對像
            out.writeObject(my1); // 將對像寫入到檔案中
            out.close(); // 將流關閉
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Object[] deserialize(String fileName) {
        try {
            File file = new File(fileName); // 根據檔案地址建立檔案對像
            if (!file.exists()) { // 如果該檔案不存在
                file.createNewFile(); // 新增檔案
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    fileName)); // 建立對像輸入流
            String today = (String) (in.readObject()); // 從流中讀取資訊
            Date date = (Date) (in.readObject());
            System.out.println(date.toString());
            Object[] object = { today, date };
            Bowel my1 = (Bowel) (in.readObject());
            in.close(); // 關閉流
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
