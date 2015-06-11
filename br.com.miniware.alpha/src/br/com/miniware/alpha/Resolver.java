package br.com.miniware.alpha;

import java.util.ArrayList;
import java.util.List;


public class Resolver {

	private static String resultado = "";
	private static String[] termos = null;
	private static String expressao = null;
	private static List<String> operacoes=new ArrayList<String>();
	
	public static String resolver(String expressao) {
		// Separa a equação em dois termos caso for nulo.
		termos = expressao.split("=");
		
		System.out.println(expressao);
		
		setExpressao(expressao);
		
		// Verifica se na primeira parte da equação está um x isolado.
		if (termos[0].equals("x")) {
			// Verifica se a segunda parte contém uma soma.
			if (termos[1].contains("+")) {
				// Realiza a soma.
				String soma = soma(termos[1]);

				resultado = termos[0] + "=" + soma;

				return resultado.replaceAll(".0", "");
			} else {
				// Retorna o valor da segunda parte da equação.
				double v = Double.parseDouble(termos[1]);

				resultado = termos[0] + "=" + v;

				return resultado.replaceAll(".0", "");
			}
		} else {
			// Verifica se a segunda parte contém uma soma.
			if (termos[1].contains("+")) {
				// Realizar a soma.
				String soma = soma(termos[1]);

				// Colocando o resultado na segunda parte da equação.
				termos[1] = soma;
				resultado += termos[0] + "=" + soma + ";";
			}

			// Verifica se as duas partes podem ser subtraídas por um numero
			// comum.
			if (termos[0].contains("+")) {
				String termoZero[] = termos[0].split("\\+");

				double valor = Double.parseDouble(termoZero[1]);

				termos[0] += "-" + valor;
				termos[1] += "-" + valor;

				resultado = termos[0] + "=" + termos[1] + ";";
			}

			// Realiza subtração nos dois termos
			if (termos[0].contains("-") && termos[1].contains("-")) {
				termos[0] = subtracao(termos[0]);
				termos[1] = subtracao(termos[1]);

				resultado += termos[0] + "=" + termos[1] + ";";
			}

			// Verifica se as duas partes da equação são divisíveis por um
			// valor.
			if (termos[0].contains("x")) {
				String termoZero = termos[0].replaceAll("x", "");

				double valor = Double.parseDouble(termoZero);

				termos[0] += "/" + valor;
				termos[1] += "/" + valor;

				resultado += termos[0] + "=" + termos[1] + ";";
			}

			if (termos[0].contains("/") && termos[0].contains("x")) {
				termos[0] = divisao(termos[0]);

				resultado += termos[0] + "=" + termos[1] + ";";
			}
			
			if (termos[1].contains("/") && !termos[1].contains("3.0")) {
				termos[1] = divisao(termos[1]);

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
		
		String operacao="Divisão "+parcelas[0]+"/"+parcelas[1];
		
		String termoZero = parcelas[0];
		if (termoZero.contains("x")) {
			termoZero = parcelas[0].replaceAll("x", "");
		}
		
		
		if (Double.parseDouble(termoZero) % Double.parseDouble(parcelas[1]) == 0) {
			s = Double.parseDouble(termoZero) / Double.parseDouble(parcelas[1]);
		}

		// Testando se o resultado é neutro, igual a 1.
		if (s == 1.0) {
			operacao+=";"+1;
			operacoes.add(operacao.replaceAll(".0",""));
			if (termo.contains("x")) {
				return "x";
			}
		} else {
			operacao+=";"+s;
			operacoes.add(operacao.replaceAll(".0",""));
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
			
			String operacao="Subtração "+parcelasUm[0]+"-"+parcelasDois[1];
			
			double s = Double.parseDouble(parcelasUm[1]);

			s -= Double.parseDouble(parcelasDois[1]);

			if (s == 0.0) {
				operacao+=";"+0;
				
				operacoes.add(operacao.replaceAll(".0",""));
				
				return parcelasDois[0];
			} else {
				operacao+=";"+s;
				
				operacoes.add(operacao.replaceAll(".0",""));
				
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
		
		String operacao="Soma "+ parcelas[0]+"+"+parcelas[1];
		
		double s = 0;
		for (int i = 0; i < parcelas.length; i++) {
			s += Double.parseDouble(parcelas[i]);
		}
		
		operacao+=";"+s;
		operacoes.add(operacao.replaceAll(".0",""));
		return String.valueOf(s);
	}

	public static String getExpressao() {
		return expressao;
	}

	public static void setExpressao(String expressao) {
		Resolver.expressao = expressao;
	}

}
