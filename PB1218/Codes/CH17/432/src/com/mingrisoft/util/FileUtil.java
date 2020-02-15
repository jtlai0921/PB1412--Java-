package com.mingrisoft.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void copySingleFile(File source, File target) throws IOException {
        FileInputStream input = new FileInputStream(source);// ��o��J�y
        FileOutputStream output = new FileOutputStream(target);// ��o��X�y
        byte[] b = new byte[1024 * 5];
        int length;
        while ((length = input.read(b)) != -1) {// �Q�δ`��Ū����J�y�����������
            output.write(b, 0, length);// �N��J�y�������e�g�J���X�y��
        }
        output.flush();// ��s��X�y
        output.close();// �����X�y�귽
        input.close();// �����J�y�귽
    }
    
    public static void copyDirectory(File source, File target) throws IOException {
        File[] files = source.listFiles();// �N���ɮק��ഫ��File�}�C
        for (File file : files) {
            if (file.isFile()) {// �p�G�O�@���ɮ״N�I�s�ƻs�ɮת���k
                copySingleFile(file, new File(target.getAbsolutePath() + "/" + file.getName()));
            } else if (file.listFiles().length == 0) {// �p�G�O�@�Ӫ��ɮק��N�I�s�إ��ɮק�����k
                new File(target.getAbsolutePath() + "/" + file.getName()).mkdir();
            } else {// �p�G�O�@�ӫD���ɮק��N�I�s�ۨ��A�i�歡�N
                new File(target.getAbsolutePath() + "/" + file.getName()).mkdir();
                copyDirectory(file, new File(target.getAbsolutePath() + "/" + file.getName()));
            }
        }
    }
    
}
