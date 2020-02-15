import java.io.FileInputStream;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.ProgressMonitorInputStream;
public class ProgressMonitorTest {
    
    public void useProgressMonitor(JFrame frame, String copyPath, String newPath) {
        try {
            File file = new File(copyPath); // �ھڭn�ƻs���ɮ׫إ�File�ﹳ
            File newFile = new File(newPath); // �ھڽƻs���ɮת��x�s�a�}�إ�File�ﹳ
            FileOutputStream fop = new FileOutputStream(newFile); // �إ�FileOutputStream�ﹳ
            InputStream in = new FileInputStream(file);
            // Ū���ɮסA�p�G�`�ӮɶW�L2��A�N�|�۰ʥX�{�@�Ӷi�׺ʵ������C
            ProgressMonitorInputStream pm = new ProgressMonitorInputStream(
                    frame, "�ɮ�Ū�����A�еy��...", in);
            int c = 0;
            byte[] bytes = new byte[1024]; // �w�qbyte�}�C
            while ((c = pm.read(bytes)) != -1) { // �`��Ū���ɮ�
                fop.write(bytes, 0, c); // �z�L�y�g���
            }
            fop.close(); // ������X�y
            pm.close(); // ������J�y
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
