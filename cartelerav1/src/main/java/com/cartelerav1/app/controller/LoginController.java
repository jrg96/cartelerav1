package com.cartelerav1.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class LoginController 
{
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String adminPanel(Authentication authentication)
	{
		authentication.getName();
		authentication.getAuthorities();
		
		return "panels/panel_admin";
	}
	
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String iniciarSesion()
	{
		return "utils/login";
	}
	
	
	/*
	 * Formulario funcion para el cierre de sesion
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String cierreSesion(HttpServletRequest request)
	{
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		
		return "redirect:/admin/loginform";
	}
}
