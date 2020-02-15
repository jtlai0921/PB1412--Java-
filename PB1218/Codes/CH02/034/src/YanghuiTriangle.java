/**
 * @author 李鍾尉
 *
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        int triangle[][]=new int[8][];// 建立二維陣列
        // 檢查二維陣列的第一層
        for (int i = 0; i < triangle.length; i++) {
            triangle[i]=new int[i+1];// 初始化第二層陣列的大小
            // 檢查第二層陣列
            for(int j=0;j<=triangle[i].length-1;j++){
                // 將兩側的陣列元素給予值為1
                if(i==0||j==0||j==triangle[i].length-1){
                    triangle[i][j]=1;
                }else{// 其它數值透過公式計算
                    triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
                }
                // 輸出陣列元素
                System.out.print(triangle[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
