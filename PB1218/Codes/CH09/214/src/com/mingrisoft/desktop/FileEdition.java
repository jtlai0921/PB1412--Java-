package com.mingrisoft.desktop;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileEdition {
    public static void main(String[] a) {
        if (Desktop.isDesktopSupported()) {// ����Desktop���O�b�ثe���x�O�_�i��
            Desktop desktop = Desktop.getDesktop();// ��oDesktop���O�����
            try {
                desktop.edit(new File("C:\\test.txt"));// �s�襻���ɮ�
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
