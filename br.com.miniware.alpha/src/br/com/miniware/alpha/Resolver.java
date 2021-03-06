package br.com.miniware.alpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Resolver {

	private static String resultado = "";
	private static String[] termos = null;
	private static String expressao = null;
	private static String operacoes = "";
	
	public static String resolver(String expressao) {
		operacoes = "";
		//zerando os valores das variaveis
		resultado = "";
		termos = null;
		
		
		// Separa a equa��o em dois termos caso for nulo.
		termos = expressao.split("=");
		
		setExpressao(expressao);
		
		// Verifica se na primeira parte da equa��o est� um x isolado.
		if (termos[0].equals("x")) {
			// Verifica se a segunda parte cont�m uma soma.
			if (termos[1].contains("+")) {
				// Realiza a soma.
				String soma = soma(termos[1]);
				//System.out.println();

				resultado = termos[0] + "=" + soma;
				
				operacoes = "Regra 2: Realiza a opera��o pendente no lado esquerdo da igualdade.";
				return resultado.replaceAll(".0", "");
			} else {
				// Retorna o valor da segunda parte da equa��o.
				double v = Double.parseDouble(termos[1]);

				resultado = termos[0] + "=" + v;
				operacoes= "A express�o j� est� simplificada.";
				return resultado.replaceAll(".0", "");
			}
		} else {
			// Verifica se a segunda parte cont�m uma soma.
			if (termos[1].contains("+")) {
				
				// Realizar a soma.
				String soma = soma(termos[1]);
				
				// Colocando o resultado na segunda parte da equa��o.
				termos[1] = soma;
				
				resultado += termos[0] + "=" + soma + ";";
				operacoes = "Regra 3: Realiza a opera��o de soma do lado direito";
			}

			// Verifica se as duas partes podem ser subtra�das por um numero
			// comum.
			if (termos[0].contains("+")) {
				String termoZero[] = termos[0].split("\\+");

				double valor = Double.parseDouble(termoZero[1]);
					
				termos[0] += "-" + valor;
				termos[1] += "-" + valor;
				operacoes = "Regra 1- Encontra um  numero comum entre as partes para simplificar";
				resultado = termos[0] + "=" + termos[1] + ";";
				
			}

			// Realiza subtra��o nos dois termos
			if (termos[0].contains("-") && termos[1].contains("-")) {
				termos[0] = subtracao(termos[0]);
				
				resultado += termos[0] + "=" + termos[1] + ";";
				
				termos[1] = subtracao(termos[1]);

				resultado += termos[0] + "=" + termos[1] + ";";
			}

			// Verifica se as duas partes da equa��o s�o divis�veis por um
			// valor.
			if (termos[0].contains("x")) {
				String termoZero = termos[0].replaceAll("x", "");

				double valor = Double.parseDouble(termoZero);

				termos[0] += "/" + valor;
				termos[1] += "/" + valor;
				operacoes = "Regra 1: Encontra um n�mero comum entre as partes para simplificar a equa��o.";
				resultado += termos[0] + "=" + termos[1] + ";";
			}

			if (termos[0].contains("/") && termos[0].contains("x")) {
				termos[0] = divisao(termos[0]);
				operacoes += ";Regra 2: Realiza a opera��o pendente no lado esquerdo da igualdade.";
				resultado += termos[0] + "=" + termos[1] + ";";
			}
			
			if (termos[1].contains("/") && !termos[1].contains("3.0")) {
				termos[1] = divisao(termos[1]);
				operacoes += ";Regra 3: Realiza a opera��o pendente no lado direito da igualdade.";

				resultado += termos[0] + "=" + termos[1];
			}

		}
		
		return resultado.replaceAll(".0", "");
	}

	/**
	 * 
	 */
	private static String divisao(String termo) {
		String[] parcelas = termo.split("/");
		double s = 0;
		
		String operacao="Divis�o "+parcelas[0]+"/"+parcelas[1];
		
		String termoZero = parcelas[0];
		if (termoZero.contains("x")) {
			termoZero = parcelas[0].replaceAll("x", "");
		}
		
		
		if (Double.parseDouble(termoZero) % Double.parseDouble(parcelas[1]) == 0) {
			s = Double.parseDouble(termoZero) / Double.parseDouble(parcelas[1]);
		}

		// Testando se o resultado � neutro, igual a 1.
		if (s == 1.0) {
			operacao+=";"+1;
			
			//System.out.println(operacoes);
			if (termo.contains("x")) {
				return "x";
			}
		} else {
			operacao+=";"+s;
			
			//System.out.println(operacoes);
			return String.valueOf(s);
			
		}

		return String.valueOf(s);
	}

	/**
	 * 
	 */
	private static String subtracao(String termo) {
		if (termo.contains("x")) {
			String[] parcelasUm = termo.split("\\-");
			String[] parcelasDois = parcelasUm[0].split("\\+");
			
			String operacao="Subtra��o "+parcelasUm[0]+"-"+parcelasDois[1];
			
			double s = Double.parseDouble(parcelasUm[1]);

			s -= Double.parseDouble(parcelasDois[1]);

			if (s == 0.0) {
				operacao+=";"+0;
				
				
				//System.out.println(operacoes);
				return parcelasDois[0];
			} else {
				operacao+=";"+s;
				
				
				return String.valueOf(s);
				
			}
			
			
		} else {
			String[] parcelas = termo.split("\\-");

			double s = 0;

			s = Double.parseDouble(parcelas[0]);

			s -= Double.parseDouble(parcelas[1]);

			return String.valueOf(s);
		}
	}

	/**
	 * return
	 */
	private static String soma(String termo) {
		String[] parcelas = termo.split("\\+");
		
		String operacao = "Soma " + parcelas[0] + "+" + parcelas[1];
		
		double s = 0;
		for (int i = 0; i < parcelas.length; i++) {
			s += Double.parseDouble(parcelas[i]);
		}
		
		operacao += ";" + s;
	
		return String.valueOf(s);
	}

	public static String getExpressao() {
		return expressao;
	}

	public static void setExpressao(String expressao) {
		Resolver.expressao = expressao;
	}

	public static String explicar() {
	
		return operacoes.toString();
	}

}
