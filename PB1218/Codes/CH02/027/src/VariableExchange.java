import java.util.Scanner;

public class VariableExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// �إ߱��˾�
        System.out.println("�п�J�ܼ�A����");
        long A = scan.nextLong();// �����Ĥ@���ܼƭ�
        System.out.println("�п�J�ܼ�B����");
        long B = scan.nextLong();// �����ĤG���ܼƭ�
        System.out.println("A=" + A + "\tB=" + B);
        System.out.println("�����ܼƤ���...");
        A = A ^ B;// �����ܼƤ���
        B = B ^ A;
        A = A ^ B;
        System.out.println("A=" + A + "\tB=" + B);
    }
}
