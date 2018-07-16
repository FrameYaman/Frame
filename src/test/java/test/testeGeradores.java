package test;

import suporte.BaseDSL;

public class testeGeradores {

	public static void main(String[] args) {
		
		BaseDSL	base = new BaseDSL();
		
		base.geraCPF();
		base.geraCNPJ();
		base.gerarRg();

	}

}
