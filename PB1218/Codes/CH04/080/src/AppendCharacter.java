public class AppendCharacter {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String appendStr = "";// �إߦr���ܼ�
        long startTime = System.nanoTime();// �}�l�O��
        for (int i = 20000; i < 50000; i++) {// �ˬd30000�Ӧr��
            appendStr += (char) i;// �r��P�C�Ӧr�Ű���s���ާ@
        }
        long endTime = System.nanoTime();// �����p��
        System.out.println("String�l�[�r��3�U�ӡC");
        // ��X�ή�
        System.out.println("�ήɡG" + (endTime - startTime) / 1000000d + "�@��");
        // ///////////////////////////////////////////////////////////////
        StringBuilder strBuilder = new StringBuilder();// �إߦr��غc��
        startTime = System.nanoTime();// �}�l�p��
        for (int i = 20000; i < 50000; i++) {// �ˬd30000�Ӧr��
            strBuilder.append((char) i);// ��C�Ӧr�Űl�[��غc��
        }
        endTime = System.nanoTime();// �����O��
        System.out.println("�r��غc���l�[�r��3�U�ӡC");
        // ��X�ή�
        System.out.print("�ήɡG" + (endTime - startTime) / 1000000d + "�@��");
    }
    
}
