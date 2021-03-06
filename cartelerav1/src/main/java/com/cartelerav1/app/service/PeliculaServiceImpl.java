package com.cartelerav1.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Pelicula;

//@Service
public class PeliculaServiceImpl implements IPeliculaService
{
	private List<Pelicula> lista = null;;
	
	public PeliculaServiceImpl()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula2.setImagen("bella.png"); // Nombre del archivo de imagen

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			pelicula3.setImagen("contratiempo.png"); // Nombre del archivo de imagen

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong La Isla Calavera");
			pelicula4.setDuracion(118);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y Aventura");
			pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
			pelicula4.setImagen("kong.png"); // Nombre del archivo de imagen
			pelicula4.setEstatus("Inactiva"); // Esta pelicula estara inactiva
			
			// Agregamos los objetos Pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Pelicula> buscarTodas() 
	{
		return this.lista;
	}

	@Override
	public Pelicula buscarPorId(int id) {
		for (Pelicula peli : this.lista) 
		{
			if (peli.getId() == id)
			{
				return peli;
			}
		}
		return null;
	}

	@Override
	public void guardar(Pelicula pelicula) 
	{
		// TODO Auto-generated method stub
		System.out.println("Insertando pelicula");
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
	public void eliminarPorId(int id) {
		// TODO Auto-generated method stub
		
	}

}
