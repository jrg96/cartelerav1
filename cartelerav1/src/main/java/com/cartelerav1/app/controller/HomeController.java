package com.cartelerav1.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.service.IPeliculaService;
import com.cartelerav1.app.util.Utileria;

@Controller
public class HomeController 
{
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	// Servicios de la aplicacion
	@Autowired
	private IPeliculaService peliculaService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome()
	{
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String paginaPrincipal(Model model)
	{
		List<Pelicula> peliculas = peliculaService.buscarTodas();
		List<String> fechas = Utileria.getNextDays(4);
		
		model.addAttribute("fechas", fechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha") String fecha)
	{
		List<Pelicula> peliculas = peliculaService.buscarTodas();
		List<String> fechas = Utileria.getNextDays(4);
		
		model.addAttribute("fechas", fechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", fecha);
		
		return "home";
	}
}
