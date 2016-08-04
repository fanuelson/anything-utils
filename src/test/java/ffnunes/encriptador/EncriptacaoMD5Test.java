package ffnunes.encriptador;
import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.EncriptadorUtils;

public class EncriptacaoMD5Test {
	
	@Test
	public void criptografiaCorretaMD5(){
		String senha = "senhax" ;
		
		//Act
		String senhaCriptografada = EncriptadorUtils.encriptarMD5(senha);
		
		//Arrange
		Assert.assertTrue(EncriptadorUtils.checkPasswordMD5(senha, senhaCriptografada));;
	}
	
	@Test
	public void criptografiaIncorretaMD5(){
		String senha1 = "senhax" ;
		String senha2 = "senhay" ;
		
		//Act
		String senha1Criptografada = EncriptadorUtils.encriptarMD5(senha1);
		
		//Arrange
		Assert.assertFalse(EncriptadorUtils.checkPasswordMD5(senha2, senha1Criptografada));
	}
	
	
	
}
