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
	 * @param by (utilizado para indicar a Tag)
	 * @param texto (utilizado para indicar o texto)
	 * @author lucas.casanova
	 */       	    	
	public void escreveTexto(By by, String texto)
	{
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}    	

	/**
	 * Encontra campo de preenchimento por Name, escreve texto neste mesmo campo.
	 * Exemplo: 'encontraNameEscreveTexto("Name" , "texto")'
	 * @param name (utilizado para indicar TAG name)
	 * @param texto (utilizado para indicar o texto)
	 * @author lucas.casanova
	 */
	public void encontraNameEscreveTexto(String name, String texto)
	{
		escreveTexto(By.name(name), texto);
	}

	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste mesmo campo e pressiona Enter.
	 * É necessário indicar a TAG referente. Exemplo: 'EscreveEClicaEnter(By.Id("Id") , "texto")'
	 * @param by 
	 * @param texto
	 * @author lucas.casanova
	 */
	public void escreveEClicaEnter(By by, String texto)
	{
		escreveTexto(by, texto);
		driver.findElement(by).sendKeys(Keys.ENTER);
	}

	/**
	 * Encontra Tag Name e clica com Backspace.
	 * Exemplo: 'clicaComBackspace("name")'
	 * @param name
	 * @author lucas.casanova
	 */
	public void clicaNameComBackspace(String name)
	{
		driver.findElement(By.name(name)).sendKeys(Keys.BACK_SPACE);
	}

	/**
	 * Encontra campo de preenchimento por ClassName, escreve texto neste mesmo campo e pressiona Enter.
	 * Exemplo: 'encontraClassEnviaTextoEnter("ClassName" , "texto")'.
	 * @param className
	 * @param texto
	 * @author lucas.casanova
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
	 * @author lucas.casanova
	 */
	public void escreveNaClasse(String nome_classe, String texto)
	{
		escreveTexto(By.className(nome_classe), texto);
	}

	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste mesmo campo.
	 * Este método chama comando 'Id'. 
	 * Exemplo: 'escreveId("Id" , texto)'
	 * @param id_campo
	 * @param texto
	 * @author lucas.casanova
	 */
	public void escreveId(String id_campo, String texto)
	{
		escreveTexto(By.id(id_campo), texto);
	}

	/**
	 * Encontra na página da Web através de Id e reserva por Tag encontrada.
	 * Exemplo: 'obterValorCampoAttribute("Id", "innerText")'
	 * @param id_campo
	 * @return
	 * @author lucas.casanova
	 */
	public String obterValorCampoAttribute(By by , String tag)
	{
		return driver.findElement(by).getAttribute(tag);
	}	        

	/**
	 * Encontra na página da Web através de Id e reserva o texto encontrado.
	 * Exemplo: 'obterCampoTexto("id")'
	 * @param by
	 * @return
	 * @author lucas.casanova
	 */
	public String obterCampoTexto(By by)
	{
		return driver.findElement(by).getText();
	}

	/**
	 * Verifica se campo obrigatório foi preenchido corretamente.
	 * Exemplo: 'checarCampoObrigatorio("texto" , "id")'
	 * @param texto
	 * @param by
	 * @author lucas.casanova
	 */
	public void checarCampoObrigatorio(String texto, By by)
	{
		Assert.assertEquals(texto, obterCampoTexto(by));
	}

	/******************** RADIO E CHECK ********************/	    

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
	 * Encontra campo Combo e seleciona elemento deste Combo.
	 * Exemplo: selecionarCombo(By.id("id")), "Texto"
	 * @param id
	 * @param texto 
	 * @author guilherme.teixeira
	 */
	public void selecionarComboTexto(By by, String texto)
	{
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(texto);
	}

	/**
	 * Encontra campo Combo e seleciona elemento por index deste Combo.
	 * Exemplo: selecionarCombo(By.id("id")), "1"
	 * @param id
	 * @param texto 
	 * @author guilherme.teixeira
	 */
	public void selecionarComboIndex(By by, Integer index)
	{
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.selectByIndex(index);
	}

	/**
	 * Encontra campo Combo e retira a seleção do elemento deste Combo.
	 * Exemplo: deselecionarCombo(By.id("id")), "Texto"
	 * @param by
	 * @param texto
	 * @author guilherme.teixeira
	 */
	public void deselecionarComboTexto(By by, String texto)
	{
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.deselectByVisibleText(texto);
	}

	/**
	 * Encontra campo Combo e retira a seleção do elemento por index deste Combo.
	 * Exemplo: deselecionarCombo(By.id("id")), "2"
	 * @param by
	 * @param texto
	 * @author guilherme.teixeira
	 */
	public void deselecionarComboIndex(By by, Integer index)
	{
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.deselectByIndex(index);
	}

	/******************** BOTÃO ********************/

	/**
	 * Encontra elemento pela indicação solicitada e clica.
	 * É necessário indicar a TAG referente. 
	 * Exemplo: 'common(By.Id("Id"))'
	 * @param by 
	 * @author guilherme.teixeira
	 */
	public void commonClica(By by)
	{
		driver.findElement(by).click();
	}

	/******************** TEXTOS ********************/

	/**
	 * Encontra elemento Text por indicação selecionada e reserva texto encontrado.
	 * É necessário indicar a TAG referente. Exemplo: 'obterTexto(By.Id("Id"))'
	 * @param by
	 * @return
	 * @author guilherme.teixeira
	 */
	public String obterTexto(By by)
	{
		return driver.findElement(by).getText();
	}

	/******************** ALERTS ********************/


	/**
	 * Desvia a atenção para um Alert obtém texto. Aceita Alert e retorna texto deste Alert
	 * Exemplo: 'alertaObterTextoEAceita()'
	 * @return	
	 * @author guilherme.teixeira
	 */
	public String alertaObterTextoEAceita()
	{
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	/**
	 * Desvia a atenção para um Alert obtém texto. Rejeita Alert e retorna texto deste Alert.
	 * Exemplo: 'alertaObterTextoENega()'
	 * @return	
	 * @author guilherme.teixeira
	 */
	public String alertaObterTextoENega()
	{
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}


	/**
	 * Desvia a atenção para um Alert escreve texto indicado e aceita Alert.
	 * Exemplo: 'alertaEscrever("Texto")'
	 * @author guilherme.teixeira
	 */
	public void alertaEscrever(String texto)
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(texto);
		alert.accept();
	}

	/******************** FRAMES E JANELAS ********************/

	/**
	 * Desvia a atenção para um Frame por Id indicado e entra.
	 * Exemplo: 'entrarFrame("Id")'
	 * @author guilherme.teixeira
	 */
	public void entrarFrame(String id)
	{
		driver.switchTo().frame(id);
	}


	/**
	 * Sai do Frame e retorna para a página principal.
	 * Exemplo: 'sairFrame("Id")'
	 * @author guilherme.teixeira
	 */
	public void sairFrame()
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * Desvia a atenção para uma janela por Id indicado.
	 * Exemplo: 'trocarFrame("elemento")'
	 * @author guilherme.teixeira
	 */
	public void trocarFrame(String elemento)
	{
		driver.switchTo().window(elemento);
	}

	/******************** TEMPO ********************/

	/**
	 * Espera o tempo determinado por milisegundos para carregar. Utilziar números inteiros.
	 * Exemplo: 'EsperaCarregar(tempo)'
	 * @author guilherme.teixeira
	 */
	public void esperaCarregar(Integer tempo)
	{
		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
	}

}
