import java.io.File;

import java.io.FileOutputStream;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;

import java.sql.*;

/**
 * . * Microsoft Excel 寫入器。
 * . *
 * . * @author HeDYn
 * . * @version --
 * .
 */
public class ExcelWriter {
    
    private File xlsFile = null;
    private String dateFormat = null;
    
    private HSSFWorkbook workbook = null;
    private SimpleDateFormat dateFormatter = null;
    
    /**
     * . * 建立一個Excel檔案寫入器，所有資料將寫入到指定的xls檔案中
     * . *
     * . * @param xlsFile 指定目標檔案位置，原位置已存在同名檔案將被覆蓋
     * .
     */
    public ExcelWriter(File xlsFile) {
        this(xlsFile, null);
        
    }
    
/**
 * . * 建立一個Excel檔案寫入器，所有資料將寫入到指定的xls檔案中；
 * . * 寫入日期時以指定格式形式寫入
 * . *
 * . * @param xlsFile 指定目標檔案位置，原位置已存在同名檔案將被覆蓋
 * . * @param dateFormat 日期格式，如果為null則按本機日期格式
 * .
 */
public ExcelWriter(File xlsFile, String dateFormat) {
    this.xlsFile = xlsFile;
    workbook = new HSSFWorkbook();
    try {
        FileOutputStream fileoUut = new FileOutputStream(xlsFile);
        workbook.write(fileoUut);
        fileoUut.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    /**
     * 寫入資料函數庫結果集的列名及資料到指定工作薄
     */

private void writeSheet(File file, ResultSet resultSet) throws SQLException {
    HSSFWorkbook book = new HSSFWorkbook(); // 定義工作薄對像
    HSSFSheet sheet = book.createSheet("員工表"); // 建立工作表
    ResultSetMetaData metaData = resultSet.getMetaData(); // 獲得關於 ResultSet對像中列的型態和屬性資訊的對象。
    int rowNum = 0;
    HSSFRow header = sheet.createRow(rowNum); // 寫入列名
    int colCount = metaData.getColumnCount(); // 獲得資料函數庫表中共有幾列
    for (int i = 0; i < colCount; i++) { // 循環檢查資料表列名
        HSSFCell cell = header.createCell(i); // 根據資料函數庫內容建立單元格
        writeCell(cell, metaData.getColumnLabel(i + 1)); // 將資料函數庫中的內容寫入到單元格內
    }
    while (resultSet.next()) { // 循環檢查查詢結果集
        rowNum++;
        HSSFRow row = sheet.createRow(rowNum); // 建立一行
        for (int i = 0; i < colCount; i++) {
            HSSFCell cell = row.createCell(i); // 新增單元格
            writeCell(cell, resultSet.getObject(i + 1)); // 將結果集中內容寫入到單元格中
        }
    }
    try {
        FileOutputStream fileO = new FileOutputStream(file); // 建立FileOutputStream對像
        book.write(fileO);
        fileO.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    /**
     * 寫入資料到指定單元格
     */
    
private void writeCell(HSSFCell hssFcell, Object object) {
    if (object instanceof Date) { // 判斷要寫入的數值是否為日期型態
        Date d = (Date) object;
        hssFcell.setCellValue(new HSSFRichTextString(dateFormatter
                .format(d)));// 日期以文字形式寫入
    } else if (object instanceof Boolean) { // 判斷要寫入的數值是否為布爾型態
        boolean b = (Boolean) object;
        hssFcell.setCellValue(b); // 向表格寫入資料
    } else if (object instanceof Number) { // 判斷要寫入的資料是否為數值型態
        double d = ((Number) object).doubleValue();
        hssFcell.setCellValue(d);// 向表格寫資料
    } else {
        String s = (String) object;
        hssFcell.setCellValue(new HSSFRichTextString(s));
    }
}

public ResultSet getRest() {
    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection conn = null;
    String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // 定義連接資料函數庫的url
    String userName = "sa"; // 連接資料函數庫的使用者名稱
    String passWord = ""; // 連接資料函數庫的密碼
    try {
        conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ResultSet rest = null;
    // 定義查詢的SQL敘述
    String sql = "select * from tb_emp";
    Statement statement;
    try {
        statement = conn.createStatement(); // 建立Statement實例
        rest = statement.executeQuery(sql); // 執行SQL敘述
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return rest;
}
    
    public static void main(String[] args) {
        File file = new File("c:\\temp.xls");
        ExcelWriter excelWriter = new ExcelWriter(file);
        ResultSet rest = excelWriter.getRest();
        try {
            excelWriter.writeSheet(file, rest);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
