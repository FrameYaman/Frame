package suporte;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static suporte.Runner.getDriver;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseDSL {

	/******************** INTERÇÕES NAVEGADOR ********************/

	/**
	 * Indicar a url para navegação Exemplo: url("http://www.exemplourl.com.br");
	 * 
	 * @author lucas.casanova
	 * @param url
	 */
	public void url(String url) {
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Executa rolagem da página. Exemplo: rolarPagina("window.scrollBy(0,650)");
	 * 
	 * @author lucas.casanova
	 */
	public void rolarPagina(String rolagem) {
		((JavascriptExecutor) getDriver()).executeScript(rolagem);
	}

	/**
	 * Espera o tempo determinado por milisegundos para carregar. Utilizar números
	 * inteiros. Exemplo: 'esperaCarregar(tempo)'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void esperaCarregar(int tempo) {
		getDriver().manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
	}

	/**
	 * Saída / Finalização do sistema
	 * 
	 * @author lucas.casanova
	 */
	public void saida() {
		getDriver().quit();
	}
	
	
	/******************** TEXTFIELD E TEXTAREA ********************/
	
	/**
	 *Deve ser usado somente na base
	 * 
	 * @author lucas.casanova
	 */
	public void escreveTexto(By by , String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	/**
	 * Limpa a máscara que existe no campo de preenchimento e escreve texto neste
	 * mesmo campo. É necessário indicar o id referente. Exemplo:
	 * 'escreveTextoId("elementoId") , "texto")'
	 * 
	 * @author lucas.casanova
	 */
	public void escreveTextoId(String elementoId , String texto) {
		getDriver().findElement(By.id(elementoId)).clear();
		getDriver().findElement(By.id(elementoId)).sendKeys(texto);
	}

	/**
	 * Encontra campo de preenchimento por Name, escreve texto neste mesmo campo.
	 * Exemplo: 'escreveTextoName("elementoName" , "texto")'
	 * 
	 * @author lucas.casanova
	 */
	public void escreveTextoName(String elementoName, String texto) {
		getDriver().findElement(By.name(elementoName)).clear();
		getDriver().findElement(By.name(elementoName)).sendKeys(texto);
	}

	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo e pressiona Enter. É necessário indicar a Tag Id referente. 
	 * Exemplo:
	 * 'escreveTextoIdEClicaEnter("elementoId") , "texto")'
	 * 
	 * @author lucas.casanova
	 */
	public void escreveTextoIdEClicaEnter(String elementoId , String texto) {
		escreveTextoId(elementoId , texto);
		getDriver().findElement(By.id(elementoId)).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo e pressiona Enter. É necessário indicar a Tag Name referente. 
	 * Exemplo:
	 * 'escreveTextoNameEClicaEnter("elementoName" , "texto")'
	 * 
	 * @author lucas.casanova
	 */
	public void escreveTextoNameEClicaEnter(String elementoName , String texto) {
		escreveTextoId(elementoName , texto);
		getDriver().findElement(By.id(elementoName)).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Encontra Tag Name e clica com Backspace. 
	 * Exemplo: 
	 * 'clicaComBackspace("elementoId")'
	 * 
	 * @author lucas.casanova
	 */
	public void clicaIdComBackspace(String elementoId) {
		getDriver().findElement(By.id(elementoId)).sendKeys(Keys.BACK_SPACE);
	}
	
	/**
	 * Encontra Tag Name e clica com Backspace. 
	 * Exemplo: 
	 * 'clicaComBackspace("elementoName")'
	 * 
	 * @author lucas.casanova
	 */
	public void clicaNameComBackspace(String elementoName) {
		getDriver().findElement(By.name(elementoName)).sendKeys(Keys.BACK_SPACE);
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
		escreveTexto(By.className(className), texto);
		getDriver().findElement(By.className(className)).sendKeys(Keys.ENTER);
	}

	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo. Este método chama comando 'ClassName'. Exemplo:
	 * 'escreverNaClasse("NomeDaClasse" , texto)'
	 * 
	 * @param nome_classe
	 * @param texto
	 */
	public void escreveNaClasse(String nome_classe, String texto) {
		escreveTexto(By.className(nome_classe), texto);
	}

	/**
	 * Limpa a máscara que existe no campo de preenchimento, escreve texto neste
	 * mesmo campo. Este método chama comando 'Id'. Exemplo: 'escreveId("Id" ,
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
	 * Encontra na página da Web através da Tag Id e reserva por Tag encontrada.
	 * Exemplo: 'obterValorCampoAttributeId("elementoId", "innerText")'
	 * 
	 * @author lucas.casanova
	 */
	public String obterValorCampoAttributeId(String elementoId, String tag) {
		return getDriver().findElement(By.id(elementoId)).getAttribute(tag);
	}
	
	/**
	 * Encontra na página da Web através da Tag Name e reserva por Tag encontrada.
	 * Exemplo: 'obterValorCampoAttributeName("elementoName", "innerText")'
	 * 
	 * @author lucas.casanova
	 */
	public String obterValorCampoAttributeName(String elementoName, String tag) {
		return getDriver().findElement(By.name(elementoName)).getAttribute(tag);
	}
	
	/**
	 * Encontra na página da Web através da Classname e reserva por Tag encontrada.
	 * Exemplo: 'obterValorCampoAttributeClassName("elementoClassName", "innerText")'
	 * 
	 * @author lucas.casanova
	 */
	public String obterValorCampoAttributeClassName(String elementoClassName, String tag) {
		return getDriver().findElement(By.className(elementoClassName)).getAttribute(tag);
	}

	/**
	 * Retorna texto do elemento através da Tag Id e reserva o texto encontrado.
	 * Exemplo: 'obterCampoTextoId("elementoId")'
	 * 
	 * @author lucas.casanova
	 */
	public String obterCampoTextoId(String elementoId) {
		return getDriver().findElement(By.id(elementoId)).getText();
	}
	
	/**
	 * Retorna texto do elemento através da Tag Name e reserva o texto encontrado.
	 * Exemplo: 'obterCampoTextoName("elementoName")'
	 * 
	 * @author lucas.casanova
	 */
	public String obterCampoTextoName(String elementoName) {
		return getDriver().findElement(By.name(elementoName)).getText();
	}
	
	/**
	 * Retorna texto do elemento através da Tag ClassName e reserva o texto encontrado.
	 * Exemplo: 'obterCampoTextoClassName("elementoId")'
	 * 
	 * @author lucas.casanova
	 */
	public String obterCampoTextoClassName(String elementoClassName) {
		return getDriver().findElement(By.className(elementoClassName)).getText();
	}
	
	/**
	 * Verifica se campo obrigatório foi preenchido corretamente. Exemplo:
	 * 'checarCampoObrigatorioId("texto" , "id")'
	 * 
	 * @author lucas.casanova
	 */
	public void checarCampoObrigatorioId(String texto, String id) {
		Assert.assertEquals(texto, obterCampoTextoId(id));
	}
	
	/**
	 * Verifica se campo obrigatório foi preenchido corretamente. Exemplo:
	 * 'checarCampoObrigatorioName("texto" , "name")'
	 * 
	 * @author lucas.casanova
	 */
	public void checarCampoObrigatorioName(String texto, String name) {
		Assert.assertEquals(texto, obterCampoTextoName(name));
	}
	
	/**
	 * Verifica se campo obrigatório foi preenchido corretamente. Exemplo:
	 * 'checarCampoObrigatorioClassName("texto" , "className")'
	 * 
	 * @author lucas.casanova
	 */
	public void checarCampoObrigatorioClassName(String texto, String className) {
		Assert.assertEquals(texto, obterCampoTextoClassName(className));
	}

	/******************** RADIO E CHECK ********************/

	/**
	 * Encontra elemento e confirma se está selecionado. 
	 * Exemplo:
	 * 'isElementoMarcadoId("Id")'
	 * 
	 * @author guilherme.teixeira
	 */
	public Boolean isElementoMarcadoId(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/**
	 * Encontra elemento e confirma se está selecionado. 
	 * Exemplo:
	 * 'isElementoMarcadoName("name")'
	 * 
	 * @author guilherme.teixeira
	 */
	public Boolean isElementoMarcadoName(String name) {
		return getDriver().findElement(By.name(name)).isSelected();
	}
	
	/**
	 * Encontra elemento e confirma se está selecionado. Exemplo:
	 * 'isElementoMarcado("className")'
	 * 
	 * @author guilherme.teixeira
	 */
	public Boolean isElementoMarcadoClassName(String className) {
		return getDriver().findElement(By.className(className)).isSelected();
	}
	
	/**
	 * Encontra campo Check, seleciona pressionando Espaço para marcar. Exemplo:
	 * 'isCheckMarcadoComEspacoId("id")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void isCheckMarcadoComEspacoId(String id) {
		getDriver().findElement(By.id(id)).sendKeys(Keys.SPACE);
	}
	
	/**
	 * Encontra campo Check, seleciona pressionando Espaço para marcar. Exemplo:
	 * 'isCheckMarcadoComEspacoName("name")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void isCheckMarcadoComEspacoName(String name) {
		getDriver().findElement(By.name(name)).sendKeys(Keys.SPACE);
	}
	
	/**
	 * Encontra campo Check, seleciona pressionando Espaço para marcar. Exemplo:
	 * 'isCheckMarcadoComEspacoClassName("className)'
	 * 
	 * @author guilherme.teixeira
	 */
	public void isCheckMarcadoComEspacoClassName(String className) {
		getDriver().findElement(By.className(className)).sendKeys(Keys.SPACE);
	}

	/******************** COMBO ********************/

	/**
	 * Encontra campo Combo e seleciona elemento por texto deste Combo. 
	 * Exemplo:
	 * 'selecionarCombo("Id" , "texto")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void selecionarComboId(String id, String texto) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}
	
	/**
	 * Encontra campo Combo e seleciona elemento por texto deste Combo. 
	 * Exemplo:
	 * 'selecionarComboName("name" , "texto")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void selecionarComboName(String name, String texto) {
		WebElement elemento = getDriver().findElement(By.name(name));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}
	
	/**
	 * Encontra campo Combo e seleciona elemento por texto deste Combo. 
	 * Exemplo:
	 * 'selecionarComboClassName("className" , "TextoDoCombo")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void selecionarComboClassName(String className, String texto) {
		WebElement elemento = getDriver().findElement(By.className(className));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}

	/**
	 * Encontra campo Combo por Tag Id e retira a seleção do elemento deste Combo.
	 * Exemplo: 'deselecionarComboId("id" , "TextoDoCombo")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void deselecionarComboId(String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}
	
	/**
	 * Encontra campo Combo por Tag Name e retira a seleção do elemento deste Combo.
	 * Exemplo: 'deselecionarComboName("name" , "TextoDoCombo")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void deselecionarComboName(String name, String valor) {
		WebElement elemento = getDriver().findElement(By.name(name));
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}
	
	/**
	 * Encontra campo Combo por Tag ClassName e retira a seleção do elemento deste Combo.
	 * Exemplo: 'deselecionarComboClassName("className" , "TextoDoCombo")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void deselecionarComboClassName(String className, String valor) {
		WebElement elemento = getDriver().findElement(By.className(className));
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}

	/******************** BOTÃO ********************/

	/**
	 * Encontra elemento pela indicação solicitada e clica.
	 * 
	 * @author guilherme.teixeira
	 */
	public void clicaElementoId(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	/**
	 * Encontra elemento pela indicação solicitada e clica.
	 * 
	 * @author guilherme.teixeira
	 */
	public void clicaElementoName(String name) {
		getDriver().findElement(By.name(name)).click();
	}
	
	/**
	 * Encontra elemento pela indicação solicitada e clica.
	 * 
	 * @author guilherme.teixeira
	 */
	public void clicaElementoClassName(String className) {
		getDriver().findElement(By.className(className)).click();
	}
	
	/**
	 * Encontra elemento pela indicação solicitada e clica.
	 * 
	 * @param xpath
	 */
	public void clicaElementoXPath(String xpath) {
		getDriver().findElement(By.xpath("xpath"));
	}
	
	/******************** TEXTOS ********************/

	/**
	 * Encontra elemento Text por indicação selecionada e reserva texto encontrado.
	 * É necessário indicar a TAG referente. 
	 * Exemplo: 
	 * 'obterTextoId("id")'
	 * 
	 * @author guilherme.teixeira
	 */
	public String obterTextoId(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	/**
	 * Encontra elemento Text por indicação selecionada e reserva texto encontrado.
	 * É necessário indicar a TAG referente. 
	 * Exemplo: 
	 * 'obterTextoName("name")'
	 * 
	 * @author guilherme.teixeira
	 */
	public String obterTextoName(String name) {
		return getDriver().findElement(By.name(name)).getText();
	}
	
	/**
	 * Encontra elemento Text por indicação selecionada e reserva texto encontrado.
	 * É necessário indicar a TAG referente. 
	 * Exemplo: 
	 * 'obterTextoClassName("className")'
	 * 
	 * @author guilherme.teixeira
	 */
	public String obterTextoClassName(String className) {
		return getDriver().findElement(By.className(className)).getText();
	}

	/******************** ALERTS ********************/

	/**
	 * Desvia a atenção para um Alert obtém texto. Aceita Alert e retorna texto
	 * deste Alert. 
	 * Exemplo: 
	 * 'alertaObterTextoEAceita()'
	 * 
	 * @author guilherme.teixeira
	 */
	public String alertaObterTextoEAceita() {
		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.accept();
		return valor;
	}

	/**
	 * Desvia a atenção para um Alert obtém texto. Rejeita Alert e retorna texto
	 * deste Alert. 
	 * Exemplo: 
	 * 'alertaObterTextoENega()'
	 * 
	 * @author guilherme.teixeira
	 */
	public String AlertaObterTextoENega() {
		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.dismiss();
		return valor;
	}

	/**
	 * Desvia a atenção para um Alert escreve texto indicado e aceita Alert.
	 * Exemplo: 'alertaEscrever("Texto")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void alertaEscrever(String texto) {
		Alert alerta = getDriver().switchTo().alert();
		alerta.sendKeys(texto);
		alerta.accept();
	}

	/******************* FRAMES E JANELAS *******************/

	/**
	 * Desvia a atenção para um Frame por Tag indicada e entra.
	 * Exemplo:
	 * 'entrarFrame("elemento")'
	 * 
	 * @author guilherme.teixeira
	 */
	public void entrarFrame(String elemento) {
		getDriver().switchTo().frame(elemento);
	}

	/**
	 * Sai do Frame e retorna para a página principal. Exemplo: 'SairFrame()'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Desvia a atenção para uma janela por Id indicado. Exemplo:
	 * 'trocarJanela("elemento")'
	 * 
	 * @param by
	 * @param valor
	 * @author guilherme.teixeira
	 */
	public void trocarJanela(String elemento) {
		getDriver().switchTo().window(elemento);
	}

	/********* CNPJ, CPF, Pessoa, Empresa e E-mail ************/

	/**
	 * Gerador de CNPJ automático
	 * 
	 * @return numerogerado
	 * @author joaofranco
	 */
	public String geraCNPJ() {
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
		System.out.println("RG gerado: " + numeroGerado);
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

	/**
	 * Metodo onde podera ser usado caso queira rodar algum progama no Shell do
	 * Windows
	 * 
	 * @author joao.celino
	 * 
	 */

	public void executarPromtWindows(String comando) {

		String ping = comando;

		String[] cmds = { ping };

		try {
			ProcessBuilder builder = new ProcessBuilder("cmd", "/c", String.join("& ", cmds));

			builder.redirectErrorStream(true);

			Process p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;

			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}

				System.out.println(line);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * Meto onde podera ser usado para executar comandos no terminal (Linux/Apple)
	 * 
	 * @author joaofranco
	 * @throws IOException
	 * 
	 */
	public void executarTerminal(String comando) throws IOException {
		
		
	}
}
