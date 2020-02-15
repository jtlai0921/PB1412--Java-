import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;

public class CreateExcelUseformula {
    
    /**
     * @param args
     */
    
public static void main(String[] args) {
    try {
        /** Excel �ɮ׭n�s�񪺦�m�A���]�bC�Юڥؿ��U */
        String outputFile = "c://temps.xls";
        // �إ߷s��Excel �u�@ï
        HSSFWorkbook excelbook = new HSSFWorkbook();
        // �p�n�s�W�@�W��"�~����"���u�@��A��ԭz���G
        HSSFSheet sheet = excelbook.createSheet("�~����");
        // �b����0����m�إߦ�]�̳��ݪ���^
        HSSFRow row = sheet.createRow((short) 0);
        // �b����0����m�إ߳椸��]���W�ݡ^
        HSSFCell monadism = row.createCell(0);
        // �w�q�椸�欰�r�ꫬ�A
        monadism.setCellType(HSSFCell.CELL_TYPE_STRING);
        // �b�椸�椤��J�@�Ǥ��e
        monadism.setCellValue("�W��");
        // �b�Ĥ@��ĤG�C�W�[���e
        HSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("���");
        row.createCell(2).setCellValue("���q");
        row.createCell(3).setCellValue("����");
        for (int i = 1; i <= 5; i++) { // �z�Lfor�`���إߪ��
            HSSFRow row2 = sheet.createRow(i); // �b�u�@�����إߤ@��
            row2.createCell(0).setCellValue("ī�G"); // �b�u�@���椤�s�W�@�C
            row2.createCell(1).setCellValue(i); // �]�w�椸���
            row2.createCell(2).setCellValue(1.2);
            row2.createCell(3).setCellFormula(
                    "B" + (i + 1) + "*C" + (i + 1) + ""); // ���椸��W�[����
        }
        // �s�W��X�ɮ׬y
        FileOutputStream out = new FileOutputStream(outputFile);
        // �������Excel�u�@ï�s��
        excelbook.write(out);
        out.flush();
        // �ާ@�����A�����ɮ�
        out.close();
        System.out.println("�ɮ׫إߦ��\�I�I�I");
    } catch (Exception e) {
        e.printStackTrace();
    }    
}
    
}
