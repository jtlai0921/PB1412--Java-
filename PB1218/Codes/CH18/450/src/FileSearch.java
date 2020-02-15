import java.util.*;
import java.io.*;

public class FileSearch {
    
    public static List findFiles(String baseDirName, String targetFileName) {
        List fileList = new ArrayList(); // �w�q�x�s�Ǧ^�Ȫ�List�ﹳ
        File baseDir = new File(baseDirName); // �ھڰѼƫإ�File�ﹳ
        if (!baseDir.exists() || !baseDir.isDirectory()) { // �p�G��File�ﹳ���s�b�Ϊ̤��O�@�ӥؿ�
            return fileList; // �Ǧ^List�ﹳ
        }
        String tempName = null;
        File[] files = baseDir.listFiles(); // ��o�Ѽƥؿ��U���ɮװ}�C
        for (int i = 0; i < files.length; i++) { // �`���ˬd�ɮװ}�C
            if (!files[i].isDirectory()) { // �p�G�}�C�����ɮפ��O�@�ӥؿ�
                tempName = files[i].getName(); // ��o�Ӱ}�C���W��
                if (FileSearch.findName(targetFileName, tempName)) { // �I�s�ɮפ���k
                    fileList.add(files[i].getAbsoluteFile()); // �N���w���ɮצW�W�[�춰�X��
                }
            }
        }
        return fileList;
    }
    
    public static boolean findName(String pattern, String str) {
        int patternLength = pattern.length(); // ��o�ѼƦr�ꪺ����
        int strLength = str.length();
        int strIndex = 0;
        char eachCh;
        for (int i = 0; i < patternLength; i++) { // �`���r�ŰѼƦr�ꤤ���C�Ӧr��
            eachCh = pattern.charAt(i); // ��o�r�ꤤ�C�ӯ��ަ�m���r��
            if (eachCh == '*') { // �p�G�o�Ӧr�ŬO�@�ӬP��
                while (strIndex < strLength) {
                    if (findName(pattern.substring(i + 1), str
                            .substring(strIndex))) { // �p�G�ɮצW�P�j���ҫ����
                        return true;
                    }
                    strIndex++;
                }
            } else if (eachCh == '?') { // �p�G�]�t�ݸ�
                strIndex++;
                if (strIndex > strLength) { // �p�Gstr���S���r�ťi�H���u?�v��
                    return false;
                }
            } else { // �p�G�n�M�䪺�O���q���ɮ�
                if ((strIndex >= strLength) || (eachCh != str.charAt(strIndex))) { // �p�G�S���M����諸�ɮ�
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }
}
