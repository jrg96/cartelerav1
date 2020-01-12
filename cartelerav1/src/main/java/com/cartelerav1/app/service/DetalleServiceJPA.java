package com.cartelerav1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Detalle;
import com.cartelerav1.app.repository.DetalleRepository;

@Service
public class DetalleServiceJPA implements IDetalleService
{
	@Autowired
	private DetalleRepository detalleRepository;

	@Override
	public void guardar(Detalle detalle) 
	{
		this.detalleRepository.save(detalle);
	}

}
