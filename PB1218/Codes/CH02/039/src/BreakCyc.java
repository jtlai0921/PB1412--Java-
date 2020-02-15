public class BreakCyc {
    public static void main(String[] args) {
        System.out.println("\n-------------中斷單層循環的例子。-------------");
        // 建立陣列
        String[] array = new String[] { "白鷺", "丹頂鶴", "黃鸝", "鸚鵡", "烏鴉", "喜鵲",
                "老鷹", "布谷鳥", "老鷹", "灰紋鳥", "老鷹", "百靈鳥" };
        System.out.println("在你發現第一隻老鷹之前，告訴我都有什麼鳥。");
        for (String string : array) {// foreach檢查陣列
            if (string.equals("老鷹"))// 如果遇到老鷹
                break;// 中斷循環
            System.out.print("有：" + string+"        ");// 否則輸出陣列元素
        }
        
        System.out.println("\n\n-------------中斷雙層循環的例子。-------------");
        // 建立成績陣列
        int[][] myScores = new int[][] { { 67, 78, 63, 22, 66 },
                { 55, 68, 78, 95, 44 }, { 95, 97, 92, 93, 81 } };
        System.out.println("寶寶這次考試成績：\n數學\t語文\t英語\t美術\t歷史");
        No1: for (int[] is : myScores) {// 檢查成績表格
            for (int i : is) {
                System.out.print(i + "\t");// 輸出成績
                if (i < 60) {// 如果中途遇到不及格的，立刻中斷所有輸出
                    System.out.println("\n等等，" + i + "分的是什麼？這個為什麼不及格？");
                    break No1;
                }
            }
            System.out.println();
        }
    }
}
