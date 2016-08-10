package ffnunes.utils;

import java.util.InputMismatchException;

public final class ValidadorUtils {
	
	private ValidadorUtils(){}

	public static boolean isCPF(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	public static boolean isCNPJ(String cnpj) {
		try {
			Long.parseLong(cnpj);
		} catch (NumberFormatException e) {
			return false;
		}

		if (cnpj.length() < 14) {
		    cnpj = String.format("%014d", Long.parseLong(cnpj));
		}

		int soma = 0;
		String cnpjCalc = cnpj.substring(0, 12);

		char[] chrCnpj = cnpj.toCharArray();
		for (int i = 0; i < 4; i++){
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9){
				soma += (chrCnpj[i] - 48) * (6 - (i + 1));
			}
		}
		
		for (int i = 0; i < 8; i++){
			if (chrCnpj[i + 4] - 48 >= 0 && chrCnpj[i + 4] - 48 <= 9){
				soma += (chrCnpj[i + 4] - 48) * (10 - (i + 1));
			}
		}
		
		int dig = 11 - soma % 11;
		cnpjCalc = (new StringBuilder(String.valueOf(cnpjCalc)))
				.append(dig != 10 && dig != 11 ? Integer.toString(dig) : "0").toString();
		soma = 0;
		for (int i = 0; i < 5; i++){
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9){
				soma += (chrCnpj[i] - 48) * (7 - (i + 1));
			}
		}
		
		for (int i = 0; i < 8; i++){
			if (chrCnpj[i + 5] - 48 >= 0 && chrCnpj[i + 5] - 48 <= 9){
				soma += (chrCnpj[i + 5] - 48) * (10 - (i + 1));
			}
		}
		
		dig = 11 - soma % 11;
		cnpjCalc = (new StringBuilder(String.valueOf(cnpjCalc)))
				.append(dig != 10 && dig != 11 ? Integer.toString(dig) : "0").toString();

		return cnpj.equals(cnpjCalc);
	}

}
