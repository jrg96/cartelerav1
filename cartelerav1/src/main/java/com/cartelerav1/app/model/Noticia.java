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
@Table(name = "Noticias")
public class Noticia 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "detalle")
	private String detalle;
	
	@Column(name = "estatus")
	private String estatus;
	
	public Noticia()
	{
		this.fecha = new Date();
		this.estatus = "Activa";
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public void setFecha(Date fecha) 
	{
		this.fecha = fecha;
	}

	public String getDetalle() 
	{
		return detalle;
	}

	public void setDetalle(String detalle) 
	{
		this.detalle = detalle;
	}

	public String getEstatus() 
	{
		return estatus;
	}

	public void setEstatus(String estatus) 
	{
		this.estatus = estatus;
	}
	
	@Override
	public String toString()
	{
		return new ToStringCreator(this)
				.append("id", this.getId())
				.append("titulo", this.getTitulo())
				.append("fecha", this.getFecha())
				.append("detalle", this.getDetalle())
				.append("estatus", this.getEstatus())
				.toString();
	}
}
