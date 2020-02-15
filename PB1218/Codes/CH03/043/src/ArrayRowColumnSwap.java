public class ArrayRowColumnSwap { // 建立類別
public static void main(String[] args) {
    // 建立2維陣列
    int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    System.out.println("行列互調前：");
    // 輸出2維陣列
    printArray(arr);
    int arr2[][] = new int[arr.length][arr.length];
    for (int i = 0; i < arr.length; i++) {// 調整陣列行列資料
        for (int j = 0; j < arr[i].length; j++) {
            arr2[i][j] = arr[j][i];
        }
    }
    System.out.println("行列互調後：");
    // 輸出2維陣列
    printArray(arr);
}
    
private static void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {// 檢查陣列
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[i][j] + " ");// 輸出陣列元素
        }
        System.out.println();
    }
}
}