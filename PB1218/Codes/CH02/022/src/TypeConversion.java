public class TypeConversion {
    public static void main(String[] args) {
        byte b = 127;
        char c = 'W';
        short s = 23561;
        int i = 3333;
        long l = 400000L;
        float f = 3.14159F;
        double d = 54.523;
        // �C���A�V�����A�۰��ഫ
        System.out.println("�֥[bype����G" + b);
        System.out.println("�֥[char����G" + (b + c));
        System.out.println("�֥[short����G" + (b + c + s));
        System.out.println("�֥[int����G" + (b + c + s + i));
        System.out.println("�֥[long����G" + (b + c + s + i + l));
        System.out.println("�֥[float����G" + (b + c + s + i + l + f));
        System.out.println("�֥[double����G" + (b + c + s + i + l + f + d));
        // �����A��C���A���j���ഫ
        System.out.println("��long�j��A�ରint�G" + (int) l);
        // �����A��C���A�ഫ�|�򥢸��
        System.out.println("��long�j��A�ରshort�G" + (short) l);
        // ��ƨ����ഫ�N�˱�p�Ƴ���
        System.out.println("��double�j��A�ରint�G" + (int) d);
        // ��ƨ�r�ū��A���ഫ�N��o�����g�{�����r��
        System.out.println("��short�j��A�ରchar�G" + (char) s);
    }
}
