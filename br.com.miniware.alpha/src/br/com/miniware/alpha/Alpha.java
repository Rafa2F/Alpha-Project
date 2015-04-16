package br.com.miniware.alpha;

public class Alpha {

	public static String resolver(String string) {
		String[] termos = string.split("=");
		if (termos[0].equals("x")) {
			if (termos[1].contains("+")) {
				String[] parcelas = termos[1].split("\\+");
				double s = 0;
				for (int i = 0; i < parcelas.length; i++) {
					s += Double.parseDouble(parcelas[i]);

				}
				return termos[0] + "=" + s;
			} else {
				double v = Double.parseDouble(termos[1]);
				return "Resposta final";
			}
		} else {
			
		}
		return null;
	}
	
	public static String resolver2(String string) {
		String termo[] = string.split("=");
		String fase1[] = termo[0].split("x");
		double value;
		value = Double.parseDouble(fase1[0]);
		return string;
	}

	public static String confirmar(String string, String string2) {
		String r = resolver(string); 
		if(r.equals(string2) ){
			return "Resposta correta";
		}
		return "Resposta incorreta";
	}
	public static boolean confirmarResultado(String expressao, String resultado) {
		String e = expressao.replaceAll("x", resultado);
		
		String[] termos = e.split("=");
		
		return termos[0].equals(termos[1]);
	}
	
	
}
