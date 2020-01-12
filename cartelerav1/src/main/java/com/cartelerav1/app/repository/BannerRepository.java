package com.cartelerav1.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cartelerav1.app.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> 
{
	List<Banner> findAllByEstatus(String estatus, Sort sort);
	
	List<Banner> findAllByEstatus(String estatus, Pageable pageable);
}
