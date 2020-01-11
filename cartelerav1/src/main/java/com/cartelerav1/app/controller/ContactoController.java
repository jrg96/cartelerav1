package com.cartelerav1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cartelerav1.app.model.Contacto;
import com.cartelerav1.app.service.IContactoService;
import com.cartelerav1.app.service.IPeliculaService;

@Controller
@RequestMapping(value= "/contactos")
public class ContactoController 
{
	@Autowired
	private IContactoService contactoService;
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crearContacto(@ModelAttribute Contacto contacto, Model model)
	{	
		model.addAttribute("lista_generos", this.peliculaService.buscarGeneros());
		return "contactos/contacto_insertar";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardarContacto(@ModelAttribute Contacto contacto, BindingResult result, Model model)
	{
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(contacto.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de contacto (insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "contactos/contacto_insertar";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		this.contactoService.guardar(contacto);
		
		model.addAttribute("lista_generos", this.peliculaService.buscarGeneros());
		return "redirect:contactos/contacto_insertar";
	}
}
