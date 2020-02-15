import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("請輸入新員工的姓名：");
        String name = scan.nextLine();// 接收員工名稱
        System.out.println("請輸入新員工應聘的編程語言：");
        String language = scan.nextLine();// 接收員工應聘的編程語言
        // 根據編程語言確定員工分配的部門
        switch (language.hashCode()) {
            case 3254818:// java的哈希碼
            case 2301506:// Java的哈希碼
            case 2269730:// JAVA的哈希碼
                System.out.println("員工"+name+"被分配到Java程式開發部門。");
                break;
            case 3104:// c#的哈希碼 
            case 2112:// C#的哈希碼 
                System.out.println("員工"+name+"被分配到C#項目維護組。");
                break;
            case -709190099: // asp.net的哈希碼 
            case 955463181:  // Asp.net的哈希碼 
            case 9745901:    // ASP.NET的哈希碼 
                System.out.println("員工"+name+"被分配到Asp.net程式測試部門。");
                break;
            default:
                System.out.println("本公司不需要" + language + "語言的程式開發人員。");
        }
    }
}
