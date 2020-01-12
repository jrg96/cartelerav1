package com.cartelerav1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartelerav1.app.model.Detalle;

@Repository(value = "detalleRepository")
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {

}
