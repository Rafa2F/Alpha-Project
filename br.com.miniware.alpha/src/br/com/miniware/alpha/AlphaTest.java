package br.com.miniware.alpha;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AlphaTest {

	@Test
	public void testQueAEquacaoJaEARespostaFinal() {
		String res;
		res = Alpha.resolver("x=2.0");
		assertEquals("Resposta final", res);
	}

	@Test
	public void testVisualizacaoDaExpressao() {
		String res;
		res = Alpha.resolver("x=7.0");
		assertEquals("Resposta final", res);
	}

	@Test
	public void testAlpha3() {
		String res;
		res = Alpha.resolver("x=2+2");
		assertEquals("x=4.0", res);
	}
	@Test
	public void testAlpha4() {
		String res;
		res = Alpha.resolver("x=2+5");
		assertEquals("x=7.0", res);
	}
	
	@Test
	public void testQueAEquacaoPossuiMultiplicadorNoX() {
		String res;
		res = Alpha.resolver("2x=2+2");
					//"2x/2.0=4.0/2.02x/2.0=2.0;x=2.0;"
		assertEquals("2x=4.0;2x/2=4.0/2;x=4.0/2;x=2.0", res);
	}
	
	@Test
	public void testAlpha6() {
		String res = null;
		res = Alpha.resolver("3x+2=4");
		assertEquals("3x+2-2=4-2;3x=4-2;3x/3=2/3;x=2/3", res);
	}
	
	@Test
	public void confirmarDesenvolvimentoDaResolucao(){
		String resultado;
		resultado = Alpha.confirmar("x=3", "Resposta final");
		assertEquals("Resposta correta",resultado);
		
	}
	
	@Test
	public void confirmarDesenvolvimentoDaResolucao1(){
		String resultado;
		resultado = Alpha.confirmar("x=3+3", "x=6.0");
		assertEquals("Resposta correta",resultado);
		
	}
	
	@Test
	public void testVerificaPontuacaoInicial () {
		Alpha.resetPontuacao();
		assertEquals(0, Alpha.getPontuacao());
	}	
	
	@Test
	public void testConfirmacaoQuandoOValorEstiverCorreto() {
		String expressao = "x=2";
		String resultado = "2";
		
		assertTrue(Alpha.confirmarResultado(expressao, resultado));
	}
	
	@Test
	public void testConfirmacaoQuandoOValorEstiverIncorreto() {
		String expressao = "x=2";
		String resultado = "3";
		
		assertFalse(Alpha.confirmarResultado(expressao, resultado));
	}
	
	@Test
	public void testVerificaPontuacaoAcerto () {
		Alpha.resetPontuacao();
		Alpha.confirmar("x=3", "Resposta final");
	
		assertEquals(1, Alpha.getPontuacao());
	}	
		
		
	
}
