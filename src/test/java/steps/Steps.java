package steps;

import cucumber.api.DataTable;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Steps {
	
	@Dado("^que estou no site \"([^\"]*)\"$")
	public void que_estou_no_site(String arg1) throws Throwable {
	}

	@Quando("^apresentar a pagina inicial$")
	public void apresentar_a_pagina_inicial() throws Throwable {
	}

	@Entao("^o menu <menu> seria visualizado com sucesso$")
	public void o_menu_menu_seria_visualizado_com_sucesso() throws Throwable {
	}

	@Dado("^clico no menu \"([^\"]*)\"$")
	public void clico_no_menu(String arg1) throws Throwable {
	}

	@Quando("^carregar a pagina \"([^\"]*)\"$")
	public void carregar_a_pagina(String arg1) throws Throwable {
	}

	@Quando("^preencher o cadastro de contato$")
	public void preencher_o_cadastro_de_contato() throws Throwable {
	}

	@Entao("^deveria enviar contato com sucesso$")
	public void deveria_enviar_contato_com_sucesso(DataTable arg1) throws Throwable {
	}
}