package com.cartelerav1.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartelerav1.app.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> 
{
	Optional<Perfil> findByCuenta(String cuenta);
}
