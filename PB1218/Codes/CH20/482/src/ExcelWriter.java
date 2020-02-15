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
 * . * Microsoft Excel �g�J���C
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
     * . * �إߤ@��Excel�ɮ׼g�J���A�Ҧ���ƱN�g�J����w��xls�ɮפ�
     * . *
     * . * @param xlsFile ���w�ؼ��ɮצ�m�A���m�w�s�b�P�W�ɮױN�Q�л\
     * .
     */
    public ExcelWriter(File xlsFile) {
        this(xlsFile, null);
        
    }
    
/**
 * . * �إߤ@��Excel�ɮ׼g�J���A�Ҧ���ƱN�g�J����w��xls�ɮפ��F
 * . * �g�J����ɥH���w�榡�Φ��g�J
 * . *
 * . * @param xlsFile ���w�ؼ��ɮצ�m�A���m�w�s�b�P�W�ɮױN�Q�л\
 * . * @param dateFormat ����榡�A�p�G��null�h����������榡
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
     * �g�J��ƨ�Ʈw���G�����C�W�θ�ƨ���w�u�@��
     */

private void writeSheet(File file, ResultSet resultSet) throws SQLException {
    HSSFWorkbook book = new HSSFWorkbook(); // �w�q�u�@���ﹳ
    HSSFSheet sheet = book.createSheet("���u��"); // �إߤu�@��
    ResultSetMetaData metaData = resultSet.getMetaData(); // ��o���� ResultSet�ﹳ���C�����A�M�ݩʸ�T����H�C
    int rowNum = 0;
    HSSFRow header = sheet.createRow(rowNum); // �g�J�C�W
    int colCount = metaData.getColumnCount(); // ��o��ƨ�Ʈw���@���X�C
    for (int i = 0; i < colCount; i++) { // �`���ˬd��ƪ�C�W
        HSSFCell cell = header.createCell(i); // �ھڸ�ƨ�Ʈw���e�إ߳椸��
        writeCell(cell, metaData.getColumnLabel(i + 1)); // �N��ƨ�Ʈw�������e�g�J��椸�椺
    }
    while (resultSet.next()) { // �`���ˬd�d�ߵ��G��
        rowNum++;
        HSSFRow row = sheet.createRow(rowNum); // �إߤ@��
        for (int i = 0; i < colCount; i++) {
            HSSFCell cell = row.createCell(i); // �s�W�椸��
            writeCell(cell, resultSet.getObject(i + 1)); // �N���G�������e�g�J��椸�椤
        }
    }
    try {
        FileOutputStream fileO = new FileOutputStream(file); // �إ�FileOutputStream�ﹳ
        book.write(fileO);
        fileO.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    /**
     * �g�J��ƨ���w�椸��
     */
    
private void writeCell(HSSFCell hssFcell, Object object) {
    if (object instanceof Date) { // �P�_�n�g�J���ƭȬO�_��������A
        Date d = (Date) object;
        hssFcell.setCellValue(new HSSFRichTextString(dateFormatter
                .format(d)));// ����H��r�Φ��g�J
    } else if (object instanceof Boolean) { // �P�_�n�g�J���ƭȬO�_���������A
        boolean b = (Boolean) object;
        hssFcell.setCellValue(b); // �V���g�J���
    } else if (object instanceof Number) { // �P�_�n�g�J����ƬO�_���ƭȫ��A
        double d = ((Number) object).doubleValue();
        hssFcell.setCellValue(d);// �V���g���
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
    String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // �w�q�s����ƨ�Ʈw��url
    String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
    String passWord = ""; // �s����ƨ�Ʈw���K�X
    try {
        conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ResultSet rest = null;
    // �w�q�d�ߪ�SQL�ԭz
    String sql = "select * from tb_emp";
    Statement statement;
    try {
        statement = conn.createStatement(); // �إ�Statement���
        rest = statement.executeQuery(sql); // ����SQL�ԭz
        
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