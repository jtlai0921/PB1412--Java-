package com.mingrisoft.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class OutputRedirect {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\debug.txt");// �إߤ@���ɮר��x�s���s�ɦV���X����r��T
        PrintStream out = new PrintStream(file);
        PrintStream cloneOut = System.out;// �ϥ��ܼ��x�s�D���x��X
        System.setOut(out);// �N�зǿ�X���s�ɦV��PrintStream
        System.out.println("�����޷s�ѧֻ��G");// �Q�μзǿ�X��X�ԭz
        System.out.println("Java�q�J�����q�]��2���^");// �Q�μзǿ�X��X�ԭz
        System.out.println("���T��Java");// �Q�μзǿ�X��X�ԭz
        System.out.println("�ӻ�Java");// �Q�μзǿ�X��X�ԭz
        out.close();// ����PrintStream
        System.setOut(cloneOut);// �N�зǿ�X���s�ɦV��D���x
        BufferedReader in = new BufferedReader(new FileReader(file));// Ū���ɮ�
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);// �b�D���x�W��X�ɮ�
        }
        in.close();// ������J�y
    }
}
