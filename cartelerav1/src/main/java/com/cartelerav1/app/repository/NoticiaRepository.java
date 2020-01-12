package com.cartelerav1.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartelerav1.app.model.Noticia;

@Repository(value = "noticiaRepository")
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> 
{
	// SELECT * FROM noticias WHERE estatus = ?
	List<Noticia> findByEstatus(String estatus);
	
	// SELECT * FROM noticias WHERE estatus = ? and rownum <= ? 
	List<Noticia> findAllByEstatus(String estatus, Pageable pageable);
	
	// SELECT * FROM noticias WHERE estatus = ? AND titulo LIKE '?%' AND rownum rownum <= ? 
	List<Noticia> findAllByEstatusAndTituloStartingWith(String estatus, String titulo, Pageable pageable);
}