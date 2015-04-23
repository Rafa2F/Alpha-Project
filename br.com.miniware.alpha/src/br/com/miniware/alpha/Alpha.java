package br.com.miniware.alpha;

import java.util.Arrays;

public class Alpha {
	
	static private Pontuacao pontuacao = new Pontuacao ();

	public static String resolver(String string) {
		String resultado = "";
		
		// Separa a equação em dois termos.
		String[] termos = string.split("=");

		// Verifica se na primeira parte da equação está um x isolado.
		if (termos[0].equals("x")) {
			// Verifica se a segunda parte contém uma soma.
			if (termos[1].contains("+")) {
				// Realiza a soma.
				String[] parcelas = termos[1].split("\\+");
				double s = 0;
				for (int i = 0; i < parcelas.length; i++) {
					s += Double.parseDouble(parcelas[i]);
				}
				resultado = termos[0] + "=" + s;

				return resultado;
			} else {
				// Retorna o valor da segunda parte da equação.
				double v = Double.parseDouble(termos[1]);

				return "Resposta final";
			}
		} else {
			// Verifica se a segunda parte contém uma soma.
			if (termos[1].contains("+")) {
				// Realizar a soma.
				String[] parcelas = termos[1].split("\\+");
				double s = 0;
				for (int i = 0; i < parcelas.length; i++) {
					s += Double.parseDouble(parcelas[i]);
				}
				// Colocando o resultado na segunda parte da equação.
				termos[1] = String.valueOf(s);
				resultado += termos[0] + "=" + s + ";";
			}
			System.out.println(Arrays.toString(termos));
			// Verifica se as duas partes da equação são divisíveis por dois.
			if (termos[0].contains("x")) {
				String termoZero = termos[0].replaceAll("x", "");

				double valor = Double.parseDouble(termoZero);

				termos[0] += "/" + valor;
				termos[1] += "/" + valor;
				resultado = termos[0] + "=" + termos[1];
				System.out.println(Arrays.toString(termos));
			}

			if (termos[1].contains("/")) {
				// Realizar a soma.
				String[] parcelas = termos[1].split("/");
				double s = 0;
				
				s = Double.parseDouble(parcelas[0]) / Double.parseDouble(parcelas[1]);
				
				// Colocando o resultado na segunda parte da equação.
				termos[1] = String.valueOf(s);
				resultado += termos[0] + "=" + s + ";";
				System.out.println(Arrays.toString(termos));
				
			} 
			
			// IMPLEMENTAÇÃO
			if (termos[0].contains("/") && termos[0].contains("x")) {
				// Realizar a soma.				
				String[] parcelas = termos[0].split("/");
				double s = 0;
				
				String termoZero = parcelas[0].replaceAll("x", "");
				
				s = Double.parseDouble(termoZero) / Double.parseDouble(parcelas[1]);
				
				// Testando se o resultado é neutro, igual a 1.
				if (s == 1.0) {
					termos[0] = "x";
				} else {
					termos[0] = String.valueOf(s);
				}
				
				// Colocando o resultado na segunda parte da equação.
				resultado += termos[0] + "=" + termos[1] + ";";
			}
			
			System.out.println(resultado);
			
		}
		return resultado;
	}
	
//	public static String resolver2(String string) {
//		String termo[] = string.split("=");
//		String fase1[] = termo[0].split("x");
//		double value;
//		value = Double.parseDouble(fase1[0]);
//		return string;
//	}

	public static String confirmar(String string, String string2) {
		String r = resolver(string); 
		if(r.equals(string2) ){
			pontuacao.adicionaPontuacao(1);
			return "Resposta correta";
		}
		return "Resposta incorreta";
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
	
	public static void resetPontuacao () {
		
		pontuacao.resetPontuacao();
		
	}

}
