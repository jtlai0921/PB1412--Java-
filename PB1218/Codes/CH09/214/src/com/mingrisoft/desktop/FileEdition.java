package com.mingrisoft.desktop;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileEdition {
    public static void main(String[] a) {
        if (Desktop.isDesktopSupported()) {// 測試Desktop類別在目前平台是否可用
            Desktop desktop = Desktop.getDesktop();// 獲得Desktop類別的實例
            try {
                desktop.edit(new File("C:\\test.txt"));// 編輯本機檔案
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
