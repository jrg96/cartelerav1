package com.cartelerav1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartelerav1.app.model.Noticia;

@Repository(value = "noticiaRepository")
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
