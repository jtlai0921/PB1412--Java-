import java.util.ArrayList;
import java.util.List;
public class UseForeach {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();// �إ�list���X
        list.add("abc");// ��l��list���X
        list.add("def");
        list.add("hij");
        list.add("klm");
        list.add("nop");
        list.add("qrs");
        System.out.print("foreach�ˬd���X�G\n\t");
        for (String string : list) {// �ˬdlist���X
            System.out.print(string);// ��X���X��������
        }
        System.out.println();
        String[] strs=new String[list.size()];
        list.toArray(strs);// �إ߰}�C
        System.out.print("foreach�ˬd�}�C�G\n\t");
        for (String string : strs) {// �ˬd�}�C
            System.out.print(string);// ��X�}�C������
        }
    }
}
