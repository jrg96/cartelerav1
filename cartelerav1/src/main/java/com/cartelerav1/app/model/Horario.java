package com.cartelerav1.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "Detalles")
public class Horario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "hora")
	private Date hora; // HH:mm
	
	@Column(name = "sala")
	private String sala; 
	
	@Column(name = "precio")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "idpelicula")
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

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
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