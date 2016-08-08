package ffnunes.utils;

public final class NumeroUtils {
	
	private NumeroUtils() {
	}

	public static int getNumeroPrimoMaisProximoAcima(int num) {
		int numeroPrimo = num+1;
		while(!isPrimo(numeroPrimo)){
			numeroPrimo++;
		}
		return numeroPrimo;
	}

	public static boolean isPrimo(int num) {
		if(num==3 || num==5 || num==7){
			return true;
		}else if(num<9){
			return false;
		}
		for (int i = 2; i <= 9; i++) {
			if (i!=num && num % i == 0)
				return false;
		}
		return true;
	}
}
