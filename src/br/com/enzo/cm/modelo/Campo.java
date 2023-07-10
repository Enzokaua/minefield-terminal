package br.com.enzo.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.AbstractRowProcessor;

public class Campo {

	private final int linhas; // COORDENADA X QUE NOSSO CAMPO IRÁ TER
	private final int colunas; // COORDENADA Y QUE NOSSO CAMPO IRÁ TER
	private boolean marcado = false; // SE O CAMPO FOI MARCADO POR POSSUIR UMA POSSIVEL BOMBA
	private boolean aberto = false; // SE O CAMPO FOI ABERTO
	private boolean minado = false; // SE O CAMPO É MINADO

	private List<Campo> vizinhos = new ArrayList<>(); // RELACAO DE 1 PRA N CONSIGO MESMO, CRIANDO ASSIM OS VIZINHOS,
														// POIS QUANDO ABRIRMOS UM CAMPO, OS VIZINHOS TAMBEM DEVEM SE
														// ABRIR

	public Campo(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
	}

	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linhas != vizinho.linhas;
		boolean colunaDiferente = colunas != vizinho.colunas;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(linhas - vizinho.linhas);
		int deltaColuna = Math.abs(colunas - vizinho.colunas);
		int deltaGeral = deltaLinha + deltaColuna;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}

	void alternarMarcacao() {
		if (!aberto) {
			marcado = !marcado;
		}
	}

	boolean abrir() {
		if (!aberto && !marcado) {
			aberto = true;
			if (minado) {
				throw new ExplosaoException();
			}
			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		} else {
			return false;
		}
	}

	boolean minado() {
		return minado = !minado;
	}

	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}

	public boolean isMarcado() {
		return marcado;
	}

	boolean minar() {
		return minado = true;
	}

	public boolean isMinado() {
		return minado;
	}

	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isAberto() {
		return aberto;
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}

	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}

	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}

	public String toString() {
		if (marcado) {
			return "X";
		} else if (aberto && minado) {
			return "*";
		} else if (aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		} else if (aberto) {
			return " ";
		} else {
			return "?";
		}
	}

}
