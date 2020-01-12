package com.cartelerav1.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Banner;
import com.cartelerav1.app.repository.BannerRepository;

@Service
public class BannerServiceJpa implements IBannerService 
{
	@Autowired
	private BannerRepository bannerRepository;

	@Override
	public void guardar(Banner banner) 
	{
		this.bannerRepository.save(banner);
	}

	@Override
	public List<Banner> obtenerTodos() 
	{
		return this.bannerRepository.findAll(Sort.by("fecha").ascending());
	}

	@Override
	public Banner buscarPorId(int id) 
	{
		Optional<Banner> banner = this.bannerRepository.findById(id);
		
		if (banner.isPresent())
		{
			return banner.get();
		}
		
		return null;
	}

	@Override
	public void eliminarPorId(int id) 
	{
		this.bannerRepository.deleteById(id);
	}

	@Override
	public List<Banner> obtenerBannersActivos() 
	{
		return this.bannerRepository.findAllByEstatus("Activo", Sort.by("fecha").ascending());
	}

}
