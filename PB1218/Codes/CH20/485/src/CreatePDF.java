import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

public class CreatePDF {
    /**
     * @param args
     */

public void writePDF(String fileName) {
    File file = new File(fileName); // �ھڰѼƫإ�File�ﹳ
    FileOutputStream out = null; // �إ�FileOutputStream���
    Document documentPDF = new Document(PageSize.A5, 50, 50, 50, 50); // �إ�PDF���ﹳ
    try {
        out = new FileOutputStream(file); // ��Ҥ�FileOutputStream�ﹳ
        PdfWriter writer = PdfWriter.getInstance(documentPDF, out); // ��Document�ﹳ�إ߼g�J��
        documentPDF.open(); // �}�һP�ؼ��ɮת��s��
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 18.2f,
                Font.BOLDITALIC, new BaseColor(255, 0, 0));// �w�q�r��
        Paragraph chapter = new Paragraph(); // �w�q�q���ﹳ
        Chapter chapter1 = new Chapter(chapter, 1); // �إ߳��`�ﹳ
        chapter1.setNumberDepth(0); // �N�s���ŧO�]�w��0�A��ܤ��|�b��������ܳ��`�s��
        font = FontFactory.getFont(FontFactory.HELVETICA, 16.0f, Font.BOLD,
                new BaseColor(255, 0, 0)); // �w�q�r��P�r���C��
        Paragraph section1_title1 = new Paragraph("frist itxt PDF", font); // �V��󤤴��J���e
        Section section1 = chapter1.addSection(section1_title1);
        Paragraph text = new Paragraph("this is frist text");
        section1.add(text); // �V��󤤼W�[���`
        documentPDF.add(chapter1);
        documentPDF.close(); // �������
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