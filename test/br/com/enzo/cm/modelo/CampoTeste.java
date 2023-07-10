package br.com.enzo.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.enzo.cm.modelo.*;

class CampoTeste {
	private Campo campo;

	@BeforeEach // PARA CADA METODO CRIADO, ELE CHAMARA ESSA FUNCAO ASSINATURA ANTES
	void defineCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testandoVizinhosCima() {
		Campo testeVizinho = new Campo(3, 2); // SETANDO UM NOVO VALOR PARA TESTE DO MESMO
		boolean resultado = campo.adicionarVizinho(testeVizinho);// ATRIBUINDO VALOR A UM CAMPO PARA TESTAR
		assertTrue(resultado); // METODO UTILIZADA PARA TESTAR UM RETORNO TRUE OR FALSE
	}

	@Test
	void testandoVizinhosBaixo() {
		Campo testeVizinho = new Campo(2, 3); // SETANDO UM NOVO VALOR PARA TESTE DO MESMO
		boolean resultado = campo.adicionarVizinho(testeVizinho);// ATRIBUINDO VALOR A UM CAMPO PARA TESTAR
		assertTrue(resultado); // METODO UTILIZADA PARA TESTAR UM RETORNO TRUE OR FALSE
	}

	@Test
	void testandoVizinhosDiagonal() {
		Campo testeVizinho = new Campo(2, 2); // SETANDO UM NOVO VALOR PARA TESTE DO MESMO
		boolean resultado = campo.adicionarVizinho(testeVizinho);// ATRIBUINDO VALOR A UM CAMPO PARA TESTAR
		assertTrue(resultado); // METODO UTILIZADA PARA TESTAR UM RETORNO TRUE OR FALSE
	}

	@Test
	void testePadraoValor() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeMinadoNaoMarcado() {
		campo.minado();
		assertThrows(ExplosaoException.class, () -> {

			campo.abrir();
		});
	}

	@Test
	void testeMinadoMarcado() {
		campo.minado();
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeVizinhoAbrir() {
		Campo vizinho1 = new Campo(2, 2);
		Campo vizinho2 = new Campo(2, 3);
		vizinho1.adicionarVizinho(vizinho2);
		campo.adicionarVizinho(vizinho1);
		campo.abrir();
		assertTrue(vizinho1.isAberto() && vizinho2.isAberto());
				
	}

}
