import java.util.Scanner;
public class JudgeMonth {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// �إ߱��˾�
        // ���ܨϥΪ̿�J���
        System.out.println("�п�J�@�Ӥ���A�گ�i�D�A���ݩ���өu�`�C");
        int month = scan.nextInt();// �����ϥΪ̿�J
        switch (month) {// �P�_����ݩ���өu�`
            case 12:
            case 1:
            case 2:
                System.out.print("�z��J������ݩ�V�u�C");
                break;
            case 3:
            case 4:
            case 5:
                System.out.print("�z��J������ݩ�K�u");
                break;
            case 6:
            case 7:
            case 8:
                System.out.print("�z��J������ݩ�L�u");
                break;
            case 9:
            case 10:
            case 11:
                System.out.print("�z��J������ݩ��u");
                break;
            default:
                System.out.print("�A����" + month + "����ܡH");
        }
    }
}
