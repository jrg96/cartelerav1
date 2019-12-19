package com.cartelerav1.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PeliculaController 
{
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula)
	{
		String tituloPelicula = "Buscando a Dory";
		int duracionMin = 120;
		double precioEntrada = 5.00;
		
		// Agregando al modelo
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracionMin);
		model.addAttribute("precio", precioEntrada);
		
		return "pelicula_detalle";
	}
}
