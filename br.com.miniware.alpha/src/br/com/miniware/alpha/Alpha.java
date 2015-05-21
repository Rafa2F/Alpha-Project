package br.com.miniware.alpha;

public class Alpha {

	static private Pontuacao pontuacao = new Pontuacao();

	public static boolean confirmarDesenvolvimentoDaResolucao(String expressao,
			String resolucao) {
		String resultado = Resolver.resolver(expressao);

		if (resultado.equals(resolucao)) {
			pontuacao.adicionaPontuacao(1);
			return true;
		} else {
			return false;
		}
	}

	public static boolean confirmarResultado(String expressao, String resultado) {
		String e = expressao.replaceAll("x", resultado);

		String[] termos = e.split("=");

		return termos[0].equals(termos[1]);
	}

	public static int getPontuacao(String respostaUsuario,
			String respostaCorreta) {
		int pontuacao = 0;

		if (respostaCorreta.equals(respostaUsuario)) {
			pontuacao++;
		}

		return pontuacao;
	}

	public static int getPontuacao() {

		return pontuacao.getPontuacao();
	}

	public static void resetPontuacao() {
		pontuacao.resetPontuacao();
	}

}
