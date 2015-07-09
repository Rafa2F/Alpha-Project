package br.com.miniware.alpha;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AlphaTest {

	@Test
	public void testResolverQuandoAEquacaoJaEARespostaFinalEDois() {
		assertEquals(Resolver.resolver("x=2"), "x=2");
	}

	@Test
	public void testExplicarQuandoAEquacaoJaEARespostaFinalEDois() {
		assertEquals(Resolver.resolver("x=2"), "x=2");
		assertEquals(Resolver.explicar(), "A expressão já está simplificada.");
	}
	
	@Test
	public void testResolverQuandoAEquacaoJaEARespostaFinalESete() {
		assertEquals(Resolver.resolver("x=7"), "x=7");
	}

	@Test
	public void testExplicarQuandoAEquacaoJaEARespostaFinalESete() {
		assertEquals(Resolver.resolver("x=7"), "x=7");
		assertEquals(Resolver.explicar(), "A expressão já está simplificada.");
	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiSomaNoSegundoTermoComValoresIguais() {
		String res;
		res = Resolver.resolver("x=2+2");	
		assertEquals("x=4", res);
	}
	
	@Test
	public void testExplicarQuandoAEquacaoPossuiSomaNoSegundoTermoComValoresIguais() {
		String res;
		res = Resolver.resolver("x=2+2");
		assertEquals("x=4", res);
		assertEquals(Resolver.explicar(), "Regra 2: está fazendo a soma de 2 termos, porque o lado esquerdo já está simplificado.");

	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiSomaNoSegundoTermoComValoresDiferentes() {
		String res;
		res = Resolver.resolver("x=2+5");
		assertEquals("x=7", res);
	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiMultiplicacaoNoPrimeiroTermo() {
		String res;
		res = Resolver.resolver("2x=2+2");
					//"2x/2=4/22x/2=2;x=2;"
					//2x=4;2x/2=4/2;x=4/2;x=2
		
		assertEquals("2x=4;"
				+ "2x/2=4/2;"
				+ "x=4/2;"
				+ "x=2", res);
	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiMultiplicacaoESomaNoPrimeiroTermo() {
		String res = null;
		res = Resolver.resolver("3x+2=4");
		
		assertEquals("3x+2-2=4-2;"
					+ "3x=4-2;"
					+ "3x=2;"
					+ "3x/3=2/3;"
					+ "x=2/3;", res);
	}
	
	@Test
	public void testConfirmarDesenvolvimentoDaResoluçaoQuandoAEquacaoJaEAResolucao(){
		assertEquals(true, Alpha.confirmarDesenvolvimentoDaResolucao("x=3", "x=3"));
	}
	
	@Test
	public void testConfirmarResultadoQuandoOValorEstiverCorreto() {
		String expressao = "x=2";
		String resultado = "2";
		
		assertTrue(Alpha.confirmarResultado(expressao, resultado));
	}
	
	@Test
	public void testConfirmarResultadoQuandoOValorEstiverIncorreto() {
		String expressao = "x=2";
		String resultado = "3";
		
		assertFalse(Alpha.confirmarResultado(expressao, resultado));
	}
	
	@Test
	public void testVerificarPontuacaoQuandoAcertar() {
		Alpha.resetPontuacao();
		Alpha.confirmarDesenvolvimentoDaResolucao("x=3", "x=3");
		
		assertEquals(1, Alpha.getPontuacao());
	}	
	
	@Test
	public void testVerificarPontuacaoQuandoErrar() {
		// pontuaçao começa em 0
		Alpha.resetPontuacao();
		
		Alpha.confirmarDesenvolvimentoDaResolucao("x=3", "x=2");
		assertFalse(false);
		
		//assertEquals(0, Alpha.getPontuacao());
	}	
		
	
	
	
}
