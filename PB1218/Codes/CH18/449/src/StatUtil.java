import java.io.*;

public class StatUtil {
public static int[] statis(String fileName) {
    FileReader fileReader = null;
    try {
        fileReader = new FileReader(fileName);  //建立FileReader對像
        StreamTokenizer stokenizer = new StreamTokenizer(new BufferedReader(
                fileReader));                   //建立StreamTokenizer對像
        stokenizer.ordinaryChar('\'');          //將單引號當作是普通字符
        stokenizer.ordinaryChar('\"');          //將雙引號當作是普通字符
        stokenizer.ordinaryChar('/');           //將「/」當作是普通字符
        int[] length = new int[4];              //定義儲存計算結果的int型陣列
        String str;
        int numberSum = 0;                      //定義儲存數字的變數
        int symbolSum = 0;                      //定義儲存英文標點數的變數
        int wordSum = 0;    
        int sum = 0;                            //定義儲存總字符數的變數
        while (stokenizer.nextToken() != StreamTokenizer.TT_EOF) {  //如果沒有讀到檔案的尾端
            switch (stokenizer.ttype) {         //判斷讀取標記的型態                   
                case StreamTokenizer.TT_NUMBER:     //如果使用者讀取的是一個數字標記
                    str = String.valueOf(stokenizer.nval);        //獲得讀取的數字值              
                    numberSum += str.length();      //計算讀取的數字長度
                    length[0] = numberSum;          //設定陣列中的元素
                    break;                          //退出敘述
                case StreamTokenizer.TT_WORD:         //如果讀取的是文字標記
                    str = stokenizer.sval;              //獲得該標記                     
                    wordSum += str.length();            //計算該文字的長度
                    length[1] = wordSum;
                    break;
                default:                            //如果讀取的是其他標記
                    str = String.valueOf((char) stokenizer.ttype);  //讀取該標記
                    symbolSum += str.length();      //計算該標記的長度
                    length[2] = symbolSum;          //設定int陣列中的元素
            }
        }            
        sum = symbolSum + numberSum + wordSum;      //獲得總字符數
        length[3] = sum;
        return length;
    } catch (Exception e) {
        e.printStackTrace();
       return null;
    }
}    
}
