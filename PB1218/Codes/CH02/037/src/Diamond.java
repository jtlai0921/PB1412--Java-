
public class Diamond {
    public static void main(String[] args) {
        printHollowRhombus(10);
    }
    
    public static void printHollowRhombus(int size) {
        if (size % 2 == 0) {
            size++;// 計算菱形大小
        }
        for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" ");// 輸出左上角位置的空白
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i) {
                    System.out.print("*");// 輸出菱形上半部邊緣
                } else {
                    System.out.print(" ");// 輸出菱形上半部空心
                }
            }
            System.out.println("");
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" ");// 輸出菱形左下角空白
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                if (j == 0 || j == 2 * (size - i - 1)) {
                    System.out.print("*");// 輸出菱形下半部邊緣
                } else {
                    System.out.print(" ");// 輸出菱形下半部空心
                }
            }
            System.out.println("");
        }
    }
}
