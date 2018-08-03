package br.com.report.screenshot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.qrcode.ByteArray;

import br.com.report.screenshot.interfaces.IFunctionReport;

/**
 * 
 * Projeto: reportpdf.IFunctionReport<BR>
 * @since 5 de jun de 2017 16:03:00
 * @param <T>
 */

public class ReportScreenshot {

	/**
	 * Metodo para realizar screenshot em um webdriver e colocar highlight em um
	 * ou mais webelemnt
	 * 
	 * @param driver {@link WebDriver}
	 * @param webElement {@link WebElement}
	 * @return {@link ByteArray}
	 */
	public static IFunctionReport<byte[]> web(final WebDriver webdriver, final WebElement... webElement) {

		return new IFunctionReport<byte[]>() {
			private final String JAVA_SCRIPT_HIGHLITH = "arguments[%d].setAttribute('style', 'border: 3px solid red!important');arguments[%d].focus();arguments[%d].scrollIntoView(true);";
			private final String JAVA_SCRIPT_UNDO = "arguments[%d].setAttribute('style', '%2$s');";
			private JavascriptExecutor jse;

			@Override
			public byte[] apply(Object input) {
				String unHighlight = highlightElement(webdriver, webElement);
				byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
				unHighlightElement(webdriver,unHighlight, webElement);
				return screenshot;
			}

			private String highlightElement(WebDriver webdriver, WebElement... webElement) {
				jse = ((JavascriptExecutor) webdriver);
				String javaScript = "";
				String initialStyle = "";

				for (int i = 0; i < webElement.length; i++) {
					// Cria o javascript para defazer o Highlight
					initialStyle = initialStyle
							+ String.format(JAVA_SCRIPT_UNDO, i, webElement[i].getAttribute("style"));
					// Cria o javascript de Highlight
					javaScript = javaScript + String.format(JAVA_SCRIPT_HIGHLITH, i, i, i);
				}

				// Aguarda visibilidade de todos elementos
				waitVisibilityOfElement(webdriver, webElement);
				// Executa o highlight em todos elementos
				jse.executeScript(javaScript, (Object[]) webElement);
				return initialStyle;

			}

			private void waitVisibilityOfElement(WebDriver webdriver, WebElement... elements) {
				WebDriverWait webDriverWait = new WebDriverWait(webdriver,30);
				for (int i = 0; i < elements.length; i++) {
					webDriverWait.until(ExpectedConditions.visibilityOf(elements[i]));
				}
			}

			private void unHighlightElement(WebDriver webdriver, String string, WebElement... webElement) {
				jse = ((JavascriptExecutor) webdriver);
				jse.executeScript(string, (Object[]) webElement);
			}
		};
	}

	/**
	 * Metodo para realizar screenshot em um sistema mainframe
	 * @param session3270 {@link Session3270}
	 * @return {@link ByteArray}
	 */
	public static IFunctionReport<PdfPTable[]> mainframe(final String[] value) {

		return new IFunctionReport<PdfPTable[]>() {

			@Override
			public PdfPTable[] apply(Object input) {
				PdfPTable[] pdfTable = new PdfPTable[value.length];
				for (int i = 0; i < value.length; i++) {
//					String string = value[i];
					pdfTable[i] = transformStringToTable(value[i]);
				}
				
				return pdfTable;
			}
			
			private PdfPTable transformStringToTable(String value) {
				PdfPTable table = new PdfPTable(value.length());
				table.setKeepTogether(true);
				table.setWidthPercentage(100);
				for (char c : value.toCharArray()) {
					Phrase phrase = new Phrase();
					phrase.setFont(FontFactory.getFont(FontFactory.COURIER, 11, Font.NORMAL, BaseColor.WHITE));
					phrase.add(String.valueOf(c));
					PdfPCell cell = new PdfPCell(phrase);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(BaseColor.WHITE);
					cell.setBackgroundColor(BaseColor.BLACK);
					cell.setBorder(0);
					table.addCell(cell);
				}
				return table;
			}
		};
	}

}
