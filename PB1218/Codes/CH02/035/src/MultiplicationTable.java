public class MultiplicationTable {
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){// �`�������ܼƱq1�ˬd��9
            for(int j=1;j<=i;j++){// �ĤG�h�`�������ܼƻP�Ĥ@�h�̤j���ެ۵�
                // ��X�p�⵲�G��������
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();// �b�~�h�`��������
        }
    }
}
