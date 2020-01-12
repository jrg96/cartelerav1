package com.cartelerav1.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "Detalles")
public class Detalle 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "actores")
	private String actores;
	
	@Column(name = "sinopsis")
	private String sinopsis;
	
	@Column(name = "trailer")
	private String trailer;
	
	public Detalle()
	{
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	@Override
	public String toString()
	{
		return new ToStringCreator(this)
				.append("director", this.getDirector())
				.append("actores", this.getActores())
				.append("trailer", this.getTrailer())
				.toString();
	}
}
