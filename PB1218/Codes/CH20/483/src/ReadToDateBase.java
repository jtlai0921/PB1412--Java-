import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;
public class ReadToDateBase {
    static JDBCUtil util = new JDBCUtil();
    public static void main(String[] args) {
String fileToBeRead = "c:\\temp.xls";
try {           
    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead)); // �إ߹�Excel�u�@ï�ɮת��Ѧ�          
    HSSFSheet sheet = workbook.getSheet("���u��");  // �إ߹�u�@���ѦҡC
    int rows = sheet.getPhysicalNumberOfRows();         //��o��檺���         
    for (int r = 1; r < rows; r++) {                //�`���ˬd��檺��
        String value ="";                           //�w�q�x�sŪ�����e��String�ﹳ
        HSSFRow row = sheet.getRow(r);              //��o�椸�椤���w����ﹳ  
        if (row != null) {
           int  cells = row.getPhysicalNumberOfCells(); //��o�椸�椤���w�C�ﹳ
            for (short c = 1; c < cells; c++) {      //�`���ˬd�椸�椤���C                  
                HSSFCell cell = row.getCell((short) c); //��o���w�椸�椤���C                      
                if (cell != null) {
                    if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {  //�P�_�椸�檺�ȬO�_���r�ꫬ�A                                
                        value += cell.getStringCellValue()+",";
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {  //�P�_�椸�檺�ȬO�_���Ʀr���A                                
                        value += cell.getNumericCellValue()+",";
                    } else if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){    //�P�_�椸�檺�ȬO�_���������A                      
                        value += cell.getStringCellValue()+",";
                    }
                }                       
            }                  
        }
        String [] str = value.split(",");           //�N�r��i�����
        util.insertEmp(str);                    //�I�s�V��ƨ�Ʈw���J��Ƥ�k
    }   
} catch (Exception e) {
    e.printStackTrace();            
}
    }
}
