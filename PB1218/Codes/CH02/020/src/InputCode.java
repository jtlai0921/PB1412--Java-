import java.util.Scanner;

public class InputCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 建立輸入流掃瞄器
        System.out.println("請輸入你的身份證號：");// 提示使用者輸入
        String line = scanner.nextLine();// 獲得使用者輸入的一行文字
        // 列印對輸入文字的描述
        System.out.println("原來你身份證號是" + line.length() + "位數字的啊");
    }
}
