public class CycFilter {
    public static void main(String[] args) {
        // �إ߰}�C
        String[] array = new String[] { "���O", "�����b", "����", "�x�M", "�Q�~", "���N",
                "���N", "������", "���N", "�ǯ���", "���N", "���F��" };
        System.out.println("�b�ڪ����̦��ܦh�����O�A���O�̪�ӤF�X�����N�A�����ڧ⥦�̧쨫�C");
        int eagleCount = 0;
        for (String string : array) {// foreach�ˬd�}�C
            if (string.equals("���N")) {// �p�G�J����N
                System.out.println("�o�{�@�����N�A�w�g���Ţ�l�̡C");
                eagleCount++;
                continue;// ���_�`��
            }
            System.out.println("�j�������O�A�o�{�F�G" + string);// �_�h��X�}�C����
        }
        System.out.println("�@�@����F�G" + eagleCount + "�u���N�C");
    }
}
