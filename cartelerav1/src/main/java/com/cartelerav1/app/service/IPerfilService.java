package com.cartelerav1.app.service;

import java.util.List;

import com.cartelerav1.app.model.Perfil;

public interface IPerfilService 
{
	void guardar(Perfil perfil);
	void eliminarPorId(int id);
	List<Perfil> buscarTodos();
	Perfil buscarPorId(int id);
	Perfil buscarPorCuenta(String cuenta);
	
	List<String> obtenerTiposPerfil();
	
}
