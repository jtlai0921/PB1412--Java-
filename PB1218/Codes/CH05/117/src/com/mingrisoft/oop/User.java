package com.mingrisoft.oop;

public class User {
    public static void main(String[] args) {
        System.out.print("�ϥΪ̿�ܤFGIF�榡�G");
        ImageSaver saver = TypeChooser.getSaver("GIF");
        saver.save();
        System.out.print("�ϥΪ̿�ܤFJPEG�榡�G");
        saver = TypeChooser.getSaver("JPEG");
        saver.save();
        System.out.print("�ϥΪ̿�ܤFPNG�榡�G");
        saver = TypeChooser.getSaver("PNG");
        saver.save();
    }
}
