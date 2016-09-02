package br.com.test.reflection;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.model.test.Pessoa;
import br.com.any.utils.ReflectionUtils;

public class ReflectionResetValuesTest {

	@Test
	public void validarResetValueToNull() {
		Pessoa pessoa = new Pessoa("NomeQualquer");
		
		//Act
		ReflectionUtils.resetFieldsToNull(pessoa, "nome");
		
		//Arrange
		Assert.assertTrue(pessoa.getNome() == null);
	}
	
	@Test
	public void validarResetValueToNewInstance() {
		Pessoa pessoa = new Pessoa("NomeQualquer");
		
		//Act
		ReflectionUtils.resetFieldsToNewInstance(pessoa, "nome");
		
		//Arrange
		Assert.assertTrue(pessoa.getNome() != null && pessoa.getNome().equals(""));
	}
}
