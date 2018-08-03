package br.com.report.iterfaces;

import org.openqa.selenium.WebDriver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * Prop?sito: Interface com o objetivo de encapsular as funcionalidades de
 * cria??o das evidencias
 * 
 *
 */
public interface Report {

	/**
	 * Define o nome do teste e o objetivo dele na capa do Report. Caso n?o seja
	 * definido nenhum valor e capa ser? adicionada em branco.
	 * 
	 * @param testName
	 * @param objective
	 */

	public void setCover(String titulo, String objetivo);

	/**
	 * 
	 * Projeto: reportpdf.Report.addStep<BR>
	 * Adiciona uma descri??o e um array de byte ? evid?ncia<BR>
	 * 
	 * @since 5 de jun de 2017 15:52:47
	 * @param description
	 * @param imagem
	 */
	public void addStep(String description, byte[] imagem);

	/**
	 * 
	 * Projeto: reportpdf.Report.addStep<BR>
	 * Adiciona uma imagem, array de byte, - ? evid?ncia<BR>
	 * 
	 * @since 5 de jun de 2017 15:53:32
	 * @param imagem
	 */
	public void addStep(byte[] imagem);

	/**
	 * 
	 * Projeto: reportpdf.Report.addStep<BR>
	 * Adiciona uma descri??o, com estilo, e uma imagem ao report TODO<BR>
	 * @since 20 de jun de 2017 14:48:40
	 * @param description
	 * @param size
	 * @param style
	 * @param color
	 * @param element
	 * @param imagem
	 */
	public void addStep(String description, String fontName, float size, int style, BaseColor color, byte[] imagem);
	
	/**
	 *             Projeto: reportpdf.Report.addMainframeStep<BR>
	 *             Adiciona uma captura de tela e uma descri??o ? evid?ncia<BR>
	 * @since 6 de jun de 2017 13:17:34
	 * @param description
	 */
	public void addMainframeStep(String description);

	/**
	 * 
	 * Projeto: reportpdf.Report.addMainframeStep<BR>
	 * Adiciona uma captura de tela ? evid?ncia TODO<BR>
	 * 
	 * @since 6 de jun de 2017 13:17:38
	 * @param screenshot
	 *            <link>
	 * 
	 */
	public void addMainframeStep(PdfPTable[] screenshot);

	/**
	 * 
	 * Projeto: reportpdf.Report.addMainframeStep<BR>
	 * Adiciona uma captura de tela e uma descri??o ? evid?ncia TODO<BR>
	 * 
	 * @since 6 de jun de 2017 13:17:42
	 * @param description
	 * @param screenshot
	 */
	public void addMainframeStep(String description, PdfPTable[] screenshot);

	/**
	 * Adicionar um texto ? mesma p?gina
	 * 
	 * @param description
	 *            Texto que ser? adicionado ao report junto ? imagem
	 * @param fontName
	 *            Define o nome da fonte
	 * @param size
	 *            Define tamanho da fonte
	 * @param style
	 *            Define o estilo da fonte ex:(Italic, bold)
	 * @BaseColor Define a cor da fonte
	 * 
	 *            Exemplo de uso: report.addText("EXAMPLE",
	 *            FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.GREEN);
	 * 
	 */
	public void addText(String description, String fontName, float size, int style, BaseColor color);

	/**
	 * Adicionar um texto ? mesma p?gina com caracter?sticas de corpo
	 * encapsuladas
	 * 
	 * @param description
	 *            Texto que ser? adicionado ao report junto ? imagem
	 * 
	 *            Exemplo de uso: report.addText("EXEMPLO");
	 * 
	 */
	public void addText(String description);

	/**
	 * Salva a evidencia no diret?rio de execu??o e p?e na capa da evid?ncia o
	 * tipo de automa??o: Arquivo
	 */
	public void save(boolean isPassed);

	/**
	 * Salva a evidencia no diret?rio de execu??o e p?e na capa da evid?ncia o
	 * tipo de automa??o: web
	 */
	public void save(boolean isPassed, WebDriver driver);


	/**
	 * 
	 * Projeto: reportpdf.Report.automationType<BR>
	 * Salva automa??o do tipo 'Arquivo' na capa da evid?ncia.TODO<BR>
	 * @since 7 de jun de 2017 15:20:44
	 */
	public void automationType();

	/**
	 * 
	 * Projeto: reportpdf.Report.automationType<BR>
	 * Salva automa??o do tipo 'Web' na capa da evid?ncia TODO<BR>
	 * @since 7 de jun de 2017 15:21:34
	 * @param driver
	 */
	public void automationType(WebDriver driver);

	

}
