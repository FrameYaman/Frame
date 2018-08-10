package suporte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Rule;
import org.junit.rules.TestName;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("unused")
public class Report {

	public void Pdf(String text) {

		Image img;
		Document document = new Document();
		
		String result = "C:\\Report\\Report.pdf";
		
		try {
			
			img = Image.getInstance(
					"C:\\Users\\jaderson.macedo\\Documents\\Frames\\Java\\Yaman\\FrameWorkYaman2\\target\\screenshot\\testeAberturaPage.png");
			document.setPageSize(PageSize.A4);
			document.setMargins(10, 10, 1, 1);
			document.setMarginMirroringTopBottom(true);

			PdfWriter.getInstance(document, new FileOutputStream(result));
			document.open();

			img.scaleToFit(500, 800);

			Paragraph texto = new Paragraph(text, FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
			texto.setAlignment(Element.ALIGN_JUSTIFIED);

			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph("testeEnvioContato"));
			document.add(new Paragraph(texto));
			document.add(img);
			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------------"));
			document.close();

		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}