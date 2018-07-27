package test;

import org.junit.Test;

import page.ContatoPage;
import suporte.Hooks;
import suporte.Operations;

public class ContatoTest extends Hooks{
	
	ContatoPage page = new ContatoPage();
	
	@Test
	public void testeEnvioContato() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
		page.clicaBotaoEnviar();
		
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
