package br.com.test.timeController;

import org.joda.time.Duration;
import org.joda.time.Period;
import org.junit.Assert;
import org.junit.Test;

import br.com.any.utils.TimeControllerUtils;

public class TimeControllerTest {

	@Test
	public void testLastPeriod() throws InterruptedException {
		TimeControllerUtils tc = new TimeControllerUtils();

		//Act
		tc.startTime();
		Thread.sleep(1000);
		tc.finishTime();
		
		//Act2
		tc.startTime();
		Thread.sleep(1000);
		tc.finishTime();
		
		Period p = tc.getLastPeriod();
		long lastPeriodDurationMillis = p.toStandardDuration().getMillis();
		
		Duration d = tc.getTotalDuration();
		long totalDurationMillis = d.getMillis();
		
		//Arrange
		Assert.assertTrue( lastPeriodDurationMillis > 800 && lastPeriodDurationMillis < 1200);
		Assert.assertTrue( totalDurationMillis > 1800 && totalDurationMillis < 2200);
	}
}
