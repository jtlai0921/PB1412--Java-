import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream {
    public static void main(String[] args) {
        try {
            PrintStream out = System.out;// �x�s���X�y
            PrintStream ps=new PrintStream("./log.txt");// �إ��ɮ׿�X�y
            System.setOut(ps);// �]�w�ϥηs����X�y
            int age=18;// �w�q����ܼ�
            System.out.println("�~���ܼƦ��\�w�q�A��Ȭ�18");
            String sex="�k";// �w�q�r���ܼ�
            System.out.println("�ʧO�ܼƦ��\�w�q�A��Ȭ��k");
            // ��X����ܼ�
            String info="�o�O��"+sex+"�Ĥl�A���Ӧ�"+age+"���F�C";
            System.out.println("��X����ܼƬ�info�r���ܼơA�䵲�G�O�G"+info);
            System.setOut(out);// ��_�즳��X�y
            System.out.println("�{�����槹���A���˵���x�ɮסC");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
