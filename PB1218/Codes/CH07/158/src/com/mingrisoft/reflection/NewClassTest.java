package com.mingrisoft.reflection;

import java.io.File;
import java.lang.reflect.Constructor;

public class NewClassTest {
    
    public static void main(String[] args) {
        try {
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            System.out.println("使用反射建立File對像");
            File file = constructor.newInstance("d://明日科技.txt");
            System.out.println("使用File對像在D碟建立檔案：明日科技.txt");
            file.createNewFile();
            System.out.println("檔案是否建立成功：" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
