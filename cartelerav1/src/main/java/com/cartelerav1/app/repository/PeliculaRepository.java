package com.cartelerav1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartelerav1.app.model.Pelicula;

@Repository(value = "peliculaRepository")
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> 
{
	
}
