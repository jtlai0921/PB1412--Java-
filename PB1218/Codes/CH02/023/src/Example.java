import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("�п�J�@�ӭ^��r��θѱK�r��");
        String password = scan.nextLine();// ��o�ϥΪ̿�J
        char[] array = password.toCharArray();// ��o�r�Ű}�C
        for (int i = 0; i < array.length; i++) {// �ˬd�r�Ű}�C
            array[i] = (char) (array[i] ^ 20000);// ��C�Ӱ}�C�����i�椬���B��
        }
        System.out.println("�[�K�θѱK���G�p�U�G");
        System.err.println(new String(array));// ��X�K�_
    }
}
