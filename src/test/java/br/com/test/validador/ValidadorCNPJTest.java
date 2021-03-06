package br.com.test.validador;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.ValidadorUtils;

public class ValidadorCNPJTest {

	@Test
	public void cnpjValido(){
		String cnpjValido = "60562166000123";
		
		//Act
		boolean resultado = ValidadorUtils.isCNPJ(cnpjValido);
		
		//Arrange
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void cnpjInvalido(){
		String cpfInvalido = "60562266000654";
		
		//Act
		boolean resultado = ValidadorUtils.isCNPJ(cpfInvalido);
		
		//Arrange
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void cnpjInvalido2(){
		String cpfInvalido = "60562266";
		
		//Act
		boolean resultado = ValidadorUtils.isCNPJ(cpfInvalido);
		
		//Arrange
		Assert.assertFalse(resultado);
	}
}
