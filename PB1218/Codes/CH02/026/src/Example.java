import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);// 建立掃瞄器
        System.out.println("請輸入一個整數");
        long number = scan.nextLong();// 獲得輸入的整數
        System.out.println("你輸入的數字是："+number);
        System.out.println("該數字乘以2的運算結果為："+(number<<1));
        System.out.println("該數字乘以4的運算結果為："+(number<<2));
        System.out.println("該數字乘以8的運算結果為："+(number<<3));
        System.out.println("該數字乘以16的運算結果為："+(number<<4));
    }
}
