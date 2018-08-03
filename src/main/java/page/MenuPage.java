package page;

import suporte.BaseDSL;

public class MenuPage {
	
	BaseDSL baseDSL = new BaseDSL();
	
	public void home() {
		baseDSL.clicaElementoId("menu-item-2828");
	}
	
	public void solucoes() {
		baseDSL.clicaElementoId("menu-item-2829");
	}
	
	public void clientesParceiros() {
		baseDSL.clicaElementoId("menu-item-101");
	}
	
	public void empresa() {
		baseDSL.clicaElementoId("menu-item-114");
	}
	
	public void contato() {
		baseDSL.clicaElementoId("menu-item-102");
	}
	
	public void artigos() {
		baseDSL.clicaElementoId("menu-item-4975");
	}
	
	public void trabalheConosco() {
		baseDSL.clicaElementoId("menu-item-396");
	}	
}
