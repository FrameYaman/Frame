package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class BaseDSL {
	 
	WebDriver driver = new ChromeDriver();
	
			/**
			 * Executa rolagem da p�gina.
			 * Exemplo: rolarPagina("window.scrollBy(0,650)");
			 * @author lucas.casanova
			 */	
			public void rolarPagina(String rolagem)
	        {
	            ((JavascriptExecutor)driver).executeScript(rolagem);
	        }
	        
	        

	        /********* TextField e TextArea ************/
	        	        	           
	        /**
	         * Limpa a m�scara que existe no campo de preenchimento e escreve texto neste mesmo campo.
	         * � necess�rio indicar a TAG referente. Exemplo: 'escreveTexto(By.id("Id") , "texto")'
	         * @author lucas.casanova
	         * @param by (utilizado para indicar a Tag)
	         * @param texto (utilizado para indicar o texto)
	         */       	    	
	    	public void escreveTexto(By by, String texto)
	        {
	            driver.findElement(by).clear();
	            driver.findElement(by).sendKeys(texto);
	        }
	    	

	        /// <summary>
	        /// Encontra campo de preenchimento por Name, 
	        /// escreve texto neste mesmo campo.
	        /// Exemplo: 'EncontraNameEscreveTexto("Name" , "texto")'
	        /// </summary>
	        /// <param name="name"></param>
	        /// <param name="texto"></param>
	        public void EncontraNameEscreveTexto(string name, string texto)
	        {
	            EscreveTexto(By.Name(name), texto);
	        }

	        /// <summary>
	        /// Limpa a m�scara que existe no campo de preenchimento, 
	        /// escreve texto neste mesmo campo e pressiona Enter.
	        /// � necess�rio indicar a TAG referente. Exemplo: 'EscreveEClicaEnter(By.Id("Id") , "texto")'
	        /// </summary>
	        /// <param name="by"></param>
	        /// <param name="texto"></param>
	        public void EscreveEClicaEnter(By by, string texto)
	        {
	            EscreveTexto(by, texto);
	            GetDriver().FindElement(by).SendKeys(Keys.Enter);
	        }

	        /// <summary>
	        /// Encontra Tag Name e clica com Backspace.
	        /// Exemplo: 'ClicaComBackspace("Name")'
	        /// </summary>
	        /// <param name="name"></param>
	        public void ClicaNameComBackspace(String name)
	        {
	            GetDriver().FindElement(By.Name(name)).SendKeys(Keys.Backspace);
	        }

	        /// <summary>
	        /// Encontra campo de preenchimento por ClassName, 
	        /// escreve texto neste mesmo campo e pressiona Enter.
	        /// Exemplo: 'EncontraClassEnviaTextoEnter("ClassName" , "texto")'.
	        /// </summary>
	        /// <param name="className"></param>
	        public void EncontraClassEnviaTextoEnter(string className, string texto)
	        {
	            EscreveEClicaEnter(By.ClassName(className), texto);
	        }

	        /// <summary>
	        /// Limpa a m�scara que existe no campo de preenchimento, 
	        /// escreve texto neste mesmo campo.
	        /// Este m�todo chama comando 'ClassName'. 
	        /// Exemplo: 'EscreverNaClasse("NomeDaClasse" , texto)'
	        /// </summary>
	        /// <param name="nome_classe"></param>
	        /// <param name="texto"></param>
	        public void EscreveNaClasse(string nome_classe, string texto)
	        {
	            EscreveTexto(By.ClassName(nome_classe), texto);
	        }

	        /// <summary>
	        /// Limpa a m�scara que existe no campo de preenchimento, 
	        /// escreve texto neste mesmo campo.
	        /// Este m�todo chama comando 'Id'. 
	        /// Exemplo: 'EscreveId("Id" , texto)'
	        /// </summary>
	        /// <param name="id_campo"></param>
	        /// <param name="texto"></param>
	        public void EscreveId(string id_campo, string texto)
	        {
	            EscreveTexto(By.id(id_campo), texto);
	        }

	        /// <summary>
	        /// Encontra na p�gina da Web atrav�s de Id e reserva o value encontrado.
	        /// Exemplo: 'ObterValorCampo("Id")'
	        /// </summary>
	        /// <param name="id_campo"></param>
	        /// <returns></returns>
	        public String ObterValorCampo(string id_campo)
	        {
	            return GetDriver().FindElement(By.Id(id_campo)).GetAttribute("value");
	        }

	        public String ObterValorCampoInnerText(string className)
	        {
	            return GetDriver().FindElement(By.ClassName(className)).GetAttribute("innerText");
	        }

	        /// <summary>
	        /// Encontra na p�gina da Web atrav�s de Id e reserva o texto encontrado.
	        /// Exemplo: 'ObterTextoCampoId("Id")'
	        /// </summary>
	        /// <param name="id_campo"></param>
	        /// <returns></returns>
	        public String ObterTextoCampoId(string id_campo)
	        {
	            return GetDriver().FindElement(By.Id(id_campo)).Text;
	        }

	        /// <summary>
	        /// Encontra na p�gina da Web atrav�s de ClassName e reserva o texto encontrado.
	        /// Exemplo: 'ObterTextoCampoClassName("className")'
	        /// </summary>
	        /// <param name="className"></param>
	        /// <returns></returns>
	        public String ObterTextoCampoClassName(string className)
	        {
	            return GetDriver().FindElement(By.ClassName(className)).Text;
	        }

	        /// <summary>
	        /// Encontra na p�gina da Web atrav�s de XPath e reserva o texto encontrado.
	        /// Exemplo: 'ObterTextoCampoXPath("//*[@href = '#XPtah']")'
	        /// </summary>
	        /// <param name="xpath"></param>
	        /// <returns></returns>
	        public String ObterTextoCampoXPath(string xpath)
	        {
	            return GetDriver().FindElement(By.XPath(xpath)).Text;
	        }

	        /// <summary>
	        /// Verifica se campo obrigat�rio foi preenchido corretamente.
	        /// Exemplo: 'ChecarCampoObrigatorio("Texto" , "Id")'
	        /// </summary>
	        /// <param name="texto"></param>
	        /// <param name="id_campo"></param>m>
	        public void ChecarCampoObrigatorio(string texto, string id_campo)
	        {
	            Assert.AreEqual(texto, ObterTexto(By.Id(id_campo)));
	        }

	        /// <summary>
	        /// Verifica se campo obrigat�rio foi preenchido corretamente.
	        /// Exemplo: 'ChecarCampoObrigatorio("Texto" , (By.Id("Id")))'
	        /// </summary>
	        /// <param name="texto"></param>
	        /// <param name="id_campo"></param>m>
	        public void ChecarCampoObrigatorioBy(string texto, By by)
	        {
	            Assert.AreEqual(texto, ObterTexto(by));
	        }
	        /********* Radio e Check ************/
	        
	        
	        /**
	         * Encontra elemento pela indica��o solicitada e clica.
	         * @param by (utilizado para indicar a Tag)
	         * � necess�rio indicar a TAG referente. Exemplo: 'findElement(By.Id("Id"))'
	         * @author guilherme.teixeira
	         */
	        public void common(By by)
	        {
	            driver.findElement(by).click();
	        }

	        /**
	         * Encontra elemento e confirma se est� selecionado.
	         * @author guilherme.teixeira
	         * @param by (utilizado para indicar a Tag)
	         * @return Boolean
	         */
	        
	        public Boolean IsElementoMarcado(By by)
	        {
	            return driver.findElement(by).isSelected();
	        }

	        /**
	         * Encontra campo Check, seleciona pressionando Espa�o para marcar.
	         * @param by (utilizado para indicar a Tag)
	         * @author guilherme.teixeira
	         */
	        public void IsCheckMarcadoComEspaco(By by)
	        {
	            driver.findElement(by).sendKeys(Keys.SPACE);
	        }

	        /********* Combo ************/

	        /// <summary>
	        /// Encontra campo Combo por Id e seleciona elemento deste Combo.
	        /// Exemplo: 'SelecionarCombo("Id" , "TextoDoCombo")'
	        /// </summary>
	        /// <param name="id"></param>
	        /// <param name="texto"></param>
	        public void SelecionarCombo(string id, string texto)
	        {
	            IWebElement element = GetDriver().FindElement(By.Id(id));
	            SelectElement combo = new SelectElement(element);
	            combo.SelectByText(texto);
	        }

	        /// <summary>
	        /// Encontra campo Combo por Id e retira a sele��o do elemento deste Combo.
	        /// Exemplo: 'DeselecionarCombo("Id" , "TextoDoCombo")'
	        /// </summary>
	        
	        /// <param name="valor"></param>
	        public void DeselecionarCombo(string id, string valor)
	        {
	            IWebElement element = GetDriver().FindElement(By.Id(id));
	            SelectElement combo = new SelectElement(element);
	            combo.DeselectByText(valor);
	        }

	        /// <summary>
	        /// Encontra ComboBox por Id e seleciona o elemento de acordo com o indicado.       
	        /// Exemplo: 'ConfigurarElementoSelecionadoNoCombo("Id" , "3")'
	        /// Por padr�o o �ndice indicado � sempre zero.
	        /// </summary>
	        /// <param name="idElemento"></param>
	        /// <param name="indice"></param>
	        public void ConfigurarElementoSelecionadoNoCombo(string idElemento, int indice = 0)
	        {
	            IWebElement element = GetDriver().FindElement(By.Id(idElemento));
	            SelectElement combo = new SelectElement(element);
	            combo.SelectByIndex(indice);
	        }

	        /// <summary>
	        /// 
	        /// </summary>
	        /// <param name="idElemento"></param>
	        /// <param name="texto"></param>
	        public void SelecionarComboPorVisibleText(By by, String texto)
	        {
	            IWebElement element = GetDriver().FindElement(by);
	            SelectElement combo = new SelectElement(element);
	            combo.SelectByText(texto);
	        }

	        /// <summary>
	        /// Encontra o ComboBox por Id e obt�m o primeiro elemento.
	        /// Exemplo: 'ObterPrimeiroElementoDoCombo("Id")'
	        /// </summary>
	        /// <param name="id"></param>
	        /// <returns></returns>
	        public string ObterPrimeiroElementoDoCombo(string id)
	        {
	            IWebElement element = GetDriver().FindElement(By.Id(id));
	            SelectElement combo = new SelectElement(element);
	            ConfigurarElementoSelecionadoNoCombo(id);
	            return combo.SelectedOption.Text; // retorna o texto do primeiro elemento na vari�vel
	        }

	        /********* Bot�o ************/
	        
	        /**
	         * Encontra elemento Bot�o por indica��o selecionada e clica.
	       	 * � necess�rio indicar a TAG referente. Exemplo: 'ClicarBotaoBy(By.Id("Id"))'
	         * @param by
	         */
	        public void clicarBotaoBy(By by)
	        {
	            driver.findElement(by).click();
	        }
	        
	        public void tagnameClicarBot�o(String tag)
	        {
	            driver.findElement(By.tagName(tag)).click();
	        }

	        /// <summary>
	        /// Encontra bot�o por Id e clica.
	        /// Exemplo: 'ClicarBotaoId("Id")'
	        /// </summary>
	        /// <param name="id"></param>
	        public void ClicarBotaoId(string id)
	        {
	            ClicarBotaoBy(By.Id(id));
	        }

	        /// <summary>
	        /// Encontra bot�o por ClassName e clica.
	        /// Exemplo: 'ClicarBotaoClass("ClassName")'
	        /// </summary>
	        /// <param name="classe"></param>
	        public void ClicarBotaoClass(string classe)
	        {
	            GetDriver().FindElement(By.ClassName(classe)).Click();
	        }

	        /// <summary>
	        /// Encontra bot�o por Name e clica.
	        /// Exemplo: 'ClicarBotaoName("Name")'
	        /// </summary>
	        /// <param name="name"></param>
	        public void ClicarBotaoName(string name)
	        {
	            GetDriver().FindElement(By.Name(name)).Click();
	        }

	        /// <summary>
	        /// Encontra bot�o de link por CssSelector e clica.
	        /// Exemplo: 'ClicarBotaoCssSelector("[href*='link']");
	        /// </summary>
	        /// <param name="name"></param>
	        public void ClicarBotaoCssSelector(string link)
	        {
	            GetDriver().FindElement(By.CssSelector(link)).Click();
	        }


	        /********* Link ************/

	        /// <summary>
	        /// Encontra elemento por LinkText e clica.
	        /// Exemplo 'ClicarLink("link")'
	        /// </summary>
	        /// <param name="link"></param>
	        public void ClicarLink(string link)
	        {
	            GetDriver().FindElement(By.LinkText(link)).Click();
	        }

	        /********* Textos ************/

	        /// <summary>
	        /// Encontra elemento Text por indica��o selecionada e reserva texto encontrado.
	        /// � necess�rio indicar a TAG referente. Exemplo: 'ObterTexto(By.Id("Id"))'
	        /// </summary>
	        /// <param name="by"></param>
	        /// <returns></returns>
	        public string ObterTexto(By by)
	        {
	            return GetDriver().FindElement(by).Text;
	        }

	        /// <summary>
	        ///  Encontra elemento Text por Id e reserva texto encontrado.
	        ///  Exemplo: 'ObterTexto("Id")'
	        /// </summary>
	        /// <param name="id"></param>
	        /// <returns></returns>
	        public string ObterTextoPorId(string id)
	        {
	            return ObterTexto(By.Id(id));
	        }

	        /********* Alerts ************/

	        /// <summary>
	        /// Desvia a aten��o para um Alert obt�m texto. Aceita Alert e retorna texto deste Alert.
	        /// Exemplo: 'AlertaObterTextoEAceita()'
	        /// </summary>
	        /// <returns></returns>
	        public string AlertaObterTextoEAceita()
	        {
	            IAlert alert = GetDriver().SwitchTo().Alert();
	            string valor = alert.Text;
	            alert.Accept();
	            return valor;
	        }

	        /// <summary>
	        /// Desvia a aten��o para um Alert obt�m texto. Rejeita Alert e retorna texto deste Alert.
	        /// Exemplo: 'AlertaObterTextoENega()'
	        /// </summary>
	        /// <returns></returns>
	        public string AlertaObterTextoENega()
	        {
	            IAlert alert = GetDriver().SwitchTo().Alert();
	            string valor = alert.Text;
	            alert.Dismiss();
	            return valor;
	        }

	        /// <summary>
	        /// Desvia a aten��o para um Alert escreve texto indicado e aceita Alert.
	        /// Exemplo: 'AlertaEscrever("Texto")'
	        /// </summary>
	        /// <param name="valor"></param>
	        public void AlertaEscrever(string valor)
	        {
	            IAlert alert = GetDriver().SwitchTo().Alert();
	            alert.SendKeys(valor);
	            alert.Accept();
	        }

	        /********* Frames e Janelas ************/

	        /// <summary>
	        /// Desvia a aten��o para um Frame por Id indicado e entra.
	        /// Exemplo: 'EntrarFrame("Id")'
	        /// </summary>
	        /// <param name="id"></param>
	        public void EntrarFrame(string id)
	        {
	            GetDriver().SwitchTo().Frame(id);
	        }

	        /// <summary>
	        /// Sai do Frame e retorna para a p�gina principal.
	        /// Exemplo: 'SairFrame()'
	        /// </summary>
	        public void SairFrame()
	        {
	            GetDriver().SwitchTo().DefaultContent();
	        }

	        /// <summary>
	        /// Desvia a aten��o para uma janela por Id indicado.
	        /// Exemplo: 'TrocarJanela("Id")'
	        /// </summary>
	        /// <param name="id"></param>
	        public void TrocarJanela(string id)
	        {
	            GetDriver().SwitchTo().Window(id);
	        }

	        /****Tempo****/

	        /// <summary>
	        /// Espera o tempo determinado por milisegundos para carregar. Utilziar n�meros inteiros.
	        /// Exemplo: 'EsperaCarregar(tempo)'
	        /// </summary>
	        /// <param name="tempo"></param>
	        public void EsperaCarregar(int tempo)
	        {
	            Thread.Sleep(tempo);

	        }
	        /// <summary>
	        /// Encontra o elemento pelo xpath e preenche o campo com o texto.
	        /// </summary>
	        /// <param name="xpath"></param>
	        /// <param name="texto"></param>
	        public void EncontraxpathEscreveTexto(string xpath, string texto)
	        {
	            EscreveTexto(By.XPath(xpath), texto);
	        }
	        
	       

	    



	}

	
	

	public void escreveEClicaEnter(By by, String texto)
    {
        escreveTexto(by, texto);
        driver.findElement(by).sendKeys(Keys.ENTER);
    }
		
	public void urlSistema(String enderecoUrl) {
		driver.get(enderecoUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
}
