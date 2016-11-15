package br.com.any.utils;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public final class TimeControllerUtils {

	private DateTime start;
	private DateTime end;
	private int totalMS = 0;
	
	public void startTime() {
		this.start = new DateTime(System.currentTimeMillis());
		this.end = null;
	}
	
	public void resetTotal() {
		this.totalMS = 0;
	}
	
	public void finishTime() {
		this.end = new DateTime(System.currentTimeMillis());
		totalMS += getLastPeriod().toStandardDuration().getMillis();
	}
	
	public void printLastPeriod() {
		String tempo = getPeriodoFormatter().print(getLastPeriod());
		System.out.println(tempo);
	}
	
	public Period getLastPeriod() {
		return new Period(start, end);
	}
	
	public void imprimirTotal() {
		Duration d = getTotalDuration();
		String tempo = getPeriodoFormatter().print(d.toPeriod());
		System.out.println(tempo);
	}
	
	public Duration getTotalDuration() {
		return Duration.millis(totalMS);
	}
	
	public static PeriodFormatter getPeriodoFormatter() {
		PeriodFormatter formatter = new PeriodFormatterBuilder()
			    .appendHours().appendSuffix("h ")
			    .appendMinutes().appendSuffix("min ")
			    .appendSeconds().appendSuffix("s ")
			    .appendMillis().appendSuffix("ms ")
			    .printZeroNever()
			    .toFormatter();
		return formatter;
	}
	
}
