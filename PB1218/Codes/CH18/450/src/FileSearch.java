import java.util.*;
import java.io.*;

public class FileSearch {
    
    public static List findFiles(String baseDirName, String targetFileName) {
        List fileList = new ArrayList(); // 定義儲存傳回值的List對像
        File baseDir = new File(baseDirName); // 根據參數建立File對像
        if (!baseDir.exists() || !baseDir.isDirectory()) { // 如果該File對像不存在或者不是一個目錄
            return fileList; // 傳回List對像
        }
        String tempName = null;
        File[] files = baseDir.listFiles(); // 獲得參數目錄下的檔案陣列
        for (int i = 0; i < files.length; i++) { // 循環檢查檔案陣列
            if (!files[i].isDirectory()) { // 如果陣列中的檔案不是一個目錄
                tempName = files[i].getName(); // 獲得該陣列的名稱
                if (FileSearch.findName(targetFileName, tempName)) { // 呼叫檔案比對方法
                    fileList.add(files[i].getAbsoluteFile()); // 將指定的檔案名增加到集合中
                }
            }
        }
        return fileList;
    }
    
    public static boolean findName(String pattern, String str) {
        int patternLength = pattern.length(); // 獲得參數字串的長度
        int strLength = str.length();
        int strIndex = 0;
        char eachCh;
        for (int i = 0; i < patternLength; i++) { // 循環字符參數字串中的每個字符
            eachCh = pattern.charAt(i); // 獲得字串中每個索引位置的字符
            if (eachCh == '*') { // 如果這個字符是一個星號
                while (strIndex < strLength) {
                    if (findName(pattern.substring(i + 1), str
                            .substring(strIndex))) { // 如果檔案名與搜索模型比對
                        return true;
                    }
                    strIndex++;
                }
            } else if (eachCh == '?') { // 如果包含問號
                strIndex++;
                if (strIndex > strLength) { // 如果str中沒有字符可以比對「?」號
                    return false;
                }
            } else { // 如果要尋找的是普通的檔案
                if ((strIndex >= strLength) || (eachCh != str.charAt(strIndex))) { // 如果沒有尋找到比對的檔案
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }
}
