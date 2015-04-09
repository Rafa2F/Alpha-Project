package br.com.miniware.alpha;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AlphaTest {

	@Test
	public void testAlpha() {
		String res;
		res = Alpha.resolver("x=2.0");
		assertEquals("Resposta final", res);
	}

	@Test
	public void testAlpha2() {
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
}
