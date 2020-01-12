package com.cartelerav1.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "Banners")
public class Banner 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "fecha")
	private Date fecha; // Fecha de Publicacion del Banner
	
	@Column(name = "archivo")
	private String archivo; // nombre de la imagen
	
	@Column(name = "estatus")
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
