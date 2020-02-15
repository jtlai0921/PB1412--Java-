public class TypeConversion {
    public static void main(String[] args) {
        byte b = 127;
        char c = 'W';
        short s = 23561;
        int i = 3333;
        long l = 400000L;
        float f = 3.14159F;
        double d = 54.523;
        // 低型態向高型態自動轉換
        System.out.println("累加bype等於：" + b);
        System.out.println("累加char等於：" + (b + c));
        System.out.println("累加short等於：" + (b + c + s));
        System.out.println("累加int等於：" + (b + c + s + i));
        System.out.println("累加long等於：" + (b + c + s + i + l));
        System.out.println("累加float等於：" + (b + c + s + i + l + f));
        System.out.println("累加double等於：" + (b + c + s + i + l + f + d));
        // 高型態到低型態的強制轉換
        System.out.println("把long強制型態轉為int：" + (int) l);
        // 高型態到低型態轉換會遺失資料
        System.out.println("把long強制型態轉為short：" + (short) l);
        // 實數到整數轉換將捨棄小數部分
        System.out.println("把double強制型態轉為int：" + (int) d);
        // 整數到字符型態的轉換將獲得對應寫程式的字符
        System.out.println("把short強制型態轉為char：" + (char) s);
    }
}
