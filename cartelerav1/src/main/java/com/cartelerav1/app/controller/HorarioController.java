package com.cartelerav1.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cartelerav1.app.model.Horario;
import com.cartelerav1.app.service.IHorarioService;
import com.cartelerav1.app.service.IPeliculaService;

@Controller
@RequestMapping("/horarios")
public class HorarioController 
{
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IHorarioService horarioService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crearHorario(@ModelAttribute Horario horario, Model model)
	{
		model.addAttribute("lista_peliculas", this.peliculaService.buscarTodas());
		return "horarios/horario_insertar";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardarHorario(@ModelAttribute Horario horario, BindingResult result, Model model)
	{
		model.addAttribute("lista_peliculas", this.peliculaService.buscarTodas());
		
		
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(horario.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de horario de pelicula (insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "horarios/horario_insertar";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		this.horarioService.guardar(horario);
		
		return "horarios/horario_insertar";
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
