import java.math.BigDecimal;
public class AccuratelyFloat {
    public static void main(String[] args) {
        double money = 2;// 現有金額
        double price = 1.1;// 商品價格
        double result=money - price;
        System.out.println("非精確計算");
        System.out.println("剩餘金額："+result);// 輸出運算結果
        // 精確浮點數的解決方法
        BigDecimal money1 = new BigDecimal("2");// 現有金額
        BigDecimal price1 = new BigDecimal("1.1");// 商品單擊
        BigDecimal result1=money1.subtract(price1);
        System.out.println("精確計算");
        System.out.println("剩餘金額："+result1);// 輸出精確結果
    }
}
