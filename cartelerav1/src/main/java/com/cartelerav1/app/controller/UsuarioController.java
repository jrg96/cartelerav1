package com.cartelerav1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cartelerav1.app.model.Usuario;
import com.cartelerav1.app.service.IPerfilService;
import com.cartelerav1.app.service.IUsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController 
{
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPerfilService perfilService;
	
	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		
		return "usuarios/demo";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crearUsuario(@ModelAttribute Usuario usuario, Model model)
	{
		model.addAttribute("lista_tipos", this.perfilService.obtenerTiposPerfil());
		return "usuarios/usuario_insertar";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardarUsuario(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attributes)
	{
		/*
		 * --------------- ZONA VERIFICACION DE ERRORES BINDING ---------------------
		 */
		System.out.println(usuario.toString());
		
		if (result.hasErrors())
		{
			System.out.println("Hubieron errores en el binding de usuario (insertar)");
			
			for (ObjectError error : result.getAllErrors()) 
			{
				System.out.println(error.getDefaultMessage());
			}
			
			return "usuarios/usuario_insertar";
		}
		
		/*
		 * --------------- ZONA DE PROCESAMIENTO DE DATOS -------------------------
		 */
		
		if (usuario.getPwd().length() != 60)
		{
			usuario.setPwd(encoder.encode(usuario.getPwd()));
		}
		
		this.usuarioService.guardar(usuario);
		usuario.getPerfil().setCuenta(usuario.getCuenta());
		this.perfilService.guardar(usuario.getPerfil());
		
		return "usuarios/usuario_insertar";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarUsuario(@PathVariable("id") int idUsuario, Model model)
	{
		Usuario usuario = this.usuarioService.buscarPorId(idUsuario);
		usuario.setPerfil(this.perfilService.buscarPorCuenta(usuario.getCuenta()));
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("lista_tipos", this.perfilService.obtenerTiposPerfil());
		
		return "usuarios/usuario_insertar";
	}
}
