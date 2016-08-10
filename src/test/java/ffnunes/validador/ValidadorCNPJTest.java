package ffnunes.validador;

import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.ValidadorUtils;

public class ValidadorCNPJTest {

	@Test
	public void cpfValido(){
		String cpfValido = "09152740358";
		
		//Act
		boolean resultado = ValidadorUtils.isCPF(cpfValido);
		
		//Arrange
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void cpfInvalido(){
		String cpfInvalido = "93253457506";
		
		//Act
		boolean resultado = ValidadorUtils.isCPF(cpfInvalido);
		
		//Arrange
		Assert.assertFalse(resultado);
	}
}
