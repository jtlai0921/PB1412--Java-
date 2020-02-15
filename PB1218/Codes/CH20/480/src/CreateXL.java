import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateXL {
    /** Excel �ɮ׭n�s�񪺦�m�A���]�bC�Юڥؿ��U */
    String outputFile = "c:/temp.xls";
    static HSSFSheet sheet = null;
    HSSFWorkbook excelbook;
    
    // �w�q����Excel����k
    
public void createExcel() {
    try {
        sheet = excelbook.createSheet("�~����"); // �b����0����m�إߦ�]�̳��ݪ���^
        HSSFRow row = sheet.createRow((short) 0);
        HSSFCell monadism = row.createCell((short) 0); // �b����0����m�إ߳椸��]���W�ݡ^
        monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // �w�q�椸�欰�r�ꫬ�A
        monadism.setCellValue("�m�W");// �b�椸�椤��J�@�Ǥ��e
        row.createCell((short) 1).setCellValue("�ʧO"); // �b�Ĥ@��ĤG�C�W�[���e
        row.createCell((short) 2).setCellValue("�~��");
        row.createCell((short) 3).setCellValue("����");
        row.createCell((short) 4).setCellValue("¾��");
        row.createCell((short) 5).setCellValue("�~����T");
        FileOutputStream out = new FileOutputStream(outputFile); // �s�W��X�ɮ׬y
        excelbook.write(out);// �������Excel�u�@ï�s��
        out.flush();
        out.close(); // �ާ@�����A�����ɮ�
        System.out.println("�ɮ׫إߦ��\�I�I�I");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    // �V���u���W�[��Ƥ�k

public void insertvalue(String name, String sex, String age, String dept,
        String job, String laborage) {
    try {
        excelbook = new HSSFWorkbook(new FileInputStream(outputFile));  //�w�qExcel��ﹳ
        HSSFSheet sheet = excelbook.getSheet("�~����");        //��o���w���u�@��
        int count = sheet.getPhysicalNumberOfRows();        //��o�u�@���`����
        HSSFRow row = sheet.createRow((short) count);       //�s�W�@��
        row.createCell((short) 0).setCellValue(name);        // �b����0����m�إ߳椸��]���W�ݡ^
        row.createCell((short) 1).setCellValue(sex);
        row.createCell((short) 2).setCellValue(age);
        row.createCell((short) 3).setCellValue(dept);
        row.createCell((short) 4).setCellValue(job);
        row.createCell((short) 5).setCellValue(laborage);        
        FileOutputStream out;// �s�W��X�ɮ׬y        
        out = new FileOutputStream(outputFile);
        excelbook.write(out);// �������Excel�u�@ï�s��
        out.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
