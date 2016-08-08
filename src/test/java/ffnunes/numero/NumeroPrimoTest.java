package ffnunes.numero;

import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.NumeroUtils;

public class NumeroPrimoTest {

	@Test
	public void isNumeroPrimoTest() {
		int numero = 7;
		
		//Act
		boolean resultado = NumeroUtils.isPrimo(numero);
		
		//Arrange
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void isNotPrimoTest() {
		int numero = 8;
		
		//Act
		boolean resultado = NumeroUtils.isPrimo(numero);
		
		//Arrange
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void numeroPrimoMaisProximoAcimaTest() {
		int numero = 8;
		
		//Act
		int resultado = NumeroUtils.getNumeroPrimoMaisProximoAcima(numero);
		
		int esperado = 11;
		//Arrange
		Assert.assertTrue(esperado == resultado);
	}
}
