package com.cartelerav1.app.service;

import com.cartelerav1.app.model.Detalle;

public interface IDetalleService 
{
	public void guardar(Detalle detalle);
	public void eliminarPorId(int id);
}
