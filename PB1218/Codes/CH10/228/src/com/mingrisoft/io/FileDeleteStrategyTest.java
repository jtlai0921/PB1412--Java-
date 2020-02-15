package com.mingrisoft.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileDeleteStrategy;

public class FileDeleteStrategyTest {
    public static void main(String[] args) {
        File rootFile = new File("d:\\明日科技\\推薦圖書");// 建立要刪除的檔案夾對像
        System.out.println("獲得所有檔案的絕對路徑：");
        File[] list = rootFile.listFiles();
        for (File file : list) {
            System.out.println(file.getAbsolutePath());// 輸出檔案夾中的所有檔案的絕對路徑
        }
        FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;// 使用普通刪除策略
        System.out.println("以普通策略刪除非空檔案夾d:\\明日科技：");
        try {
            strategy.delete(new File("d:\\明日科技"));
            System.out.println("檔案夾刪除成功！");// 如果刪除成功則提示刪除成功
        } catch (IOException e) {
            System.out.println("檔案夾刪除失敗！");// 如果刪除失敗則提示刪除失敗
        }
        strategy = FileDeleteStrategy.FORCE;// 使用強制刪除策略
        System.out.println("以強制策略刪除非空檔案夾d:\\明日科技：");
        try {
            strategy.delete(new File("d:\\明日科技"));
            System.out.println("檔案夾刪除成功！");// 如果刪除成功則提示刪除成功
        } catch (IOException e) {
            System.out.println("檔案夾刪除失敗！");// 如果刪除失敗則提示刪除失敗
        }
    }
}
