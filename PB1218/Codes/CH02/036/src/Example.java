import java.math.BigDecimal;
public class Example {
    public static void main(String args[]) {
        BigDecimal sum = new BigDecimal(0.0); // �M
        BigDecimal factorial = new BigDecimal(1.0); // ���������p�⵲�G
        int i = 1; // �`���W�q
        while (i <= 20) {
            sum = sum.add(factorial); // �֥[�U���������M
            ++i; // i�[1
            factorial = factorial.multiply(new BigDecimal(1.0 / i)); // �p�ⶥ����
        }
        System.out.println("1+1��2!+1��3!�P�P�P1��20!���p�⵲�G����G\n" + sum); // ��X�p�⵲�G
    }
}
