package com.mingrisoft.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileDeleteStrategy;

public class FileDeleteStrategyTest {
    public static void main(String[] args) {
        File rootFile = new File("d:\\������\\���˹Ϯ�");// �إ߭n�R�����ɮק��ﹳ
        System.out.println("��o�Ҧ��ɮת�������|�G");
        File[] list = rootFile.listFiles();
        for (File file : list) {
            System.out.println(file.getAbsolutePath());// ��X�ɮק������Ҧ��ɮת�������|
        }
        FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;// �ϥδ��q�R������
        System.out.println("�H���q�����R���D���ɮק�d:\\�����ޡG");
        try {
            strategy.delete(new File("d:\\������"));
            System.out.println("�ɮק��R�����\�I");// �p�G�R�����\�h���ܧR�����\
        } catch (IOException e) {
            System.out.println("�ɮק��R�����ѡI");// �p�G�R�����ѫh���ܧR������
        }
        strategy = FileDeleteStrategy.FORCE;// �ϥαj��R������
        System.out.println("�H�j����R���D���ɮק�d:\\�����ޡG");
        try {
            strategy.delete(new File("d:\\������"));
            System.out.println("�ɮק��R�����\�I");// �p�G�R�����\�h���ܧR�����\
        } catch (IOException e) {
            System.out.println("�ɮק��R�����ѡI");// �p�G�R�����ѫh���ܧR������
        }
    }
}
