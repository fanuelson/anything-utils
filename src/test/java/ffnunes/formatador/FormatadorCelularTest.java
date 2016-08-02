package ffnunes.formatador;

import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.FormatadorUtils;

public class FormatadorCelularTest {

	@Test
	public void testar8DigitosComOperadora() {
		String numero = "3288112233";
		
		//Act
		String numeroFormatado = FormatadorUtils.formatarCelular(numero);
		
		String esperado = "(32) 8811-2233";
		
		//Arrange
		Assert.assertEquals(esperado, numeroFormatado);
	}
	
	@Test
	public void testar8DigitosSemOperadora() {
		String numero = "88112233";
		
		//Act
		String numeroFormatado = FormatadorUtils.formatarCelular(numero);
		
		String esperado = "8811-2233";
		
		//Arrange
		Assert.assertEquals(esperado, numeroFormatado);
	}
	
	@Test
	public void testar9DigitosComOperadora() {
		String numero = "32988112233";
		
		//Act
		String numeroFormatado = FormatadorUtils.formatarCelular(numero);
		
		String esperado = "(32) 98811-2233";
		
		//Arrange
		Assert.assertEquals(esperado, numeroFormatado);
	}
	
	@Test
	public void testar9DigitosSemOperadora() {
		String numero = "988112233";
		
		//Act
		String numeroFormatado = FormatadorUtils.formatarCelular(numero);
		
		String esperado = "98811-2233";
		
		//Arrange
		Assert.assertEquals(esperado, numeroFormatado);
	}
}
