public class CycUtmost {
    public static void main(String[] args) {
        int end=Integer.MAX_VALUE;// �w�q�`���פ��
        int start=end-50;// �w�q�`���_�l��
        int count=0;// �w�q�`���p�ƾ�
        for (int i = start; i <= end; i++) {// ����`��
            count++;// �`���p��
        }
        // ��X�`���p�ƾ�
        System.out.println("�����`�����Ƭ��G"+count);
    }
}