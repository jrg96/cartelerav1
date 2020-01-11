package com.cartelerav1.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("banners")
public class BannerController 
{
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listaBanner()
	{
		return "banners/banner_lista";
	}
}
