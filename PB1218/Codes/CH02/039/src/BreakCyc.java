public class BreakCyc {
    public static void main(String[] args) {
        System.out.println("\n-------------���_��h�`�����Ҥl�C-------------");
        // �إ߰}�C
        String[] array = new String[] { "���O", "�����b", "����", "�x�M", "�Q�~", "���N",
                "���N", "������", "���N", "�ǯ���", "���N", "���F��" };
        System.out.println("�b�A�o�{�Ĥ@�����N���e�A�i�D�ڳ������򳾡C");
        for (String string : array) {// foreach�ˬd�}�C
            if (string.equals("���N"))// �p�G�J����N
                break;// ���_�`��
            System.out.print("���G" + string+"        ");// �_�h��X�}�C����
        }
        
        System.out.println("\n\n-------------���_���h�`�����Ҥl�C-------------");
        // �إߦ��Z�}�C
        int[][] myScores = new int[][] { { 67, 78, 63, 22, 66 },
                { 55, 68, 78, 95, 44 }, { 95, 97, 92, 93, 81 } };
        System.out.println("�_�_�o���Ҹզ��Z�G\n�ƾ�\t�y��\t�^�y\t���N\t���v");
        No1: for (int[] is : myScores) {// �ˬd���Z���
            for (int i : is) {
                System.out.print(i + "\t");// ��X���Z
                if (i < 60) {// �p�G���~�J�줣�ή檺�A�ߨ褤�_�Ҧ���X
                    System.out.println("\n�����A" + i + "�����O����H�o�Ӭ����򤣤ή�H");
                    break No1;
                }
            }
            System.out.println();
        }
    }
}
