import java.util.Scanner;
public class ParityCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// �إ߿�J�y���˾�
        System.out.println("�п�J�@�Ӿ�ơG");
        long number = scan.nextLong();// ��o�ϥΪ̿�J�����
        String check = (number % 2 == 0) ? "�o�ӼƦr�O:����" : "�o�ӼƦr�O�G�_��";
        System.out.println(check);
    }
}
