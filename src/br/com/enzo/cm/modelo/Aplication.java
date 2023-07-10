package br.com.enzo.cm.modelo;

import br.com.enzo.cm.visao.TabuleiroConsole;

public class Aplication {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(10, 10, 4);
		new TabuleiroConsole(tabuleiro);

	}

}
