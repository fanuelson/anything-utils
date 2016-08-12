package br.com.test.data;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.DataUtils;

public class ColisaoDataPeriodoTest {
	
	@Test
	public void dataIgualAoInicio(){
		Date inicioPeriodo = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date data =          new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date fimPeriodo =    new DateTime(2016, 12, 20, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, true);
		boolean resultado2 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, true);
		boolean resultado3 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, false);
		boolean resultado4 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, false);
		
		//Arrange
		Assert.assertTrue(resultado1);
		Assert.assertFalse(resultado2);
		Assert.assertTrue(resultado3);
		Assert.assertFalse(resultado4);
	}
	
	@Test
	public void dataIgualAoFim(){
		Date inicioPeriodo = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date data =          new DateTime(2016, 12, 20, 5, 10, 0).toDate();
		Date fimPeriodo =    new DateTime(2016, 12, 20, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, true);
		boolean resultado2 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, true);
		boolean resultado3 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, false);
		boolean resultado4 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, false);
		
		//Arrange
		Assert.assertTrue(resultado1);
		Assert.assertTrue(resultado2);
		Assert.assertFalse(resultado3);
		Assert.assertFalse(resultado4);
	}
	
	@Test
	public void dataDentro(){
		Date inicioPeriodo = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date data =          new DateTime(2016, 11, 20, 5, 10, 0).toDate();
		Date fimPeriodo =    new DateTime(2016, 12, 20, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, true);
		boolean resultado2 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, true);
		boolean resultado3 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, false);
		boolean resultado4 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, false);
		
		//Arrange
		Assert.assertTrue(resultado1);
		Assert.assertTrue(resultado2);
		Assert.assertTrue(resultado3);
		Assert.assertTrue(resultado4);
	}
	
	@Test
	public void dataForaAntes(){
		Date data =          new DateTime(2016, 9, 20, 5, 10, 0).toDate();
		Date inicioPeriodo = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date fimPeriodo =    new DateTime(2016, 12, 20, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, true);
		boolean resultado2 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, true);
		boolean resultado3 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, false);
		boolean resultado4 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, false);
		
		//Arrange
		Assert.assertFalse(resultado1);
		Assert.assertFalse(resultado2);
		Assert.assertFalse(resultado3);
		Assert.assertFalse(resultado4);
	}
	
	@Test
	public void dataForaDepois(){
		Date inicioPeriodo = new DateTime(2016, 10, 20, 5, 10, 0).toDate();
		Date fimPeriodo =    new DateTime(2016, 11, 20, 5, 10, 0).toDate();
		Date data =          new DateTime(2016, 12, 20, 5, 10, 0).toDate();
		
		//Act
		boolean resultado1 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, true);
		boolean resultado2 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, true);
		boolean resultado3 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, true, false);
		boolean resultado4 = DataUtils.dataEstaDentroDoPeriodo(data, inicioPeriodo, fimPeriodo, false, false);
		
		//Arrange
		Assert.assertFalse(resultado1);
		Assert.assertFalse(resultado2);
		Assert.assertFalse(resultado3);
		Assert.assertFalse(resultado4);
	}
}
