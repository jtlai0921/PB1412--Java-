package com.cdd.util;
import java.io.*;
public class Employ {
public static void main(String args[]) {
    File file = new File("Example8.txt");
    try {
        if (!file.exists())                      // �p�G�ɮפ��s�b
            file.createNewFile();                // �إ߷s�ɮ�
        InputStreamReader isr = new InputStreamReader(System.in);   //�w�q��J�y�ﹳ
        BufferedReader br = new BufferedReader(isr);            
        System.out.println("�п�J�G");
        String str = br.readLine();             //Ū���ϥΪ̿�J����T
        System.out.println("�z��J�����e�O�G" + str);
        FileWriter fos = new FileWriter(file, true);         // �إ��ɮ׿�X�y
        BufferedWriter bw = new BufferedWriter(fos);
        bw.write(str);                          //�V�ɮ׼g�J��T
        br.close();
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
