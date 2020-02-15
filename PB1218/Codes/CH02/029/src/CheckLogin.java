import java.util.Scanner;
public class CheckLogin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 建立掃瞄器
        System.out.println("請輸入登入使用者名稱：");
        String username = scan.nextLine();// 接收使用者輸入登入名
        System.out.println("請輸入登入密碼：");
        String password = scan.nextLine();// 接收使用者輸入登入密碼
        if (!username.equals("mr")) {// 判斷使用者名稱合法性
            System.out.println("使用者名稱非法。");
        } else if (!password.equals("mrsoft")) {// 判斷密碼合法性
            System.out.println("登入密碼錯誤。");
        } else {// 透過以上兩個條件判斷則預設透過登入驗證
            System.out.println("恭喜您，登入資訊透過驗證。");
        }
    }
}
