import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * ���B�ഫ
 * 
 * @author YongQiang Lee
 */
public class ConvertMoney {
    // �j�g�Ʀr
    private final static String[] STR_NUMBER = { "�s", "��", "�L", "�T", "�v", "��",
            "��", "�m", "��", "�h" };
    private final static String[] STR_UNIT = { "", "�B", "��", "�a", "�U", "�B",
            "��", "�a", "��", "�B", "��", "�a" };// ��Ƴ��
    private final static String[] STR_UNIT2 = { "��", "��", "��" };// �p�Ƴ��
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// �إ߱��˾�
        System.out.println("�п�J�@�Ӫ��B");
        // ��o���B�ഫ�᪺�r��
        String convert = convert(scan.nextDouble());
        System.out.println(convert);// ��X�ഫ���G
    }
    
    /**
     * ��o�i�Ƴ���
     * 
     * @param num
     *            ���B
     * @return ���B��Ƴ���
     */
    public static String getInteger(String num) {
        if (num.indexOf(".") != -1) { // �P�_�O�_�]�t�p���I
            num = num.substring(0, num.indexOf("."));
        }
        num = new StringBuffer(num).reverse().toString(); // ����r��
        StringBuffer temp = new StringBuffer(); // �إߤ@��StringBuffer�ﹳ
        for (int i = 0; i < num.length(); i++) {// �[�J���
            temp.append(STR_UNIT[i]);
            temp.append(STR_NUMBER[num.charAt(i) - 48]);
        }
        num = temp.reverse().toString();// ����r��
        num = numReplace(num, "�s�B", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "�s��", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "�s�a", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "�s�U", "�U"); // �����r�ꪺ�r��
        num = numReplace(num, "�s��", "��"); // �����r�ꪺ�r��
        num = numReplace(num, "�s�s", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "���U", "��"); // �����r�ꪺ�r��
        // �p�G�r��H�s�����N�䰣�h
        if (num.lastIndexOf("�s") == num.length() - 1) {
            num = num.substring(0, num.length() - 1);
        }
        return num;
    }
    
    /**
     * ��o�p�Ƴ���
     * 
     * @param num
     *            ���B
     * @return ���B���p�Ƴ���
     */
    public static String getDecimal(String num) {
        // �P�_�O�_�]�t�p���I
        if (num.indexOf(".") == -1) {
            return "";
        }
        num = num.substring(num.indexOf(".") + 1);
        // ����r��
        num = new StringBuffer(num).reverse().toString();
        // �إߤ@��StringBuffer�ﹳ
        StringBuffer temp = new StringBuffer();
        // �[�J���
        for (int i = 0; i < num.length(); i++) {
            temp.append(STR_UNIT2[i]);
            temp.append(STR_NUMBER[num.charAt(i) - 48]);
        }
        num = temp.reverse().toString(); // �����r�ꪺ�r��
        num = numReplace(num, "�s��", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "�s��", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "�s��", "�s"); // �����r�ꪺ�r��
        num = numReplace(num, "�s�s", "�s"); // �����r�ꪺ�r��
        // �p�G�r��H�s�����N�䰣�h
        if (num.lastIndexOf("�s") == num.length() - 1) {
            num = num.substring(0, num.length() - 1);
        }
        return num;
    }
    
    /**
     * �����r�ꤤ���e
     * 
     * @param num
     *            �r��
     * @param oldStr
     *            �Q�������e
     * @param newStr
     *            �s���e
     * @return �����᪺�r��
     */
    public static String numReplace(String num, String oldStr, String newStr) {
        while (true) {
            // �P�_�r�ꤤ�O�_�]�t���w�r��
            if (num.indexOf(oldStr) == -1) {
                break;
            }
            // �����r��
            num = num.replaceAll(oldStr, newStr);
        }
        // �Ǧ^�����᪺�r��
        return num;
    }
    
    /**
     * ���B�ഫ
     * 
     * @param d
     *            ���B
     * @return �ഫ���j�g�����B
     */
    public static String convert(double d) {
        // ��Ҥ�DecimalFormat�ﹳ
        DecimalFormat df = new DecimalFormat("#0.###");
        // �榡��double�Ʀr
        String strNum = df.format(d);
        // �P�_�O�_�]�t�p���I
        if (strNum.indexOf(".") != -1) {
            String num = strNum.substring(0, strNum.indexOf("."));
            // ��Ƴ����j��12�����ഫ
            if (num.length() > 12) {
                System.out.println("�Ʀr�Ӥj�A���৹���ഫ�I");
                return "";
            }
        }
        String point = "";// �p���I
        if (strNum.indexOf(".") != -1) {
            point = "��";
        } else {
            point = "����";
        }
        // �ഫ���G
        String result = getInteger(strNum) + point + getDecimal(strNum);
        if (result.startsWith("��")) { // �P�_�O�r��O�_�w"��"����
            result = result.substring(1, result.length()); // �I���r��
        }
        return result; // �Ǧ^�s���r��
    }
}
