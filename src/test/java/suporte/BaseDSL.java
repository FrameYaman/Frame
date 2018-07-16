package suporte;

import java.util.Random;
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

	/******************** INTERA��ES NAVEGADOR ********************/

	/**
	 * Indicar a url para navega��o Exemplo: url("http://www.exemplourl.com.br");
	 * 
	 * @author lucas.casanova
	 * @param url
	 */
	public void url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Executa rolagem da p�gina. Exemplo: rolarPagina("window.scrollBy(0,650)");
	 * 
	 * @author lucas.casanova
	 */
	public void rolarPagina(String rolagem) {
		((JavascriptExecutor) driver).executeScript(rolagem);
	}

	/**
	 * Espera o tempo determinado por milisegundos para carregar. Utilizar n�meros
	 * inteiros. Exemplo: 'esperaCarregar(tempo)'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void esperaCarregar(int tempo) {
		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
	}

	/**
	 * Sa�da / Finaliza��o do sistema
	 * 
	 * @author lucas.casanova
	 */
	public void saida() {
		driver.quit();
	}

	/******************** TEXTFIELD E TEXTAREA ********************/

	/**
	 * Limpa a m�scara que existe no campo de preenchimento e escreve texto neste
	 * mesmo campo. � necess�rio indicar a TAG referente. Exemplo:
	 * 'escreveTexto(By.id("Id") , "texto")'
	 * 
	 * @author lucas.casanova
	 * @param by
	 *            (utilizado para indicar a Tag)
	 * @param texto
	 *            (utilizado para indicar o texto)
	 */
	public void escreveTexto(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	/**
	 * Encontra campo de preenchimento por Name, escreve texto neste mesmo campo.
	 * Exemplo: 'encontraNameEscreveTexto("Name" , "texto")'
	 * 
	 * @author lucas.casanova
	 * @param name
	 *            (utilizado para indicar TAG name)
	 * @param texto
	 *            (utilizado para indicar o texto)
	 */
	public void encontraNameEscreveTexto(String name, String texto) {
		escreveTexto(By.name(name), texto);
	}

	/**
	 * Limpa a m�scara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo e pressiona Enter. � necess�rio indicar a TAG referente. Exemplo:
	 * 'EscreveEClicaEnter(By.Id("Id") , "texto")'
	 * 
	 * @author lucas.casanova
	 * @param by
	 * @param texto
	 */
	public void escreveEClicaEnter(By by, String texto) {
		escreveTexto(by, texto);
		driver.findElement(by).sendKeys(Keys.ENTER);
	}

	/**
	 * Encontra Tag Name e clica com Backspace. Exemplo: 'clicaComBackspace("name")'
	 * 
	 * @author lucas.casanova
	 * @param name
	 */
	public void clicaNameComBackspace(String name) {
		driver.findElement(By.name(name)).sendKeys(Keys.BACK_SPACE);
	}

	/**
	 * Encontra campo de preenchimento por ClassName, escreve texto neste mesmo
	 * campo e pressiona Enter. Exemplo: 'encontraClassEnviaTextoEnter("ClassName" ,
	 * "texto")'.
	 * 
	 * @author lucas.casanova
	 * @param className
	 * @param texto
	 */
	public void encontraClassEnviaTextoEnter(String className, String texto) {
		escreveEClicaEnter(By.className(className), texto);
	}

	/**
	 * Limpa a m�scara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo. Este m�todo chama comando 'ClassName'. Exemplo:
	 * 'escreverNaClasse("NomeDaClasse" , texto)'
	 * 
	 * @param nome_classe
	 * @param texto
	 */
	public void escreveNaClasse(String nome_classe, String texto) {
		escreveTexto(By.className(nome_classe), texto);
	}

	/**
	 * Limpa a m�scara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo. Este m�todo chama comando 'Id'. Exemplo: 'escreveId("Id" ,
	 * texto)'
	 * 
	 * @author lucas.casanova
	 * @param id_campo
	 * @param texto
	 */
	public void escreveId(String id_campo, String texto) {
		escreveTexto(By.id(id_campo), texto);
	}

	/**
	 * Encontra na p�gina da Web atrav�s de Id e reserva por Tag encontrada.
	 * Exemplo: 'obterValorCampoAttribute("Id", "innerText")'
	 * 
	 * @author lucas.casanova
	 * @param id_campo
	 * @return
	 */
	public String obterValorCampoAttribute(By by, String tag) {
		return driver.findElement(by).getAttribute(tag);
	}

	/**
	 * Encontra na p�gina da Web atrav�s de Id e reserva o texto encontrado.
	 * Exemplo: 'obterCampoTexto("id")'
	 * 
	 * @author lucas.casanova
	 * @param by
	 * @return
	 */
	public String obterCampoTexto(By by) {
		return driver.findElement(by).getText();
	}

	/**
	 * Verifica se campo obrigat�rio foi preenchido corretamente. Exemplo:
	 * 'checarCampoObrigatorio("texto" , "id")'
	 * 
	 * @author lucas.casanova
	 * @param texto
	 * @param by
	 */
	public void checarCampoObrigatorio(String texto, By by) {
		Assert.assertEquals(texto, obterCampoTexto(by));
	}

	/******************** RADIO E CHECK ********************/

	/**
	 * Encontra elemento pela indica��o solicitada e clica.
	 * 
	 * @param by
	 *            (utilizado para indicar a Tag) � necess�rio indicar a TAG
	 *            referente. Exemplo: 'common(By.Id("Id"))'
	 * @author guilherme.teixeira
	 */
	public void common(By by) {
		driver.findElement(by).click();
	}

	/**
	 * Encontra elemento e confirma se est� selecionado. Exemplo:
	 * 'isElementoMarcado(By.Id("Id"))'
	 * 
	 * @author guilherme.teixeira
	 * @param by
	 *            (utilizado para indicar a Tag)
	 * @return Boolean
	 */
	public Boolean isElementoMarcado(By by) {
		return driver.findElement(by).isSelected();
	}

	/**
	 * Encontra campo Check, seleciona pressionando Espa�o para marcar. Exemplo:
	 * 'isCheckMarcadoComEspaco(By.Id("Id"))'
	 * 
	 * @param by
	 *            (utilizado para indicar a Tag)
	 * @author guilherme.teixeira
	 */
	public void isCheckMarcadoComEspaco(By by) {
		driver.findElement(by).sendKeys(Keys.SPACE);
	}

	/******************** COMBO ********************/

	/**
	 * Encontra campo Combo e seleciona elemento por texto deste Combo. Exemplo:
	 * 'selecionarCombo("Id" , "TextoDoCombo")'
	 * 
	 * @param by
	 * @param texto
	 * @author guilherme.teixeira
	 */
	public void selecionarCombo(By by, String texto) {
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}

	/**
	 * Encontra campo Combo por Id e retira a sele��o do elemento deste Combo.
	 * Exemplo: 'deselecionarCombo("Id" , "TextoDoCombo")'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void deselecionarCombo(By by, String valor) {
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}

	/******************** BOT�O ********************/

	/**
	 * Encontra elemento Bot�o por indica��o selecionada e clica. � necess�rio
	 * indicar a TAG referente. Exemplo: 'commonClicar(By.Id("Id"))'
	 * 
	 * @param by
	 */
	public void commonClicar(By by) {
		driver.findElement(by).click();
	}

	/******************** TEXTOS ********************/

	/**
	 * Encontra elemento Text por indica��o selecionada e reserva texto encontrado.
	 * � necess�rio indicar a TAG referente. Exemplo: 'obterTexto(By.Id("Id"))'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	/******************** ALERTS ********************/

	/**
	 * Desvia a aten��o para um Alert obt�m texto. Aceita Alert e retorna texto
	 * deste Alert. Exemplo: 'alertaObterTextoEAceita()'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public String alertaObterTextoEAceita() {
		Alert alerta = driver.switchTo().alert();
		String valor = alerta.getText();
		alerta.accept();
		return valor;
	}

	/**
	 * Desvia a aten��o para um Alert obt�m texto. Rejeita Alert e retorna texto
	 * deste Alert. Exemplo: 'alertaObterTextoENega()'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public String AlertaObterTextoENega() {
		Alert alerta = driver.switchTo().alert();
		String valor = alerta.getText();
		alerta.dismiss();
		return valor;
	}

	/**
	 * Desvia a aten��o para um Alert escreve texto indicado e aceita Alert.
	 * Exemplo: 'alertaEscrever("Texto")'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void alertaEscrever(String texto) {
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys(texto);
		alerta.accept();
	}

	/******************* FRAMES E JANELAS *******************/

	/**
	 * Desvia a aten��o para um Frame por Id indicado e entra. Exemplo:
	 * 'entrarFrame("Id")'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void entrarFrame(String elemento) {
		driver.switchTo().frame(elemento);
	}

	/**
	 * Sai do Frame e retorna para a p�gina principal. Exemplo: 'SairFrame()'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Desvia a aten��o para uma janela por Id indicado. Exemplo:
	 * 'trocarJanela("elemento")'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void trocarJanela(String elemento) {
		driver.switchTo().window(elemento);
	}

	/********* CNPJ, CPF, Pessoa, Empresa e E-mail ************/

	/**
	 * Gerador de CNPJ automatico
	 * 
	 * @return numerogerado
	 * @author joaofranco
	 */
	public String geraCNPJ()  {
		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;
		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);
		int n10 = numeroAleatorio.nextInt(10);
		int n11 = numeroAleatorio.nextInt(10);
		int n12 = numeroAleatorio.nextInt(10);
		int soma = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4
				+ n1 * 5;
		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3
				+ n3 * 4 + n2 * 5 + n1 * 6;
		int valor2 = (soma2 / 11) * 11;
		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + "." + String.valueOf(n3) + String.valueOf(n4)
				+ String.valueOf(n5) + "." + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8) + "/"
				+ String.valueOf(n9) + String.valueOf(n10) + String.valueOf(n11) + String.valueOf(n12) + "-";

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
		numeroGerado = numerosContatenados + nDigResult;
		System.out.println("Digito 2 ->" + digito2);
		System.out.println("CNPJ Gerado " + numeroGerado);
		return numeroGerado;
	}

	/**
	 * Gerador de RG
	 * 
	 * @return numerogerado
	 * @throws Exception
	 * @author joaofranco
	 */

	public String gerarRg() {
		String numerosContatenados;
		String numeroGerado;
		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9);
		numeroGerado = numerosContatenados;
		return numeroGerado;
	}

	/**
	 * Gerador de CPF automatico
	 * 
	 * @author joaofranco
	 * @return numerogerado
	 * 
	 */
	public String geraCPF() {
		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;
		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);
		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;
		int valor = (soma / 11) * 11;
		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;
		int valor2 = (soma2 / 11) * 11;
		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + "." + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + "." + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9) + "-";

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
		numeroGerado = numerosContatenados + nDigResult;
		System.out.println("CPF Gerado " + numeroGerado);
		return numeroGerado;
	}
}
