import java.util.ArrayList;
import java.util.List;
public class UseForeach {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();// 建立list集合
        list.add("abc");// 初始化list集合
        list.add("def");
        list.add("hij");
        list.add("klm");
        list.add("nop");
        list.add("qrs");
        System.out.print("foreach檢查集合：\n\t");
        for (String string : list) {// 檢查list集合
            System.out.print(string);// 輸出集合的元素值
        }
        System.out.println();
        String[] strs=new String[list.size()];
        list.toArray(strs);// 建立陣列
        System.out.print("foreach檢查陣列：\n\t");
        for (String string : strs) {// 檢查陣列
            System.out.print(string);// 輸出陣列元素值
        }
    }
}
