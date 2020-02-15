import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL,
                Locale.CHINA);
        // ������
        String string = formater.format(date);
        System.out.println("�������G\t"+string);
        // �[���j���
        formater = DateFormat.getDateInstance(DateFormat.FULL,
                Locale.CANADA);
        System.out.println("�[���j����G\t"+formater.format(date));
        // �饻���
        formater = DateFormat.getDateInstance(DateFormat.FULL,
                Locale.JAPAN);
        System.out.println("�饻����G\t"+formater.format(date));
        // �k����
        formater = DateFormat.getDateInstance(DateFormat.FULL,
                Locale.FRANCE);
        System.out.println("�k�����G\t"+formater.format(date));
        // �w����
        formater = DateFormat.getDateInstance(DateFormat.FULL,
                Locale.GERMAN);
        System.out.println("�w�����G\t"+formater.format(date));
        // �N�j�Q���
        formater = DateFormat.getDateInstance(DateFormat.FULL,
                Locale.ITALIAN);
        System.out.println("�N�j�Q����G\t"+formater.format(date));
    }
}
