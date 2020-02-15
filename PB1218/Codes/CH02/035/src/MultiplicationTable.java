public class MultiplicationTable {
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){// 循環控制變數從1檢查到9
            for(int j=1;j<=i;j++){// 第二層循環控制變數與第一層最大索引相等
                // 輸出計算結果但不換行
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();// 在外層循環中換行
        }
    }
}
