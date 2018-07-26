package test;

import org.junit.Test;

import page.ContatoPage;

public class ContatoTest{
	
	ContatoPage page = new ContatoPage();
	
	@Test
	public void testeEnvioContato() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
		
	}
	
	@Test
	public void testeEnvioVazio() {
		page.inicia();
		page.clicaBotaoEnviar();
	}
	
	@Test
	public void testeAberturaPage() {
		page.inicia();
	}
}
