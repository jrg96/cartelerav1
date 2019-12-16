package com.cartelerav1.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController 
{

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome()
	{
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String paginaPrincipal(Model model)
	{
		List<String> peliculas = new LinkedList<>();
		peliculas.add("Buscando a Dory");
		peliculas.add("The Maze Runner");
		peliculas.add("Los Increibles 2");
		
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
}
