package ffnunes.reflection;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ffnunes.anotacao.Testando;
import ffnunes.exception.FieldNotFoundException;
import ffnunes.model.test.Pessoa;
import ffnunes.utils.ReflectionUtils;

public class ReflectionValorCampoTest {

	@Test
	public void recuperarValorCampoExistente(){
		Pessoa p = new Pessoa("NomeQualquer");
		
		//Act
		String resultado = (String) ReflectionUtils.recuperarValorCampo(p, "nome"); 
		
		//Arrange
		Assert.assertTrue(p.getNome().equals(resultado));
	}
	
	@Test(expected=FieldNotFoundException.class)
	public void recuperarValorCampoInexistente(){
		Pessoa p = new Pessoa("NomeQualquer");
		
		//Act
		ReflectionUtils.recuperarValorCampo(p, "nomeee"); 
	}
	
	@Test
	public void recuperarTodosCampos(){
		//Act
		Field[] campos = ReflectionUtils.recuperarTodosCampos(Pessoa.class);

		//Arrange
		Assert.assertTrue(campos.length==3);
	}
	
	@Test
	public void recuperarTodosCamposAnotadosCom(){
		//Act
		List<Field> camposAnotados = ReflectionUtils.recuperarCamposAnotadosCom(Pessoa.class, Testando.class);

		//Arrange
		Assert.assertTrue(camposAnotados.size()==1);
	}
}
