import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("�п�J�@�Ӧ~���G");
        long year = scan.nextLong();// �����ϥΪ̿�J
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { // �O�|�~
            System.out.print(year + "�O�|�~�I");
        } else { // ���O�|�~
            System.out.print(year + "���O�|�~�I");
        }
    }
}
