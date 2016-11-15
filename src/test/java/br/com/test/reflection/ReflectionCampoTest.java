package br.com.test.reflection;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.anotacao.Atributo;
import br.com.any.exception.FieldNotFoundException;
import br.com.any.model.test.Pessoa;
import br.com.any.model.test.PessoaFisicaTest;
import br.com.any.utils.ReflectionUtils;

public class ReflectionCampoTest {

	@Test
	public void recuperarValorCampoExistente(){
		Pessoa pessoa = new Pessoa("NomeQualquer");
		PessoaFisicaTest pessoaFisica = new PessoaFisicaTest("NomePessoaFisica");
		
		//Act
		String resultadoPessoa = (String) ReflectionUtils.recuperarValorCampo(pessoa, "nome");
		String resultadoPessoaFisica = (String) ReflectionUtils.recuperarValorCampo(pessoaFisica, "nome");
		
		//Arrange
		Assert.assertTrue(pessoa.getNome().equals(resultadoPessoa));
		Assert.assertTrue(pessoaFisica.getNome().equals(resultadoPessoaFisica));
	}
	
	//Arrange
	@Test(expected=FieldNotFoundException.class)
	public void recuperarValorCampoInexistente(){
		Pessoa p = new Pessoa("NomeQualquer");
		
		//Act
		ReflectionUtils.recuperarValorCampo(p, "nomeee"); 
	}
	
	@Test
	public void recuperarTodosCampos(){
		//Act
		Field[] camposPessoa = ReflectionUtils.recuperarTodosCampos(Pessoa.class);
		Field[] camposPessoaFisica = ReflectionUtils.recuperarTodosCampos(PessoaFisicaTest.class);

		//Arrange
		Assert.assertTrue(camposPessoa.length==4);
		Assert.assertTrue(camposPessoaFisica.length==5);
	}
	
	@Test
	public void recuperarTodosCamposAnotadosCom(){
		//Act
		List<Field> camposAnotadosPessoa = ReflectionUtils.recuperarCamposAnotadosCom(Pessoa.class, Atributo.class);
		List<Field> camposAnotadosPessoaFisica = ReflectionUtils.recuperarCamposAnotadosCom(PessoaFisicaTest.class, Atributo.class);

		//Arrange
		Assert.assertTrue(camposAnotadosPessoa.size()==1);
		Assert.assertTrue(camposAnotadosPessoaFisica.size()==1);
	}
	
	@Test
	public void atribuirValorCampoExistente(){
		Pessoa p = new Pessoa("NomePessoa");
		PessoaFisicaTest pessoaFisica = new PessoaFisicaTest("NomePessoaFisica");
		
		//Act
		ReflectionUtils.atribuirValorAoCampo("NomePessoaAlterado", p, "nome");
		ReflectionUtils.atribuirValorAoCampo("NomePessoaFisicaAlterado", pessoaFisica, "nome");

		//Arrange
		Assert.assertTrue(p.getNome().equals("NomePessoaAlterado"));
		Assert.assertTrue(pessoaFisica.getNome().equals("NomePessoaFisicaAlterado"));
	}
	
	//Arrange
	@Test(expected=FieldNotFoundException.class)
	public void atribuirValorCampoInexistente(){
		Pessoa p = new Pessoa("NomePessoa1");
		
		//Act
		ReflectionUtils.atribuirValorAoCampo("NomeAlterado", p, "nomeea");;
	}
}
