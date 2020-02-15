
public class Diamond {
    public static void main(String[] args) {
        printHollowRhombus(10);
    }
    
    public static void printHollowRhombus(int size) {
        if (size % 2 == 0) {
            size++;// �p��٧Τj�p
        }
        for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" ");// ��X���W����m���ť�
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i) {
                    System.out.print("*");// ��X�٧ΤW�b����t
                } else {
                    System.out.print(" ");// ��X�٧ΤW�b���Ť�
                }
            }
            System.out.println("");
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" ");// ��X�٧Υ��U���ť�
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                if (j == 0 || j == 2 * (size - i - 1)) {
                    System.out.print("*");// ��X�٧ΤU�b����t
                } else {
                    System.out.print(" ");// ��X�٧ΤU�b���Ť�
                }
            }
            System.out.println("");
        }
    }
}
