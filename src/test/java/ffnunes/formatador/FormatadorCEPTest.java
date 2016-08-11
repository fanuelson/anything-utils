package ffnunes.formatador;

import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.FormatadorUtils;

public class FormatadorCEPTest {
	//42800-080
	@Test
	public void testarFormataçãoCEPvalido() {
		String cep = "42800080";

		// Act
		String cepFormatado = FormatadorUtils.formatarCEP(cep);

		String esperado = "42800-080";

		// Arrange
		Assert.assertEquals(esperado, cepFormatado);
	}

	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testarFormataçãoCEPInvalido() {
		String cep = "428080";

		// Act
		FormatadorUtils.formatarCEP(cep);
	}

}
