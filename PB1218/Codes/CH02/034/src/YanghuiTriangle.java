/**
 * @author ����L
 *
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        int triangle[][]=new int[8][];// �إߤG���}�C
        // �ˬd�G���}�C���Ĥ@�h
        for (int i = 0; i < triangle.length; i++) {
            triangle[i]=new int[i+1];// ��l�ƲĤG�h�}�C���j�p
            // �ˬd�ĤG�h�}�C
            for(int j=0;j<=triangle[i].length-1;j++){
                // �N�ⰼ���}�C���������Ȭ�1
                if(i==0||j==0||j==triangle[i].length-1){
                    triangle[i][j]=1;
                }else{// �䥦�ƭȳz�L�����p��
                    triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
                }
                // ��X�}�C����
                System.out.print(triangle[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
