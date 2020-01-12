package com.cartelerav1.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

@Service
public class NoticiaServiceJpa implements INoticiaService 
{
	@Autowired
	private NoticiaRepository noticiaRepository;

	@Override
	public void guardar(Noticia noticia) 
	{
		this.noticiaRepository.save(noticia);
	}

	@Override
	public List<Noticia> buscarTodas() 
	{
		// Mostrar las noticias mas recientes primero
		return this.noticiaRepository.findAll(Sort.by("fecha").descending());
	}

	@Override
	public Noticia buscarPorId(int id) 
	{
		Optional<Noticia> noticia = this.noticiaRepository.findById(id);
		
		if (noticia.isPresent())
		{
			return noticia.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) 
	{
		if (this.noticiaRepository.existsById(id))
		{
			this.noticiaRepository.deleteById(id);
		}
	}

	@Override
	public List<Noticia> obtenerNoticiasActivas() 
	{
		return this.noticiaRepository.findAllByEstatus("Activa", Sort.by("fecha").descending());
	}
	
	
}
