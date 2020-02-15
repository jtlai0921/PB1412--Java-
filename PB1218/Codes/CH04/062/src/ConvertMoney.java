import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 肂锣传
 * 
 * @author YongQiang Lee
 */
public class ConvertMoney {
    // 糶计
    private final static String[] STR_NUMBER = { "箂", "滁", "禠", "", "竩", "ヮ",
            "嘲", "琺", "", "╤" };
    private final static String[] STR_UNIT = { "", "珺", "ㄕ", "", "窾", "珺",
            "ㄕ", "", "货", "珺", "ㄕ", "" };// 俱计虫
    private final static String[] STR_UNIT2 = { "à", "だ", "往" };// 计虫
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// ミ苯核竟
        System.out.println("叫块肂");
        // 莉眔肂锣传﹃
        String convert = convert(scan.nextDouble());
        System.out.println(convert);// 块锣传挡狦
    }
    
    /**
     * 莉眔计场だ
     * 
     * @param num
     *            肂
     * @return 肂俱计场だ
     */
    public static String getInteger(String num) {
        if (num.indexOf(".") != -1) { // 耞琌计翴
            num = num.substring(0, num.indexOf("."));
        }
        num = new StringBuffer(num).reverse().toString(); // は锣﹃
        StringBuffer temp = new StringBuffer(); // ミStringBuffer癸钩
        for (int i = 0; i < num.length(); i++) {// 虫
            temp.append(STR_UNIT[i]);
            temp.append(STR_NUMBER[num.charAt(i) - 48]);
        }
        num = temp.reverse().toString();// は锣﹃
        num = numReplace(num, "箂珺", "箂"); // 蠢传﹃才
        num = numReplace(num, "箂ㄕ", "箂"); // 蠢传﹃才
        num = numReplace(num, "箂", "箂"); // 蠢传﹃才
        num = numReplace(num, "箂窾", "窾"); // 蠢传﹃才
        num = numReplace(num, "箂货", "货"); // 蠢传﹃才
        num = numReplace(num, "箂箂", "箂"); // 蠢传﹃才
        num = numReplace(num, "货窾", "货"); // 蠢传﹃才
        // 狦﹃箂挡Ю盢ㄤ埃
        if (num.lastIndexOf("箂") == num.length() - 1) {
            num = num.substring(0, num.length() - 1);
        }
        return num;
    }
    
    /**
     * 莉眔计场だ
     * 
     * @param num
     *            肂
     * @return 肂计场だ
     */
    public static String getDecimal(String num) {
        // 耞琌计翴
        if (num.indexOf(".") == -1) {
            return "";
        }
        num = num.substring(num.indexOf(".") + 1);
        // は锣﹃
        num = new StringBuffer(num).reverse().toString();
        // ミStringBuffer癸钩
        StringBuffer temp = new StringBuffer();
        // 虫
        for (int i = 0; i < num.length(); i++) {
            temp.append(STR_UNIT2[i]);
            temp.append(STR_NUMBER[num.charAt(i) - 48]);
        }
        num = temp.reverse().toString(); // 蠢传﹃才
        num = numReplace(num, "箂à", "箂"); // 蠢传﹃才
        num = numReplace(num, "箂だ", "箂"); // 蠢传﹃才
        num = numReplace(num, "箂往", "箂"); // 蠢传﹃才
        num = numReplace(num, "箂箂", "箂"); // 蠢传﹃才
        // 狦﹃箂挡Ю盢ㄤ埃
        if (num.lastIndexOf("箂") == num.length() - 1) {
            num = num.substring(0, num.length() - 1);
        }
        return num;
    }
    
    /**
     * 蠢传﹃いず甧
     * 
     * @param num
     *            ﹃
     * @param oldStr
     *            砆蠢传ず甧
     * @param newStr
     *            穝ず甧
     * @return 蠢传﹃
     */
    public static String numReplace(String num, String oldStr, String newStr) {
        while (true) {
            // 耞﹃い琌﹚才
            if (num.indexOf(oldStr) == -1) {
                break;
            }
            // 蠢传﹃
            num = num.replaceAll(oldStr, newStr);
        }
        // 肚蠢传﹃
        return num;
    }
    
    /**
     * 肂锣传
     * 
     * @param d
     *            肂
     * @return 锣传Θ糶肂
     */
    public static String convert(double d) {
        // 龟ㄒてDecimalFormat癸钩
        DecimalFormat df = new DecimalFormat("#0.###");
        // Αてdouble计
        String strNum = df.format(d);
        // 耞琌计翴
        if (strNum.indexOf(".") != -1) {
            String num = strNum.substring(0, strNum.indexOf("."));
            // 俱计场だ12ぃ锣传
            if (num.length() > 12) {
                System.out.println("计びぃЧΘ锣传");
                return "";
            }
        }
        String point = "";// 计翴
        if (strNum.indexOf(".") != -1) {
            point = "じ";
        } else {
            point = "じ俱";
        }
        // 锣传挡狦
        String result = getInteger(strNum) + point + getDecimal(strNum);
        if (result.startsWith("じ")) { // 耞琌﹃琌"じ"挡Ю
            result = result.substring(1, result.length()); // 篒﹃
        }
        return result; // 肚穝﹃
    }
}
