package com.cartelerav1.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Usuario;
import com.cartelerav1.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceJpa implements IUsuarioService
{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void guardar(Usuario usuario) 
	{
		this.usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarPorId(int id) 
	{
		if (this.usuarioRepository.existsById(id)) 
		{
			this.usuarioRepository.deleteById(id);
		}
	}

	@Override
	public List<Usuario> buscarTodos() 
	{
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorId(int id) 
	{
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		
		if (usuario.isPresent())
		{
			return usuario.get();
		}
		
		return null;
	}
}
