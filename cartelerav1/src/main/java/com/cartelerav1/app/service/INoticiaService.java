package com.cartelerav1.app.service;

import java.util.List;

import com.cartelerav1.app.model.Noticia;

public interface INoticiaService 
{
	void guardar(Noticia noticia);
	List<Noticia> buscarTodas();
	Noticia buscarPorId(int id);
	void eliminarPorId(int id);
}
