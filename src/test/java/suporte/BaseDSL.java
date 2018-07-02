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

//	/**
//	 * Encontra na página da Web através de Id e reserva o texto encontrado.
//	 * Exemplo: 'obterCampoTexto("id")'
//	 * @param by
//	 * @return
//	 * @author lucas.casanova
//	 */
//	public String obterCampoTexto(By by)
//	{
//		return driver.findElement(by).getText();
//	}

//	/**
//	 * Verifica se campo obrigatório foi preenchido corretamente.
//	 * Exemplo: 'checarCampoObrigatorio("texto" , "id")'
//	 * @param texto
//	 * @param by
//	 * @author lucas.casanova
//	 */
//	public void checarCampoObrigatorio(String texto, By by)
//	{
//		Assert.assertEquals(texto, obterCampoTexto(by));
//	}

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
	
//	/**
//	 * Verifica se campo obrigatório foi preenchido corretamente.
//	 * Exemplo: 'checarCampoObrigatorio("texto" , "id")'
//	 * @author lucas.casanova
//	 * @param texto
//	 * @param by
//	 */
//	public void checarCampoObrigatorio(String texto, By by)
//	{
//		Assert.assertEquals(texto, obterCampoTexto(by));
//	}
//			
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
	
/******************** COMBO ********************/
	
