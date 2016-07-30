package ffnunes.data;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import ffnunes.utils.DataUtils;

public class ColisaoPeriodoPeriodoTest {
	
	@Test
	public void periodosNaoColidemExclusive(){
		Date inicioPeriodo1 = new DateTime(2016, 10, 10, 5, 10, 0).toDate();
		Date fimPeriodo1 =    new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		
		Date inicioPeriodo2 = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date fimPeriodo2 =    new DateTime(2016, 10, 25, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.periodosColidem(inicioPeriodo1, fimPeriodo1, inicioPeriodo2, fimPeriodo2, false);
		
		
		//Arrange
		Assert.assertFalse(resultado1);
	}
	
	@Test
	public void periodosNaoColidemInclusive(){
		Date inicioPeriodo1 = new DateTime(2016, 10, 10, 5, 10, 0).toDate();
		Date fimPeriodo1 =    new DateTime(2016, 10, 15, 5, 10, 0).toDate();
		
		Date inicioPeriodo2 = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date fimPeriodo2 =    new DateTime(2016, 10, 25, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.periodosColidem(inicioPeriodo1, fimPeriodo1, inicioPeriodo2, fimPeriodo2, true);
		
		
		//Arrange
		Assert.assertFalse(resultado1);
	}
	
	@Test
	public void periodosColidemExclusive(){
		Date inicioPeriodo1 = new DateTime(2016, 10, 22, 5, 10, 0).toDate();
		Date fimPeriodo1 =    new DateTime(2016, 10, 25, 5, 10, 0).toDate();
		
		Date inicioPeriodo2 = new DateTime(2016, 10, 24, 5, 10, 0).toDate();
		Date fimPeriodo2 =    new DateTime(2016, 10, 26, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.periodosColidem(inicioPeriodo1, fimPeriodo1, inicioPeriodo2, fimPeriodo2, false);
		
		
		//Arrange
		Assert.assertTrue(resultado1);
	}
	
	@Test
	public void periodosColidemInclusive(){
		Date inicioPeriodo1 = new DateTime(2016, 10, 22, 5, 10, 0).toDate();
		Date fimPeriodo1 =    new DateTime(2016, 10, 24, 5, 10, 0).toDate();
		
		Date inicioPeriodo2 = new DateTime(2016, 10, 24, 5, 10, 0).toDate();
		Date fimPeriodo2 =    new DateTime(2016, 10, 26, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.periodosColidem(inicioPeriodo1, fimPeriodo1, inicioPeriodo2, fimPeriodo2, true);
		
		
		//Arrange
		Assert.assertTrue(resultado1);
	}
	
	
}
