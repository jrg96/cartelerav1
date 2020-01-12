package com.cartelerav1.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
		return this.peliculaRepository.findAll();
	}

	@Override
	public Pelicula buscarPorId(int id) {
		Optional<Pelicula> peli =  this.peliculaRepository.findById(id);
		
		if (peli.isPresent())
		{
			return peli.get();
		}
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

	@Override
	public void eliminarPorId(int id) 
	{
		this.peliculaRepository.deleteById(id);
	}

}
