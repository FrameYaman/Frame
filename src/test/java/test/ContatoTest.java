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
	}
	@Test
	public void testeEnvioContato22() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato11() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato1() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato2() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato3() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato4() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato5() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	@Test
	public void testeEnvioContato6() {
		page.inicia();
		page.escreveSeuEmail("exemplo.email@email.com");
		page.escreveAssunto("Yaman");
		page.escreveSuaMensagem("#NAOIRRITEOCLIENTE");
	}
	
	@Test
	public void testeEnvioVazio() {
		page.inicia();
	}
	
	@Test
	public void testeAberturaPage() {
		page.inicia();
	}
}
