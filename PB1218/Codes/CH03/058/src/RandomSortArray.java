import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class RandomSortArray {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();// 建立TreeSet集合對像
        Random ran = new Random();// 建立隨機數對像
        int count = 0;// 定義隨機數計數器
        while (count < 10) {// 循環產生隨機數
            boolean succeed = set.add(ran.nextInt(100));// 為集合增加數字
            if (succeed)// 累加成功增加到集合中數字的數量
                count++;
        }
        int size = set.size();// 獲得集合大小
        Integer[] array = new Integer[size];// 建立同等大小的陣列
        Integer[] ddd = set.toArray(array);// 獲得集合中的陣列
        System.out.println("產生的重複隨機陣列內容如下：");
        for (int value : array) {// 檢查輸出陣列內容
            System.out.print(value + "   ");
        }
    }
}
