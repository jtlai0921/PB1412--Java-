public class AppendCharacter {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String appendStr = "";// 建立字串變數
        long startTime = System.nanoTime();// 開始記事
        for (int i = 20000; i < 50000; i++) {// 檢查30000個字符
            appendStr += (char) i;// 字串與每個字符執行連接操作
        }
        long endTime = System.nanoTime();// 結束計時
        System.out.println("String追加字符3萬個。");
        // 輸出用時
        System.out.println("用時：" + (endTime - startTime) / 1000000d + "毫秒");
        // ///////////////////////////////////////////////////////////////
        StringBuilder strBuilder = new StringBuilder();// 建立字串建構器
        startTime = System.nanoTime();// 開始計時
        for (int i = 20000; i < 50000; i++) {// 檢查30000個字符
            strBuilder.append((char) i);// 把每個字符追加到建構器
        }
        endTime = System.nanoTime();// 結束記事
        System.out.println("字串建構器追加字符3萬個。");
        // 輸出用時
        System.out.print("用時：" + (endTime - startTime) / 1000000d + "毫秒");
    }
    
}
