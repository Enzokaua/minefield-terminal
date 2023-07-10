package br.com.enzo.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.enzo.cm.modelo.ExplosaoException;
import br.com.enzo.cm.modelo.SairException;
import br.com.enzo.cm.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	
		executarJogo();
	}
	
	public void executarJogo() {
		
		try {
			boolean continuar = true;
			while(continuar) {
				cicloGame();
				
				System.out.println("Outra partida? (S/n): ");
				String resposta = entrada.next();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}
		} catch(SairException e) {
			System.out.println("TCHAU!!!");
		} finally{
			entrada.close();
		}
		
	}
	
	
	private void cicloGame() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarDigitado("DIGITE (Y, X): ");;
				 Iterator <Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();
				 System.out.println("DIGITE 1(ABRIR), 2(MARCAR): ");
				 digitado = entrada.next();
				 if (digitado.equals("1")) {
				     tabuleiro.abrir(xy.next(), xy.next());
				 } else if (digitado.equals("2")) {
				     tabuleiro.alterarMarcacao(xy.next(), xy.next());
				 } else {
				     System.out.println("Digite um valor válido");
				 }

			}
			System.out.println(tabuleiro);
			System.out.println("Parabéns você ganhou!");
		} catch (ExplosaoException e){
			System.out.println("Infelizmente você perdeu!");
		}
	} 
	
	private String capturarDigitado(String texto) {
		System.out.println(texto);
		String digitado = entrada.next();
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		} else {
			
		}
		
		return digitado;
	}
	
}
