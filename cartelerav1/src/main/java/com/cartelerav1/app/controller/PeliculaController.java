package com.cartelerav1.app.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.service.IDetalleService;
import com.cartelerav1.app.service.IPeliculaService;
import com.cartelerav1.app.util.Utileria;

@Controller
@RequestMapping(value = "/peliculas")
public class PeliculaController 
{
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IDetalleService detalleService;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listaPelicula(Model model)
	{
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		model.addAttribute("lista_peliculas", this.peliculaService.buscarTodas());
		
		return "peliculas/pelicula_lista";
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha)
	{
		// Obteniendo la pelicula desde nuestro servicio
		model.addAttribute("pelicula", this.peliculaService.buscarPorId(idPelicula));
		
		return "peliculas/pelicula_detalle";
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(@ModelAttribute Pelicula pelicula, Model model)
	{
		model.addAttribute("lista_generos", peliculaService.buscarGeneros());
		return "peliculas/pelicula_insertar";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request)
	{
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(pelicula.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de pelicula (insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "peliculas/pelicula_insertar";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		
		// Verificando si el usuario subio imagen y realizar la subida
		if (!multiPart.isEmpty())
		{
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}
		
		// Para guardar pelicula, primero guardamos sus dependencias (sus FK)
		detalleService.guardar(pelicula.getDetalle());
		peliculaService.guardar(pelicula);
		
		
		attributes.addFlashAttribute("mensaje", "Pelicula insertada con exito");
		return "redirect:/peliculas/index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarPelicula(@PathVariable("id") int idPelicula, Model model)
	{
		model.addAttribute("pelicula", this.peliculaService.buscarPorId(idPelicula));
		model.addAttribute("lista_generos", this.peliculaService.buscarGeneros());
		return "peliculas/pelicula_insertar";
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminarPelicula(@PathVariable("id") int idPelicula, RedirectAttributes attributes)
	{
		Pelicula pelicula = this.peliculaService.buscarPorId(idPelicula);
		
		this.peliculaService.eliminarPorId(idPelicula);
		this.detalleService.eliminarPorId(pelicula.getDetalle().getId());
		attributes.addFlashAttribute("mensaje", "Pelicula eliminada con exito");
		return "redirect:/peliculas/index";
	}
	
	
	/*
	 * --------- REGLAS DE CONVERSION PARA EL CONTROLADOR ------------------------
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		// Definiendo el formato a ocupar para las fechas (para transoformarlas)
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(date, false));
	}
}
