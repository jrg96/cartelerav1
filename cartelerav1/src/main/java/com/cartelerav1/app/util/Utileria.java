package com.cartelerav1.app.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Utileria {

	/**
	 * Metodo que regresa una Lista de Strings con las fechas siguientes, segun el parametro count
	 * @param count
	 * @return
	 */
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		// Paso 1: obtener la fecha actual
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); // colocando la fecha final (fecha inicial + count)
		Date endDate = cal.getTime();

		// El calendario ocupado hoy en dia es el gregoriano
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		
		while (!gcal.getTime().after(endDate)) 
		{
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}
	
}
