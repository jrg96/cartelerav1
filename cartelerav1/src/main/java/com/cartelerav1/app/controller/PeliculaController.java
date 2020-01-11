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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.service.IPeliculaService;

@Controller
@RequestMapping(value = "/peliculas")
public class PeliculaController 
{
	@Autowired
	private IPeliculaService peliculaService;
	
	
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
	public String crear()
	{
		return "peliculas/pelicula_insertar";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
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
			String nombreImagen = guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}
		peliculaService.guardar(pelicula);
		
		
		attributes.addFlashAttribute("mensaje", "Pelicula insertada con exito");
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
	
	
	/*
	 * --------- FUNCIONES DE APOYO ---------------------------------------------
	 */
	private String guardarImagen(MultipartFile multiPart, HttpServletRequest request)
	{
		// Paso 1: obtener el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		
		// Paso 2: obtener la ruta absoluta a donde guardar las imagenes
		// apache-tomcat/webapps/cartelerav1/resources/images/uploads
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/uploads/");
		
		// Paso 3: intentamos mover el archivo desde la carpeta tmp a su destino final
		try 
		{
			System.out.println("Creando archivo");
			File imageFile = new File(rutaFinal + nombreOriginal);
			
			System.out.println("Empezando a transferir");
			multiPart.transferTo(imageFile);
			
			return nombreOriginal;
		}
		catch(Exception e)
		{
			System.out.println("Error al subir archivo: " + e.getMessage());
		}
		
		return null;
	}
}
