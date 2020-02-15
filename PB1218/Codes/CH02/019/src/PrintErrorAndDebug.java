public class PrintErrorAndDebug {
    public static void main(String[] args) {
        System.out.println("main()方法開始執行了。");
        // 輸出錯誤資訊
        System.err.println("在執行期間手動輸出一個錯誤資訊：");
        System.err.println("\t該軟件沒有買保險，請注意安全");
        System.out.println("PrintErrorAndDebug.main()");
        System.out.println("main()方法執行結束。");
    }
}
