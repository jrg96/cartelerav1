package com.cartelerav1.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/noticias")
public class NoticiaController 
{
	@GetMapping(value="/create")
	public String crear()
	{
		return "noticias/insertar_noticia";
	}
}
