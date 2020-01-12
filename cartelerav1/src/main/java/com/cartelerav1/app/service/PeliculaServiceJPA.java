package com.cartelerav1.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.repository.PeliculaRepository;

@Service
public class PeliculaServiceJPA implements IPeliculaService
{
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Pelicula pelicula) 
	{
		peliculaRepository.save(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> listaGeneros = new LinkedList<>();
		
		listaGeneros.add("Accion");
		listaGeneros.add("Aventura");
		listaGeneros.add("Clasicas");
		listaGeneros.add("Comedia");
		listaGeneros.add("Comedia Romantica");
		listaGeneros.add("Drama");
		listaGeneros.add("Terror");
		listaGeneros.add("Infantil");
		listaGeneros.add("Accion y Aventura");
		listaGeneros.add("Romantica");
		
		return listaGeneros;
	}

}
