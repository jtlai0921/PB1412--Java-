import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("�п�J�s���u���m�W�G");
        String name = scan.nextLine();// �������u�W��
        System.out.println("�п�J�s���u���u���s�{�y���G");
        String language = scan.nextLine();// �������u���u���s�{�y��
        // �ھڽs�{�y���T�w���u���t������
        switch (language.hashCode()) {
            case 3254818:// java�����ƽX
            case 2301506:// Java�����ƽX
            case 2269730:// JAVA�����ƽX
                System.out.println("���u"+name+"�Q���t��Java�{���}�o�����C");
                break;
            case 3104:// c#�����ƽX 
            case 2112:// C#�����ƽX 
                System.out.println("���u"+name+"�Q���t��C#���غ��@�աC");
                break;
            case -709190099: // asp.net�����ƽX 
            case 955463181:  // Asp.net�����ƽX 
            case 9745901:    // ASP.NET�����ƽX 
                System.out.println("���u"+name+"�Q���t��Asp.net�{�����ճ����C");
                break;
            default:
                System.out.println("�����q���ݭn" + language + "�y�����{���}�o�H���C");
        }
    }
}
