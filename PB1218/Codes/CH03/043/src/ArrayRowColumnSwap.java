public class ArrayRowColumnSwap { // �إ����O
public static void main(String[] args) {
    // �إ�2���}�C
    int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    System.out.println("��C���իe�G");
    // ��X2���}�C
    printArray(arr);
    int arr2[][] = new int[arr.length][arr.length];
    for (int i = 0; i < arr.length; i++) {// �վ�}�C��C���
        for (int j = 0; j < arr[i].length; j++) {
            arr2[i][j] = arr[j][i];
        }
    }
    System.out.println("��C���ի�G");
    // ��X2���}�C
    printArray(arr);
}
    
private static void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {// �ˬd�}�C
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[i][j] + " ");// ��X�}�C����
        }
        System.out.println();
    }
}
}