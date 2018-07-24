package steps;

import cucumber.api.DataTable;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Steps {
	
	@Dado("^que estou no site \"([^\"]*)\"$")
	public void que_estou_no_site(String arg1) throws Throwable {
	}

	@Quando("^apresentar a página inicial$")
	public void apresentar_a_página_inicial() throws Throwable {
	}

	@Então("^o menu <menu> será visualizado com sucesso$")
	public void o_menu_menu_será_visualizado_com_sucesso() throws Throwable {
	}

	@Dado("^clico no menu <menu>$")
	public void clico_no_menu_menu() throws Throwable {
	}

	@Quando("^cerregar a página \"([^\"]*)\"$")
	public void cerregar_a_página(String arg1) throws Throwable {
	}

	@Quando("^preencher o cadastro de contato$")
	public void preencher_o_cadastro_de_contato() throws Throwable {
	}

	@Então("^deverá enviar contato com sucesso$")
	public void deverá_enviar_contato_com_sucesso(DataTable arg1) throws Throwable {
	}
}
