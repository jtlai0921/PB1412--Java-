package com.mingrisoft.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.comparator.SizeFileComparator;

public class SizeFileComparatorTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        File rootFile = new File("D:\\������");// �إߤ@���ɮק��ﹳ
        File[] files = rootFile.listFiles();// ��o���ɮק����Ҧ��ɮס]���^
        System.out.println("�ɮס]���^����l�ƧǡG");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// ��X�ɮק����ɮס]���^���W��
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_COMPARATOR);// ��files�}�C�i��Ƨ�
        System.out.println("�ɮס]���^��SIZE_COMPARATOR�ƧǡG");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// ��X�ɮק����ɮס]���^���W��
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_REVERSE); // ��files�}�C�i��Ƨ�
        System.out.println("�ɮס]���^��SIZE_REVERSE�ƧǡG");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// ��X�ɮק����ɮס]���^���W��
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_COMPARATOR);
        System.out.println("�ɮס]���^��SIZE_SUMDIR_COMPARATOR�ƧǡG");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// ��X�ɮק����ɮס]���^���W��
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_REVERSE);
        System.out.println("�ɮס]���^��SIZE_SUMDIR_REVERSE�ƧǡG");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// ��X�ɮק����ɮס]���^���W��
        }
    }
}
