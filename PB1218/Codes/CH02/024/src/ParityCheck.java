import java.util.Scanner;
public class ParityCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 建立輸入流掃瞄器
        System.out.println("請輸入一個整數：");
        long number = scan.nextLong();// 獲得使用者輸入的整數
        String check = (number % 2 == 0) ? "這個數字是:偶數" : "這個數字是：奇數";
        System.out.println(check);
    }
}
