/**
 * @author 李鍾尉
 */
public class ErgodicArray {
    public static void main(String[] args) {
        // 建立鳥類別陣列
        String[] aves = new String[] { "白鷺", "丹頂鶴", "黃鸝", "鸚鵡", "烏鴉", "喜鵲",
                "布谷鳥", "灰紋鳥", "百靈鳥" };
        int index = 0;// 建立索引變數
        System.out.println("我的花園裡有很多鳥，種類別大約包括：");
        while (index < aves.length) {// 檢查陣列
            System.out.println(aves[index++]);// 自增索引值
        }
    }
}
