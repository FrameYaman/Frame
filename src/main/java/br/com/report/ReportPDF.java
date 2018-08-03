package br.com.report;

import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;

import br.com.report.exception.ReportException;
import br.com.report.iterfaces.Report;

/**
 * 
 * Projeto: reportpdf.ReportPDF<BR>
 * Classe respons?vel por implementar m?todos da interface Report TODO<BR>
 * 
 * @since 5 de jun de 2017 16:09:31
 */
public class ReportPDF implements Report {

	private final float MARGIN = 20;
	private String path = Paths.get("").toAbsolutePath().toString() + "//Evidences//" + Thread.currentThread().getName()
			+ ".pdf";
	private Document document = new Document();
	private ReportCapa capa = new ReportCapa(document, MARGIN, path);
	private ContentPDF contentPDF = new ContentPDF(document, MARGIN);

	@Override
	public void setCover(String titulo, String objetivo) {
		capa.setCapa(titulo, objetivo);
	}

	@Override
	public void addStep(String description, byte[] imagem) {
		contentPDF.addStep(description, imagem);

	}

	@Override
	public void addStep(String description, String fontName, float size, int style, BaseColor color, byte[] imagem) {
		contentPDF.addStep(description, fontName, size, style, color, imagem);

	}

	@Override
	public void addStep(byte[] imagem) {
		contentPDF.addStep(imagem);
	}

	@Override
	@Deprecated
	public void addMainframeStep(String description) {
		contentPDF.addMainframeStep(description);

	}

	@Override
	public void addMainframeStep(String description, PdfPTable[] screenshot) {
		contentPDF.addMainframeStep(description, screenshot);

	}

	@Override
	public void addMainframeStep(PdfPTable[] screenshot) {
		contentPDF.addMainframeStep(screenshot);

	}

	@Override
	public void addText(String description, String fontName, float size, int style, BaseColor color) {
		contentPDF.addText(description, fontName, size, style, color);
	}

	@Override
	public void addText(String description) {
		contentPDF.addText(description, FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
	}

	@Override
	public void save(boolean isPassed) {
		save(this.path, isPassed);
	}

	@Override
	public void save(boolean isPassed, WebDriver driver) {
		save(this.path, isPassed, driver);
	}


	private void save(String path, boolean isPassed) {
		try {
			this.automationType();
			capa.setStatus(isPassed);
			document.close();
			ReportManager.addEvidence(Paths.get(path));
		} catch (IOException e) {
			throw new ReportException(e);
		}
	}

	private void save(String path, boolean isPassed, WebDriver driver) {
		try {
			this.automationType(driver);
			capa.setStatus(isPassed);
			document.close();
			ReportManager.addEvidence(Paths.get(path));
		} catch (IOException e) {
			throw new ReportException(e);
		}
	}

	@Override
	public void automationType() {
		capa.getDescText().addText(new Phrase("Automa??o: Arquivo"));
		try {
			capa.getDescText().go();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void automationType(WebDriver driver) {
		String browserVersion;
		browserVersion = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase() + " "
				+ ((RemoteWebDriver) driver).getCapabilities().getVersion().toString();
		capa.getDescText().addText(new Phrase("Browser: " + browserVersion));
		try {
			capa.getDescText().go();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}


}
