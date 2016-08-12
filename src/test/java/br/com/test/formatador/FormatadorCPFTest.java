package br.com.test.formatador;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.FormatadorUtils;

public class FormatadorCPFTest {

	@Test
	public void testarFormataçãoCPFvalido() {
		String cpf = "61318096740";

		// Act
		String cpfFormatado = FormatadorUtils.formatarCPF(cpf);

		String esperado = "613.180.967-40";

		// Arrange
		Assert.assertEquals(esperado, cpfFormatado);
	}

	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testarFormataçãoCPFInvalido() {
		String cpf = "61318090";

		// Act
		FormatadorUtils.formatarCPF(cpf);
	}

}
