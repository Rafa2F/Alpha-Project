package br.com.miniware.alpha;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AlphaTest {

	@Test
	public void testResolverQuandoAEquacaoJaEARespostaFinalEDois() {
		assertEquals(Resolver.resolver("x=2.0"), "x=2.0");
	}

	@Test
	public void testResolverQuandoAEquacaoJaEARespostaFinalESete() {
		assertEquals(Resolver.resolver("x=7.0"), "x=7.0");
	}

	@Test
	public void testResolverQuandoAEquacaoPossuiSomaNoSegundoTermoComValoresIguais() {
		String res;
		res = Resolver.resolver("x=2+2");
		assertEquals("x=4.0", res);
	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiSomaNoSegundoTermoComValoresDiferentes() {
		String res;
		res = Resolver.resolver("x=2+5");
		assertEquals("x=7.0", res);
	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiMultiplicacaoNoPrimeiroTermo() {
		String res;
		res = Resolver.resolver("2x=2+2");
					//"2x/2.0=4.0/2.02x/2.0=2.0;x=2.0;"
					//2x=4.0;2x/2=4.0/2;x=4.0/2;x=2.0
		
		assertEquals("2x=4.0;"
				+ "2x/2.0=4.0/2.0;"
				+ "x=4.0/2.0;"
				+ "x=2.0", res);
	}
	
	@Test
	public void testResolverQuandoAEquacaoPossuiMultiplicacaoESomaNoPrimeiroTermo() {
		String res = null;
		res = Resolver.resolver("3.0x+2.0=4.0");
		
		assertEquals("3.0x+2.0-2.0=4.0-2.0;"
					+ "3.0x=2.0;"
					+ "3.0x/3.0=2.0/3.0;"
					+ "x=2.0/3.0;", res);
	}
	
	@Test
	public void testConfirmarDesenvolvimentoDaResoluçaoQuandoAEquacaoJaEAResolucao(){
		assertEquals(true, Alpha.confirmarDesenvolvimentoDaResolucao("x=3.0", "x=3.0"));
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
		Alpha.confirmarDesenvolvimentoDaResolucao("x=3.0", "x=3.0");
		
		assertEquals(1, Alpha.getPontuacao());
	}	
	
	@Test
	public void testVerificarPontuacaoQuandoErrar() {
		Alpha.resetPontuacao();
		Alpha.confirmarDesenvolvimentoDaResolucao("x=3", "x=2");
	
		assertEquals(0, Alpha.getPontuacao());
	}	
		
		
	
}
