package mypack;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.ResultSet;

public class PDF {
   public static void main(String[] args) {
    }
    
    public void make(ResultSet rs) {
        try {
            // Create a filename
            System.out.println(System.getProperty("user.dir"));
            String filename = System.getProperty("user.dir") + "\\Practice.pdf";

            // Open the document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            // Add Content
        
            Paragraph para = new Paragraph("LIbrary Management System");
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            para=new Paragraph(" ");
            document.add(para);
            document.add(para);
            document.add(para);
             
            BaseFont bf=BaseFont.createFont("C:\\Users\\M.S.SAKTHIVEL\\Documents\\NetBeansProjects\\Practice\\src\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font ff=new Font(bf, 10.0f, Font.NORMAL, BaseColor.BLACK);
            Font fh=new Font(bf, 10.0f, Font.BOLD, BaseColor.BLACK);
            PdfPTable table=new PdfPTable(6);
            float[] columnWidths = new float[] {10f, 20f, 10f, 13f, 13f, 30f};
            table.setWidths(columnWidths);
            

            PdfPCell c=new PdfPCell(new Phrase("User Id",fh));
            c.setFixedHeight(50.0f);
            table.addCell(c);
            
            c=new PdfPCell(new Phrase("User Name",fh));
            c.setFixedHeight(50.0f);
            table.addCell(c);
            
            c=new PdfPCell(new Phrase("Book Id",fh));
            c.setFixedHeight(50.0f);
            table.addCell(c);
            
            c=new PdfPCell(new Phrase("Start Date",fh));
            c.setFixedHeight(50.0f);
            table.addCell(c);
            
            c=new PdfPCell(new Phrase("End date",fh));
            c.setFixedHeight(50.0f);
            table.addCell(c);
            
            c=new PdfPCell(new Phrase("gmail",fh));
            c.setFixedHeight(50.0f);
            table.addCell(c);
            
            
            table.setHeaderRows(1);
            
            while (rs.next()){
                c=new PdfPCell(new Phrase(rs.getString(1),ff));
                c.setFixedHeight(30.0f);
                table.addCell(c);
                c=new PdfPCell(new Phrase(rs.getString(2),ff));
                c.setFixedHeight(30.0f);
                table.addCell(c);
                c=new PdfPCell(new Phrase(rs.getString(3),ff));
                c.setFixedHeight(30.0f);
                table.addCell(c);
                c=new PdfPCell(new Phrase(rs.getString(4),ff));
                c.setFixedHeight(30.0f);
                table.addCell(c);
                c=new PdfPCell(new Phrase(rs.getString(5),ff));
                c.setFixedHeight(30.0f);
                table.addCell(c);
                c=new PdfPCell(new Phrase(rs.getString(6),ff));
                c.setFixedHeight(30.0f);
                table.addCell(c);
            }
            document.add(table);

            // Close the document
            document.close();
        
            System.out.println("End of try block");
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
