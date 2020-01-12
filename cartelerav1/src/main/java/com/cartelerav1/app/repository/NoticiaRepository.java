package com.cartelerav1.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartelerav1.app.model.Noticia;

@Repository(value = "noticiaRepository")
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> 
{
	List<Noticia> findByEstatus(String estatus);
	
	@Query(value = "SELECT * FROM noticias WHERE estatus = ? AND TO_DATE(fecha) = ?",
		   nativeQuery = true)
	List<Noticia> finByEstatusAndFecha(String estatus, Date fecha);
	
	List<Noticia> findAllByEstatusAndTituloStartingWith(String estatus, String titulo, Pageable pageable);
	
	@Query(value = "SELECT * FROM noticias WHERE TO_DATE(fecha) = ?",
		   countQuery = "SELECT COUNT(*) FROM noticias WHERE TO_DATE(fecha) = ?",
		   nativeQuery = true)
	List<Noticia> findAllByFecha(Date fecha, Pageable pageable);
	
	/*
	 * Lista de metodos ocupados por la aplicacion
	 */
	List<Noticia> findAllByEstatus(String estatus, Sort sort);
	
	List<Noticia> findAllByEstatus(String estatus, Pageable pageable);
	
}
