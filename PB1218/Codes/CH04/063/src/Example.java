import java.util.Date;
import java.util.Locale;

public class Example {
    public static void main(String[] args) {
        Date today = new Date();
        // �榡�ƫ᪺�r�ꬰ������^���Y�g
        String a = String.format(Locale.US, "%tb", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ������^���Y�g: " + a);
        // �榡�ƫ᪺�r�ꬰ������^����g
        String b = String.format(Locale.US, "%tB", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ������^���Y�g: " + b);
        // �榡�ƫ᪺�r�ꬰ�P���]�p�G�P���@�^
        String c = String.format("%ta", today);
        System.out.println("��榡�ƫ᪺�r�ꬰ�P��: " + c);
        // �榡�ƫ᪺�r�ꬰ�P���]�p�G�P���@�^
        String d = String.format("%tA", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ�P��: " + d);
        // �榡�ƫ᪺�r�ꬰ4�쪺�~����
        String e = String.format("%tY", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ4�쪺�~����: " + e);
        // �榡�ƫ᪺�r�ꬰ2�쪺�~����
        String f = String.format("%ty", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ2�쪺�~����: " + f);
        // �榡�ƫ᪺�r�ꬰ2�쪺�����
        String g = String.format("%tm", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ2�쪺�����: " + g);
        // �榡�ƫ᪺�r�ꬰ2�쪺�����
        String h = String.format("%td", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ2�쪺�����: " + h);
        // �榡�ƫ᪺�r�ꬰ1�쪺�����
        String i = String.format("%te", today);
        System.out.println("�榡�ƫ᪺�r�ꬰ1�쪺�����: " + i);
    }
}
