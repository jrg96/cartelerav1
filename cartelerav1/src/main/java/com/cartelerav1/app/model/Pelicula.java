package com.cartelerav1.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "Peliculas")
public class Pelicula 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "duracion")
	private int duracion;
	
	@Column(name = "clasificacion")
	private String clasificacion;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "imagen")
	private String imagen = "cinema.png";
	
	@Column(name = "fechaestreno")
	private Date fechaEstreno;
	
	@Column(name = "estatus")
	private String estatus = "Activa";
	
	//@Transient
	@OneToOne
	@JoinColumn(name = "iddetalle")
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
