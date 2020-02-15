import java.io.*;
import java.util.*;
public class SortUtil {
  //獲得磁碟所有檔案方法
    public List getList(String path){
         LinkedList<File> list=new LinkedList<File>();
         ArrayList<String> listPath = new ArrayList<String>();
         File dir=new File(path);
         File file[]=dir.listFiles();
         for(int i=0;i<file.length;i++){
          if(file[i].isDirectory())
           list.add(file[i]);
          else{
              listPath.add(file[i].getAbsolutePath());
          }             
         }
         File tmp;
         while(!list.isEmpty()){
          tmp=list.removeFirst();           //移除並傳回集合中第一項
          if(tmp.isDirectory()){
           file=tmp.listFiles();
           if(file==null)continue;
           for(int i=0;i<file.length;i++){
            if(file[i].isDirectory())
             list.add(file[i]);
            else{
                 listPath.add(file[i].getAbsolutePath());
            }     
            
           }
          }else{
      
          }
         }
         return listPath;
    }
    //建立檔案夾方法
    
public void createFolder(String strPath) {
    try {      
        File myFilePath = new File(strPath);        //根據檔案地址建立File對像
        if (!myFilePath.exists()) { //如果指定的File對像不存在
            myFilePath.mkdir();     //建立目錄
        }
    } catch (Exception e) {
        System.out.println("新增檔案夾操作出錯");
        e.printStackTrace();
    }
}
    
    //複製檔案方法
    public void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 檔案存在時
                InputStream inStream = new FileInputStream(oldPath); // 讀入原檔案
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字節數 檔案大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
