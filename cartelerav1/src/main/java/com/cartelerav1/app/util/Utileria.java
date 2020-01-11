package com.cartelerav1.app.util;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

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
	
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request)
	{
		// Paso 1: obtener el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = Utileria.randomAlphanumeric(15) + nombreOriginal.replace(" ", "_");
		
		// Paso 2: obtener la ruta absoluta a donde guardar las imagenes
		// apache-tomcat/webapps/cartelerav1/resources/images/uploads
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/uploads/");
		
		// Paso 3: intentamos mover el archivo desde la carpeta tmp a su destino final
		try 
		{
			System.out.println("Creando archivo");
			File imageFile = new File(rutaFinal + nombreOriginal);
			
			System.out.println("Empezando a transferir");
			multiPart.transferTo(imageFile);
			
			return nombreOriginal;
		}
		catch(Exception e)
		{
			System.out.println("Error al subir archivo: " + e.getMessage());
		}
		
		return null;
	}
	
	public static String randomAlphanumeric(int count)
	{
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		
		while (count-- != 0)
		{
			int pos = (int) (Math.random() * caracteres.length());
			builder.append(caracteres.charAt(pos));
		}
		
		return builder.toString();
	}
}
