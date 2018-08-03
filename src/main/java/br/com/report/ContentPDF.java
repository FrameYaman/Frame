package br.com.report;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

import br.com.report.exception.ReportException;

/**
 * 
 * Projeto: reportpdf.ContentPDF<BR>
 * Classe que guarda m?todos que v?o adicionar recursos eevid?ncia <BR>
 * 
 * @since 5 de jun de 2017 16:03:50
 */
public class ContentPDF {
	private Document document;
	private Font dadosFormatacao = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL);
	private float margin;

	public ContentPDF(Document document, float margin) {
		this.document = document;
		this.margin = margin;
	}

	/**
	 * 
	 * Inmetrics<BR>
	 * Projeto: reportpdf.ContentPDF.addStep<BR>
	 * Adiciona um texto e uma imagem e evidencia TODO<BR>
	 * 
	 * @since 5 de jun de 2017 16:04:44
	 * @author AndreMoreira<BR>
	 * @param description
	 * @param imagem
	 */
	public void addStep(String description, byte[] imagem) {
		try {
			if (this.document.isOpen() == true) {
				ReportManager.clearTextReport(Thread.currentThread().getName());
				this.document.newPage();
				this.document.add(new Paragraph(description, dadosFormatacao));
			} else {
				StringBuilder report = new StringBuilder();
				for (String t : ReportManager.getTextReport(Thread.currentThread().getName())) {
					report.append(t);
				}
				report.append("\n" + description);
				document.add(new Paragraph(report.toString(), dadosFormatacao));
			}
			setImage(imagem);
		} catch (DocumentException e) {
			throw new ReportException(e);
		}
	}

	/**
	 * 
	 * Inmetrics<BR>
	 * Projeto: reportpdf.ContentPDF.addStep<BR>
	 * Adiciona uma descricao, com estilo, e uma imagem em uma pagina do report
	 * TODO<BR>
	 * 
	 * @param description
	 * @param fontName
	 * @param size
	 * @param style
	 * @param color
	 * @param imagem
	 */

	public void addStep(String description, String fontName, float size, int style, BaseColor color, byte[] imagem) {
		Font format;
		try {
			if (this.document.isOpen() == true) {
				ReportManager.clearTextReport(Thread.currentThread().getName());
				this.document.newPage();
				format = FontFactory.getFont(fontName, size, style, color);
				this.document.add(new Paragraph(description, format));
			} else {
				StringBuilder report = new StringBuilder();
				for (String t : ReportManager.getTextReport(Thread.currentThread().getName())) {
					report.append(t);
				}
				report.append("\n" + description);
				document.add(new Paragraph(report.toString(), dadosFormatacao));
			}
			setImage(imagem);
		} catch (DocumentException e) {
			throw new ReportException(e);
		}
	}

	/**
	 * 
	 * Projeto: reportpdf.ContentPDF.addStep<BR>
	 * Adiciona imagem a evidencia TODO<BR>
	 * 
	 * @param imagem
	 */
	public void addStep(byte[] imagem) {
		try {
			if (document.isOpen()) {
				ReportManager.clearTextReport(Thread.currentThread().getName());
				document.newPage();
			} else {
				StringBuilder report = new StringBuilder();
				for (String t : ReportManager.getTextReport(Thread.currentThread().getName())) {
					report.append(t);
				}
				document.add(new Paragraph(report.toString(), dadosFormatacao));
			}
			setImage(imagem);
		} catch (DocumentException e) {
			throw new ReportException(e);
		}

	}

	@Deprecated
	public void addMainframeStep(String description) {

		Image image = null;
		String path = Paths.get("").toAbsolutePath().toString() + "/temp/images/";
		File f = new File(path);

		File[] files = f.listFiles();
		for (File file : files) {
			try {
				image = Image.getInstance(this.convertImageToBytes(file));
			} catch (BadElementException | IOException e) {
				e.printStackTrace();
			}
			break;
		}

		image.scaleToFit(document.getPageSize().getWidth() - (margin * 2), document.getPageSize().getHeight());
		try {
			document.add(new Paragraph(description, dadosFormatacao));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			document.add(image);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.newPage();

		this.deleteFiles(path);

	}

	public void addMainframeStep(String description, PdfPTable[] screenMainFrame) {
		try {
			if (document.isOpen()) {
				document.add(new Paragraph(description + "\n"));
				for (PdfPTable pdfPTable : screenMainFrame) {
					document.add(pdfPTable);
				}
				document.newPage();
			}
		} catch (DocumentException e) {
			throw new ReportException(e.getMessage());
		}
	}

	public void addMainframeStep(PdfPTable[] screenMainFrame) {
		try {
			if (document.isOpen()) {
				for (PdfPTable pdfPTable : screenMainFrame) {
					document.add(pdfPTable);
				}
				document.newPage();
			}
		} catch (DocumentException e) {
			throw new ReportException(e.getMessage());
		}
	}

	/**
	 * Adicionar um texto e mesma p?gina
	 * 
	 * @param description
	 *            Texto que sereadicionado ao report junto eimagem
	 * @param fontName
	 *            Define o nome da fonte
	 * @param size
	 *            Define tamanho da fonte
	 * @param style
	 *            Define o estilo da fonte ex:(Italic, bold)
	 * @BaseColor Define a cor da fonte
	 * 
	 *            Exemplo de uso: report.addText("EXAMPLE", FontFactory.HELVETICA,
	 *            12, Font.BOLD, BaseColor.GREEN);
	 * 
	 * @author Jhonny Santos
	 */
	public void addText(String description, String fontName, float size, int style, BaseColor color) {
		Font format;
		try {
			ReportManager.clearTextReport(Thread.currentThread().getName());
			format = FontFactory.getFont(fontName, size, style, color);
			document.add(new Paragraph(description, format));
		} catch (DocumentException e) {
			throw new ReportException(e);
		}

	}

	/**
	 * 
	 * Inmetrics<BR>
	 * Projeto: reportpdf.ContentPDF.setImage<BR>
	 * Adiciona imagem ao documento TODO<BR>
	 * 
	 * @since 5 de jun de 2017 16:05:55
	 * @author AndreMoreira<BR>
	 * @param pictureData
	 */
	private void setImage(byte[] pictureData) {
		try {
			Image image = Image.getInstance(pictureData);
			image.scaleToFit(document.getPageSize().getWidth() - (margin * 2), document.getPageSize().getHeight());
			document.add(image);
			document.newPage();
		} catch (BadElementException | IOException e) {
			throw new ReportException(e);
		} catch (DocumentException e) {
			throw new ReportException(e);
		}
	}

	/**
	 * Converte Image para uma array de Bytes
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private byte[] convertImageToBytes(File file) throws IOException {
		BufferedImage img = ImageIO.read(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, "png", baos);
		byte[] imageInByte = baos.toByteArray();
		baos.flush();
		baos.close();
		return imageInByte;
	}

	/**
	 * Delete files
	 * 
	 * @param file
	 */
	private void deleteFiles(String... file) {
		for (String f : file) {
			File fileStar = new File(f);
			File[] listFiles = fileStar.listFiles();
			if (listFiles != null) {
				for (File fl : listFiles) {
					fl.delete();
				}
			}
		}
	}
}
