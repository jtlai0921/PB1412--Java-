package com.mingrisoft.util;

import java.io.File;
import java.util.List;

public class FileUtils {
    // �R���ɮק��U�Ҧ��ɮ�
    public static void deleteFiles(File rootFile) {
        if (rootFile.listFiles().length == 0) {// �p�G�ϥΪ̫��w���O���ɮק��N�h�X��k
            return;
        } else {
            File[] files = rootFile.listFiles();// �N�D���ɮק��ഫ��File�}�C
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();// �R�����w�ɮק��U���Ҧ��ɮ�
                } else {
                    if (file.listFiles().length == 0) {
                        file.delete();// �R�����w�ɮק��U���Ҧ����ɮק�
                    } else {
                        deleteDirectories(file);// �R�����w�ɮק��U���Ҧ��D���ɮק�
                    }
                }
            }
        }
    }
    
    // �R���ɮק����ɮק��U�Ҧ��ɮ�
    public static void deleteDirectories(File rootFile) {
        if (rootFile.isFile()) {
            rootFile.delete();// �p�G���w��File��H�O�ɮ״N�����R��
        } else {// �p�G�O�@���ɮק��N�N���ഫ��File�}�C
            File[] files = rootFile.listFiles();
            for (File file : files) {
                deleteDirectories(file);// �p�G���O���ɮק��h�N���NdeleteDictionary()��k
            }
            rootFile.delete();// �p�G�O���ɮק��N�����R��
        }
        
    }
    
    // ��o���w�ؿ��U���Ҧ��ɮת����|
    public static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", File.separator));
            }
        }
        return list;
    }
}
