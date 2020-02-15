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
        /** Excel 檔案要存放的位置，假設在C碟根目錄下 */
        String outputFile = "c://temps.xls";
        // 建立新的Excel 工作簿
        HSSFWorkbook excelbook = new HSSFWorkbook();
        // 如要新增一名為"薪水表"的工作表，其敘述為：
        HSSFSheet sheet = excelbook.createSheet("薪水表");
        // 在索引0的位置建立行（最頂端的行）
        HSSFRow row = sheet.createRow((short) 0);
        // 在索引0的位置建立單元格（左上端）
        HSSFCell monadism = row.createCell(0);
        // 定義單元格為字串型態
        monadism.setCellType(HSSFCell.CELL_TYPE_STRING);
        // 在單元格中輸入一些內容
        monadism.setCellValue("名稱");
        // 在第一行第二列增加內容
        HSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("單價");
        row.createCell(2).setCellValue("重量");
        row.createCell(3).setCellValue("價錢");
        for (int i = 1; i <= 5; i++) { // 透過for循環建立表格
            HSSFRow row2 = sheet.createRow(i); // 在工作薄中建立一行
            row2.createCell(0).setCellValue("蘋果"); // 在工作薄行中新增一列
            row2.createCell(1).setCellValue(i); // 設定單元格值
            row2.createCell(2).setCellValue(1.2);
            row2.createCell(3).setCellFormula(
                    "B" + (i + 1) + "*C" + (i + 1) + ""); // 為單元格增加公式
        }
        // 新增輸出檔案流
        FileOutputStream out = new FileOutputStream(outputFile);
        // 把對應的Excel工作簿存碟
        excelbook.write(out);
        out.flush();
        // 操作結束，關閉檔案
        out.close();
        System.out.println("檔案建立成功！！！");
    } catch (Exception e) {
        e.printStackTrace();
    }    
}
    
}
