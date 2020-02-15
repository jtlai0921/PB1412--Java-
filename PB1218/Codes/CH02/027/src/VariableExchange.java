import java.util.Scanner;

public class VariableExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 建立掃瞄器
        System.out.println("請輸入變數A的值");
        long A = scan.nextLong();// 接收第一個變數值
        System.out.println("請輸入變數B的值");
        long B = scan.nextLong();// 接收第二個變數值
        System.out.println("A=" + A + "\tB=" + B);
        System.out.println("執行變數互換...");
        A = A ^ B;// 執行變數互換
        B = B ^ A;
        A = A ^ B;
        System.out.println("A=" + A + "\tB=" + B);
    }
}
