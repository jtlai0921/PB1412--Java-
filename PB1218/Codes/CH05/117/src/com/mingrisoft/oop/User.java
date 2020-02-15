package com.mingrisoft.oop;

public class User {
    public static void main(String[] args) {
        System.out.print("使用者選擇了GIF格式：");
        ImageSaver saver = TypeChooser.getSaver("GIF");
        saver.save();
        System.out.print("使用者選擇了JPEG格式：");
        saver = TypeChooser.getSaver("JPEG");
        saver.save();
        System.out.print("使用者選擇了PNG格式：");
        saver = TypeChooser.getSaver("PNG");
        saver.save();
    }
}
