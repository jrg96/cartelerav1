package com.cartelerav1.app.service;

import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService
{
	@Override
	public void guardar(Horario horario)
	{
		System.out.println("Guardando horario");
	}
}
