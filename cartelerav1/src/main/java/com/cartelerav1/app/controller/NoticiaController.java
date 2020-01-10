package com.cartelerav1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.service.INoticiaService;

@Controller
@RequestMapping(value="/noticias")
public class NoticiaController 
{
	@Autowired
	private INoticiaService noticiaService;
	
	@GetMapping(value="/create")
	public String crear()
	{
		return "noticias/insertar_noticia";
	}
	
	
	// Sin el uso de Data Binding, se tendria la siguiente linea
	/*public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, 
			@RequestParam("detalle") String detalle)*/
	@PostMapping(value="/save")
	public String guardar(Noticia noticia)
	
	{		
		// Realizar guardado a traves del servicio
		this.noticiaService.guardar(noticia);
		
		return "noticias/insertar_noticia";
	}
}
