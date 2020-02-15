import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("請輸入一個年份：");
        long year = scan.nextLong();// 接收使用者輸入
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { // 是閏年
            System.out.print(year + "是閏年！");
        } else { // 不是閏年
            System.out.print(year + "不是閏年！");
        }
    }
}
