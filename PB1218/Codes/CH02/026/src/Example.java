import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);// �إ߱��˾�
        System.out.println("�п�J�@�Ӿ��");
        long number = scan.nextLong();// ��o��J�����
        System.out.println("�A��J���Ʀr�O�G"+number);
        System.out.println("�ӼƦr���H2���B�⵲�G���G"+(number<<1));
        System.out.println("�ӼƦr���H4���B�⵲�G���G"+(number<<2));
        System.out.println("�ӼƦr���H8���B�⵲�G���G"+(number<<3));
        System.out.println("�ӼƦr���H16���B�⵲�G���G"+(number<<4));
    }
}
