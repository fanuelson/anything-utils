package ffnunes.utils;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public final class DataUtils {

	private DataUtils() {}
	
	public static boolean dataEstaDentroDoPeriodo(Date data, Date inicioPeriodo, Date fimPeriodo, boolean inicioInclusive, boolean fimInclusive){
		DateTime dataTime = new DateTime(data);
		DateTime inicioPeriodoTime = new DateTime(inicioPeriodo);
		DateTime fimPeriodoTime = new DateTime(fimPeriodo);
		Interval intervalo = new Interval(inicioPeriodoTime, fimPeriodoTime);
		boolean contem = intervalo.contains(dataTime);
		if(!inicioInclusive){
			contem = contem && !intervalo.getStart().isEqual(dataTime);
		}
		if(fimInclusive){
			contem = contem || intervalo.getEnd().isEqual(dataTime);
		}
		return contem;
	}
	
	public static boolean periodosColidem(Date inicioPeriodo1, Date fimPeriodo1, Date inicioPeriodo2, Date fimPeriodo2, boolean inclusive){
		Interval intervalo1 = new Interval(new DateTime(inicioPeriodo1), new DateTime(fimPeriodo1));
		Interval intervalo2 = new Interval(new DateTime(inicioPeriodo2), new DateTime(fimPeriodo2));
		if(inclusive){
			return intervalo1.overlaps(intervalo2) || intervalo1.abuts(intervalo2);
		}
		return intervalo1.overlaps(intervalo2);
	}
}
