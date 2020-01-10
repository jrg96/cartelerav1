package com.cartelerav1.app.service;

import java.util.List;

import com.cartelerav1.app.model.Pelicula;

public interface IPeliculaService 
{
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int id);
	void guardar(Pelicula pelicula);
}
