package com.cartelerav1.app.service;

import java.util.List;

import com.cartelerav1.app.model.Usuario;

public interface IUsuarioService 
{
	void guardar(Usuario usuario);
	void eliminarPorId(int id);
	List<Usuario> buscarTodos();
	Usuario buscarPorId(int id);
}
