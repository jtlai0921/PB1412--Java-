import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class FormatNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// �إ߼Ъ`��J�y���˾�
        System.out.println("�п�J�@�ӼƦr�G");
        double number = scan.nextDouble();// ��o�ϥΪ̿�J�Ʀr
        System.out.println("�ӼƦr��Locale���O���H�U�`�Ƨ@���榡�ƹ�H���غc�ѼơA�N��o���P���f���榡�G");
        // �إ߮榡�ƹﹳ
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        // ��X�榡�Ƴf���榡
        System.out.println("Locale.CHINA�G" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Locale.US�G" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        System.out.println("Locale.ENGLISH�G" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
        System.out.println("Locale.TAIWAN�G" + format.format(number));
    }
}
