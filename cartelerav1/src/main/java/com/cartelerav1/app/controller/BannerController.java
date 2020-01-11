package com.cartelerav1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cartelerav1.app.model.Banner;
import com.cartelerav1.app.service.IBannerService;

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
	public String formularioCrearBanner()
	{
		return "banners/banner_insertar";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardarBanner()
	{
		return "banners/banner_insertar";
	}
}
