package com.mingrisoft.oop;

public class GIFSaver implements ImageSaver {
    
    @Override
    public void save() {
        System.out.println("將圖片儲存成GIF格式");
    }
}
