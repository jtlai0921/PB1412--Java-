import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class RandomSortArray {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();// �إ�TreeSet���X�ﹳ
        Random ran = new Random();// �إ��H���ƹﹳ
        int count = 0;// �w�q�H���ƭp�ƾ�
        while (count < 10) {// �`�������H����
            boolean succeed = set.add(ran.nextInt(100));// �����X�W�[�Ʀr
            if (succeed)// �֥[���\�W�[�춰�X���Ʀr���ƶq
                count++;
        }
        int size = set.size();// ��o���X�j�p
        Integer[] array = new Integer[size];// �إߦP���j�p���}�C
        Integer[] ddd = set.toArray(array);// ��o���X�����}�C
        System.out.println("���ͪ������H���}�C���e�p�U�G");
        for (int value : array) {// �ˬd��X�}�C���e
            System.out.print(value + "   ");
        }
    }
}
