package ffnunes.encriptador;
import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.EncriptadorUtils;

public class EncriptacaoSHA_1Test {
	
	@Test
	public void criptografiaCorretaMD5(){
		String senha = "senhax" ;
		
		//Act
		String senhaCriptografada = EncriptadorUtils.encriptarSHA_1(senha);
		
		//Arrange
		Assert.assertTrue(EncriptadorUtils.checkPasswordSHA_1(senha, senhaCriptografada));;
	}
	
	@Test
	public void criptografiaIncorretaMD5(){
		String senha1 = "senhax" ;
		String senha2 = "senhay" ;
		
		//Act
		String senha1Criptografada = EncriptadorUtils.encriptarSHA_1(senha1);
		
		//Arrange
		Assert.assertFalse(EncriptadorUtils.checkPasswordSHA_1(senha2, senha1Criptografada));
	}
	
}
