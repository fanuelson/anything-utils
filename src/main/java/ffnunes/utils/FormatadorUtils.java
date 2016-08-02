package ffnunes.utils;

import org.apache.commons.lang3.StringUtils;

public class FormatadorUtils {
	
	private static final String HIFEN = "-";
	private static final int _4DIGITOS = 4;
	
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
		resultado += str.substring(0,str.length()-_4DIGITOS)+HIFEN+str.substring(str.length()-_4DIGITOS);
		return resultado;
	}
	
	private static String inserirParentesesOperadora(String str) {
		String resultado = str;
		if (str.length() > 10){
			resultado = "(";
			resultado += str.substring(0,2)+") "+str.substring(2);
		}
		return resultado;
	}
}
