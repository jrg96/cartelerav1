package com.cartelerav1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.service.IPeliculaService;

@Controller
@RequestMapping(value = "/peliculas")
public class PeliculaController 
{
	@Autowired
	private IPeliculaService peliculaService;
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha)
	{
		// Obteniendo la pelicula desde nuestro servicio
		model.addAttribute("pelicula", this.peliculaService.buscarPorId(idPelicula));
		
		return "peliculas/pelicula_detalle";
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear()
	{
		return "peliculas/pelicula_insertar";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Pelicula pelicula, BindingResult result)
	{
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(pelicula.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de pelicula (Insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "peliculas/pelicula_insertar";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		peliculaService.guardar(pelicula);
		return "peliculas/pelicula_insertar";
	}
}
