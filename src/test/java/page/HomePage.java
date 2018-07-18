package page;

import org.openqa.selenium.By;

import suporte.BaseDSL;

public class HomePage {
	
	BaseDSL baseDSL = new BaseDSL();
	
/*********** INÍCIO NAVEGAÇÃO **********/	
	public void inicia() {
		baseDSL.url("http://www.yaman.com.br");
	}
	
/********** BARRA DE PESQUISA **********/	
	
	public void lupaPesquisa() {
		baseDSL.common(By.className("fa fa-search"));	
	}
	
	public void barraPesquisa(String texto) {
		baseDSL.escreveEClicaEnter(By.id("s"), texto);
	}
	
	public void fecharBarraPesquisa() {
		baseDSL.common(By.className("search-off"));
	}
		
/*********** MENU **********/
	
	public void menuHome() {
		baseDSL.common(By.linkText("HOME"));
	}

/*********** BOXS INTERATIVOS **********/
	
	public void clicaPerformaceEDisponibilidade() {
		baseDSL.common(By.xpath("//div[@id='content-box-1']/div[1]//a[@href='http://yaman.com.br/performance-disponibilidade/']"));
	}
	
	public void clicaSegurancaDeAplicacoes() {
		baseDSL.common(By.xpath("//div[@id='content-box-1']/div[2]//a[@href='http://yaman.com.br/seguranca-de-aplicacoes/']"));
	}
	
	public void clicaQaTestes() {
		baseDSL.common(By.xpath("//div[@id='content-box-1']/div[3]//a[@href='http://yaman.com.br/qa-testes/']"));
	}
	
	public void clicaPerDevOps() {
		baseDSL.common(By.xpath("//div[@id='content-box-1']/div[4]//a[@href='http://yaman.com.br/devops/']"));
	}
	
/********** FIM *********/
	public void finaliza() {
		baseDSL.saida();
	}
}




