package com.cartelerav1.app.model;

import org.springframework.core.style.ToStringCreator;

public class Contacto 
{
	private int id;
	private String nombre;
	private String email;
	private int rating;
	private String[] generos;
	private String[] notificaciones;
	private String comentarios;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String[] getGeneros() {
		return generos;
	}
	public void setGeneros(String[] generos) {
		this.generos = generos;
	}
	public String[] getNotificaciones() {
		return notificaciones;
	}
	public void setNotificaciones(String[] notificaciones) {
		this.notificaciones = notificaciones;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public String toString()
	{
		return new ToStringCreator(this)
				.append("id", this.getId())
				.append("nombre", this.getNombre())
				.append("email", this.getEmail())
				.append("rating", this.getRating())
				.append("generos", this.getGeneros())
				.append("notificaciones", this.getNotificaciones())
				.append("comentarios", this.getComentarios())
				.toString();
	}
	
}
