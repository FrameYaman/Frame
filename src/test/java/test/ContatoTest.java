package test;

import org.junit.Test;

import page.ContatoPage;
import suporte.Hooks;
//import suporte.Operations;

public class ContatoTest extends Hooks{
	
	ContatoPage page = new ContatoPage();
	
	@Test
	public void testeEnvioContato() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
//		page.finaliza();
	}
	
	@Test
	public void testeEnvioVazio() {
		page.inicia();
//		page.finaliza();
	}
	
	@Test
	public void testeAberturaPage() {
		page.inicia();
//		page.finaliza();
	}
}
