public class CycFilter {
    public static void main(String[] args) {
        // 建立陣列
        String[] array = new String[] { "白鷺", "丹頂鶴", "黃鸝", "鸚鵡", "烏鴉", "喜鵲",
                "老鷹", "布谷鳥", "老鷹", "灰紋鳥", "老鷹", "百靈鳥" };
        System.out.println("在我的花園裡有很多鳥類別，但是最近來了幾隻老鷹，請幫我把它們抓走。");
        int eagleCount = 0;
        for (String string : array) {// foreach檢查陣列
            if (string.equals("老鷹")) {// 如果遇到老鷹
                System.out.println("發現一隻老鷹，已經抓到籠子裡。");
                eagleCount++;
                continue;// 中斷循環
            }
            System.out.println("搜索鳥類別，發現了：" + string);// 否則輸出陣列元素
        }
        System.out.println("一共捉到了：" + eagleCount + "只老鷹。");
    }
}
