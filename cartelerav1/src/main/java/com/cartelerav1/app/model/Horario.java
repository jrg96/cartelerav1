package com.cartelerav1.app.model;

import java.util.Date;

import org.springframework.core.style.ToStringCreator;

public class Horario 
{
	
	private int id;
	private Date fecha;
	private String hora; // HH:mm
	private String sala; 
	private double precio;
	private Pelicula pelicula;

	public Horario() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("id", this.getId())
				.append("fecha", this.getFecha())
				.append("hora", this.getHora())
				.append("sala", this.getSala())
				.append("precio", this.getPrecio())
				.append("pelicula", this.getPelicula())
				.toString();
	}
		
}