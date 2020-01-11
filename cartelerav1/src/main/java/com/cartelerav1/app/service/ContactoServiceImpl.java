package com.cartelerav1.app.service;

import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService{
	
	@Override
	public void guardar(Contacto contacto)
	{
		System.out.println("Insertando contacto");
	}
}
