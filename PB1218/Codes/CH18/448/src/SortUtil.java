import java.io.*;
import java.util.*;
public class SortUtil {
  //��o�ϺЩҦ��ɮפ�k
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
          tmp=list.removeFirst();           //�����öǦ^���X���Ĥ@��
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
    //�إ��ɮק���k
    
public void createFolder(String strPath) {
    try {      
        File myFilePath = new File(strPath);        //�ھ��ɮצa�}�إ�File�ﹳ
        if (!myFilePath.exists()) { //�p�G���w��File�ﹳ���s�b
            myFilePath.mkdir();     //�إߥؿ�
        }
    } catch (Exception e) {
        System.out.println("�s�W�ɮק��ާ@�X��");
        e.printStackTrace();
    }
}
    
    //�ƻs�ɮפ�k
    public void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // �ɮצs�b��
                InputStream inStream = new FileInputStream(oldPath); // Ū�J���ɮ�
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // �r�`�� �ɮפj�p
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