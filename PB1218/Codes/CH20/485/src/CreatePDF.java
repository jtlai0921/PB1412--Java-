import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

public class CreatePDF {
    /**
     * @param args
     */

public void writePDF(String fileName) {
    File file = new File(fileName); // 根據參數建立File對像
    FileOutputStream out = null; // 建立FileOutputStream實例
    Document documentPDF = new Document(PageSize.A5, 50, 50, 50, 50); // 建立PDF文件對像
    try {
        out = new FileOutputStream(file); // 實例化FileOutputStream對像
        PdfWriter writer = PdfWriter.getInstance(documentPDF, out); // 為Document對像建立寫入器
        documentPDF.open(); // 開啟與目標檔案的連接
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 18.2f,
                Font.BOLDITALIC, new BaseColor(255, 0, 0));// 定義字體
        Paragraph chapter = new Paragraph(); // 定義段落對像
        Chapter chapter1 = new Chapter(chapter, 1); // 建立章節對像
        chapter1.setNumberDepth(0); // 將編號級別設定為0，表示不會在頁面中顯示章節編號
        font = FontFactory.getFont(FontFactory.HELVETICA, 16.0f, Font.BOLD,
                new BaseColor(255, 0, 0)); // 定義字體與字體顏色
        Paragraph section1_title1 = new Paragraph("frist itxt PDF", font); // 向文件中插入內容
        Section section1 = chapter1.addSection(section1_title1);
        Paragraph text = new Paragraph("this is frist text");
        section1.add(text); // 向文件中增加章節
        documentPDF.add(chapter1);
        documentPDF.close(); // 關閉文件
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        CreatePDF paf = new CreatePDF();
        paf.writePDF("C://temp.pdf");
        
    }
}
