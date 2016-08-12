package br.com.any.utils;

import org.apache.commons.lang3.StringUtils;

public final class FormatadorUtils {

	private static final String HIFEN = "-";
	private static final int _4DIGITOS = 4;

	private FormatadorUtils() {
	}

	public static String formatarCelular(String str) {
		String telefoneFormatado = str;
		if (StringUtils.isNotBlank(str) && str.length() > 7) {
			telefoneFormatado = inserirHifen(str);
			telefoneFormatado = inserirParentesesOperadora(telefoneFormatado);
		}
		return telefoneFormatado;
	}

	private static String inserirHifen(String str) {
		String resultado = "";
		resultado += str.substring(0, str.length() - _4DIGITOS) + HIFEN + str.substring(str.length() - _4DIGITOS);
		return resultado;
	}

	private static String inserirParentesesOperadora(String str) {
		String resultado = str;
		if (str.length() > 10) {
			resultado = "(";
			resultado += str.substring(0, 2) + ") " + str.substring(2);
		}
		return resultado;
	}

	public static String formatarCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	}

	public static String formatarCNPJ(String cnpj) {
		return (cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
				+ cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14));
	}

	public static String formatarCEP(String cep) {
		return (cep.substring(0, 5) + "-" + cep.substring(5, 8));
	}

}
