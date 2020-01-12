package com.cartelerav1.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.service.IBannerService;
import com.cartelerav1.app.service.INoticiaService;
import com.cartelerav1.app.service.IPeliculaService;
import com.cartelerav1.app.util.Utileria;

@Controller
public class HomeController 
{
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IBannerService bannerService;
	
	@Autowired
	private INoticiaService noticiaService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome()
	{
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String paginaPrincipal(Model model)
	{
		List<Pelicula> peliculas = peliculaService.buscarTodas();
		List<String> fechas = Utileria.getNextDays(4);
		
		model.addAttribute("fechas", fechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", this.bannerService.obtenerBannersActivos());
		model.addAttribute("noticias", this.noticiaService.obtenerNoticiasActivas());
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha") String fecha)
	{
		List<Pelicula> peliculas = peliculaService.buscarTodas();
		List<String> fechas = Utileria.getNextDays(4);
		
		model.addAttribute("fechas", fechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", fecha);
		
		return "home";
	}
	
	/*
	 * Formulario funcion para el cierre de sesion
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String cierreSesion(HttpServletRequest request)
	{
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		
		return "redirect:/login";
	}
}
