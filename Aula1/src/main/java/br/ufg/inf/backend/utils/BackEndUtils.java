package br.ufg.inf.backend.utils;

public class BackEndUtils {
	
	public static String validaCampoString(String operacao, String nomeCampo) {
		if (operacao == null || operacao.isBlank()) {
			throw new ParreiraException(String.format("O campo '%s' deve ser preenchido.", nomeCampo));
		}
		return operacao.trim();
	}

	public static Double validaDouble(String numero, String nomeCampo) {
		validaCampoString(numero, nomeCampo);
		try {
			return Double.valueOf(numero);
		} catch (NumberFormatException e) {
			throw new ParreiraException(String.format("O campo '%s' deve ser um número válido.", nomeCampo));
		}
	}

	public static Integer validaInteger(String numero, String nomeCampo) {
		validaCampoString(numero, nomeCampo);
		try {
			return Integer.valueOf(numero);
		} catch (NumberFormatException e) {
			throw new ParreiraException(String.format("O campo '%s' deve ser um número inteiro válido.", nomeCampo));
		}
	}

}