//	/// <summary>
//	/// Encontra campo Combo por Id e seleciona elemento deste Combo.
//	/// Exemplo: 'selecionarCombo("Id" , "TextoDoCombo")'
//	/// </summary>
//	/// <param name="id"></param>
//	/// <param name="texto"></param>
//	public void selecionarCombo(String id, String texto)
//	{
//	    WebElement element = driver.findElement(By.id(id));
//	    Select combo = new Select(element);
//	    combo.SelectByText(texto);
//	}
//	
//	/// <summary>
//	/// Encontra campo Combo por Id e retira a seleção do elemento deste Combo.
//	/// Exemplo: 'DeselecionarCombo("Id" , "TextoDoCombo")'
//	/// </summary>
//	
//	/// <param name="valor"></param>
//	public void DeselecionarCombo(string id, string valor)
//	{
//	    IWebElement element = GetDriver().FindElement(By.Id(id));
//	    SelectElement combo = new SelectElement(element);
//	    combo.DeselectByText(valor);
//	}
//	
//	/// <summary>
//	/// Encontra ComboBox por Id e seleciona o elemento de acordo com o indicado.       
//	/// Exemplo: 'ConfigurarElementoSelecionadoNoCombo("Id" , "3")'
//	/// Por padrão o índice indicado é sempre zero.
//	/// </summary>
//	/// <param name="idElemento"></param>
//	/// <param name="indice"></param>
//	public void ConfigurarElementoSelecionadoNoCombo(string idElemento, int indice = 0)
//	{
//	    IWebElement element = GetDriver().FindElement(By.Id(idElemento));
//	    SelectElement combo = new SelectElement(element);
//	    combo.SelectByIndex(indice);
//	}
//	
//	/// <summary>
//	/// 
//	/// </summary>
//	/// <param name="idElemento"></param>
//	/// <param name="texto"></param>
//	public void SelecionarComboPorVisibleText(By by, String texto)
//	{
//	    IWebElement element = GetDriver().FindElement(by);
//	    SelectElement combo = new SelectElement(element);
//	    combo.SelectByText(texto);
//	}
//	
//	/// <summary>
//	/// Encontra o ComboBox por Id e obtém o primeiro elemento.
//	/// Exemplo: 'ObterPrimeiroElementoDoCombo("Id")'
//	/// </summary>
//	/// <param name="id"></param>
//	/// <returns></returns>
//	public string ObterPrimeiroElementoDoCombo(string id)
//	{
//	    IWebElement element = GetDriver().FindElement(By.Id(id));
//	    SelectElement combo = new SelectElement(element);
//	    ConfigurarElementoSelecionadoNoCombo(id);
//	    return combo.SelectedOption.Text; // retorna o texto do primeiro elemento na variável
//	}
//	
///******************** BOTÃO ********************/
//	
//	/**
//	 * Encontra elemento Botão por indicação selecionada e clica.
//	 * É necessário indicar a TAG referente. Exemplo: 'ClicarBotaoBy(By.Id("Id"))'
//	 * @param by
//	 */
//	public void clicarBotaoBy(By by)
//	{
//	    driver.findElement(by).click();
//	}
//	
//	public void tagnameClicarBotão(String tag)
//	{
//	    driver.findElement(By.tagName(tag)).click();
//	}
//	
//	/// <summary>
//	/// Encontra botão por Id e clica.
//	/// Exemplo: 'ClicarBotaoId("Id")'
//	/// </summary>
//	/// <param name="id"></param>
//	public void ClicarBotaoId(string id)
//	{
//	    ClicarBotaoBy(By.Id(id));
//	}
//	
//	/// <summary>
//	/// Encontra botão por ClassName e clica.
//	/// Exemplo: 'ClicarBotaoClass("ClassName")'
//	/// </summary>
//	/// <param name="classe"></param>
//	public void ClicarBotaoClass(string classe)
//	{
//	    GetDriver().FindElement(By.ClassName(classe)).Click();
//	}
//	
//	/// <summary>
//	/// Encontra botão por Name e clica.
//	/// Exemplo: 'ClicarBotaoName("Name")'
//	/// </summary>
//	/// <param name="name"></param>
//	public void ClicarBotaoName(string name)
//	{
//	    GetDriver().FindElement(By.Name(name)).Click();
//	}
//	
//	/// <summary>
//	/// Encontra botão de link por CssSelector e clica.
//	/// Exemplo: 'ClicarBotaoCssSelector("[href*='link']");
//	/// </summary>
//	/// <param name="name"></param>
//	public void ClicarBotaoCssSelector(string link)
//	{
//	    GetDriver().FindElement(By.CssSelector(link)).Click();
//	}
//	
//	
///******************** LINK ********************/
//	
//	/// <summary>
//	/// Encontra elemento por LinkText e clica.
//	/// Exemplo 'ClicarLink("link")'
//	/// </summary>
//	/// <param name="link"></param>
//	public void ClicarLink(string link)
//	{
//	    GetDriver().FindElement(By.LinkText(link)).Click();
//	}
//	
///******************** TEXTOS ********************/
//	
//	/// <summary>
//	/// Encontra elemento Text por indicação selecionada e reserva texto encontrado.
//	/// É necessário indicar a TAG referente. Exemplo: 'ObterTexto(By.Id("Id"))'
//	/// </summary>
//	/// <param name="by"></param>
//	/// <returns></returns>
//	public string ObterTexto(By by)
//	{
//	    return GetDriver().FindElement(by).Text;
//	}
//	
//	/// <summary>
//	///  Encontra elemento Text por Id e reserva texto encontrado.
//	///  Exemplo: 'ObterTexto("Id")'
//	/// </summary>
//	/// <param name="id"></param>
//	/// <returns></returns>
//	public string ObterTextoPorId(string id)
//	{
//	    return ObterTexto(By.Id(id));
//	}
//	
///******************** ALERTS ********************/
//	
//	/// <summary>
//	/// Desvia a atenção para um Alert obtém texto. Aceita Alert e retorna texto deste Alert.
//	/// Exemplo: 'AlertaObterTextoEAceita()'
//	/// </summary>
//	/// <returns></returns>
//	public string AlertaObterTextoEAceita()
//	{
//	    IAlert alert = GetDriver().SwitchTo().Alert();
//	    string valor = alert.Text;
//	    alert.Accept();
//	    return valor;
//	}
//	
//	/// <summary>
//	/// Desvia a atenção para um Alert obtém texto. Rejeita Alert e retorna texto deste Alert.
//	/// Exemplo: 'AlertaObterTextoENega()'
//	/// </summary>
//	/// <returns></returns>
//	public string AlertaObterTextoENega()
//	{
//	    IAlert alert = GetDriver().SwitchTo().Alert();
//	    string valor = alert.Text;
//	    alert.Dismiss();
//	    return valor;
//	}
//	
//	/// <summary>
//	/// Desvia a atenção para um Alert escreve texto indicado e aceita Alert.
//	/// Exemplo: 'AlertaEscrever("Texto")'
//	/// </summary>
//	/// <param name="valor"></param>
//	public void AlertaEscrever(string valor)
//	{
//	    IAlert alert = GetDriver().SwitchTo().Alert();
//	    alert.SendKeys(valor);
//	    alert.Accept();
//	}
//	
///******************** FRAMES E JANELAS ********************/
//	
//	/// <summary>
//	/// Desvia a atenção para um Frame por Id indicado e entra.
//	/// Exemplo: 'EntrarFrame("Id")'
//	/// </summary>
//	/// <param name="id"></param>
//	public void EntrarFrame(string id)
//	{
//	    GetDriver().SwitchTo().Frame(id);
//	}
//	
//	/// <summary>
//	/// Sai do Frame e retorna para a página principal.
//	/// Exemplo: 'SairFrame()'
//	/// </summary>
//	public void SairFrame()
//	{
//	    GetDriver().SwitchTo().DefaultContent();
//	}
//	
//	/// <summary>
//	/// Desvia a atenção para uma janela por Id indicado.
//	/// Exemplo: 'TrocarJanela("Id")'
//	/// </summary>
//	/// <param name="id"></param>
//	public void TrocarJanela(string id)
//	{
//	    GetDriver().SwitchTo().Window(id);
//	}
//	
///******************** TEMPO ********************/
//	
//	/// <summary>
//	/// Espera o tempo determinado por milisegundos para carregar. Utilziar números inteiros.
//	/// Exemplo: 'EsperaCarregar(tempo)'
//	/// </summary>
//	/// <param name="tempo"></param>
//	public void EsperaCarregar(int tempo)
//	{
//	    Thread.Sleep(tempo);
//	
//	}
//	/// <summary>
//	/// Encontra o elemento pelo xpath e preenche o campo com o texto.
//	/// </summary>
//	/// <param name="xpath"></param>
//	/// <param name="texto"></param>
//	public void EncontraxpathEscreveTexto(string xpath, string texto)
//	{
//	    EscreveTexto(By.XPath(xpath), texto);
//	}
}
