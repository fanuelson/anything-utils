package ffnunes.formatador;

import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.FormatadorUtils;

public class FormatadorCPFTest {

	@Test
	public void testarFormataçãoCPF() {
		String cpf = "61318096740";
		
		//Act
		String cpfFormatado = FormatadorUtils.formatarCPF(cpf);
		
		String esperado = "613.180.967-40";
		
		//Arrange
		Assert.assertEquals(esperado, cpfFormatado);
	}
	
	@Test
	public void testarFormataçãoCPFInvalido() {
		String cpf = "61318090";
		
		try{
			//Act
			FormatadorUtils.formatarCPF(cpf);
		}catch(Exception e){
			
			//Arrange
			Assert.assertTrue(e instanceof StringIndexOutOfBoundsException);
		}
		
		
	}
	
}
