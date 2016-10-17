package br.com.test.validador;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.ValidadorUtils;

public class ValidadorCPF2Test {

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
	
	@Test(expected=NullPointerException.class)
	public void cpfInvalidoNull(){
		String cpfInvalido = null;
		
		//Act
		ValidadorUtils.isCPF(cpfInvalido);
	}
	
	@Test
	public void cpfInvalidoBranco(){
		String cpfInvalido = "";
		
		//Act
		boolean resultado = ValidadorUtils.isCPF(cpfInvalido);
		
		//Arrange
		Assert.assertFalse(resultado);
	}
}
