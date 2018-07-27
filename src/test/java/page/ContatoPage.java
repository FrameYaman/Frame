package page;

import suporte.BaseDSL;

public class ContatoPage {
	

	BaseDSL baseDSL = new BaseDSL();
	MenuPage menu = new MenuPage();

	/*********** INÍCIO NAVEGAÇÃO **********/
	
	public void inicia() {
		baseDSL.url("http://www.yaman.com.br");
		menu.contato();
	}	
	
	/*********** TEXTFILD **********/
	
	public void escreveSeuEmail(String email) {
		baseDSL.escreveTextoName("your-email", email); 
	}
	
	public void escreveAssunto(String assunto) {
		baseDSL.escreveTextoName("your-subject", assunto);
	}
	
	public void escreveSuaMensagem(String mensagem) {
		baseDSL.escreveTextoName("your-message", mensagem);
	}
	
	/*********** BOTÃO **********/
	
	public void clicaBotaoEnviar() {
		baseDSL.clicaElementoClassName("wpcf7-form-control wpcf7-submit");
	}
	
	public void finaliza() {
		baseDSL.saida();
	}

}
