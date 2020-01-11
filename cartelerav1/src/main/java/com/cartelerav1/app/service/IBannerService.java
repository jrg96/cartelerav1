package com.cartelerav1.app.service;

import java.util.List;

import com.cartelerav1.app.model.Banner;

public interface IBannerService 
{
	void guardar(Banner banner);
	List<Banner> obtenerTodos();
	Banner buscarPorId(int id);
}
