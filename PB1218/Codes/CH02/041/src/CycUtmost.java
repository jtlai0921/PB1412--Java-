public class CycUtmost {
    public static void main(String[] args) {
        int end=Integer.MAX_VALUE;// 定義循環終止數
        int start=end-50;// 定義循環起始數
        int count=0;// 定義循環計數器
        for (int i = start; i <= end; i++) {// 執行循環
            count++;// 循環計數
        }
        // 輸出循環計數器
        System.out.println("本次循環次數為："+count);
    }
}