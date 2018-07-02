package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

public class BaseDSL {
	 
	WebDriver driver = new ChromeDriver();
	//WebDriver driver = new FirefoxDriver();
	
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
	
	/// <summary>
	/// Encontra campo Combo por Id e seleciona elemento deste Combo.
//	/// Exemplo: 'SelecionarCombo("Id" , "TextoDoCombo")'
//	/// </summary>
//	/// <param name="id"></param>
//	/// <param name="texto"></param>
//	public void SelecionarCombo(string id, string texto)
//	{
//	    IWebElement element = GetDriver().FindElement(By.Id(id));
//	    SelectElement combo = new SelectElement(element);
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
//		
}
