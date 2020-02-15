import java.math.BigDecimal;
public class Example {
    public static void main(String args[]) {
        BigDecimal sum = new BigDecimal(0.0); // 和
        BigDecimal factorial = new BigDecimal(1.0); // 階乘項的計算結果
        int i = 1; // 循環增量
        while (i <= 20) {
            sum = sum.add(factorial); // 累加各項階乘的和
            ++i; // i加1
            factorial = factorial.multiply(new BigDecimal(1.0 / i)); // 計算階乘項
        }
        System.out.println("1+1／2!+1／3!···1／20!的計算結果等於：\n" + sum); // 輸出計算結果
    }
}
