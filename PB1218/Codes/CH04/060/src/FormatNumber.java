import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class FormatNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 建立標注輸入流掃瞄器
        System.out.println("請輸入一個數字：");
        double number = scan.nextDouble();// 獲得使用者輸入數字
        System.out.println("該數字用Locale類別的以下常數作為格式化對象的建構參數，將獲得不同的貨幣格式：");
        // 建立格式化對像
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        // 輸出格式化貨幣格式
        System.out.println("Locale.CHINA：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Locale.US：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        System.out.println("Locale.ENGLISH：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
        System.out.println("Locale.TAIWAN：" + format.format(number));
    }
}
