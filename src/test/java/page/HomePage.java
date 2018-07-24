package page;

import suporte.BaseDSL;

public class HomePage {

	BaseDSL baseDSL = new BaseDSL();

	/*********** INÍCIO NAVEGAÇÃO **********/
	public void inicia() {
		baseDSL.url("http://www.yaman.com.br");
	}

	/********** BARRA DE PESQUISA **********/

	public void clicaPesquisa() {
		baseDSL.clicaElementoClassName("fa fa-search");
	}

	public void escreveBarraPesquisa(String texto) {
		baseDSL.escreveTextoIdEClicaEnter("s", texto);
	}

	public void fecharBarraPesquisa() {
		baseDSL.clicaElementoClassName("search-off");
	}

	/*********** BOXS INTERATIVOS **********/

	public void clicaPerformaceEDisponibilidade() {
		baseDSL.clicaElementoXPath("//div[@id='content-box-1']/div[1]//a[@href='http://yaman.com.br/performance-disponibilidade/']");
	}

	public void clicaSegurancaDeAplicacoes() {
		baseDSL.clicaElementoXPath("//div[@id='content-box-1']/div[2]//a[@href='http://yaman.com.br/seguranca-de-aplicacoes/']");
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
