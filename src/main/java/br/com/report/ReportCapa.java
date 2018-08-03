package br.com.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.report.exception.ReportException;
/**
 * 
 * Projeto: reportpdf.ReportCapa<BR>
 * Classe que monta a capa da evid?ncia pdf TODO<BR>
 * @since 5 de jun de 2017 16:07:03
 */
public class ReportCapa {

	private Document document;
	private ColumnText descText;
	private Font tituloFormatacao = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.BLACK);
	private Font subtituloFormatacao = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.GRAY);
	private PdfWriter writer;

	public ColumnText getDescText() {
		return descText;
	}

	public ReportCapa(Document document, float margin, String path) {
		this.document = document;
		document.open();
		document.setMargins(margin, margin, margin, margin);

		try {
			this.writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	public void setCapa(String testName, String objective) {
		
		Paragraph titulo = new Paragraph(testName, tituloFormatacao);

		
			document.open();
			
			if (!document.isOpen() == true){
				Document document = new Document();
				this.document = document;
				document.open();
			}
			
			// Load and configure Logo
			ReportLogo imgLogo = new ReportLogo("resource/logo.jpg", 30f, 750f, 140f, 50f);
			ReportLogo imgCap = new ReportLogo("resource/cap.png", 300f, 0f);
			try {
				document.add(imgLogo.getImage());
			} catch (DocumentException e) {
				throw new ReportException(e);
			}
			try {
				document.add(imgCap.getImage());
			} catch (DocumentException e) {
				throw new ReportException(e);
			}

			// Add Title
			ColumnText title = addTextArea(30, 400, 560, 720);
			title.addText(titulo);
			title.setLeading(23);
			try {
				title.go();
			} catch (DocumentException e) {
				throw new ReportException(e);
			}

			// Add objective
			ColumnText obj = addTextArea(30, 340, 560, 460);
			titulo = new Paragraph(70, objective, subtituloFormatacao);
			obj.addText(new Paragraph(titulo));
			try {
				obj.go();
			} catch (DocumentException e) {
				throw new ReportException(e);
			}

			// Set status
			String info = "Nome: Automacao\nData: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date())
					+ "\nHora da execu??o: " + new SimpleDateFormat("HH:mm:ss").format(new Date())
					+ "\r\rio logado: " + System.getProperty("user.name");

			Paragraph p = new Paragraph(70, info);
			PdfTemplate status = writer.getDirectContent().createTemplate(200, 200);
			writer.getDirectContent().addTemplate(status, 0, 30);
			descText = addTextArea(40, 30, 350, 150, status);
			descText.addText(p);
			try {
				descText.go();
			} catch (DocumentException e) {
					throw new ReportException(e);
			}
			document.newPage();
		}

	private ColumnText addTextArea(int startX, int endX, int startY, int endY, PdfContentByte contentByte) {
		ColumnText ct = new ColumnText(contentByte);
		ct.setSimpleColumn(startX, endX, startY, endY);
		return ct;
	}

	private ColumnText addTextArea(int startX, int endX, int startY, int endY) {
		return addTextArea(startX, endX, startY, endY, writer.getDirectContent());
	}

	public void setStatus(Boolean isPassed) {
		if (isPassed) {
			Font f = new Font();
			f.setColor(BaseColor.GREEN);
			descText.addText(new Phrase("Status: Passed", f));
		} else {
			Font f = new Font();
			f.setColor(BaseColor.RED);
			descText.addText(new Phrase("Status: Failed", f));
		}
		try {
			descText.go();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
