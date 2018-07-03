package suporte;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class BaseDSL {
	 
	WebDriver driver = new ChromeDriver();
	
	
/******************** BARRA DE ROLAGEM ********************/
	
	public void url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * Executa rolagem da página.
	 * Exemplo: rolarPagina("window.scrollBy(0,650)");
	 * @author lucas.casanova
	 */	
	public void rolarPagina(String rolagem)
	{
	    ((JavascriptExecutor)driver).executeScript(rolagem);
	}
		
/******************** TEXTFIELD E TEXTAREA ********************/
	        	           
	/**
	 * Limpa a máscara que existe no campo de preenchimento e escreve texto neste mesmo campo.
	 * É necessário indicar a TAG referente. Exemplo: 'escreveTexto(By.id("Id") , "texto")'
	 * @author lucas.casanova
	 * @param by (utilizado para indicar a Tag)
	 * @param texto (utilizado para indicar o texto)
	 */       	    	
	public void escreveTexto(By by, String texto)
	{
	    driver.findElement(by).clear();
	    driver.findElement(by).sendKeys(texto);
	}    	
		    	
	/**
	 * Encontra campo de preenchimento por Name, escreve texto neste mesmo campo.
	 * Exemplo: 'encontraNameEscreveTexto("Name" , "texto")'
	 * @author lucas.casanova
	 * @param name (utilizado para indicar TAG name)
	 * @param texto (utilizado para indicar o texto)
	 */
	public void encontraNameEscreveTexto(String name, String texto)
	{
	    escreveTexto(By.name(name), texto);
	}
	
	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste mesmo campo e pressiona Enter.
	 * É necessário indicar a TAG referente. Exemplo: 'EscreveEClicaEnter(By.Id("Id") , "texto")'
	 * @author lucas.casanova
	 * @param by 
	 * @param texto
	 */
	public void escreveEClicaEnter(By by, String texto)
	{
	    escreveTexto(by, texto);
	    driver.findElement(by).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Encontra Tag Name e clica com Backspace.
	 * Exemplo: 'clicaComBackspace("name")'
	 * @author lucas.casanova
	 * @param name
	 */
	public void clicaNameComBackspace(String name)
	{
	    driver.findElement(By.name(name)).sendKeys(Keys.BACK_SPACE);
	}
	
	/**
	 * Encontra campo de preenchimento por ClassName, escreve texto neste mesmo campo e pressiona Enter.
	 * Exemplo: 'encontraClassEnviaTextoEnter("ClassName" , "texto")'.
	 * @author lucas.casanova
	 * @param className
	 * @param texto
	 */
	public void encontraClassEnviaTextoEnter(String className, String texto)
	{
	    escreveEClicaEnter(By.className(className), texto);
	}
	
	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste mesmo campo.
	 * Este método chama comando 'ClassName'. 
	 * Exemplo: 'escreverNaClasse("NomeDaClasse" , texto)'
	 * @param nome_classe
	 * @param texto
	 */
	public void escreveNaClasse(String nome_classe, String texto)
	{
	    escreveTexto(By.className(nome_classe), texto);
	}
	
	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste mesmo campo.
	 * Este método chama comando 'Id'. 
	 * Exemplo: 'escreveId("Id" , texto)'
	 * @author lucas.casanova
	 * @param id_campo
	 * @param texto
	 */
	public void escreveId(String id_campo, String texto)
	{
	    escreveTexto(By.id(id_campo), texto);
	}
	
	/**
	 * Encontra na página da Web através de Id e reserva por Tag encontrada.
	 * Exemplo: 'obterValorCampoAttribute("Id", "innerText")'
	 * @author lucas.casanova
	 * @param id_campo
	 * @return
	 */
	public String obterValorCampoAttribute(By by , String tag)
	{
	    return driver.findElement(by).getAttribute(tag);
	}	        
	
	/**
	 * Encontra na página da Web através de Id e reserva o texto encontrado.
	 * Exemplo: 'obterCampoTexto("id")'
	 * @author lucas.casanova
	 * @param by
	 * @return
	 */
	public String obterCampoTexto(By by)
	{
	    return driver.findElement(by).getText();
	}
	
	/**
	 * Verifica se campo obrigatório foi preenchido corretamente.
	 * Exemplo: 'checarCampoObrigatorio("texto" , "id")'
	 * @author lucas.casanova
	 * @param texto
	 * @param by
	 */
	public void checarCampoObrigatorio(String texto, By by)
	{
		Assert.assertEquals(texto, obterCampoTexto(by));
	}
			
/******************** RADIO E CHECK ********************/	    
	
	/**
	 * Encontra elemento pela indicação solicitada e clica.
	 * @param by (utilizado para indicar a Tag)
	 * É necessário indicar a TAG referente. 
	 * Exemplo: 'common(By.Id("Id"))'
	 * @author guilherme.teixeira
	 */
	public void common(By by)
	{
	    driver.findElement(by).click();
	}
	
	/**
	 * Encontra elemento e confirma se está selecionado.
	 * Exemplo: 'isElementoMarcado(By.Id("Id"))'
	 * @author guilherme.teixeira
	 * @param by (utilizado para indicar a Tag)
	 * @return Boolean
	 */	
	public Boolean isElementoMarcado(By by)
	{
	    return driver.findElement(by).isSelected();
	}
	
	/**
	 * Encontra campo Check, seleciona pressionando Espaço para marcar.
	 * Exemplo: 'isCheckMarcadoComEspaco(By.Id("Id"))'
	 * @param by (utilizado para indicar a Tag)
	 * @author guilherme.teixeira
	 */
	public void isCheckMarcadoComEspaco(By by)
	{
	    driver.findElement(by).sendKeys(Keys.SPACE);
	}
	
/******************** COMBO ********************/

	/**
	 * Encontra campo Combo e seleciona elemento por texto deste Combo.
	 * Exemplo: 'selecionarCombo("Id" , "TextoDoCombo")'
	 * @param by
	 * @param texto
	 * @author guilherme.teixeira
	 */
	public void selecionarCombo(By by, String texto)
	{
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}
	
	/**
	 * Encontra campo Combo por Id e retira a seleção do elemento deste Combo.
	 * Exemplo: 'deselecionarCombo("Id" , "TextoDoCombo")'
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void deselecionarCombo(By by, String valor)
	{
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}
	
	/******************** BOTÃO ********************/
	
	/**
	 * Encontra elemento Botão por indicação selecionada e clica.
	 * É necessário indicar a TAG referente. Exemplo: 'commonClicar(By.Id("Id"))'
	 * @param by
	 */
	public void commonClicar(By by)
	{
		driver.findElement(by).click();
	}
	
	/******************** TEXTOS ********************/
	
	/**
	 * Encontra elemento Text por indicação selecionada e reserva texto encontrado.
	 * É necessário indicar a TAG referente. Exemplo: 'obterTexto(By.Id("Id"))'
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public String obterTexto(By by)
	{
		return driver.findElement(by).getText();
	}
	
	/******************** ALERTS ********************/
	
	/**
	 * Desvia a atenção para um Alert obtém texto. Aceita Alert e retorna texto deste Alert.
	 * Exemplo: 'alertaObterTextoEAceita()'
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public String alertaObterTextoEAceita()
	{
		Alert alerta = driver.switchTo().alert();
		String valor = alerta.getText();
		alerta.accept();
		return valor;
	}
	
	/**
	 *	Desvia a atenção para um Alert obtém texto. Rejeita Alert e retorna texto deste Alert.
	 * Exemplo: 'alertaObterTextoENega()'
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public String AlertaObterTextoENega()
	{
		Alert alerta = driver.switchTo().alert();
		String valor = alerta.getText();
		alerta.dismiss();
		return valor;
	}
	
	/**
	 * Desvia a atenção para um Alert escreve texto indicado e aceita Alert.
	 * Exemplo: 'alertaEscrever("Texto")'
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void alertaEscrever(String texto)
	{
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys(texto);
		alerta.accept();
	}


/******************* FRAMES E JANELAS *******************/
	
	/**
	 * Desvia a atenção para um Frame por Id indicado e entra.
	  Exemplo: 'entrarFrame("Id")'
	  @param by
	  @param valor
	  @author guilherme.teixeira
	 */
	public void entrarFrame(String elemento)
	{
		driver.switchTo().frame(elemento);
	}
	
	/**
	 *  Sai do Frame e retorna para a página principal.
	  Exemplo: 'SairFrame()'
	  @param by
	  @param valor
	  @author guilherme.teixeira
	 */
	public void sairFrame()
	{
		driver.switchTo().defaultContent();
	}

	/**
	 *  Desvia a atenção para uma janela por Id indicado.
	  Exemplo: 'trocarJanela("elemento")'
	  @param by
	  @param valor
	  @author guilherme.teixeira
	 */
	public void trocarJanela(String elemento)
	{
		driver.switchTo().window(elemento);
	}

/******************* TEMPO *******************/

	/**
	 * Espera o tempo determinado por milisegundos para carregar. Utilziar números inteiros.
	  Exemplo: 'esperaCarregar(tempo)'
	  @param by
	  @param valor
	  @author guilherme.teixeira
	 */			
	public void esperaCarregar(int tempo)
	{
		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
	}
}
