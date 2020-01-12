package com.cartelerav1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.service.INoticiaService;

@Controller
@RequestMapping(value="/noticias")
public class NoticiaController 
{
	@Autowired
	private INoticiaService noticiaService;
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listaNoticia(Model model)
	{
		model.addAttribute("lista_noticias", this.noticiaService.buscarTodas());
		return "noticias/noticia_lista";
	}
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Noticia noticia)
	{
		return "noticias/insertar_noticia";
	}
	
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia, BindingResult result, RedirectAttributes attributes)
	
	{		
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(noticia.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de noticia (Insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "noticias/insertar_noticia";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		this.noticiaService.guardar(noticia);
		
		
		attributes.addFlashAttribute("mensaje", "Noticia creada con exito");
		return "redirect:/noticias/index";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editarNoticia(@PathVariable("id") int idNoticia, Model model)
	{
		model.addAttribute("noticia", this.noticiaService.buscarPorId(idNoticia));
		return "noticias/insertar_noticia";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes)
	{
		this.noticiaService.eliminarPorId(idNoticia);
		attributes.addFlashAttribute("mensaje", "Noticia eliminada con exito");
		return "redirect:/noticias/index";
	}
}
