package com.cartelerav1.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cartelerav1.app.model.Banner;

//@Service
public class BannerServiceImpl implements IBannerService
{
	private List<Banner> listaBanner;
	
	public BannerServiceImpl()
	{
		try
		{
			this.listaBanner = new LinkedList<>();
			
			Banner banner = new Banner();
			banner.setId(1);
			banner.setTitulo("Slide1");
			banner.setArchivo("slide1.jpg");
			this.listaBanner.add(banner);
			
			banner = new Banner();
			banner.setId(2);
			banner.setTitulo("Slide2");
			banner.setArchivo("slide2.jpg");
			this.listaBanner.add(banner);
			
			banner = new Banner();
			banner.setId(3);
			banner.setTitulo("Slide3");
			banner.setArchivo("slide3.jpg");
			this.listaBanner.add(banner);
			
			banner = new Banner();
			banner.setId(4);
			banner.setTitulo("Slide4");
			banner.setArchivo("slide4.jpg");
			this.listaBanner.add(banner);
			
			banner = new Banner();
			banner.setId(5);
			banner.setTitulo("Slide4");
			banner.setArchivo("slide5.jpg");
			this.listaBanner.add(banner);
		}
		catch(Exception e)
		{
			System.out.println("Error al crear lista enlazada de Banner");
		}
	}
	
	@Override
	public void guardar(Banner banner) 
	{
		// TODO Auto-generated method stub
		System.out.println("Guardamos banner");
	}

	@Override
	public List<Banner> obtenerTodos() {
		return this.listaBanner;
	}

	@Override
	public Banner buscarPorId(int id) {
		for (Banner banner : this.listaBanner)
		{
			if (banner.getId() == id)
			{
				return banner;
			}
		}
		return null;
	}

}
