import java.math.BigDecimal;
public class AccuratelyFloat {
    public static void main(String[] args) {
        double money = 2;// �{�����B
        double price = 1.1;// �ӫ~����
        double result=money - price;
        System.out.println("�D��T�p��");
        System.out.println("�Ѿl���B�G"+result);// ��X�B�⵲�G
        // ��T�B�I�ƪ��ѨM��k
        BigDecimal money1 = new BigDecimal("2");// �{�����B
        BigDecimal price1 = new BigDecimal("1.1");// �ӫ~����
        BigDecimal result1=money1.subtract(price1);
        System.out.println("��T�p��");
        System.out.println("�Ѿl���B�G"+result1);// ��X��T���G
    }
}
