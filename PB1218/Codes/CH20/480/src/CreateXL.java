import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateXL {
    /** Excel 檔案要存放的位置，假設在C碟根目錄下 */
    String outputFile = "c:/temp.xls";
    static HSSFSheet sheet = null;
    HSSFWorkbook excelbook;
    
    // 定義產生Excel表格方法
    
public void createExcel() {
    try {
        sheet = excelbook.createSheet("薪水表"); // 在索引0的位置建立行（最頂端的行）
        HSSFRow row = sheet.createRow((short) 0);
        HSSFCell monadism = row.createCell((short) 0); // 在索引0的位置建立單元格（左上端）
        monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
        monadism.setCellValue("姓名");// 在單元格中輸入一些內容
        row.createCell((short) 1).setCellValue("性別"); // 在第一行第二列增加內容
        row.createCell((short) 2).setCellValue("年齡");
        row.createCell((short) 3).setCellValue("部門");
        row.createCell((short) 4).setCellValue("職位");
        row.createCell((short) 5).setCellValue("薪水資訊");
        FileOutputStream out = new FileOutputStream(outputFile); // 新增輸出檔案流
        excelbook.write(out);// 把對應的Excel工作簿存碟
        out.flush();
        out.close(); // 操作結束，關閉檔案
        System.out.println("檔案建立成功！！！");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    // 向員工表中增加資料方法

public void insertvalue(String name, String sex, String age, String dept,
        String job, String laborage) {
    try {
        excelbook = new HSSFWorkbook(new FileInputStream(outputFile));  //定義Excel表對像
        HSSFSheet sheet = excelbook.getSheet("薪水表");        //獲得指定的工作表
        int count = sheet.getPhysicalNumberOfRows();        //獲得工作表中總體行數
        HSSFRow row = sheet.createRow((short) count);       //新增一行
        row.createCell((short) 0).setCellValue(name);        // 在索引0的位置建立單元格（左上端）
        row.createCell((short) 1).setCellValue(sex);
        row.createCell((short) 2).setCellValue(age);
        row.createCell((short) 3).setCellValue(dept);
        row.createCell((short) 4).setCellValue(job);
        row.createCell((short) 5).setCellValue(laborage);        
        FileOutputStream out;// 新增輸出檔案流        
        out = new FileOutputStream(outputFile);
        excelbook.write(out);// 把對應的Excel工作簿存碟
        out.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
