package test;

import org.junit.Test;

import page.HomePage;

public class HomePageTest {

	HomePage page = new HomePage();

	@Test
	public void testeDeExemplo() {
		page.inicia();
		page.clicaPerformaceEDisponibilidade();
		page.finaliza();
	}
}
