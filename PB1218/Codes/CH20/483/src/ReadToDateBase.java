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
    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead)); // 建立對Excel工作簿檔案的參考          
    HSSFSheet sheet = workbook.getSheet("員工表");  // 建立對工作表的參考。
    int rows = sheet.getPhysicalNumberOfRows();         //獲得表格的行數         
    for (int r = 1; r < rows; r++) {                //循環檢查表格的行
        String value ="";                           //定義儲存讀取內容的String對像
        HSSFRow row = sheet.getRow(r);              //獲得單元格中指定的行對像  
        if (row != null) {
           int  cells = row.getPhysicalNumberOfCells(); //獲得單元格中指定列對像
            for (short c = 1; c < cells; c++) {      //循環檢查單元格中的列                  
                HSSFCell cell = row.getCell((short) c); //獲得指定單元格中的列                      
                if (cell != null) {
                    if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {  //判斷單元格的值是否為字串型態                                
                        value += cell.getStringCellValue()+",";
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {  //判斷單元格的值是否為數字型態                                
                        value += cell.getNumericCellValue()+",";
                    } else if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){    //判斷單元格的值是否為布爾型態                      
                        value += cell.getStringCellValue()+",";
                    }
                }                       
            }                  
        }
        String [] str = value.split(",");           //將字串進行分割
        util.insertEmp(str);                    //呼叫向資料函數庫插入資料方法
    }   
} catch (Exception e) {
    e.printStackTrace();            
}
    }
}
