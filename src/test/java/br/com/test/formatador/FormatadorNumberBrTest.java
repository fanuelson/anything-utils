package br.com.test.formatador;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.FormatadorUtils;

public class FormatadorNumberBrTest {

	@Test
	public void testNumberOk() {
		BigDecimal b = new BigDecimal(10.356);
		
		//Act
		String numberFormatted = FormatadorUtils.formatNumberBr(b, 3);
		
		//Arrange
		Assert.assertEquals("10,356", numberFormatted);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumberNull() {
		BigDecimal b = null;
		
		//Act
		FormatadorUtils.formatNumberBr(b, 3);
	}
	
	@Test
	public void testNumber2CasasDecimais() {
		BigDecimal num = new BigDecimal(103.9178);
		
		//Act
		String numberFormatted = FormatadorUtils.formatNumberBr(num, 2);
		
		//Arrange
		Assert.assertEquals("103,92", numberFormatted);
	}
}
