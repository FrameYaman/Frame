package test;

import java.io.IOException;

import suporte.BaseDSL;

public class testeGeradores {

	public static void main(String[] args) throws IOException {
		
		BaseDSL	base = new BaseDSL();
		
		base.geraCPF();
		base.geraCNPJ();
		base.gerarRg();

		base.executarTerminal("ping");
	}

}
