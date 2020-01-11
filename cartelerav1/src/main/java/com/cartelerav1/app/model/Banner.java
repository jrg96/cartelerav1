package com.cartelerav1.app.model;

import java.util.Date;

import org.springframework.core.style.ToStringCreator;

public class Banner {

	private int id;
	private String titulo;
	private Date fecha; // Fecha de Publicacion del Banner
	private String archivo; // nombre de la imagen
	private String estatus;
	
	/**
	 * Constructor de la clase
	 */
	public Banner(){		
		this.fecha = new Date();
		this.estatus="Activo";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("id", this.getId())
				.append("titulo", this.getTitulo())
				.append("fecha", this.getFecha())
				.append("archivo", this.getArchivo())
				.append("estatus", this.getEstatus())
				.toString();
	}	
		
}
