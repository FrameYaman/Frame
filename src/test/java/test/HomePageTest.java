package test;

import org.junit.Test;

import page.HomePage;

public class HomePageTest {
	
	HomePage page = new HomePage();
	
	@Test
	public void testeExemplo() {
		page.inicia();
		page.clicaPerformaceEDisponibilidade();		
	}
}
