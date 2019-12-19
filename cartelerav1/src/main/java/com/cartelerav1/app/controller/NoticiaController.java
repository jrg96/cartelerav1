package com.cartelerav1.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartelerav1.app.model.Noticia;

@Controller
@RequestMapping(value="/noticias")
public class NoticiaController 
{
	@GetMapping(value="/create")
	public String crear()
	{
		return "noticias/insertar_noticia";
	}
	
	@PostMapping(value="/save")
	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, 
			@RequestParam("detalle") String detalle)
	{
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setDetalle(detalle);
		noticia.setEstatus(estatus);
		
		return "noticias/insertar_noticia";
	}
}
