import java.util.Scanner;

public class InputCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// �إ߿�J�y���˾�
        System.out.println("�п�J�A�������Ҹ��G");// ���ܨϥΪ̿�J
        String line = scanner.nextLine();// ��o�ϥΪ̿�J���@���r
        // �C�L���J��r���y�z
        System.out.println("��ӧA�����Ҹ��O" + line.length() + "��Ʀr����");
    }
}
