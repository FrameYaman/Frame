package page;

import suporte.BaseDSL;

public class HomePage {

	BaseDSL baseDSL = new BaseDSL();

	/*********** INÍCIO NAVEGAÇÃO **********/
	public void inicia() {
		baseDSL.url("http://www.yaman.com.br");
	}

	/********** BARRA DE PESQUISA **********/

	public void lupaPesquisa() {
		baseDSL.clicaElementoName("fa fa-search");
	}

	public void barraPesquisa(String texto) {
		baseDSL.escreveId("s", texto);
	}

	public void fecharBarraPesquisa() {
		baseDSL.clicaElementoName("search-off");
	}

	/*********** MENU **********/

	public void menuHome() {
		baseDSL.clicaElementoLink("HOME");
	}

	/*********** BOXS INTERATIVOS **********/

	public void clicaPerformaceEDisponibilidade() {
		baseDSL.clicaElementoXPath(
				"//div[@id='content-box-1']/div[1]//a[@href='http://yaman.com.br/performance-disponibilidade/']");
	}

	public void clicaSegurancaDeAplicacoes() {
		baseDSL.clicaElementoXPath(
				"//div[@id='content-box-1']/div[2]//a[@href='http://yaman.com.br/seguranca-de-aplicacoes/']");
	}

	public void clicaQaTestes() {
		baseDSL.clicaElementoXPath("//div[@id='content-box-1']/div[3]//a[@href='http://yaman.com.br/qa-testes/']");
	}

	public void clicaPerDevOps() {
		baseDSL.clicaElementoXPath("//div[@id='content-box-1']/div[4]//a[@href='http://yaman.com.br/devops/']");
	}

	/********** FIM *********/
	public void finaliza() {
		baseDSL.saida();
	}
}
