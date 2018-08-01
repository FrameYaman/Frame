package suporte;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;
 
import java.io.File;
import java.io.IOException;


/**
 * Simple Hello World example.
 */
@WrapToTest
public class ReportPDF {
	
	 
	    public static final String DEST = "target/screenshot/guilherme_gay.pdf";
	 
	    public static void main(String args[]) throws IOException {
	        File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        new ReportPDF().createPdf(DEST);
	    }
	 
	    public void createPdf(String dest) throws IOException {
	        //Initialize PDF writer
	        PdfWriter writer = new PdfWriter(dest);
	 
	        //Initialize PDF document
	        PdfDocument pdf = new PdfDocument(writer);
	 
	        // Initialize document
	        Document document = new Document(pdf);
	 
	        //Add paragraph to the document
	        document.add(new Paragraph("Guilerme Gay!"));
	 
	        //Close document
	        document.close();
	    }
			
}
