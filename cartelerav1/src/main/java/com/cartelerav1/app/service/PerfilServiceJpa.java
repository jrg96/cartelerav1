package com.cartelerav1.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Perfil;
import com.cartelerav1.app.repository.PerfilRepository;

@Service
public class PerfilServiceJpa implements IPerfilService
{
	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void guardar(Perfil perfil) 
	{
		this.perfilRepository.save(perfil);
	}

	@Override
	public void eliminarPorId(int id) 
	{
		if (this.perfilRepository.existsById(id))
		{
			this.perfilRepository.deleteById(id);
		}
	}

	@Override
	public List<Perfil> buscarTodos() 
	{
		return this.perfilRepository.findAll();
	}

	@Override
	public Perfil buscarPorId(int id) 
	{
		Optional<Perfil> perfil = this.perfilRepository.findById(id);
		if (perfil.isPresent())
		{
			return perfil.get();
		}
		return null;
	}

	@Override
	public List<String> obtenerTiposPerfil() 
	{
		List<String> listaTipos = new LinkedList<>();
		
		listaTipos.add("EDITOR");
		listaTipos.add("GERENTE");
		
		return listaTipos;
	}

	@Override
	public Perfil buscarPorCuenta(String cuenta) 
	{
		Optional<Perfil> perfil = this.perfilRepository.findByCuenta(cuenta);
		if (perfil.isPresent())
		{
			return perfil.get();
		}
		return null;
	}
}
