import java.util.Scanner;
public class JudgeMonth {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 建立掃瞄器
        // 提示使用者輸入月份
        System.out.println("請輸入一個月份，我能告訴你它屬於哪個季節。");
        int month = scan.nextInt();// 接收使用者輸入
        switch (month) {// 判斷月份屬於哪個季節
            case 12:
            case 1:
            case 2:
                System.out.print("您輸入的月份屬於冬季。");
                break;
            case 3:
            case 4:
            case 5:
                System.out.print("您輸入的月份屬於春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.print("您輸入的月份屬於夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.print("您輸入的月份屬於秋季");
                break;
            default:
                System.out.print("你那有" + month + "月份嗎？");
        }
    }
}
