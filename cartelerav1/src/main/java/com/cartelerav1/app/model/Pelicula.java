package com.cartelerav1.app.model;

import java.util.Date;

import org.springframework.core.style.ToStringCreator;

public class Pelicula 
{
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png";
	private Date fechaEstreno;
	private String estatus = "Activa";
	
	private Detalle detalle;
	
	
	
	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
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
	
	public int getDuracion() 
	{
		return duracion;
	}
	
	public void setDuracion(int duracion) 
	{
		this.duracion = duracion;
	}
	
	public String getClasificacion() 
	{
		return clasificacion;
	}
	
	public void setClasificacion(String clasificacion) 
	{
		this.clasificacion = clasificacion;
	}
	
	public String getGenero() 
	{
		return genero;
	}
	
	public void setGenero(String genero) 
	{
		this.genero = genero;
	}
	
	public String getImagen() 
	{
		return imagen;
	}
	
	public void setImagen(String imagen) 
	{
		this.imagen = imagen;
	}
	
	public Date getFechaEstreno() 
	{
		return fechaEstreno;
	}
	
	public void setFechaEstreno(Date fechaEstreno) 
	{
		this.fechaEstreno = fechaEstreno;
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
				.append("duracion", this.getDuracion())
				.append("clasificacion", this.getClasificacion())
				.append("genero", this.getGenero())
				.append("imagen", this.getImagen())
				.append("fechaEstreno", this.getFechaEstreno())
				.append("estatus", this.getEstatus())
				.append("detalle", this.getDetalle())
				.toString();
	}	
}
