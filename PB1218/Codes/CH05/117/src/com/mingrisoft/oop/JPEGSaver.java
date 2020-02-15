package com.mingrisoft.oop;

public class JPEGSaver implements ImageSaver {
    
    @Override
    public void save() {
        System.out.println("將圖片儲存成JPG格式");
    }
}
