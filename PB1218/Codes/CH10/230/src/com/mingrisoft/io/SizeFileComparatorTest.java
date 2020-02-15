package com.mingrisoft.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.comparator.SizeFileComparator;

public class SizeFileComparatorTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        File rootFile = new File("D:\\明日科技");// 建立一個檔案夾對像
        File[] files = rootFile.listFiles();// 獲得該檔案夾中所有檔案（夾）
        System.out.println("檔案（夾）的原始排序：");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// 輸出檔案夾中檔案（夾）的名稱
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_COMPARATOR);// 對files陣列進行排序
        System.out.println("檔案（夾）的SIZE_COMPARATOR排序：");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// 輸出檔案夾中檔案（夾）的名稱
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_REVERSE); // 對files陣列進行排序
        System.out.println("檔案（夾）的SIZE_REVERSE排序：");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// 輸出檔案夾中檔案（夾）的名稱
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_COMPARATOR);
        System.out.println("檔案（夾）的SIZE_SUMDIR_COMPARATOR排序：");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// 輸出檔案夾中檔案（夾）的名稱
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_REVERSE);
        System.out.println("檔案（夾）的SIZE_SUMDIR_REVERSE排序：");
        for (File file : files) {
            System.out.print(file.getName() + "\t");// 輸出檔案夾中檔案（夾）的名稱
        }
    }
}
