package br.com.test.formatador;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.FormatadorUtils;

public class FormatadorCNPJTest {

	@Test
	public void testarFormataçãoCNPJvalido() {
		String cnpj = "91458573000119";

		// Act
		String cnpjFormatado = FormatadorUtils.formatarCNPJ(cnpj);

		String esperado = "91.458.573/0001-19";

		// Arrange
		Assert.assertEquals(esperado, cnpjFormatado);
	}

	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testarFormataçãoCNPJInvalido() {
		String cnpj = "61318090";

		// Act
		FormatadorUtils.formatarCNPJ(cnpj);
	}

}
