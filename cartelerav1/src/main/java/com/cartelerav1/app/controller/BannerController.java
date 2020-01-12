package com.cartelerav1.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cartelerav1.app.model.Banner;
import com.cartelerav1.app.service.IBannerService;
import com.cartelerav1.app.util.Utileria;

@Controller
@RequestMapping("banners")
public class BannerController 
{
	@Autowired
	private IBannerService bannerService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listaBanner(Model model)
	{
		model.addAttribute("lista_banners", this.bannerService.obtenerTodos());
		return "banners/banner_lista";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String formularioCrearBanner(@ModelAttribute Banner banner)
	{
		return "banners/banner_insertar";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardarBanner(@ModelAttribute Banner banner, BindingResult result, 
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request,
			RedirectAttributes attributes)
	{
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(banner.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de pelicula (insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "banners/banner_insertar";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		// Verificando si el usuario subio imagen y realizar la subida
		if (!multiPart.isEmpty())
		{
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);
		}
		this.bannerService.guardar(banner);
		
		attributes.addFlashAttribute("mensaje", "banner agregado con exito");
		return "redirect:/banners/index";
	}
}
