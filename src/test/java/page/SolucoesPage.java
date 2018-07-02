package page;

import org.openqa.selenium.By;

import suporte.BaseDSL;

public class SolucoesPage {
	
	BaseDSL baseDSL = new BaseDSL();
	
	public void menuSolucoes() {
		baseDSL.common(By.linkText("SOLUÇÕES"));
	}

}
