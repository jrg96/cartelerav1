package com.cartelerav1.app.service;

import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Noticia;

@Service
public class NoticiaServiceImpl implements INoticiaService 
{
	@Override
	public void guardar(Noticia noticia)
	{
		System.out.println("Guardando el objeto noticia");
	}
}
