import java.util.Scanner;
public class CheckLogin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// �إ߱��˾�
        System.out.println("�п�J�n�J�ϥΪ̦W�١G");
        String username = scan.nextLine();// �����ϥΪ̿�J�n�J�W
        System.out.println("�п�J�n�J�K�X�G");
        String password = scan.nextLine();// �����ϥΪ̿�J�n�J�K�X
        if (!username.equals("mr")) {// �P�_�ϥΪ̦W�٦X�k��
            System.out.println("�ϥΪ̦W�٫D�k�C");
        } else if (!password.equals("mrsoft")) {// �P�_�K�X�X�k��
            System.out.println("�n�J�K�X���~�C");
        } else {// �z�L�H�W��ӱ���P�_�h�w�]�z�L�n�J����
            System.out.println("���߱z�A�n�J��T�z�L���ҡC");
        }
    }
}
