import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("請輸入一個英文字串或解密字串");
        String password = scan.nextLine();// 獲得使用者輸入
        char[] array = password.toCharArray();// 獲得字符陣列
        for (int i = 0; i < array.length; i++) {// 檢查字符陣列
            array[i] = (char) (array[i] ^ 20000);// 對每個陣列元素進行互斥運算
        }
        System.out.println("加密或解密結果如下：");
        System.err.println(new String(array));// 輸出密鑰
    }
}
