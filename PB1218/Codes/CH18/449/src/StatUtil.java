import java.io.*;

public class StatUtil {
public static int[] statis(String fileName) {
    FileReader fileReader = null;
    try {
        fileReader = new FileReader(fileName);  //�إ�FileReader�ﹳ
        StreamTokenizer stokenizer = new StreamTokenizer(new BufferedReader(
                fileReader));                   //�إ�StreamTokenizer�ﹳ
        stokenizer.ordinaryChar('\'');          //�N��޸���@�O���q�r��
        stokenizer.ordinaryChar('\"');          //�N���޸���@�O���q�r��
        stokenizer.ordinaryChar('/');           //�N�u/�v��@�O���q�r��
        int[] length = new int[4];              //�w�q�x�s�p�⵲�G��int���}�C
        String str;
        int numberSum = 0;                      //�w�q�x�s�Ʀr���ܼ�
        int symbolSum = 0;                      //�w�q�x�s�^����I�ƪ��ܼ�
        int wordSum = 0;    
        int sum = 0;                            //�w�q�x�s�`�r�żƪ��ܼ�
        while (stokenizer.nextToken() != StreamTokenizer.TT_EOF) {  //�p�G�S��Ū���ɮת�����
            switch (stokenizer.ttype) {         //�P�_Ū���аO�����A                   
                case StreamTokenizer.TT_NUMBER:     //�p�G�ϥΪ�Ū�����O�@�ӼƦr�аO
                    str = String.valueOf(stokenizer.nval);        //��oŪ�����Ʀr��              
                    numberSum += str.length();      //�p��Ū�����Ʀr����
                    length[0] = numberSum;          //�]�w�}�C��������
                    break;                          //�h�X�ԭz
                case StreamTokenizer.TT_WORD:         //�p�GŪ�����O��r�аO
                    str = stokenizer.sval;              //��o�ӼаO                     
                    wordSum += str.length();            //�p��Ӥ�r������
                    length[1] = wordSum;
                    break;
                default:                            //�p�GŪ�����O��L�аO
                    str = String.valueOf((char) stokenizer.ttype);  //Ū���ӼаO
                    symbolSum += str.length();      //�p��ӼаO������
                    length[2] = symbolSum;          //�]�wint�}�C��������
            }
        }            
        sum = symbolSum + numberSum + wordSum;      //��o�`�r�ż�
        length[3] = sum;
        return length;
    } catch (Exception e) {
        e.printStackTrace();
       return null;
    }
}    
}
