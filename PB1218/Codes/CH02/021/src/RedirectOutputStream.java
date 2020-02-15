import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream {
    public static void main(String[] args) {
        try {
            PrintStream out = System.out;// 儲存原輸出流
            PrintStream ps=new PrintStream("./log.txt");// 建立檔案輸出流
            System.setOut(ps);// 設定使用新的輸出流
            int age=18;// 定義整形變數
            System.out.println("年齡變數成功定義，初值為18");
            String sex="女";// 定義字串變數
            System.out.println("性別變數成功定義，初值為女");
            // 整合兩個變數
            String info="這是個"+sex+"孩子，應該有"+age+"歲了。";
            System.out.println("整合兩個變數為info字串變數，其結果是："+info);
            System.setOut(out);// 恢復原有輸出流
            System.out.println("程式執行完畢，請檢視日誌檔案。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
